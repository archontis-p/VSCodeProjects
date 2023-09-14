import Button from "./Button"
import PropTypes from 'prop-types'

const Categories = ({categories, onClick}) => {
  return (
    <>
      <div className="container"><h1>Select a category:</h1></div>
      <div className="container">
      {categories.map((catName) => (
          <Button key={catName} name={catName} onClick={onClick} />
        ))}
      </div>
    </>
  )
}

Button.propTypes = {
    categories: PropTypes.array
}



export default Categories