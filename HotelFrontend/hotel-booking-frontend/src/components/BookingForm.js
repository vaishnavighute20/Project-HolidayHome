// src/components/BookingForm.js
import React, { useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import './BookingForm.css';

function BookingForm() {
  const { id } = useParams();
  const [bookingDetails, setBookingDetails] = useState({
    checkIn: '',
    checkOut: '',
    roomType: ''
  });

  const handleInputChange = (e) => {
    setBookingDetails({
      ...bookingDetails,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post(`http://localhost:8080/api/hotels/${id}/book`, bookingDetails)
      .then(response => {
        console.log('Booking successful', response.data);
      })
      .catch(error => console.error('Error booking hotel:', error));
  };

  return (
    <form onSubmit={handleSubmit} className="booking-form">
      <div>
        <label>Check-In Date:</label>
        <input type="date" name="checkIn" value={bookingDetails.checkIn} onChange={handleInputChange} required />
      </div>
      <div>
        <label>Check-Out Date:</label>
        <input type="date" name="checkOut" value={bookingDetails.checkOut} onChange={handleInputChange} required />
      </div>
      <div>
        <label>Room Type:</label>
        <select name="roomType" value={bookingDetails.roomType} onChange={handleInputChange} required>
          <option value="single">Single</option>
          <option value="double">Double</option>
          <option value="suite">Suite</option>
        </select>
      </div>
      <button type="submit">Book Now</button>
    </form>
  );
}

export default BookingForm;
