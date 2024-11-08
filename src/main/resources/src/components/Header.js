// src/components/Header.js
import React from "react";
import "../styles/Header.css";
import logo from "../images/logo.png";

function Header() {
    const navigateToLogin = () => {
        window.location.href = "/login"; // Redireciona para a página de login
    };

    return (
        <header className="header">
            <div className="logo-nav">
                <div className="logo">
                    <img src={logo} alt="Logo LatteShelf" />
                </div>
                <nav>
                    <a href="#">Explorar</a>
                    <a href="#">Reservas</a>
                </nav>
            </div>
            <button className="login-button" onClick={navigateToLogin}>
                Login
            </button>
        </header>
    );
}

export default Header;
