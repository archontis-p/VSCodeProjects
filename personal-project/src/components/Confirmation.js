import React from 'react'

const Confirmation = ({selection, onBack, onConfirm}) => {
  return (
      <div>
        <div className='container'><h1>Your category is: <span style={{textTransform: 'uppercase'}}>{selection}</span></h1></div>
        <div className='container'>
        <button className='btn btn-cat' onClick={() => onBack("")}>BACK</button>
        <button className='btn btn-cat' onClick={() => onConfirm(true)}>CONFIRM</button>
        </div>
    </div>
  )
}

export default Confirmation