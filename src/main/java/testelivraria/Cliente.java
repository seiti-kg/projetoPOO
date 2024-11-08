package testelivraria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
   private int id;

   public Cliente() {}

   public int getIdCliente() {
      return this.id;
   }

   public void setIdCliente(int id) {
      this.id = id;
   }

   public List<Livro> consultarLivrosDisponiveis() {
      String sql = "SELECT * FROM livros WHERE quantidadeDisponivel > 0";
      List<Livro> livrosDisponiveis = new ArrayList<>();
      try (Connection conn = DatabaseConnection.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql);
           ResultSet rs = pstmt.executeQuery()) {
         while (rs.next()) {
            Livro livro = new Livro();
            livro.setTituloLivro(rs.getString("titulo"));
            livro.setAutorLivro(rs.getString("autor"));
            livro.setCategoriaLivro(rs.getString("categoria"));
            livro.setQuantidadeDiponivelLivro(rs.getInt("quantidadeDisponivel"));
            livrosDisponiveis.add(livro);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return livrosDisponiveis;
   }
}
