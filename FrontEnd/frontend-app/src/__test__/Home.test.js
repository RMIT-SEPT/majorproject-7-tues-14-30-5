import React from 'react';
import ReactDOM from 'react-dom';
import {render} from '@testing-library/react';
import Home from '../components/Home/Home.js';
import renderer from 'react-test-renderer';

it("renders home page without crashing",() => {
    const dev = document.createElement("dev");
    ReactDOM.render(<Home></Home>, dev);
})


// it("Home Class Snapshot is Matched",() => {
   
//     const tree = renderer.create(<Home></Home>).toJSON();
//     expect(tree).toMatchSnapshot();
// })