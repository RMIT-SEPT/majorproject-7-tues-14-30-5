import React from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { Navbar, Nav} from "react-bootstrap";
import { logout } from '../../redux'

function HeaderHooks() {

    const loggedIn = useSelector(state => state.login.loggedIn)
    const dispatch = useDispatch()

    if (!loggedIn) {
        return (
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="/">AGME</Navbar.Brand>
                <Nav className="mr-auto">
                    <Nav.Link href="/">Home</Nav.Link>
                    <Nav.Link href="/about">About</Nav.Link>
                    <Nav.Link href="/contact">Contact Us</Nav.Link>
                </Nav>
                <Nav className="ml-auto">
                    <Nav.Link href="/login" activeclassname="current">Log In</Nav.Link>
                    <Nav.Link href="/registration">Sign Up</Nav.Link>
                </Nav>
            </Navbar>
        )

    } else {
        return (
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="/">AGME</Navbar.Brand>
                <Nav className="mr-auto">
                    <Nav.Link href="/">Home</Nav.Link>
                    <Nav.Link href="/about">About</Nav.Link>
                    <Nav.Link href="/contact">Contact Us</Nav.Link>
                </Nav>
                <Nav className="ml-auto">
                    <Nav.Link href="/" activeclassname="current" onClick={() => dispatch(logout)}>Log Out</Nav.Link>
                </Nav>
            </Navbar>
        )
    }
}

export default HeaderHooks