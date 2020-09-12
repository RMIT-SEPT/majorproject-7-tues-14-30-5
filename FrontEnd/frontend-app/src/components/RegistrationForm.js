import React, { Component } from 'react'
import axios from 'axios'

export default class RegistrationForm extends Component {

    state = {
        username:'',
        password:'',
        verifyPassword:'',
        name:'',

    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>Username: <input type='text' name='username' onChange={this.handleChange} /></label><br />
                    <label>Password: <input type='text' name='password' onChange={this.handleChange} /></label><br />
                    <label>Re-enter password: <input type='text' name='verifyPassword' onChange={this.handleChange} /></label><br />
                    <label>Name: <input type='text' name='name' onChange={this.handleChange} /></label><br />
                    <label>Address: <input type='text' name='address' onChange={this.handleChange} /></label><br />
                    <label>Contact No: <input type='text' name='contactNo' onChange={this.handleChange} /></label><br />
                    <button type ='submit'>Register</button>
                </form>
            </div>
        )
    }
}
