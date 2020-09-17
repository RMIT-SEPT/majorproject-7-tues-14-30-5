import axios from 'axios'
import {
    // LOGIN,
    LOGOUT,
    LOGIN_SUCCESS,
    LOGIN_FAILURE,
    LOGIN_REQUEST
} from "./loginTypes"


// export const login = () => {
//     return {
//         type: LOGIN
//     }
// }

export const logout = () => {
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

// const loginSuccess = function(user) {
//     return {type: LOGIN_SUCCESS, payload: user}
// }

export const loginFailure = error => {
    return {
        type: LOGIN_FAILURE,
        payload: error
    }
}

export const login = (customerLogin) => {
    console.log('dispatchlogin is called')
    return (dispatch) => {
        dispatch(loginRequest)
        axios.post('http://localhost:8080/api/login', customerLogin)
        .then(response => {
            console.log('GOT RESPONSE----!')
            const user = response.data
            dispatch(loginSuccess(user))
        })
        .catch(error => {
            const errorMsg = error.message
            dispatch(loginFailure(errorMsg))
        })
    }
}