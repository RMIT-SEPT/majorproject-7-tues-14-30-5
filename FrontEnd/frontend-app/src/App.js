import React from 'react';
import {BrowserRouter as Router, Switch, Route, Redirect } from 'react-router-dom'
import {Provider} from 'react-redux'
import './App.css'
import store from './redux/store'
import About from './components/Home/About'
import Header from './components/Layout/Header'
import Contact from './components/Home/Contact'
import Home from './components/Home/Home'
import LoginForm from './components/Login/LoginForm'
import CreateBookingContainer from './components/Booking/CreateBookingContainer'
import Booking_History from './components/Booking/BookingHistory'


function App() {

  let currentStore = store.getState()

  return (
    <Provider store={store}>
      <Router>
        <div className="App">
            <Header />
            <Switch>
              <Route exact path="/" component={Home} />
              <Route path="/about" component={About} />
              <Route path="/contact" component={Contact} />
              <Route path="/login" component={LoginForm} />
              <Route path='/booking/create' component={CreateBookingContainer}>
                {!currentStore.login.loggedIn ? <Redirect to='/login' /> : <CreateBookingContainer />}
              </Route>
              <Route path='/booking/history' component={Booking_History} />
            </Switch>
        </div>
      </Router>
    </Provider>
  )
    
}

export default App;