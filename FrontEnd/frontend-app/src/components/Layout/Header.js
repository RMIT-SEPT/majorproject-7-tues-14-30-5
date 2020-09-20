import React, {Component} from "react";
import { Link } from "react-router-dom";

import './Header.css'
import Logo from '../../public/logo/Logo.png'
import Navbar from "./Navbar"


class Header extends Component {

    render() {
        return (
          <div className="header">

          <Navbar/>

            <Link to='/' className= "header__icon">
                <img className="header__icon" src={Logo} alt="AGME_Logo" />
            </Link>
              
            <div className="header__center">
              <button class="home__button">HOME</button>
              <button class="About__button">ABOUT</button>
              <button class="Contact__button">CONTACT</button>
            </div>

          </div>
        )

    }

}

export default Header
