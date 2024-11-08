package testelivraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        // URL para a conexão com o banco SQLite (substitua o caminho para o seu banco)
        String url = "jdbc:sqlite:demo\\src\\main\\resources\\biblioteca.db";
        
        Connection conn = null;
        
        try {
            // Carregar o driver JDBC SQLite
            Class.forName("org.sqlite.JDBC");
            
            // Estabelecer a conexão com o banco de dados
            conn = DriverManager.getConnection(url);
            System.out.println("Conexão com o banco de dados estabelecida.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado.");
        }
        
        return conn;
    }

    public static void main(String[] args) {
        // Testar a conexão
        Connection conn = connect();
        if (conn != null) {
            // Realize suas operações no banco de dados aqui
        }
    }
}
