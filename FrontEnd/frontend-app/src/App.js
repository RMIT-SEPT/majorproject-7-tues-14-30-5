import React from 'react';
import {BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import {Provider} from 'react-redux'
import './App.css';
import store from './redux/store';
import Home from './components/HomePages/Home';
import About from "./components/HomePages/About";
import Contact from "./components/HomePages/Contact";
import HeaderHooks from './components/Layout/HeaderHooks';
import LoginContainer from './components/Login/LoginContainer'
import CreateBookingContainer from './components/Booking/CreateBookingContainer';


function App() {

  return (
    <Provider store={store}>
      <Router>
        <div className="App">
            <HeaderHooks />
            <Switch>
              <Route exact path="/" component={Home} />
              <Route path="/about" component={About} />
              <Route path="/contact" component={Contact} />
              <Route path="/login" component={LoginContainer} />
              <Route path='/booking/create' component={CreateBookingContainer} />
            </Switch>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
