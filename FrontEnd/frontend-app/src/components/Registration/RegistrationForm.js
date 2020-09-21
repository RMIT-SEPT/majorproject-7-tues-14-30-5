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
            contactNo:'',
            role:'customer'
        };

    }

    handleChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    handleSubmit = (event) => {
        
        event.preventDefault();

        const user = {
            username: this.state.username,
            password: this.state.password,
            name: this.state.name,
            address: this.state.address,
            contactNo: this.state.contactNo,
            role: this.state.role
        };
        
        const passwordCheck = {password: this.state.password, verifyPassword: this.state.verifyPassword};
        
        if (passwordCheck.password !== passwordCheck.verifyPassword) {
            alert("Passwords don't match!");
            
        } else {

            axios.post('http://localhost:8080/api/registration', user)
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
            
        }

    }
        
    render() {

        const {username, password, name, verifyPassword, address, contactNo} = this.state


        return (
            <div>
                <h1>Register new customer</h1>
                <form onSubmit={this.handleSubmit}>
                    <div className='form-group'>
                        <label>Username:</label>
                        <input type='text' className='form-control' id='username"' placeholder='Enter username' name='username' value={username} onChange={this.handleChange} />
                    </div>
                    <div className='form-group'>
                        <label>Password:</label>
                        <input type='password' className='form-control' id='password"' placeholder='Enter password' name='password' value={password} onChange={this.handleChange} />
                    </div>
                    <div className='form-group'>
                        <label>Re-enter Password:</label>
                        <input type='password' className='form-control' id='verifyPassword"' placeholder='Verify password' name='verifyPassword' value={verifyPassword} onChange={this.handleChange} />
                    </div>
                    <div className='form-group'>
                        <label>Name:</label>
                        <input type='text' className='form-control' id='name"' placeholder='Enter name' name='name' value={name} onChange={this.handleChange} />
                    </div>
                    <div className='form-group'>
                        <label>Address:</label>
                        <input type='text' className='form-control' id='address"' placeholder='Enter address' name='address' value={address} onChange={this.handleChange} />
                    </div>
                    <div className='form-group'>
                        <label>Contact Number:</label>
                        <input type='text' className='form-control' id='contactNo"' placeholder='Enter contact' name='contactNo' value={contactNo} onChange={this.handleChange} />
                    </div>
                    <button type='submit' className='btn-default'>Submit</button>
                </form>
            </div>
        )
    }

}
