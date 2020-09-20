import React from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { logout } from '../../redux'
import { Link, useHistory } from 'react-router-dom'

import './Header.css'
import Logo from '../../public/logo/Logo.png'
import Navbar from './Navbar'

function Header() {
    
    const loggedIn = useSelector(state => state.login.loggedIn)
    const dispatch = useDispatch()

    const history = useHistory()
    
    return (
        <div className="header">    
            <Navbar/>
            <Link to='/' className= "header__icon">
                <img className="header__icon" src={Logo} alt="AGME_Logo" />
            </Link>
              
            <div className="header__center">
                <button class="home__button" onClick={() => history.push('/')}>HOME</button>
                {!loggedIn ? 
                    <button class="About__button" onClick={history.push('/login')}>LOGIN</button> :
                    <button class="About__button" onClick={() => dispatch(logout)}>LOGOUT</button> 
                }
                
                <button class="About__button" onClick={() => history.push('/login')}>LOGIN</button>
                <button class="Contact__button" onClick={() => history.push('/contact')} >CONTACT</button>
            </div>

      
        </div>


        
        
        // if (!loggedIn) {
            
            //     <Navbar bg="dark" variant="dark">
            //         <Navbar.Brand href="/">AGME</Navbar.Brand>
        //         <Nav className="mr-auto">
        //             <Nav.Link href="/">Home</Nav.Link>
        //             <Nav.Link href="/about">About</Nav.Link>
        //             <Nav.Link href="/contact">Contact Us</Nav.Link>
        //         </Nav>
        //         <Nav className="ml-auto">
        //             <Nav.Link href="/login" activeclassname="current">Log In</Nav.Link>
        //             <Nav.Link href="/registration">Sign Up</Nav.Link>
        //         </Nav>
        //     </Navbar>
            
        // } else {
        //     return (
        //         <Navbar bg="dark" variant="dark">
        //         <Navbar.Brand href="/">AGME</Navbar.Brand>
        //         <Nav className="mr-auto">
        //         <Nav.Link href="/">Home</Nav.Link>
        //         <Nav.Link href="/about">About</Nav.Link>
        //         <Nav.Link href="/contact">Contact Us</Nav.Link>
        //         </Nav>
        //         <Nav className="ml-auto">
        //         <Nav.Link href="/" activeclassname="current" onClick={() => dispatch(logout)}>Log Out</Nav.Link>
        //         </Nav>
        //         </Navbar>
        //     )
        // }
    )
}

export default Header