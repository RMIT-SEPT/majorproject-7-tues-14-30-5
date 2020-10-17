import { CREATE_BOOKING_FAILURE, CREATE_BOOKING_REQUEST, CREATE_BOOKING_SUCCESS, SET_BOOKING_TYPE } from './bookingTypes'


import { BARBER, LAWYER, TRAINER, ACCOUNTANT, SPA, TUTOR, NONE} from './bookingTypes'

const initialState = {
    loading: false,
    error:'',
    booking: {},
    justBooked: false,
    bookingsList: [],
    booking_service:NONE
}

const bookingReducer = (state = initialState, action) => {

    switch(action.type) {

        case CREATE_BOOKING_REQUEST:
            return {
                ...state,
                loading: true,
                justBooked:false
            }
        
        case CREATE_BOOKING_SUCCESS:
            return {
                ...state,
                loading: false,
                booking: action.payload,
                justBooked:true,
                error: ''
            }

        case CREATE_BOOKING_FAILURE:
            return {
                ...state,
                loading: false,
                error: action.error,
                justBooked: false,
                booking: {}
            }
        
        case SET_BOOKING_TYPE:
            return{
                ...state,
                booking_service:action.payload
            }

        default: return state
    }

}

export default bookingReducer