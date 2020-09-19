import React,{useState, useEffect} from "react";
import { Button } from "@material-ui/core";
import Modal from 'react-bootstrap/Modal';
import "./Popup.css"




//{value, setValue})

function Popup({isClick, setIsClick}) {

    // function handleChange(event) {
    //     // Here, we invoke the callback with the new value
    //     props.onChange(event.target.value);
    // }

    // const[value, setValue] = useState(false);

    // const clickHandler = (onHide) => {
    //     if (isClick == true){
    //         setValue(true);
    //     }
    //     else if (onHide == true ){
    //         setValue(false);
    //     }
    // }

    // const[value, setValue] = useState(false);

    // const clickHandler = () => {
    //     if(isClick){
    //         setValue(true);
    //     }
    // }

    // const[run, setRun] = useState(true);

    // // Anonymous Functionn
    // useEffect(()=>{
    //     if(isClick && run){

    //         setValue(true);
    //         setRun(false);
    //     }
    // })


    

    return (
      <>
        <Modal
          show={isClick}
          onHide={() => {
             setIsClick(false)
           }}
          dialogClassName="modal-90w"
          aria-labelledby="example-custom-modal-styling-title"
        >
          <Modal.Header closeButton>
            <Modal.Title id="example-custom-modal-styling-title">
              Custom Modal Styling
            </Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <p>
              Ipsum molestiae natus adipisci modi eligendi? Debitis amet quae
              unde commodi aspernatur enim, consectetur. Cumque deleniti
              temporibus ipsam atque a dolores quisquam quisquam adipisci
              possimus laboriosam. Quibusdam facilis doloribus debitis! Sit
              quasi quod accusamus eos quod. Ab quos consequuntur eaque quo rem!
              Mollitia reiciendis porro quo magni incidunt dolore amet atque
              facilis ipsum deleniti rem!
              Ipsum molestiae natus adipisci modi eligendi? Debitis amet quae
              unde commodi aspernatur enim, consectetur. Cumque deleniti
              temporibus ipsam atque a dolores quisquam quisquam adipisci
              possimus laboriosam. Quibusdam facilis doloribus debitis! Sit
              quasi quod accusamus eos quod. Ab quos consequuntur eaque quo rem!
              Mollitia reiciendis porro quo magni incidunt dolore amet atque
              facilis ipsum deleniti rem!
              Ipsum molestiae natus adipisci modi eligendi? Debitis amet quae
              unde commodi aspernatur enim, consectetur. Cumque deleniti
              temporibus ipsam atque a dolores quisquam quisquam adipisci
              possimus laboriosam. Quibusdam facilis doloribus debitis! Sit
              quasi quod accusamus eos quod. Ab quos consequuntur eaque quo rem!
              Mollitia reiciendis porro quo magni incidunt dolore amet atque
              facilis ipsum deleniti rem!
            </p>
          </Modal.Body>
        </Modal>
      </>
    );
  }
  export default Popup;