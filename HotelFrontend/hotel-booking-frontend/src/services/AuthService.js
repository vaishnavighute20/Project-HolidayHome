// authService.js

const API_URL = 'http://your-api-url.com/api/user/signin'; // Replace with your actual API URL

export const login = async (email, password) => {
    try {
        const response = await fetch(`${API_URL}/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email, password }),
        });

        if (!response.ok) {
            throw new Error('Login failed');
        }

        const data = await response.json();
        // Store the token or any other necessary info
        localStorage.setItem('adminToken', data.token);
        return data;
    } catch (error) {
        throw error;
    }
};

export const logout = () => {
    // Clear the token or any other stored info
    localStorage.removeItem('adminToken');
};
