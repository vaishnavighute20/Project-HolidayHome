// src/components/HotelDetails.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import './HotelDetails.css';

function HotelDetails() {
  const { id } = useParams();
  const [hotel, setHotel] = useState(null);

  useEffect(() => {
    axios.get(`http://localhost:8080/api/hotels/${id}`)
      .then(response => setHotel(response.data))
      .catch(error => console.error('Error fetching hotel details:', error));
  }, [id]);

  if (!hotel) return <div>Loading...</div>;

  return (
    <div className="hotel-details">
      <h2>{hotel.name}</h2>
      <p>{hotel.description}</p>
      <div className="hotel-info">
        <h3>Rooms</h3>
        <ul>
          {hotel.rooms.map(room => (
            <li key={room.id}>
              {room.type} - ${room.price} per night
            </li>
          ))}
        </ul>
        <h3>Amenities</h3>
        <ul>
          {hotel.amenities.map(amenity => (
            <li key={amenity.id}>{amenity.name}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default HotelDetails;
