import React, {Component} from "react";
import { Button, Form } from 'react-bootstrap';
import axios from 'axios';
import './Header.css'
import Logo from "../Logo.png";

import LanguageIcon from "@material-ui/icons/Language";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import { Avatar } from "@material-ui/core";

import { Link } from "react-router-dom";

import Navbar from "./Navbar"

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
          <div className="header">

          <Navbar/>

            <Link to='/' className= "header__icon">
                <img
                className="header__icon"
                src={Logo}
                alt=""
                />
            </Link>
              
            <div className="header__center">
              <button class="home__button">HOME</button>
              <button class="About__button">ABOUT</button>
              <button class="Contact__button">CONTACT</button>
            </div>


          </div>
        );

    }

}
