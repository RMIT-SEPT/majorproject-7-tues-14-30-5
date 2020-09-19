import React from 'react';
import './App.css';
import Welcome from './components/Welcome.js'
import LoginForm from './components/LoginForm.js';
import Header from "./components/Header.js";
import Home from "./components/Home.js";
import BookingPage from "./components/BookingPage"

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Booking_History from './components/history';

function App() {
  return (
  <div className="app">
      <Router>
        <Header />
        
        <Switch>
          <Route path="/booking">
            <BookingPage />
          </Route>

          <Route path='/history' component={Booking_History}/>

          <Route path="/">
            <Home />
          </Route>
        </Switch>
  
      </ Router>
    </div>
    );
    
}

export default App;
{/* Home */}

  {/* Header */}

  {/* Banner */}
    {/* Search */}


  {/* Card */}
      {/* Search */}



