import React, { useState } from 'react'
import { createBooking } from '../../redux'
import { useDispatch, useSelector } from 'react-redux'

import DateTimePicker from 'react-datetime-picker';
import { useHistory } from 'react-router-dom';
import './booking_new.css'

function CreateBookingContainer() {

    const history = useHistory()
    const dispatch = useDispatch()

    const loggedIn = useSelector(state => state.login.loggedIn)
    const currentUser = useSelector(state => state.login.user.username)
    // const justBooked = useSelector(state => state.booking.justBooked)
    const booking = useSelector(state => state.booking)
    
    
    // For selectingbooking. datelogin. and time
    const [bookingDateTime, setBookingDateTime] = useState(new Date());
    
    const [newBooking, setNewBooking] = useState({
        dateTime: '2020-10-22T18:21:09.921Z',
        customer: currentUser,
        worker: '',
        service: ''
    })

    
    if (!loggedIn) {
        history.pushState('/login')
    }

    return (
        <div id= "booking">

        <div id= "booking__container">
            <div className="datePicker">
                <div id="dateSelect" >
                <DateTimePicker onChange={setBookingDateTime} value={bookingDateTime} />
                </div>
            </div>
            <div id= "select__service">
                <form id= "select__service">
                    <label>Select Service</label>
                    <select onChange={e => setNewBooking({...newBooking, service: e.target.value})} placeholder='Service'>
                        <option defaultValue=''> -- select an option -- </option>
                        <option value='Barber'>Barber</option>
                        <option value='Lawyer'>Lawyer</option>
                        </select>
                </form>
            </div>
            
            
            <div id= "select__worker">
                <form id= "select__worker">
                        
                    <label>Select Worker</label>
                    <select onChange={e => setNewBooking({...newBooking, worker: e.target.value})} placeholder='Worker'>
                        <option defaultValue> -- select an option -- </option>
                        <option value='worker'>Worker</option>
                        <option value='worker2'>Worker2</option>
                    </select>
                </form>
            </div>
            <div id="submit">
                <form id="submit"> 
                    <input type='button' onClick={() => {setNewBooking({...newBooking, dateTime: bookingDateTime}); dispatch(createBooking(newBooking))}} value='Create Booking' />
                </form>
            </div>
            
            

            {!booking.justBooked ?
                <>
                {
                    /*<h2>{JSON.stringify(bookingDateTime)}</h2>
                    <h2>{JSON.stringify(newBooking.service)}</h2>
                    <h2>{JSON.stringify(newBooking.worker)}</h2>
                    <h2>{JSON.stringify(newBooking.customer)}</h2>*/
                }
                </>

                :

                <h2>Your booking for a {booking.booking.service.serviceName} has been confirmed</h2>

            }
        </div>

        </div>
    )
}

export default CreateBookingContainer
