const express = require('express');
const sqlite3 = require('sqlite3').verbose();
const bodyParser = require('body-parser');
const cors = require('cors');
const bcrypt = require('bcrypt');

const app = express();
app.use(cors());
app.use(bodyParser.json());

const db = new sqlite3.Database('./biblioteca/biblioteca.db');

// Rota de cadastro
app.post('/register', (req, res) => {
    const { nome, email, senha } = req.body;
    const hashedSenha = bcrypt.hashSync(senha, 10);
    db.run(
        `INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)`,
        [nome, email, hashedSenha],
        function (err) {
            if (err) {
                return res.status(400).json({ error: 'Erro no cadastro.' });
            }
            res.status(200).json({ message: 'Usuário registrado com sucesso!' });
        }
    );
});

// Rota de login
app.post('/login', (req, res) => {
    const { email, senha } = req.body;
    db.get(`SELECT * FROM usuarios WHERE email = ?`, [email], (err, user) => {
        if (err) return res.status(500).json({ error: 'Erro interno' });
        if (user && bcrypt.compareSync(senha, user.senha)) {
            res.status(200).json({ message: 'Login realizado com sucesso!' });
        } else {
            res.status(400).json({ error: 'Email ou senha incorretos' });
        }
    });
});

app.listen(5000, () => {
    console.log('Servidor rodando na porta 5000');
});
