import axios from 'axios'
import {
    LOGOUT,
    LOGIN_SUCCESS,
    LOGIN_FAILURE,
    LOGIN_REQUEST
} from "./loginTypes"


export const logout_confirm = () => {
    sessionStorage.clear()
    return {
        type: LOGOUT
    }
}

export const loginRequest = () => {
    return {
        type: LOGIN_REQUEST
    }
}

export const loginSuccess = user => {
    return {
        type: LOGIN_SUCCESS,
        payload: user
    }
}

export const loginFailure = error => {
    return {
        type: LOGIN_FAILURE,
        payload: error
    }
}

export const login = (customerLogin) => {
    return (dispatch) => {
        dispatch(loginRequest)
        axios.post('http://localhost:8080/api/login', customerLogin)
        .then(response => {
            const user = response.data
            dispatch(loginSuccess(user))
        })
        .catch(error => {
            const errorMsg = error.message
            dispatch(loginFailure(errorMsg))
        })
    }
}

export const logout = () => {
    return (dispatch) => {
        dispatch(logout_confirm)
    }
}