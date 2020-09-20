import React from 'react';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import './App.css';
import LoginForm from './components/Login/LoginForm';
import Header from "./components/Layout/Header";
import Home from "./components/Home/Home";
import BookingPage from "./components/Booking/BookingPage"
import Booking_History from './components/Booking/BookingHistory';


function App() {
  return (
  <div className="app">
      <Router>
        <Header />
        <Switch>
          <Route path="/booking">
            <BookingPage />
          </Route>
          <Route path='login' component={LoginForm} />
          <Route path='/history' component={Booking_History}/>
          <Route exact path="/">
            <Home />
          </Route>
        </Switch>
  
      </ Router>
    </div>
    );
    
}

export default App;