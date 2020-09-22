import React from 'react';
import ReactDOM from 'react-dom';
import {render} from '@testing-library/react';
import Contact from '../components/Home/Contact.js';
import renderer from 'react-test-renderer';



it("renders Contact button without crashing",() => {
    const dev = document.createElement("dev");
    ReactDOM.render(<Contact></Contact>, dev);
})


it("Contact Class Snapshot is Matched",() => {
 
    const tree = renderer.create(<Contact></Contact>).toJSON();
    expect(tree).toMatchSnapshot();
})