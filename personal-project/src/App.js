import logo from './logo.svg';
import './App.css';
import Categories from './components/Categories';
import { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes, useNavigate } from 'react-router-dom'
import { Link } from 'react-router-dom'
import Confirmation from './components/Confirmation';
import MainQuestionArea from './components/MainQuestionArea';
import EndPage from './components/EndPage';
import Scoreboard from './components/Scoreboard';

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
  const [scores, setScores] = useState([])

  useEffect(() => {
    const getScores = async () => {
      const scoresFromServer = await fetchScores()
      setScores(scoresFromServer)
    }

    getScores()  
  }, [])

  const delay = async (ms) => {
    return new Promise(resolve =>{
      setTimeout(resolve,ms)
    })
  }

  let navigate = useNavigate(); 
  const navToScoreboard = () =>{ 
    let path = `/scoreboard`; 
    navigate(path);
  }

  const navToHome = () =>{ 
    let path = `/`; 
    startOver()
    navigate(path);
  }

  const setCategory = async (name) => {
    console.log(name)
    setSelectedCat(name)
    let questionsFromServer = await fetchQuestions(name)
    setQuestions(questionsFromServer)
    setCurrentQuestion(questionsFromServer[questionCount])
  }

  const confirmCategory = () => {
    setFinished(false)
    setConfirmed(true)
  }

  const fetchQuestion = async (category, id) => {
    let res = await fetch(`http://localhost:8080/${category}/${id}`)
    let data = await res.json()

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


  const fetchScores = async () => {
    const res = await fetch(`http://localhost:8080/scoreboard`)
    const scores = await res.json()
    return scores
  }


  const addScore = async (score) => {
    console.log(score)
    const currentDate = new Date();
    const currentDayOfMonth = currentDate.getDate();
    const currentMonth = currentDate.getMonth(); 
    const currentYear = currentDate.getFullYear();
    const hour = currentDate.getHours();
    const minutes = (currentDate.getMinutes() < 10) ? "0"+currentDate.getMinutes() : currentDate.getMinutes();
    const dateTimeString = currentYear + "-" + ((currentMonth + 1) < 10 ? "0" + (currentMonth + 1) : (currentMonth + 1)) + "-" + currentDayOfMonth + " " + hour + ":" + minutes;
    console.log(dateTimeString)
    

    let prevLargestId = scores.pop()["id"]
    let scoreToAdd = {"id":prevLargestId+1, "timestamp": dateTimeString, "category": selectedCat, "score": String(score)}
    
    const res = await fetch('http://localhost:8080/scoreboard', {
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: JSON.stringify(scoreToAdd),
    })


    setScores([...scores, scoreToAdd])
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
      await addScore(correctCount*100/NUMBER_OF_QUESTIONS)
      setShowAnswer(false)
      setFinished(true)
    }
  }

  const startOver = () => {
    setSelectedCat("")
    setConfirmed(false)
    setQuestionCount(NUMBER_OF_QUESTIONS-1);
    setCorrectCount(0)
    setCurrentQuestion([])
    setQuestions([])
  }

  return (
      <div className="App">
        <header className='App-header'>
        <Link to='/' onClick={startOver}>The GoCity Quiz</Link>        
        </header>
        <Routes>
          <Route
            path='/'
            element={
              <>
                {(selectedCat==="") && <Categories categories={categories} onClick={setCategory}/>}
                {(selectedCat!=="" && confirmed===false) && <Confirmation selection={selectedCat} onBack={setCategory} onConfirm={confirmCategory}/>}
                {(confirmed===true && finished===false) && <MainQuestionArea questionInfo={currentQuestion} showAnswer={showAnswer} nextQ={nextQuestion}/> }
                {(finished===true && questionCount===0) && <EndPage score={correctCount*100/NUMBER_OF_QUESTIONS} startOver={startOver} scoreBoard={navToScoreboard} />}
              </>
            }
            />
            
            <Route path='/scoreboard' element={<Scoreboard key="scoreboard" goHome={navToHome} scores={scores}/>} />
          </Routes>
      </div>
  );
}

export default App;
