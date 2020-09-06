import React, {Component} from "react";
import { Button, Form } from 'react-bootstrap';
import axios from 'axios';
import './LoginForm.css'
export default class LoginForm extends Component {

    constructor(props) {
        super(props)
        this.state = {
		username:"",
		password:""
	};
        this.signIn = this.signIn.bind(this)
        this.formChange = this.formChange.bind(this)
    }
    signIn(event)
    {
        const data = {
		username: this.state.username,
		password: this.state.password
	};
        axios.post('http://localhost:8080/login', data).then(r => console.log(r)).catch(error => console.log(error));
        event.preventDefault()
        
    }
    formChange(event)
    {
        this.setState({
            [event.target.name]:event.target.value
        });
    }


    render() {
        return (
            <div className="Main"> 
              <div className="Logo"> </div>
                <div className="LetterA"> A</div>
                    <div className="LetterG"> G</div>
                        <div className="LetterM"> M</div>
                            <div className="LetterE"> E</div>
                                <div className="AGME"> AGME Booking Solution</div>
                {/* <div className="Home"> Home</div> */}
                {/* <div className="Contact"> Contact</div> */}
                {/* <div className="About"> About</div> */}
                <button class="homeBtn">HOME</button>
                <button class="AboutBtn">ABOUT</button>
                <button class="ContactBtn">CONTACT</button>
                




               
                

                
                {/* <Form onSubmit={this.signIn} id="loginFormId">
                    <Form.Group controlId="formBasicEmail">
                        <Form.Row>
                            <Form.Label>Username</Form.Label>
                            <Form.Control required name="username" value={this.state.username} onChange={this.formChange} type="username" placeholder="Username" />
                        </Form.Row>
                    </Form.Group>

                    <Form.Group controlId="formBasicPassword">
                        <Form.Row>
                            <Form.Label>Password</Form.Label>
                            <Form.Control required name="password" value={this.state.password} onChange={this.formChange} type="password" placeholder="Password" />
                        </Form.Row>
                    </Form.Group>

                    <Button variant="success" type="submit">
                        LOGIN
                    </Button>
                </Form> */}
                
            </div>
        )

    }

}
