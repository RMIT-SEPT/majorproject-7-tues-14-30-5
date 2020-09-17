import React from 'react';
import './App.css';
import Welcome from './components/Welcome';
import LoginForm from "./components/LoginForm";
import Header from "./components/Layout/Header";
import Home from './components/HomePages/Home';
import About from "./components/HomePages/About";
import Contact from "./components/HomePages/Contact";
import {BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import RegistrationForm from './components/RegistrationForm';


function App() {
  return (
    <Router>
      <div className="App">
          <Welcome/>
          <Header/>
          <Switch>
            <Route exact path="/" component={Home}/>
            <Route path="/about" component={About}/>
            <Route path="/contact" component={Contact}/>
            <Route path="/registration" component={RegistrationForm}/>
            <Route path="/login" component={LoginForm}/>
          </Switch>
      </div>
    </Router>
  );
}

export default App;
