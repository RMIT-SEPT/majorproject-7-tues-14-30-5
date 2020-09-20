import React, { useState } from 'react'
import {useSelector, useDispatch} from 'react-redux'
import { useHistory } from 'react-router-dom'
import { login } from '../../redux'


function LoginContainer() {

    const [customerLogin, setLogin] = useState({
        username:'',
        password:''
    })
    
    const history = useHistory()

    const loggedIn = useSelector(state => state.login.loggedIn)
    const dispatch = useDispatch()

    if (loggedIn) {
        history.push('/')
    }

    return (
        <div>
            <form>
                <label>Username:</label>
                <input type='text' value={customerLogin.username} onChange={e => setLogin({...customerLogin, username: e.target.value})} placeholder="Username" />
                <label>Password:</label>
                <input type='password' value={customerLogin.password} onChange={e => setLogin({...customerLogin, password: e.target.value})} placeholder="Password" />
                <input type='button' onClick={()=>dispatch(login(customerLogin))} value='Login'/>
            </form>

            <h2>{JSON.stringify(customerLogin)}</h2>
            <h2>{JSON.stringify(loggedIn)}</h2>
        </div>

    )

}

export default LoginContainer
import React, { Component } from "react";
import { Button, Form } from "react-bootstrap";
import Logo from "../../public/logo/Logo.png";
import axios from "axios";
import "./loginForm.css";

export default class LoginForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: "",
    };
    this.signIn = this.signIn.bind(this);
    this.formChange = this.formChange.bind(this);
  }
  signIn(event) {
    const data = {
      username: this.state.username,
      password: this.state.password,
    };
    axios
      .post("http://localhost:8080/login", data)
      .then((r) => console.log(r))
      .catch((error) => console.log(error));
    event.preventDefault();
  }
  formChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }

  render() {
    return (
      // <div className="col-md-5 col-md-offset-2">
      <div className="login">
      
        <div className="login__container">
        <img className="loginBox__logo" src={Logo} alt="" />
          <Form onSubmit={this.signIn} id="loginFormId">
            <form username="">
              <Form.Group controlId="formBasicEmail">
                <Form.Row>
                  <Form.Control
                    required
                    name="username"
                    value={this.state.username}
                    onChange={this.formChange}
                    type="username"
                    placeholder="Username"
                  />
                </Form.Row>
              </Form.Group>
            </form>

            <form password="">
              <Form.Group controlId="formBasicPassword">
                <Form.Row>
                  <Form.Control
                    required
                    name="password"
                    value={this.state.password}
                    onChange={this.formChange}
                    type="password"
                    placeholder="Password"
                  />
                </Form.Row>
              </Form.Group>
            </form>

            <Button variant="success" type="submit">
              Submit
            </Button>
          </Form>
        </div>
      </div>
    );
  }
}
