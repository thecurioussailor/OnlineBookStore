import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Login.css';

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.get(`http://localhost:8080/api/customers?email=${email}`);
      const user = response.data;

      if (user && user.password === password) {
        // Successful login
        setError("");
        // Perform the necessary actions, such as setting authentication tokens or redirecting to another page
        navigate("/dashboard"); // Replace "/dashboard" with the desired redirect URL after successful login
      } else {
        // Invalid email or password
        setError("Invalid email or password");
      }
    } catch (error) {
      // API request or server error
      setError("An error occurred. Please try again later.");
    }
  };

  return (
    <div className="container">
      <h1>Login</h1>
      {error && <p className="error">{error}</p>}
      <form className="form" onSubmit={handleLogin}>
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(event) => setEmail(event.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(event) => setPassword(event.target.value)}
        />
        <button type="submit">Login</button>
      </form>
      <p>
        Don't have an account?{" "}
        <Link to="/Register">Register</Link>
      </p>
    </div>
  );
}

export default Login;
