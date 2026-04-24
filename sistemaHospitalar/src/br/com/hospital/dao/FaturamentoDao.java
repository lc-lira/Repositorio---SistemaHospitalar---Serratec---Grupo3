package br.com.hospital.dao;

import br.com.hospital.enums.ValorImposto;
import br.com.hospital.model.Atendimento;
import br.com.hospital.model.Faturamento;
import br.com.hospital.model.Hospital;
import br.com.hospital.model.Paciente;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FaturamentoDao {
    private Connection connection;

    public FaturamentoDao(Connection connection) {
        this.connection = connection;
    }

    public List<Faturamento> gerarListaFaturamentos() {
        String sql = "SELECT f.id_faturamento, p.nome, p.cpf, f.valor, h.cnpj, h.nome AS nome_hospital, a.tipo FROM faturamento f INNER JOIN atendimento a ON f.id_atendimento = a.id_atendimento INNER JOIN paciente p ON a.id_paciente = p.id_paciente INNER JOIN hospital h ON a.id_atendimento = h.id_hospital;";

        List<Faturamento> faturamento = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getString("nome"),
                        rs.getString("cpf"));

                Hospital hospital = new Hospital(
                        rs.getString("nome_hospital"),
                        rs.getString("cnpj"));

                Atendimento atendimento = new Atendimento(
                        Atendimento.Tipo.valueOf(rs.getString("tipo")));

                Faturamento fatura = new Faturamento(
                        rs.getInt("id_faturamento"),
                        rs.getDouble("valor"),
                        paciente,
                        hospital,
                        atendimento);

                faturamento.add(fatura);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Problemas ao listar as notas fiscais");
            e.printStackTrace();
        }

        return faturamento;

    }

    public void salvarNFBanco(Faturamento faturamento) {
        String sql = "INSERT INTO nota_fiscal (id_fatura, paciente, cpf, hospital, cnpj, valor_total, descricao, valorpagopis, valorpagocofins, valorpagoiss, valorpagoirpj, valorpagocsll) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        ;
        BigDecimal iss = new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.ISS)).setScale(2,
                RoundingMode.HALF_UP);
        BigDecimal pis = new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.PIS)).setScale(2,
                RoundingMode.HALF_UP);
        BigDecimal cofins = new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.COFINS))
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal irpj = new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.IRPJ)).setScale(2,
                RoundingMode.HALF_UP);
        BigDecimal csll = new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.CSLL)).setScale(2,
                RoundingMode.HALF_UP);

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, faturamento.getId());

            stmt.setString(2, faturamento.getPaciente().getNome());
            stmt.setString(3, faturamento.getPaciente().getCpf());

            stmt.setString(4, faturamento.getHospital().getNome());
            stmt.setString(5, faturamento.getHospital().getCnpj());

            stmt.setDouble(6, faturamento.getValor());

            stmt.setString(7, faturamento.getAtendimento().getTipo().name());

            stmt.setBigDecimal(8, pis);
            stmt.setBigDecimal(9, cofins);
            stmt.setBigDecimal(10, iss);
            stmt.setBigDecimal(11, irpj);
            stmt.setBigDecimal(12, csll);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Nota fiscal já existe no banco de dados!");
        }
    }

}