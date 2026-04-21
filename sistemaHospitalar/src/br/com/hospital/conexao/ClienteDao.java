package br.com.hospital.conexao;

import br.com.hospital.conexao.ConnectionFactory;
import br.com.hospital.model.Faturamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
   private Connection connection = (new ConnectionFactory()).getConnection();

//public ClienteDao() {
   
/*
   public void inserir(NotaFiscal notafiscal) {
      String sql = "insert into cliente(nome,email) values (?,?)";

      try {
         PreparedStatement stmt = this.connection.prepareStatement(sql);
         stmt.setString(1, notafiscal.getNome());
         stmt.setString(2, notafiscal.getEmail());
         stmt.execute();
         stmt.close();
         this.connection.close();
      } catch (SQLException var4) {
         System.err.println("Nota fiscal não inserida!");
      }

   }

         stmt.setString(2, cliente.getEmail());
         stmt.execute();
         stmt.close();
         this.connection.close();
      } catch (SQLException var4) {
         System.err.println("Cliente não inserido!");
      }

   }
/*
   public void alterar(Cliente cliente) {
      String sql = "update cliente set nome=?, email=? where id=?";

      try {
         PreparedStatement stmt = this.connection.prepareStatement(sql);
         stmt.setString(1, cliente.getNome());
         stmt.setString(2, cliente.getEmail());
         stmt.setInt(3, cliente.getId());
         stmt.execute();
         stmt.close();
         this.connection.close();
      } catch (SQLException var4) {
         System.err.println("Cliente não inserido!");
      }

   }

   public void apagar(int codigo) {
      String sql = "delete from cliente where id=?";

      try {
         PreparedStatement stmt = this.connection.prepareStatement(sql);
         stmt.setInt(1, codigo);
         stmt.execute();
         stmt.close();
         this.connection.close();
      } catch (SQLException e) {
         System.err.println("Cliente não removido!");
         e.printStackTrace();
      }

   } */

   public List<Faturamento> gerarFatura() {
      String sql = "SELECT c.nome, f.valor FROM faturamento f INNER JOIN atendimento a ON f.id_atendimento = a.id_atendimento INNER JOIN paciente c ON a.id_paciente= c.id_paciente";
      List<Faturamento> faturamento = new ArrayList();
      try {
         PreparedStatement stmt = this.connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();

         while(rs.next()) {
            Faturamento fatura = new Faturamento(rs.getString("nome"), rs.getDouble("valor"));
            faturamento.add(fatura);
         }

         rs.close();
         stmt.close();
         this.connection.close();
      } catch (SQLException e) {
         System.err.println("Problemas ao listar as notas fiscais");
         e.printStackTrace();
      }

      return faturamento;
   }
}
