import axios from 'axios'
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

export const createBooking = newBooking => {
    return (dispatch) => {
        dispatch(createBookingRequest)
        axios.post('http://localhost:8080/api/booking/create', newBooking)
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