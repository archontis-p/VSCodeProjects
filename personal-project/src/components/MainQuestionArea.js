import React from 'react'
import Button from './Button'

const MainQuestionArea = ({questionInfo, showAnswer, nextQ}) => {

    let correct = {
        "a": (questionInfo["a"]===questionInfo["correct"]), 
        "b": (questionInfo["b"]===questionInfo["correct"]), 
        "c": (questionInfo["c"]===questionInfo["correct"]), 
        "d": (questionInfo["d"]===questionInfo["correct"])
    }

    let classN = {
        "a": (correct["a"] ? 'btn correct' : 'btn false'),
        "b": (correct["b"] ? 'btn correct' : 'btn false'),
        "c": (correct["c"] ? 'btn correct' : 'btn false'),
        "d": (correct["d"] ? 'btn correct' : 'btn false')
    }

    return (
    <div className='container'>
        <div className='question'>
            {questionInfo["question"]}
        </div>


        <Button key={questionInfo["a"]} name={questionInfo["a"]} onClick={() => (nextQ(correct["a"]))} classN={showAnswer ? classN["a"] : 'btn btn-cat'} />
        <Button key={questionInfo["b"]} name={questionInfo["b"]} onClick={() => (nextQ(correct["b"]))} classN={showAnswer ? classN["b"] : 'btn btn-cat'} />
        {(questionInfo["c"]!=="") && <Button key={questionInfo["c"]} name={questionInfo["c"]} onClick={() => (nextQ(correct["c"]))} classN={showAnswer ? classN["c"] : 'btn btn-cat'} />}
        {(questionInfo["d"]!=="") && <Button key={questionInfo["d"]} name={questionInfo["d"]} onClick={() => (nextQ(correct["d"]))} classN={showAnswer ?  classN["d"] : 'btn btn-cat'} />}
        
        
    </div>
  )
}

export default MainQuestionArea