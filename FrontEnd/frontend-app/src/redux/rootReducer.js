import {combineReducers} from 'redux'
import loginReducer from './login/loginReducer'

const rootReducer = combineReducers({
    login: loginReducer

    // Example
    // object: objectReducer
})

export default rootReducer