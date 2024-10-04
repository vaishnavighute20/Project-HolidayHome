// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './components/Home';
import HotelList from './components/HotelList';
import HotelDetails from './components/HotelDetails';
import BookingForm from './components/BookingForm';
import UserProfile from './components/UserProfile';
import RegistrationForm from './components/registrationform';
import Login from './components/Login';
import './App.css';

function App() {
  return (
    <Router>
      <Header />
      <main>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/hotels" element={<HotelList />} />
          <Route path="/hotel/:id" element={<HotelDetails />} />
          <Route path="/hotel/:id/book" element={<BookingForm />} />
          <Route path="/profile" element={<UserProfile />} />
          <Route path="/signup" element={<RegistrationForm />} />
          <Route path="/login" element={<Login />} />
                  </Routes>
      </main>
      <Footer />
    </Router>
  );
}

export default App;
