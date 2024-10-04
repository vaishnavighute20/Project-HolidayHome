// src/components/UserProfile.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './UserProfile.css';

function UserProfile() {
  const [user, setUser] = useState(null);
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/user/profile')
      .then(response => {
        setUser(response.data.user);
        setBookings(response.data.bookings);
      })
      .catch(error => console.error('Error fetching user profile:', error));
  }, []);

  if (!user) return <div>Loading...</div>;

  return (
    <div className="user-profile">
      <h2>Profile</h2>
      <p>Name: {user.name}</p>
      <p>Email: {user.email}</p>
      <h3>Booking History</h3>
      <ul>
        {bookings.map(booking => (
          <li key={booking.id}>
            Hotel: {booking.hotelName}, Room: {booking.roomType}, Dates: {booking.checkIn} - {booking.checkOut}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UserProfile;
