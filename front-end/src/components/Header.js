import React from 'react';
import "./Header.css"

const Header = () => {
  return (
    <header className='head'>
      <nav>
        <div className='logo'>
            Online Book Store
        </div>

        <ul>
          <li><a href='Home'>Home</a></li>
          <li><a href='Books'>Books</a></li>
          <li><a href='Arrivals'>Arrivals</a></li>
          <li><a href='About'>About</a></li>
          <li><a href='Login'>Login</a></li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
