import React from 'react'
import {useSelector} from 'react-redux'

function Home() {

    const loggedIn = useSelector(state => state.login.loggedIn)

    return (
        <div>
            <h1>HOME PAGE HERE</h1>
            <h2>Logged in: {JSON.stringify(loggedIn)}</h2>
            
        </div>
    )
}

export default Home