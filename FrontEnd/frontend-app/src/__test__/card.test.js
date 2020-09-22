import React from 'react';
 import ReactDOM from 'react-dom';
 import Card from '../components/Home/Card';
 import Header from '../components/Login/LoginForm.js';

import {render, cleanup, getByTestId} from "@testing-library/react";
import legal from "../public/images/legal.jpg";
import "@testing-library/jest-dom" ;
import LoginForm from '../components/Login/LoginForm.js';

const ReactTestRenderer = require('react-test-renderer');

afterEach(cleanup)

 it ("renders without crashing", () =>   {
    const div = document.createElement("div");
    expect(ReactDOM.render(<Card></Card>,div)).toBeTruthy;
 });


 it("renders card correctly", ()=> {
     render(<Card
        src={legal}
        title="Pearson Spector - Law Firm"
        description="Expert Legal services, led by a team of exceptional Attorneys."
        />)
        // expect(getByTestId('card-test')).toHaveProperty()
        // expect(getByTestId('card-test')).toHaveAttribute()
        // const object = getByTestId(document, 'card-test');
        
        expect(getByTestId(document, 'card-test')).toHaveProperty('title')
        expect(getByTestId(document, 'card-test')).toHaveTextContent("Pearson Spector - Law Firm")
        expect(getByTestId(document, 'card-test')).toHaveTextContent("Expert Legal services, led by a team of exceptional Attorneys.")
        
 });


 it("matches-snapshot", () => {
    const tree = ReactTestRenderer.create(<Card
        src={legal}
        title="Pearson Spector - Law Firm"
        description="Expert Legal services, led by a team of exceptional Attorneys."
        />).toJSON();

    expect(tree).toMatchSnapshot();
 })



