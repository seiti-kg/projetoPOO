package testelivraria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Emprestimo {

   // Método para emprestar um livro
   public String emprestarLivro(int idCliente, int idLivro) {
      String verificaDisponibilidade = "SELECT quantidadeDisponivel FROM livros WHERE id = ?";
      String emprestarSql = "INSERT INTO emprestimos (idCliente, idLivro, dataEmprestimo, dataDevolucao) VALUES (?, ?, ?, ?)";
      String atualizaLivro = "UPDATE livros SET quantidadeDisponivel = quantidadeDisponivel - 1 WHERE id = ?";

      try (Connection conn = DatabaseConnection.connect();
           PreparedStatement verificaStmt = conn.prepareStatement(verificaDisponibilidade);
           PreparedStatement emprestarStmt = conn.prepareStatement(emprestarSql);
           PreparedStatement atualizaStmt = conn.prepareStatement(atualizaLivro)) {

         verificaStmt.setInt(1, idLivro);
         ResultSet rs = verificaStmt.executeQuery();
         if (rs.next() && rs.getInt("quantidadeDisponivel") > 0) {
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucao = dataEmprestimo.plusDays(7);

            emprestarStmt.setInt(1, idCliente);
            emprestarStmt.setInt(2, idLivro);
            emprestarStmt.setString(3, dataEmprestimo.toString());
            emprestarStmt.setString(4, dataDevolucao.toString());
            emprestarStmt.executeUpdate();

            atualizaStmt.setInt(1, idLivro);
            atualizaStmt.executeUpdate();

            return "Empréstimo realizado com sucesso! Data de devolução: " + dataDevolucao;
         } else {
            return "Livro indisponível para empréstimo.";
         }
      } catch (SQLException e) {
         return "Erro ao emprestar livro: " + e.getMessage();
      }
   }

   // Método para devolver um livro
   public String devolverLivro(int idCliente, int idLivro) {
      String verificaEmprestimo = "SELECT dataDevolucao FROM emprestimos WHERE idCliente = ? AND idLivro = ?";
      String removerEmprestimo = "DELETE FROM emprestimos WHERE idCliente = ? AND idLivro = ?";
      String atualizaLivro = "UPDATE livros SET quantidadeDisponivel = quantidadeDisponivel + 1 WHERE id = ?";

      try (Connection conn = DatabaseConnection.connect();
           PreparedStatement verificaStmt = conn.prepareStatement(verificaEmprestimo);
           PreparedStatement removerStmt = conn.prepareStatement(removerEmprestimo);
           PreparedStatement atualizaStmt = conn.prepareStatement(atualizaLivro)) {

         verificaStmt.setInt(1, idCliente);
         verificaStmt.setInt(2, idLivro);
         ResultSet rs = verificaStmt.executeQuery();

         if (rs.next()) {
            LocalDate dataDevolucao = LocalDate.parse(rs.getString("dataDevolucao"));
            LocalDate hoje = LocalDate.now();

            // Remover o empréstimo e atualizar a quantidade de livros
            removerStmt.setInt(1, idCliente);
            removerStmt.setInt(2, idLivro);
            removerStmt.executeUpdate();

            atualizaStmt.setInt(1, idLivro);
            atualizaStmt.executeUpdate();

            return "Livro devolvido com sucesso!";
         } else {
            return "Registro de empréstimo não encontrado.";
         }
      } catch (SQLException e) {
         return "Erro ao devolver livro: " + e.getMessage();
      }
   }
}
