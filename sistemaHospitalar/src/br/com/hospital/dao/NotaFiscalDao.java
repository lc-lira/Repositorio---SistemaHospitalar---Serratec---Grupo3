package br.com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.hospital.model.Atendimento;
import br.com.hospital.model.Faturamento;
import br.com.hospital.model.Hospital;
import br.com.hospital.model.NotaFiscal;
import br.com.hospital.model.Paciente;
import br.com.hospital.model.ValoresImpostos;

public class NotaFiscalDao {
    private Connection connection;

    public NotaFiscalDao(Connection connection) {
        this.connection = connection;
    }

    public NotaFiscal buscarFatura(Integer id) {
        String sql = "SELECT id_fatura, paciente AS nome_paciente, cpf, hospital, cnpj, valor_total, descricao, valorpagopis, valorpagocofins, valorpagoiss, valorpagoirpj, valorpagocsll FROM nota_fiscal WHERE id_fatura = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getString("nome_paciente"),
                        rs.getString("cpf"));

                Hospital hospital = new Hospital(
                        rs.getString("hospital"),
                        rs.getString("cnpj"));

                Atendimento atendimento = new Atendimento(
                        Atendimento.Tipo.valueOf(rs.getString("descricao")));

                Faturamento faturamento = new Faturamento(paciente,
                        rs.getDouble("valor_total"),
                        hospital,
                        atendimento);

                ValoresImpostos valores = new ValoresImpostos(
                        rs.getDouble("valorpagopis"),
                        rs.getDouble("valorpagocofins"),
                        rs.getDouble("valorpagoiss"),
                        rs.getDouble("valorpagoirpj"),
                        rs.getDouble("valorpagocsll"));

                NotaFiscal nota = new NotaFiscal(faturamento);
                nota.setValoresImpostos(valores);

                rs.close();
                stmt.close();

                return nota;
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Problemas ao buscar a nota fiscal!");
            e.printStackTrace();
        }

        throw new RuntimeException("Fatura com ID " + id + " não encontrada!");
    }
}
