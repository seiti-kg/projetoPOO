// src/components/Login.js
import React, { useState } from "react";
import "../styles/Login.css";

function Login() {
    const [isRegistering, setIsRegistering] = useState(false);

    const toggleRegister = () => {
        setIsRegistering(!isRegistering);
    };

    return (
        <div className="login-container">
            <h2>{isRegistering ? "Cadastro" : "Login"}</h2>
            <form>
                <label>
                    Email:
                    <input type="email" required />
                </label>
                <label>
                    Senha:
                    <input type="password" required />
                </label>
                {isRegistering && (
                    <label>
                        Confirme a Senha:
                        <input type="password" required />
                    </label>
                )}
                <button type="submit">{isRegistering ? "Registrar" : "Entrar"}</button>
            </form>
            <p onClick={toggleRegister} className="toggle-register">
                {isRegistering
                    ? "Já tem uma conta? Faça login."
                    : "Não tem uma conta? Cadastre-se."}
            </p>
        </div>
    );
}

export default Login;
