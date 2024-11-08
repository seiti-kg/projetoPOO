package testelivraria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Funcionario extends Usuario {
   private int id;

   public Funcionario() {}

   public int getIdFunc() {
      return this.id;
   }

   public void setIdFunc(int id) {
      this.id = id;
   }

   public String adicionarLivro(String titulo, String autor, String categoria, int quantidadeDisponivel, int idLivro) {
      String sql = "INSERT INTO livros (id, titulo, autor, categoria, quantidadeDisponivel) VALUES (?, ?, ?, ?, ?)";
      try (Connection conn = DatabaseConnection.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)) {
         pstmt.setInt(1, idLivro);
         pstmt.setString(2, titulo);
         pstmt.setString(3, autor);
         pstmt.setString(4, categoria);
         pstmt.setInt(5, quantidadeDisponivel);
         pstmt.executeUpdate();
         return "Livro adicionado com sucesso!";
      } catch (SQLException e) {
         return "Erro ao adicionar livro: " + e.getMessage();
      }
   }

   public String atualizarLivro(int idLivro, String campo, Object novoValor) {
      String sql = "UPDATE livros SET " + campo + " = ? WHERE id = ?";
      try (Connection conn = DatabaseConnection.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)) {
         pstmt.setObject(1, novoValor);
         pstmt.setInt(2, idLivro);
         pstmt.executeUpdate();
         return "Livro atualizado com sucesso!";
      } catch (SQLException e) {
         return "Erro ao atualizar livro: " + e.getMessage();
      }
   }
}
