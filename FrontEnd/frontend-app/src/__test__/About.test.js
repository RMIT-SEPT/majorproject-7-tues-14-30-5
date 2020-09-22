import React from 'react';
import ReactDOM from 'react-dom';
import {render} from '@testing-library/react';
import About from '../components/Home/About';
import renderer from 'react-test-renderer';


it("renders About button without crashing",() => {
    const dev = document.createElement("dev");
    ReactDOM.render(<About></About>, dev);
})


it("About Class Snapshot is Matched",() => {
  
    const tree = renderer.create(<About></About>).toJSON();
    expect(tree).toMatchSnapshot();
})