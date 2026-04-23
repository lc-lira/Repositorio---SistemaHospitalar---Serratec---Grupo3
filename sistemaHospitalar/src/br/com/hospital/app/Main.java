package br.com.hospital.app;

import java.util.List;
import br.com.hospital.dao.FaturamentoDao;
import br.com.hospital.model.Faturamento;
import br.com.hospital.model.NotaFiscal;

public class Main {
    public static void main(String[] args) {
        FaturamentoDao dao = new FaturamentoDao();
        List<Faturamento> faturas = dao.gerarListaFaturamentos();
        Integer N1 = 1;
        Integer N2 = 11;

        System.out.println("Gerando nota fiscal no Formato TXT...");

        for (Faturamento notasTXT : faturas) {
            NotaFiscal notaFiscal = new NotaFiscal(notasTXT);
            notaFiscal.gerarNotaFiscalTXT(N1++);
        }

        System.out.println("Gerando nota fiscal no formato CSV...");

        for (Faturamento notasCSV : faturas) {
            NotaFiscal notaFiscal = new NotaFiscal(notasCSV);
            notaFiscal.gerarNotaFiscalCSV(N2++);
        }

        System.out.println("Notas geradas com sucesso!");
    }
}