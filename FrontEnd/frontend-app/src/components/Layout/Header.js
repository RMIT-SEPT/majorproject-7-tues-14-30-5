import React, {Component} from "react";
import { Navbar, Nav} from "react-bootstrap";

class Header extends Component {
    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="#home">AGME</Navbar.Brand>
                <Nav className="mr-auto">
                    <Nav.Link href="/">Home</Nav.Link>
                    <Nav.Link href="/about">About AGME</Nav.Link>
                    <Nav.Link href="/contact">Contact Us</Nav.Link>
                </Nav>
                <Nav className="ml-auto">
                    <Nav.Link href="/login" activeClassName="current">Log In</Nav.Link>
                    <Nav.Link href="/signup">Sign Up</Nav.Link>
                </Nav>
            </Navbar>
            
            
            
        )
    }
}

export default Header