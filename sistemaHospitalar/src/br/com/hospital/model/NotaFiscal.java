package br.com.hospital.model;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.hospital.enums.ValorImposto;

public class NotaFiscal {
    private Integer id;
    private Faturamento faturamento;

    public NotaFiscal(Faturamento faturamento) {
        this.faturamento = faturamento;
    }

    public Integer getId() {
        return id;
    }

    public Faturamento getFaturamento() {
        return faturamento;
    }

    public void gerarNotaFiscalTXT(Integer numero) {
        try {
            FileWriter caminho = new FileWriter("\\notafiscal\\Nota " + (numero) + ".txt");
            PrintWriter gravarArquivo = new PrintWriter(caminho);

            String linhaArquivo = "Prestador de Serviço\n" +
                    "Clinica: " + faturamento.getNomeHospital() + "\n" +
                    "CNPJ: " + faturamento.getCnpj() + "\n\n" +

                    "Tomador\n" +
                    "Paciente: " + faturamento.getNome() + "\n" +
                    "CPF: " + faturamento.getCpf() + "\n\n"

                    + "Descrição do Serviço" + "\n" +
                    "Tipo Serviço: " + faturamento.getTipo() + "\n\n"

                    + "Valor da Nota" + "\n" +
                    "Valor bruto do serviço: R$ " + faturamento.getValor() + "\n\n"

                    + "ISS\n" +
                    "Alíquota: " + ValorImposto.ISS.getValorPorImposto() * 100 + "%" + "\n" +
                    "Valor: R$ "
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.ISS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + "\n\n" +

                    "PIS\n" +
                    "Alíquota: " + ValorImposto.PIS.getValorPorImposto() * 100 + "%" + "\n" +
                    "Valor: R$ "
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.PIS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + "\n\n" +

                    "COFINS\n" +
                    "Alíquota: " + ValorImposto.COFINS.getValorPorImposto() * 100 + "%" + "\n" +
                    "Valor: R$ "
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.COFINS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + "\n\n" +

                    "IRPJ\n" +
                    "Alíquota: " + ValorImposto.IRPJ.getValorPorImposto() * 100 + "%" + "\n" +
                    "Valor: R$ "
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.IRPJ)).setScale(2,
                            RoundingMode.HALF_UP)
                    + "\n\n" +

                    "CSLL\n" + "Alíquota: " + ValorImposto.CSLL.getValorPorImposto() * 100 + "%" + "\n" +
                    "Valor: R$ "
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.CSLL)).setScale(2,
                            RoundingMode.HALF_UP)
                    + "\n\n" +

                    "RESUMO DOS IMPOSTOS\n\n" +

                    "Impostos - " + "Taxa - " + "Valor\n" +
                    ValorImposto.ISS + " - " + ValorImposto.ISS.getValorPorImposto() * 100 + "%" + " - R$ " +
                    new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.ISS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + "\n" +

                    ValorImposto.PIS + " - " + ValorImposto.PIS.getValorPorImposto() * 100 + "%" + " - R$ " +
                    new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.PIS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + "\n" +

                    ValorImposto.COFINS + " - " + ValorImposto.COFINS.getValorPorImposto() * 100 + "%" + " - R$ " +
                    new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.COFINS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + "\n" +

                    ValorImposto.IRPJ + " - " + ValorImposto.IRPJ.getValorPorImposto() * 100 + "%" + " - R$ "
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.IRPJ)).setScale(2,
                            RoundingMode.HALF_UP)
                    + "\n" +

                    ValorImposto.CSLL + " - " + ValorImposto.CSLL.getValorPorImposto() * 100 + "%" + " - R$ "
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.CSLL)).setScale(2,
                            RoundingMode.HALF_UP)
                    + "\n";

            gravarArquivo.print(linhaArquivo);
            gravarArquivo.close();

        } catch (Exception e) {
            System.err.println("Erro ao gerar nota fiscal");
            e.printStackTrace();
        }
    }

    public void gerarNotaFiscalCSV(Integer numero) {
        try {
            FileWriter caminho = new FileWriter("\\notafiscal\\Nota " + (numero) + ".csv");
            PrintWriter gravarArquivo = new PrintWriter(caminho);

            String linhaArquivo = "Prestador de Serviço,\n" +
                    "Clinica:," + faturamento.getNomeHospital() + ",\n" +
                    "CNPJ:," + faturamento.getCnpj() + ",\n\n" +

                    "Tomador,\n" +
                    "Paciente:," + faturamento.getNome() + ",\n" +
                    "CPF:," + faturamento.getCpf() + ",\n\n"

                    + "Descrição do Serviço:" + ",\n" +
                    "Tipo Serviço:," + faturamento.getTipo() + ",\n\n"

                    + "Valor da Nota:" + ",\n" +
                    "Valor bruto do serviço:, R$" + faturamento.getValor() + ",\n\n"

                    + "ISS,\n" +
                    "Alíquota:," + ValorImposto.ISS.getValorPorImposto() * 100 + "%" + ",\n" +
                    "Valor:, R$"
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.ISS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + ",\n\n" +

                    "PIS,\n" +
                    "Alíquota:," + ValorImposto.PIS.getValorPorImposto() * 100 + "%" + ",\n" +
                    "Valor:, R$"
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.PIS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + ",\n\n" +

                    "COFINS,\n" +
                    "Alíquota:," + ValorImposto.COFINS.getValorPorImposto() * 100 + "%" + ",\n" +
                    "Valor:, R$"
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.COFINS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + ",\n\n" +

                    "IRPJ,\n" +
                    "Alíquota:," + ValorImposto.IRPJ.getValorPorImposto() * 100 + "%" + ",\n" +
                    "Valor:, R$"
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.IRPJ)).setScale(2,
                            RoundingMode.HALF_UP)
                    + ",\n\n" +

                    "CSLL,\n" + "Alíquota:, " + ValorImposto.CSLL.getValorPorImposto() * 100 + "%" + ",\n" +
                    "Valor:, R$"
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.CSLL)).setScale(2,
                            RoundingMode.HALF_UP)
                    + ",\n\n" +

                    "RESUMO DOS IMPOSTOS,\n\n" +

                    "Impostos," + "Taxa," + "Valor,\n" +
                    ValorImposto.ISS + "," + ValorImposto.ISS.getValorPorImposto() * 100 + "%," + "R$ " +
                    new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.ISS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + ",\n" +

                    ValorImposto.PIS + "," + ValorImposto.PIS.getValorPorImposto() * 100 + "%," + "R$ " +
                    new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.PIS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + ",\n" +

                    ValorImposto.COFINS + "," + ValorImposto.COFINS.getValorPorImposto() * 100 + "%," + "R$ " +
                    new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.COFINS)).setScale(2,
                            RoundingMode.HALF_UP)
                    + ",\n" +

                    ValorImposto.IRPJ + "," + ValorImposto.IRPJ.getValorPorImposto() * 100 + "%," + "R$ "
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.IRPJ)).setScale(2,
                            RoundingMode.HALF_UP)
                    + ",\n" +

                    ValorImposto.CSLL + "," + ValorImposto.CSLL.getValorPorImposto() * 100 + "%," + "R$ "
                    + new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.CSLL)).setScale(2,
                            RoundingMode.HALF_UP)
                    + ",\n";

            gravarArquivo.print(linhaArquivo);
            gravarArquivo.close();

        } catch (Exception e) {
            System.err.println("Erro ao gerar nota fiscal");
            e.printStackTrace();
        }
    }
}
