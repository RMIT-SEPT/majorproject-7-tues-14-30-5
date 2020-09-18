import axios from 'axios'
import { loginFailure } from '../login/loginActions'
import { CREATE_BOOKING_FAILURE, CREATE_BOOKING_REQUEST, CREATE_BOOKING_SUCCESS } from './bookingTypes'


export const createBookingRequest = () => {
    return {
        type: CREATE_BOOKING_REQUEST
    }
}

export const createBookingSuccess = booking => {
    return {
        type: CREATE_BOOKING_SUCCESS,
        payload: booking
    }
}

export const createBookingFailure = error => {
    return {
        type: CREATE_BOOKING_FAILURE,
        payload: error
    }
}

export const createBooking = () => {
    return (dispatch) => {
        dispatch(createBookingRequest)
        axios.post(url, data) // Fill this in later
        .then(response => {
            const booking = response.data
            dispatch(createBookingSuccess(booking))
        })
        .catch(error => {
            const errorMsg = error.message
            dispatch(createBookingFailure(errorMsg))
        })
    }
}