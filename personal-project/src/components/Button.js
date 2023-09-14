import PropTypes from 'prop-types'


const Button = ({name, onClick, classN}) => {
  return (
    <button
      className={classN}
      onClick={() => onClick(name)}
    >
      {name}
    </button>
  )
}

Button.defaultProps = {
  classN: 'btn btn-cat',
}

Button.propTypes = {
  classN: PropTypes.string,
  onClick: PropTypes.func,
}

export default Button