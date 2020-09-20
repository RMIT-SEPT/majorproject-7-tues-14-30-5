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
