import React from 'react';
import {BrowserRouter as Router, Switch, Route, Redirect } from 'react-router-dom';
import {Provider} from 'react-redux'
import './App.css';
import store from './redux/store';
import Home from './components/HomePages/Home';
import About from "./components/HomePages/About";
import Contact from "./components/HomePages/Contact";
import HeaderHooks from './components/Layout/HeaderHooks';
import LoginForm from './components/Login/LoginForm'
import CreateBookingContainer from './components/Booking/CreateBookingContainer';


function App() {

  let currentStore = store.getState()

  return (
    <Provider store={store}>
      <Router>
        <div className="App">
            <HeaderHooks />
            <Switch>
              <Route exact path="/" component={Home} />
              <Route path="/about" component={About} />
              <Route path="/contact" component={Contact} />
              <Route path="/login" component={LoginForm} />
              <Route path='/booking/create' component={CreateBookingContainer}>
                {!currentStore.login.loggedIn ? <Redirect to='/login' /> : <CreateBookingContainer />}
              </Route>
            </Switch>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
