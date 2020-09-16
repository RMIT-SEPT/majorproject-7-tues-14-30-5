import React, { useState } from 'react'
import {useSelector, useDispatch} from 'react-redux'
import { login } from '../../redux'


function LoginContainer() {

    const [customerLogin, setLogin] = useState({
        username:'',
        password:''
    })

    const loggedIn = useSelector(state => state.login.loggedIn)
    const dispatch = useDispatch()

    if (!loggedIn) {
        // console.log('Not Logged in')
    } else {
        console.log('Logged in!')
    }

    return (
        <div>
            <form onSubmit={() => dispatch(login(customerLogin))}>
                <label>Username:</label>
                <input type='text' value={customerLogin.username} onChange={e => setLogin({...customerLogin, username: e.target.value})} placeholder="Username" />
                <label>Password:</label>
                <input type='password' value={customerLogin.password} onChange={e => setLogin({...customerLogin, password: e.target.value})} placeholder="Password" />
                <input type='submit' value='Login' />
            </form>
        </div>

    )

}

export default LoginContainer
