import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import DateTimePicker from 'react-datetime-picker';

import "./Home.css";
import Card from "./Card";
import Popup from './Popup.js';

import legal from "../../public/images/legal.jpg"
import barber from "../../public/images/barber.jpg";
import trainer from "../../public/images/personal_training.jpg";
import accounting from "../../public/images/accounting.jpg";
import spa from "../../public/images/spa.jpg";
import tutor from "../../public/images/tutoring.jpg";


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

    const [isClick, setIsClick] = useState(false);
    

  return (
    <div className="home">
        <div className="datePicker">
            <div id="dateSelect" >
            <DateTimePicker
                onChange={onChange}
                value={value}
            />
            </div>
        </div>

      <div className="home__section">
      <Popup isClick = {isClick}  setIsClick ={setIsClick}/>

            <div onClick={() => { setIsClick(true) }}>
                <Card
                src={legal}
                title="Pearson Spector - Law Firm"
                description="Expert Legal services, led by a team of exceptional Attorneys."
                />
            </div>

            <div onClick={() => history.push('/booking')}>
                <Card
                src={barber}
                title="Bristol Barbers"
                description="Beautiful hair in professional hands."
                />
            </div>
        
            <Card
            src={trainer}
            title="Personal Power"
            description="Fitness and personal development solutions."
            />
      </div>

      <div className="home__section">
        <Card
            src={accounting}
            title="Litt Accounting Inc."
            description="Big firm capability. Small firm personality."
            />
        
        <Card
            src={spa}
            title="Serenity Day Spa"
            description="Body and soul together."
            />
        
        <Card
            src={tutor}
            title="LessonUp - Tutoring"
            description="At the heart of learning."
            />


      </div>
    </div>
  );
}

export default Home;
