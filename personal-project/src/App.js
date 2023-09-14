import logo from './logo.svg';
import './App.css';
import Categories from './components/Categories';
import { useEffect, useState } from 'react';
import Confirmation from './components/Confirmation';
import MainQuestionArea from './components/MainQuestionArea';
import EndPage from './components/EndPage';

const NUMBER_OF_QUESTIONS = 4

function App() {

  const categories = ["animals", "celebrities","entertainment", "general", "geography", "history", "hobbies", "literature", "movies", "music", "people", "sports", "television", "world"]

  const [selectedCat, setSelectedCat] = useState("")
  const [questions, setQuestions] = useState([])
  const [confirmed, setConfirmed] = useState(false) 
  const [correctCount, setCorrectCount] = useState(0)
  const [showAnswer, setShowAnswer] = useState(false)
  const [questionCount, setQuestionCount] = useState(NUMBER_OF_QUESTIONS-1)
  const [currentQuestion, setCurrentQuestion] = useState([])
  const [finished, setFinished] = useState(true)


  const delay = async (ms) => {
    return new Promise(resolve =>{
      setTimeout(resolve,ms)
    })
  }


  const setCategory = (name) => {
    console.log(name)
    setSelectedCat(name)
  }

  const confirmCategory = async () => {
    setFinished(false)
    let questionsFromServer = await fetchQuestions(selectedCat)
    setQuestions(questionsFromServer)
    setCurrentQuestion(questionsFromServer[questionCount])
    setConfirmed(true)
  }

  const fetchQuestion = async (category, id) => {
    const res = await fetch(`http://localhost:8080/${category}/${id}`)
    const data = await res.json()

    return data
  }


  const fetchQuestions = async (category) => {
    const res = await fetch(`http://localhost:8080/${category}`)
    const allQ = await res.json()
    
    const total = Object.keys(allQ).length

    const ids = Array.from({length: NUMBER_OF_QUESTIONS}, () => Math.floor(Math.random() * total));
    
    const questions=[]

    for (let i=0;i<ids.length;i++){
      questions.push(await fetchQuestion(category,ids[i]))
    }
    console.log(questions)
    return questions
  }

  const nextQuestion = async (correct) => {
    if(questionCount!==0){
      correct && setCorrectCount(correctCount+1)
      setShowAnswer(true)
      await delay(1500)
      setShowAnswer(false)
      setCurrentQuestion(questions[questionCount-1])
      setQuestionCount(questionCount-1)
    }
    else{
      correct && setCorrectCount(correctCount+1)
      setShowAnswer(true)
      await delay(1500)
      setShowAnswer(false)
      setFinished(true)
    }
  }

  const startOver = () => {
    setCategory("")
    setConfirmed(false)
    setQuestionCount(NUMBER_OF_QUESTIONS);
    setCurrentQuestion([])
    setQuestions([])
  }

  return (
    <div className="App">
      <header className='App-header'>
        The GoCity Quiz        
      </header>

      {(selectedCat==="") && <Categories categories={categories} onClick={setCategory}/>}
      {(selectedCat!=="" && confirmed===false) && <Confirmation selection={selectedCat} onBack={setCategory} onConfirm={confirmCategory}/>}
      {(confirmed===true && finished===false) && <MainQuestionArea questionInfo={currentQuestion} showAnswer={showAnswer} nextQ={nextQuestion}/> }
      {(finished===true && questionCount===0) && <EndPage score={correctCount*100/NUMBER_OF_QUESTIONS} startOver={startOver} />}
    </div>
  );
}

export default App;
