// src/components/HotelList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './HotelList.css';

function HotelList() {
  const [hotels, setHotels] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/hotels')
      .then(response => setHotels(response.data))
      .catch(error => console.error('Error fetching hotels:', error));
  }, []);

  return (
    <div className="hotel-list">
      <h2>Available Hotels</h2>
      <ul>
        {hotels.map(hotel => (
          <li key={hotel.id}>
            <Link to={`/hotel/${hotel.id}`}>{hotel.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default HotelList;
