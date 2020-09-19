import React, { useState } from 'react'
import { createBooking } from '../../redux'
import { useDispatch } from 'react-redux'

function CreateBookingContainer() {

    // const [newBooking, setNewBooking] = useState({
    //     dateTime: '',
    //     customer: '',
    //     worker: '',
    //     service: ''
    // })
    
    // Dummy booking for test purposes
    const [newBooking, setNewBooking] = useState({
        dateTime: '2020-12-25T13:00',
        customer: 'customer',
        worker: 'worker',
        service: 'haircut'
    })

    const dispatch = useDispatch()
    
    

    return (
        <div>
            <form>
                <input type='text' onChange={e => setNewBooking(...newBooking,)} />
                <input type='button' onClick={() => dispatch(createBooking(newBooking))} value='Create Booking' />
            </form>
        </div>
    )
}

export default CreateBookingContainer
