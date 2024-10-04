// src/components/Home.js
import React from 'react';
import './Home.css';

function Home() {
  return (
    <div className="home">
      <h1>Welcome to HolidayHome</h1>
      <p>Find your perfect stay from our wide selection of hotels.</p>
      <div className="search-bar">
        <input type="text" placeholder="Search for hotels..." />
        <button>Search</button>
      </div>
      <div className="featured-hotels">
        <h2>Featured Hotels</h2>
        {/* Add code to dynamically load featured hotels */}
      </div>
    </div>
  );
}

export default Home;
