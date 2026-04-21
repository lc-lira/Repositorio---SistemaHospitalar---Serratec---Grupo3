package br.com.hospital.conexao;

import br.com.hospital.model.Faturamento;

public class TesteConexao {
     /*public static void main(String[] args) {
      
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.getConnection();
        ClienteDao clienteDAO = new ClienteDao();
         clienteDAO.gerarFatura();
          
         public class TesteFaturamento { */
    public static void main(String[] args) {
        ClienteDao dao = new ClienteDao();

        for (Faturamento faturamento : dao.gerarFatura()) {
            System.out.println(faturamento);
        }
    }

}
  
