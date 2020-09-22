import React, { useState } from 'react'
import {useSelector, useDispatch} from 'react-redux'
import { useHistory } from 'react-router-dom'
import { login } from '../../redux'
import { Button, Form } from "react-bootstrap";
import './loginForm.css'
import Logo from '../../public/logo/Logo.png'


function LoginForm() {

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
        <div className='login'>
          <div className='login__container'>
            <img className='loginBox__logo' src={Logo} alt='AGME_Logo' />
            <Form.Row id="username">
                <input type='text' value={customerLogin.username} onChange={e => setLogin({...customerLogin, username: e.target.value})} placeholder="Username" />
            </Form.Row>
            <Form.Row id="password">
                <input type='password' value={customerLogin.password} onChange={e => setLogin({...customerLogin, password: e.target.value})} placeholder="Password" />
                </Form.Row>
                <Form.Row id="submit_button">
                <input type='button' onClick={()=>dispatch(login(customerLogin))} value='Login'/>
                </Form.Row>
          </div>

        </div>

    )

}

export default LoginForm