import React from 'react';
import {BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import {Provider} from 'react-redux'
import './App.css';
import Welcome from './components/Welcome';
// import LoginForm from "./components/LoginForm";
// import Header from "./components/Layout/Header";
import Home from './components/HomePages/Home';
import About from "./components/HomePages/About";
import Contact from "./components/HomePages/Contact";
// import RegistrationForm from './components/RegistrationForm';
import HeaderHooks from './components/Layout/HeaderHooks';
import store from './redux/store';
import LoginContainer from './components/Login/LoginContainer'


function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="App">
            <Welcome/>
            {/*<Header/>*/}
            <HeaderHooks />
            <Switch>
              <Route exact path="/" component={Home}/>
              <Route path="/about" component={About}/>
              <Route path="/contact" component={Contact}/>
              {/*<Route path="/registration" component={RegistrationForm}/>*/}
              <Route path="/login" component={LoginContainer}/>
            </Switch>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
