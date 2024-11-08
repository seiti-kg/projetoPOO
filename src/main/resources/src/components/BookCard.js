// src/components/BookCard.js
import React from 'react';
import '../styles/BookCard.css';

function BookCard({ title, cover }) {
    return (
        <div className="book-card">
            <img src={cover} alt={title} className="book-cover" />
            <p className="book-title">{title}</p>
        </div>
    );
}

export default BookCard;
