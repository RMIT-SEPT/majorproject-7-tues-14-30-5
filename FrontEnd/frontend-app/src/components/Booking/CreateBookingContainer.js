import React, { useState } from 'react'
import { createBooking } from '../../redux'
import { useDispatch, useSelector } from 'react-redux'

import DateTimePicker from 'react-datetime-picker';
import { useHistory } from 'react-router-dom';

function CreateBookingContainer() {

    const history = useHistory()
    const loggedIn = useSelector(state => state.login.loggedIn)
    const currentUser = useSelector(state => state.login.user.username)
    if (!loggedIn) {
        history.pushState('/login')
    }


    // For selecting datelogin. and time
    const [dateTime, setDateTime] = useState(new Date());

    // Dummy booking for test purposes
    // const [newBooking, setNewBooking] = useState({
    //     dateTime: '',
    //     customer: 'username',
    //     worker: 'worker',
    //     service: 'Barber'
    // })
    
    const [newBooking, setNewBooking] = useState({
        bookingDateTime: '',
        customer: currentUser,
        worker: 'worker',
        service: ''
    })

    const dispatch = useDispatch()
    
    

    return (
        <div>
            <div className="datePicker">
                <div id="dateSelect" >
                <DateTimePicker onChange={setDateTime} value={dateTime} />
                </div>
            </div>
            <form>
                <label>Select Service</label>
                <select value={newBooking.service} onChange={e => setNewBooking({...newBooking, service: e.target.value})} placeholder='Service'>
                    <option value='Barber'>Barber</option>
                    <option value='Lawyer'>Lawyer</option>
                </select>

                <label>Select Worker</label>
                <select value={newBooking.worker} onChange={e => setNewBooking({...newBooking, worker: e.target.value})} placeholder='Worker'>
                    <option value='worker'>Worker</option>
                </select>
                <input type='button' onClick={() => dispatch(createBooking(newBooking))} value='Create Booking' />
            </form>

            <h2>{JSON.stringify(dateTime)}</h2>
            <h2>{JSON.stringify(newBooking.service)}</h2>
            <h2>{JSON.stringify(newBooking.worker)}</h2>
            <h2>{JSON.stringify(newBooking.customer)}</h2>
        </div>
    )
}

export default CreateBookingContainer
