package testelivraria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Administrador extends Usuario {

   // Método para gerenciar clientes (adicionar, atualizar, remover)
   public String gerenciarClientes(int idCliente, String acao, String dadosCliente) {
      String sql = "";
      if ("adicionar".equalsIgnoreCase(acao)) {
         sql = "INSERT INTO clientes (id, nome, telefone, email, cpf, idade) VALUES (?, ?, ?, ?, ?, ?)";
      } else if ("atualizar".equalsIgnoreCase(acao)) {
         sql = "UPDATE clientes SET nome = ?, telefone = ?, email = ?, cpf = ?, idade = ? WHERE id = ?";
      } else if ("remover".equalsIgnoreCase(acao)) {
         sql = "DELETE FROM clientes WHERE id = ?";
      }

      try (Connection conn = DatabaseConnection.connect();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

         if ("adicionar".equalsIgnoreCase(acao)) {
            String[] campos = dadosCliente.split(",");
            stmt.setInt(1, idCliente);
            stmt.setString(2, campos[0]);
            stmt.setString(3, campos[1]);
            stmt.setString(4, campos[2]);
            stmt.setString(5, campos[3]);
            stmt.setInt(6, Integer.parseInt(campos[4]));
            stmt.executeUpdate();
            return "Cliente adicionado com sucesso!";
         } else if ("atualizar".equalsIgnoreCase(acao)) {
            String[] campos = dadosCliente.split(",");
            stmt.setString(1, campos[0]);
            stmt.setString(2, campos[1]);
            stmt.setString(3, campos[2]);
            stmt.setString(4, campos[3]);
            stmt.setInt(5, Integer.parseInt(campos[4]));
            stmt.setInt(6, idCliente);
            stmt.executeUpdate();
            return "Cliente atualizado com sucesso!";
         } else if ("remover".equalsIgnoreCase(acao)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
            return "Cliente removido com sucesso!";
         } else {
            return "Ação inválida.";
         }
      } catch (SQLException e) {
         return "Erro ao gerenciar cliente: " + e.getMessage();
      }
   }

   // Método para configurar regras de empréstimo
   public String configurarRegrasEmprestimo(int maxLivros, int prazoDevolucao) {
      String sql = "UPDATE regras_emprestimo SET maxLivros = ?, prazoDevolucao = ?";
      
      try (Connection conn = DatabaseConnection.connect();
           PreparedStatement stmt = conn.prepareStatement(sql)) {
         
         stmt.setInt(1, maxLivros);
         stmt.setInt(2, prazoDevolucao);
         stmt.executeUpdate();
         return "Regras de empréstimo configuradas com sucesso!";
      } catch (SQLException e) {
         return "Erro ao configurar regras de empréstimo: " + e.getMessage();
      }
   }

   // Método para gerenciar funcionários (adicionar, atualizar, remover)
   public String gerenciarFuncionarios(int idFuncionario, String acao, String dadosFuncionario) {
      String sql = "";
      if ("adicionar".equalsIgnoreCase(acao)) {
         sql = "INSERT INTO funcionarios (id, nome, cargo) VALUES (?, ?, ?)";
      } else if ("atualizar".equalsIgnoreCase(acao)) {
         sql = "UPDATE funcionarios SET nome = ?, cargo = ? WHERE id = ?";
      } else if ("remover".equalsIgnoreCase(acao)) {
         sql = "DELETE FROM funcionarios WHERE id = ?";
      }

      try (Connection conn = DatabaseConnection.connect();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

         if ("adicionar".equalsIgnoreCase(acao)) {
            String[] campos = dadosFuncionario.split(",");
            stmt.setInt(1, idFuncionario);
            stmt.setString(2, campos[0]);
            stmt.setString(3, campos[1]);
            stmt.executeUpdate();
            return "Funcionário adicionado com sucesso!";
         } else if ("atualizar".equalsIgnoreCase(acao)) {
            String[] campos = dadosFuncionario.split(",");
            stmt.setString(1, campos[0]);
            stmt.setString(2, campos[1]);
            stmt.setInt(3, idFuncionario);
            stmt.executeUpdate();
            return "Funcionário atualizado com sucesso!";
         } else if ("remover".equalsIgnoreCase(acao)) {
            stmt.setInt(1, idFuncionario);
            stmt.executeUpdate();
            return "Funcionário removido com sucesso!";
         } else {
            return "Ação inválida.";
         }
      } catch (SQLException e) {
         return "Erro ao gerenciar funcionário: " + e.getMessage();
      }
   }
}
