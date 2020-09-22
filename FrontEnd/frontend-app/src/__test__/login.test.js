import React from 'react';
 import ReactDOM from 'react-dom';
 import {useSelector, useDispatch, Provider} from 'react-redux'
 import Card from '../components/Home/Card';
 import Login from '../components/Login/LoginForm.js';

import {render, cleanup, getByTestId} from "@testing-library/react";
import legal from "../public/images/legal.jpg";
import "@testing-library/jest-dom" ;
import LoginForm from '../components/Login/LoginForm.js';

import configureMockStore from 'redux-mock-store'
import { login } from '../redux';


import Header from '../components/Layout/Header';
const ReactTestRenderer = require('react-test-renderer');

let store;
const mockStore = configureMockStore([]);

const initialState = {login:{
    loading: false,
    loggedIn: false,
    user: {},
    error:''
}}
 
beforeEach(() => {
 store = mockStore(initialState);
});


it ("renders correctly", () =>   {
    // const div = document.createElement("div");
    // expect(ReactDOM.render(<Provider><Login /></Provider>,div)).toBeTruthy

    render( <Provider store={store}> <Login/> </Provider>)
 });



