package br.com.hospital.app;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import br.com.hospital.dao.FaturamentoDao;
import br.com.hospital.model.Faturamento;

public class Main {
    public static void main(String[] args) {

        try {
            List<Faturamento> faturamentos = new ArrayList<>();
            FaturamentoDao dao = new FaturamentoDao();

            for (Faturamento faturamento : dao.gerarFatura()) {
                faturamentos.add(faturamento);
            }

            System.out.println("Gerando nota fiscal...");

            FileWriter caminho = new FileWriter("\\notafiscal\\nota.txt");
            PrintWriter gravarArquivo = new PrintWriter(caminho);

            for (Faturamento faturamento : faturamentos) {
                String linhaArquivo = faturamento.getNome() + "|" + faturamento.getValor() + "\n";
                gravarArquivo.printf(linhaArquivo);
            }
            gravarArquivo.close();

        } catch (Exception e) {

        }
    }
}
