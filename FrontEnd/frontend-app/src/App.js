import React from 'react';
import './App.css';
import Welcome from './components/Welcome'
import LoginForm from "./components/LoginForm";
function App() {
  return (
    <div className="App">
        <Welcome/>
        <LoginForm/>
    </div>
  );
}

export default App;
