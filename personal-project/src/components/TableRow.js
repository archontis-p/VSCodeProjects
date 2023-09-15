import React from 'react'

const TableRow = ({category, score, timestamp}) => {
  return (
    <tr>
        <td>{category}</td>
        <td>{score}</td>
        <td>{timestamp}</td>
    </tr>
  )
}

export default TableRow