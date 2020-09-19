import { Button } from "@material-ui/core";
import React, { useState } from "react";
import "./Card.css";
import Popup from './Popup.js';


  
    // <Button variant="primary" onClick={() => setShow(true)}>
    //       Custom Width Modal
    //     </Button>


function Card({ src, title, description, price }) {

  // const [value, setPopup] = useState(false);

  // const updateState = (value) => {
  //   setPopup(value)
  //   console.log("Changed State: value = ",value);
  // }


  const [isClick, setIsClick] = useState(false);




  console.log("value at 26 = ",isClick);
  return (
    <div className="card">
          <img src={src} alt="" />
          <div className="card__info">
            <h2>{title}</h2>
            <h4>{description}</h4>
            <h3>{price}</h3>
          </div>
    </div>
  );
}

export default Card;
