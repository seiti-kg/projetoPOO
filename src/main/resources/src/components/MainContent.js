// src/components/MainContent.js
import React from 'react';
import '../styles/MainContent.css';
import BookList from './BookList';

function MainContent() {
    return (
        <main className="main-content">
            {/* Mensagem de Boas-Vindas */}
            <section className="welcome-section">
                <h1>Olá {`{Nome}`}, Bem vindo de volta!</h1>
            </section>

            {/* Seção de Reservas do Usuário */}
            <section className="user-reservations">
                <h2>Suas Reservas:</h2>
                <div className="reservation-list">
                    <div>
                        <div className="reservation-item">
                            <div className="book-title">A Guerra dos Tronos</div>
                        </div>
                        <p className="return-date">Data Devolução</p>
                    </div>
                    <div>
                        <div className="reservation-item">
                            <div className="book-title">A Guerra dos Mundos</div>
                        </div>
                        <p className="return-date">Data Devolução</p>
                    </div>
                </div>
            </section>

            {/* Seção de Livros Disponíveis para Empréstimos */}
            <section className="book-section">
                <h2>Alguns Livros Disponíveis para Empréstimos:</h2>
                <BookList type="emprestimos" />
            </section>

            {/* Seção de Livros Disponíveis para Reservas */}
            <section className="book-section">
                <h2>Alguns Livros Disponíveis para Reservas:</h2>
                <BookList type="reservas" />
            </section>
        </main>
    );
}

export default MainContent;
