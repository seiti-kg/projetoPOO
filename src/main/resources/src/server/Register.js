import React, { useState } from 'react';
import axios from 'axios';

function Register() {
    const [form, setForm] = useState({ nome: '', email: '', senha: '' });

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:5000/register', form);
            alert('Cadastro realizado com sucesso!');
        } catch (error) {
            alert('Erro no cadastro.');
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="nome" onChange={handleChange} placeholder="Nome" />
            <input type="email" name="email" onChange={handleChange} placeholder="Email" />
            <input type="password" name="senha" onChange={handleChange} placeholder="Senha" />
            <button type="submit">Cadastrar</button>
        </form>
    );
}

export default Register;
