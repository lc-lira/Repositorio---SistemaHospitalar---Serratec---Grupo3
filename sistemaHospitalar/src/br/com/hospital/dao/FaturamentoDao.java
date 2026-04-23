package br.com.hospital.dao;

import br.com.hospital.conexao.ConnectionFactory;
import br.com.hospital.model.Faturamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FaturamentoDao {
    private Connection connection = (new ConnectionFactory()).getConnection();

    public FaturamentoDao() {
    }

    public List<Faturamento> gerarListaFaturamentos() {
        String sql = "SELECT f.id_faturamento, p.nome, p.cpf, f.valor, h.cnpj, h.nome as nome_hospital, a.tipo FROM faturamento f INNER JOIN atendimento a ON f.id_atendimento = a.id_atendimento INNER JOIN paciente p ON a.id_paciente= p.id_paciente INNER JOIN hospital h on p.id_paciente = h.id_hospital";

        List<Faturamento> faturamento = new ArrayList<>();

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Faturamento fatura = new Faturamento(
                        rs.getInt("id_faturamento"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDouble("valor"),
                        rs.getString("cnpj"),
                        rs.getString("nome_hospital"),
                        rs.getString("tipo"));
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
    
    public void salvarNFBanco(){
        String sql = "insert into nota_fiscal()"

        try {
            PreparedStatement stmt = connection.prepareCall(sql);
            stmt.
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println("Não foi possível salvar a nota no banco de dados!");
        }
    }

}