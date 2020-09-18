import { CREATE_BOOKING_FAILURE, CREATE_BOOKING_REQUEST, CREATE_BOOKING_SUCCESS } from './bookingTypes'


const initialState = {
    loading: false,
    error:'',
    booking: {},
    bookingsList: []
}

const bookingReducer = (state = initialState, action) => {

    switch(action.type) {

        case CREATE_BOOKING_REQUEST:
            return {
                ...state,
                loading: true
            }
        
        case CREATE_BOOKING_SUCCESS:
            return {
                ...state,
                loading: false,
                booking: action.payload,
                error: ''
            }

        case CREATE_BOOKING_FAILURE:
            return {
                ...state,
                loading: false,
                error: action.error,
                booking: {}
            }

        default: return state
    }

}

export default bookingReducer