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

    if (!loggedIn) {
        // console.log('Not Logged in')
    } else {
        console.log('Logged in!')
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
