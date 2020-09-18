import {combineReducers} from 'redux'
import bookingReducer from './booking/bookingReducer'
import loginReducer from './login/loginReducer'

const rootReducer = combineReducers({
    login: loginReducer,
    booking: bookingReducer

    // Example
    // object: objectReducer
})

export default rootReducer