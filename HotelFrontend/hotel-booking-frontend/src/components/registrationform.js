import React, { useState } from 'react';
import axios from 'axios';
import './registrationform.css'; // Import the CSS file

const RegistrationForm = () => {
    const [user, setUser] = useState({
        name: '',
        email: '',
        password: '',
        confirmPassword: '',
        role: 'USER',
    });
    const [profilePic, setProfilePic] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value,
        });
    };

    const handleFileChange = (e) => {
        setProfilePic(e.target.files[0]);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (user.password !== user.confirmPassword) {
            alert("Passwords do not match");
            return;
        }

        const formData = new FormData();
        formData.append('name', user.name);
        formData.append('email', user.email);
        formData.append('password', user.password);
        formData.append('role', user.role);
        formData.append('profilePic', profilePic);

        try {
            const response = await axios.post('http://localhost:8080/api/user/signup', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            });
            alert('Registration successful');
        } catch (error) {
            console.error('There was an error registering!', error);
        }
    };

    return (
        <div className="registration-container">
            <h2>User Registration</h2>
            <form onSubmit={handleSubmit} className="registration-form">
                <div className="form-group">
                    <label>Name:</label>
                    <input
                        type="text"
                        name="name"
                        value={user.name}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={user.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={user.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Confirm Password:</label>
                    <input
                        type="password"
                        name="confirmPassword"
                        value={user.confirmPassword}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Role:</label>
                    <select name="role" value={user.role} onChange={handleChange}>
                        <option value="USER">User</option>
                        <option value="ADMIN">Admin</option>
                        <option value="GUEST">Guest</option>
                    </select>
                </div>
                <div className="form-group">
                    <label>Profile Picture:</label>
                    <input
                        type="file"
                        name="profilePic"
                        onChange={handleFileChange}
                        accept="image/*"
                        required
                    />
                </div>
                <div className="form-group">
                    <button type="submit" className="submit-button">Register</button>
                </div>
            </form>
        </div>
    );
};

export default RegistrationForm;
