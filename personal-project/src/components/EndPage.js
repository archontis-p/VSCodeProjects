import React from 'react'
import Button from './Button'

const EndPage = ({score, startOver, scoreBoard}) => {
  return (
    <div>
        <div className='container'>
            <h1>Score = {score}%</h1>
        </div>
        <div className='container'>
            <Button key="StartOver" name="Start Over" onClick={startOver}/>
            <Button key="Scoreboard" name="Scoreboard" onClick={scoreBoard}/>
        </div>
    </div>
  )
}

export default EndPage