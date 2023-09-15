import React from 'react'
import TableRow from './TableRow'
import Button from './Button'

const Scoreboard = ({goHome, scores}) => {
  
  // const scores = [
  //   {"id":1, "timestamp": "2023-09-14 15:14", "category": "animals", "score":75},
  //   {"id":2, "timestamp": "2023-09-14 16:33", "category": "animals", "score":75},
  //   {"id":3, "timestamp": "2023-09-14 16:54", "category": "animals", "score":75}
  // ]

  console.log(scores)
  
  return (
    <div>
        <div className='container'>
          <h1>ScoreBoard</h1>
        </div>

        <div className='container'>
          <table>
            <tr>
              <th>Category</th>
              <th>Score</th>
              <th>Time</th>
            </tr>
            {scores.reverse().map((sc) => (
                <TableRow key={String(sc["id"])} category={sc["category"]} score={sc["score"]} timestamp={sc["timestamp"]} />
              ))}
          </table>
        </div>

        <div className='container' style={{justifyContent: "center", width:'80%'}}>
          <Button key="goHome" name="Start over" onClick={goHome} />
        </div>


    </div>
  )
}

export default Scoreboard