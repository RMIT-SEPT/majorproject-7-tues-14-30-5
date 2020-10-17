import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import DateTimePicker from 'react-datetime-picker';


import { useSelector, useDispatch } from 'react-redux'
import { setBookingType } from '../../redux'


import "./Home.css";
import Card from "./Card";
import Popup from './Popup.js';

import legal from "../../public/images/legal.jpg"
import barber from "../../public/images/barber.jpg";
import trainer from "../../public/images/trainer2.jpg";
import accounting from "../../public/images/accounting.jpg";
import spa from "../../public/images/spa2.jpg";
import tutor from "../../public/images/tutoring2.jpg";

import { BARBER, LAWYER, TRAINER, ACCOUNTANT, SPA, TUTOR, NONE} from '../../redux/booking/bookingTypes'


// import { useHistory } from "react-router-dom";

// const history = useHistory();
// const [showSearch, setShowSearch] = useState(false);


// const [show, setShow] = useState(false);
  
//     <Button variant="primary" onClick={() => setShow(true)}>
//           Custom Width Modal
//         </Button>

function Home() {
    const [value, onChange] = useState(new Date());
    const history = useHistory();

    const bookingType = useSelector(state => state.booking.bookingType)

    const dispatch = useDispatch()

    const [isClick, setIsClick] = useState(false);
    

  return (
    <div className="home" id="home">
        <div className="datePicker">
            <div id="dateSelect__home" >
            <DateTimePicker
                onChange={onChange}
                value={value}
            />
            </div>
        </div>

      <div className="home__section" id="home__section">
      <Popup isClick = {isClick}  setIsClick ={setIsClick}/>

            {/*
                For future Popup Implementation 
                <div onClick={() => { setIsClick(true) }}>
                <Card
                src={legal}
                title="Pearson Spector - Law Firm"
                description="Expert Legal services, led by a team of exceptional Attorneys."
                />
            </div>*/}
            

            <div onClick={() => {
                history.push('/booking/create')
                dispatch(setBookingType(LAWYER))
        }}>
                <Card
                src={legal}
                title="Pearson Spector - Law Firm"
                description="Expert Legal services, led by a team of exceptional Attorneys."
                />
            </div>

            <div onClick={() => {
                history.push('/booking/create')
                dispatch(setBookingType(BARBER))
            }}>
                <Card
                src={barber}
                title="Bristol Barbers"
                description="Beautiful hair in professional hands."
                />
            </div>
        
            <div onClick={() => {
                history.push('/booking/create')
                dispatch(setBookingType(TRAINER))
            }}>
                <Card
                src={trainer}
                title="Personal Power"
                description="Fitness and personal development solutions."
                />
            </div>
      </div>

      <div className="home__section" id="home__section">

        <div onClick={() => {
            history.push('/booking/create')
            dispatch(setBookingType(ACCOUNTANT))
        }}>
            <Card
                src={accounting}
                title="Litt Accounting Inc."
                description="Big firm capability. Small firm personality."
                />
        </div>

        <div onClick={() => {
            history.push('/booking/create')
            dispatch(setBookingType(SPA))
        }}> 
            <Card
                src={spa}
                title="Serenity Day Spa"
                description="Body and soul together."
                />
        </div>
        
        <div onClick={() => {
            history.push('/booking/create')
            dispatch(setBookingType(TUTOR))
        }}>
            <Card
            src={tutor}
            title="LessonUp - Tutoring"
            description="At the heart of learning."
            />
        </div>
        
      </div>
    </div>
  );
}

export default Home;
