// src/components/App.js
import React from 'react';
import Header from './Header';
import Footer from './Footer';
import MainContent from './MainContent';
import Login from '../server/Login'; // Ajuste para a pasta server
import Register from '../server/Register'; // Ajuste para a pasta server
import '../styles/App.css';

function App() {
    return (
        <div className="App">
            <Header />
            <MainContent />
            <Footer />
        </div>
    );
}

export default App;
