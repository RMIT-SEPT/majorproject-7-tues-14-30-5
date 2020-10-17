import React, { useState, useEffect } from 'react'
import { createBooking, createBookingRequest, setBookingType } from '../../redux'
import { useDispatch, useSelector } from 'react-redux'

import DateTimePicker from 'react-datetime-picker';
import { useHistory } from 'react-router-dom';
import './booking_new.css'

import { BARBER, LAWYER, TRAINER, ACCOUNTANT, SPA, TUTOR, NONE} from '../../redux/booking/bookingTypes'

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
        history.push('/login')
    }



    let service_name = "";
    let service_type = "";

    const bookingType = useSelector(state => state.booking.booking_service)
    
    useEffect(() => {
    console.log(bookingType);
    dispatch(createBookingRequest());
    },[bookingType])

    if (bookingType !== NONE) {
      if (bookingType === LAWYER) {
        service_name = "Pearson Spector - Law Firm";
        service_type = "LAWYER";
      } 
      else if (bookingType === BARBER) {
        service_name = "Bristol Barbers";
        service_type = "BARBER";
      } 
      else if (bookingType === TRAINER) {
        service_name = "Personal Power";
        service_type = "TRAINER";
      } 
      else if (bookingType === ACCOUNTANT) {
        service_name = "Litt Accounting Inc.";
        service_type = "ACCOUNTANT";
      } 
      else if (bookingType === SPA) {
        service_name = "Serenity Day Spa";
        service_type = "SPA";
      } 
      else if (bookingType === TUTOR) {
        service_name = "LessonUp - Tutoring";
        service_type = "TUTOR";
      
      }
    }



    return (
      <div id="booking">
        <div id="service__title">
        <h2>{service_name}</h2>
       </div>
           <div id="booking__container">
            <div className="datePicker">
              <div id="dateSelect__bookingPage">
                <DateTimePicker
                  onChange={setBookingDateTime}
                  value={bookingDateTime}
                />
              </div>
            </div>
            {/*<div id="select__service">
              <form id="select__service">
                <label>Select Service</label>
                <select
                  onChange={(e) =>
                    setNewBooking({ ...newBooking, service: e.target.value })
                  }
                  placeholder="Service"
                >
                  <option defaultValue=""> -- select an option -- </option>
                  <option value="Barber">Barber</option>
                  <option value="Lawyer">Lawyer</option>
                </select>
              </form>
            </div>*/}


            <div id="select__worker">
              <form id="select__worker">
                <label>Select Worker  </label>
                <select
                  onChange={(e) =>
                    setNewBooking({ ...newBooking, worker: e.target.value })
                  }
                  placeholder="Worker"
                >
                  <option defaultValue> -- select an option -- </option>
                  <option value="worker">Worker</option>
                  <option value="worker2">Worker2</option>
                </select>
              </form>
            </div>
            <div id="submit">
              <form id="submit">
                <input
                  type="button"
                  onClick={() => {
                    setNewBooking({ ...newBooking, dateTime: bookingDateTime });
                    setNewBooking({ ...newBooking, service: service_type})
                    dispatch(createBooking(newBooking));
                  }}
                  value="Create Booking"
                />
              </form>
            </div>


            <div id="booking__message">
                {!booking.justBooked ? (
                <>
                    {/*<h2>{JSON.stringify(bookingDateTime)}</h2>
                        <h2>{JSON.stringify(newBooking.service)}</h2>
                        <h2>{JSON.stringify(newBooking.worker)}</h2>
                        <h2>{JSON.stringify(newBooking.customer)}</h2>*/}
                </>
                ) : (
                <h3>
                Your booking for a {booking.booking.service.serviceName} has been confirmed
                </h3>
                )
            }
            </div>

          </div>
      </div>
    );
}

export default CreateBookingContainer
