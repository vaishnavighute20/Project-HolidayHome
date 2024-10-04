// src/components/Footer.js
import React from 'react';
import './Footer.css';

function Footer() {
  return (
    <footer className="footer">
      <p>© 2024 HolidayHome. All rights reserved.</p>
      <p>Contact us: contact@holidayhome.com | +123-456-7890</p>
      <div className="social-media">
        <a href="#">Facebook</a> | <a href="#">Twitter</a> | <a href="#">Instagram</a>
      </div>
    </footer>
  );
}

export default Footer;
