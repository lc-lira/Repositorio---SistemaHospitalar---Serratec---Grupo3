package br.com.hospital.app;

import java.sql.Connection;
import java.util.List;

import br.com.hospital.conexao.ConnectionFactory;
import br.com.hospital.dao.FaturamentoDao;
import br.com.hospital.dao.NotaFiscalDao;
import br.com.hospital.model.Faturamento;
import br.com.hospital.model.NotaFiscal;

public class Main {
    public static void main(String[] args) {

        try (Connection connection = new ConnectionFactory().getConnection()) {

            FaturamentoDao fDao = new FaturamentoDao(connection);
            List<Faturamento> faturas = fDao.gerarListaFaturamentos();
            Integer N1 = 1;
            Integer N2 = 1;

            System.out.println("\nGerando nota fiscal no Formato TXT e CSV...");
            for (Faturamento notas : faturas) {
                NotaFiscal nf = new NotaFiscal(notas);
                nf.gerarNotaFiscalTXT(N1++);
                nf.gerarNotaFiscalCSV(N2++);
                fDao.salvarNFBanco(notas);
            }

            System.out.println("\nNotas geradas com sucesso e armazenadas no Banco de dados!");

            System.out.println("-----------------------------------");

            NotaFiscalDao nDao = new NotaFiscalDao(connection);
            Integer idBusca = 3;

            System.out.println("Buscar por ID...\n");

            NotaFiscal buscaNF = nDao.buscarFatura(idBusca);

            if (buscaNF != null) {
                System.out.println("Nota Fiscal encontrada!\n");

                System.out.println("Hospital: " + buscaNF.getFaturamento().getHospital().getNome());
                System.out.println("CNPJ: " + buscaNF.getFaturamento().getHospital().getCnpj() + "\n");

                System.out.println("Tipo de Serviço: " + buscaNF.getFaturamento().getAtendimento().getTipo() + "\n");

                System.out.println("Paciente: " + buscaNF.getFaturamento().getPaciente().getNome());
                System.err.println("CPF: " + buscaNF.getFaturamento().getPaciente().getCpf() + "\n");

                System.out.println("Valor: R$ " + buscaNF.getFaturamento().getValor() + "\n");

                System.out.println("Resumo dos Impostos:" + "\n");
                System.out.println("PIS: R$ " + buscaNF.getValoresImpostos().getPis());
                System.out.println("COFINS: R$ " + buscaNF.getValoresImpostos().getCofins());
                System.out.println("ISS: R$ " + buscaNF.getValoresImpostos().getIss());
                System.out.println("IRPJ: R$ " + buscaNF.getValoresImpostos().getIrpj());
                System.out.println("CSLL: R$ " + buscaNF.getValoresImpostos().getCsll() + "\n");

            } else {
                System.out.println("Nota fiscal não encontrada!");
            }
            buscaNF.gerarNotaFiscalCSV(idBusca);

            System.out.println("Nota gerada com sucesso!\n");

        } catch (Exception e) {
            System.err.println("Error ao gerar faturas!");
            e.printStackTrace();
        }

    }
}