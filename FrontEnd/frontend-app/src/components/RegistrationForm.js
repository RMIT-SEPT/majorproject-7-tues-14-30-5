import React, { Component } from 'react'
import axios from 'axios'

export default class RegistrationForm extends Component {

    state = {
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>Username: <input type='text' name='username' onChange={this.handleChange} /></label><br />
                    <label>Password: <input type='text' name='password' onChange={this.handleChange} /></label><br />
                    <label>Re-enter password: <input type='text' name='verifyPassword' onChange={this.handleChange} /></label><br />
                    <label>Name: <input type='text' name='username' onChange={this.handleChange} /></label><br />
                    <button type ='submit'>Register</button>
                </form>
            </div>
        )
    }
}
