// src/services/hotelService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/hotels'; // Replace with your API URL

export const fetchHotels = async () => {
  try {
    const response = await axios.get(API_URL);
    return response.data;
  } catch (error) {
    console.error('Error fetching hotels:', error);
    throw error;
  }
};
