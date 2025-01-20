import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom'; 
import NavbarComponent from './components/NavbarComponent';
import LoginComponent from './components/LoginComponent';
import RegisterComponent from './components/RegisterComponent';
import HomeComponent from './components/HomeComponent';
import AboutComponent from './components/AboutComponent';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <div className='App'>
    <NavbarComponent />
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<HomeComponent />} />
          <Route path='/login' element={<LoginComponent />} />
          <Route path="/register" element={<RegisterComponent/>} />
          <Route path="/about" element={<AboutComponent/>}></Route>
        </Routes>
      </BrowserRouter>
  </div>
);
