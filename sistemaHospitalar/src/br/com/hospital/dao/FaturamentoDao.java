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

    public List<Faturamento> gerarFatura() {
        String sql = "SELECT c.nome, f.valor FROM faturamento f INNER JOIN atendimento a ON f.id_atendimento = a.id_atendimento INNER JOIN paciente c ON a.id_paciente= c.id_paciente";

        List<Faturamento> faturamento = new ArrayList<>();

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Faturamento fatura = new Faturamento(
                        rs.getString("nome"),
                        rs.getDouble("valor"));
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