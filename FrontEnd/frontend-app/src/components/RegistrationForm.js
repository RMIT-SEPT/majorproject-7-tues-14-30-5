import React, { Component } from 'react'
import axios from 'axios'

export default class RegistrationForm extends Component {

    constructor(props) {
        super(props)
        this.state = {
            username:'',
            password:'',
            verifyPassword:'',
            name:'',
            address:'',
            contactNo:''
        };
    }

    // state = {
    //     username:'',
    //     password:'',
    //     verifyPassword:'',
    //     name:'',
    //     address:'',
    //     contactNo:''

    // }

    handleChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    handleSubmit = event => {
        event.preventDefault();

        const user = {
            username: this.state.username,
            password: this.state.password,
            name: this.state.name,
            address: this.state.address,
            contactNo: this.state.contactNo
        };

        const {password, verifyPassword} = this.state;

        if (password !== verifyPassword) {
            alert("Passwords don't match!");

        } else {
            axios.post('http://localhost:8080/api/user/registration', {user})
                .then(res => {
                    console.log(res);
                    console.log(res.data);
                })

        }

    }



    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>Username: <input type='text' name='username' onChange={this.handleChange} /></label><br />
                    <label>Password: <input type='password' name='password' onChange={this.handleChange} /></label><br />
                    <label>Re-enter password: <input type='password' name='verifyPassword' onChange={this.handleChange} /></label><br />
                    <label>Name: <input type='text' name='name' onChange={this.handleChange} /></label><br />
                    <label>Address: <input type='text' name='address' onChange={this.handleChange} /></label><br />
                    <label>Contact No: <input type='text' name='contactNo' onChange={this.handleChange} /></label><br />
                    <button type ='submit'>Register</button>
                </form>
            </div>
        )
    }
}
