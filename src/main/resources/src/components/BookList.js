// src/components/BookList.js
import React from 'react';
import '../styles/BookList.css';

function BookList({ type }) {
    const books = [
        { title: "A Guerra dos Tronos", status: type },
        { title: "Corte de Espinhos e Rosas", status: type },
        { title: "O Homem mais Inteligente da História", status: type },
        { title: "Origem - Dan Brown", status: type },
        { title: "Neuromancer", status: type },
        { title: "Artificial Condition", status: type },
    ];

    return (
        <div className="book-list">
            {books.map((book, index) => (
                <div key={index} className="book-item">
                    <div className="book-content">
                        <span>{book.title}</span>
                    </div>
                    <p className="return-date">Data Disponível</p>
                </div>
            ))}
        </div>
    );
}

export default BookList;
