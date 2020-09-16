import { LOGIN, LOGOUT, LOGIN_REQUEST, LOGIN_SUCCESS, LOGIN_FAILURE } from './loginTypes'

const initialState = {
    loading: false,
    loggedIn: false,
    user: {},
    error:''
}

const loginReducer = (state = initialState, action) => {

    switch (action.type) {
        case LOGIN: return {
            ...state,
            loggedIn: true
        }

        case LOGOUT: return {
            ...state,
            loggedIn: false,
            user: {},
        }

        case LOGIN_REQUEST: return {
            ...state,
            loading: true
        }

        case LOGIN_SUCCESS: return {
            ...state,
            loading: false,
            user: action.payload,
            loggedIn: true,
            error: ''
        }

        case LOGIN_FAILURE: return {
            ...state,
            loading: false,
            user: {},
            loggedIn: false,
            error: action.payload
        }

        default: return state
    }
}

export default loginReducer