package br.com.hospital.model;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.hospital.enums.ValorImposto;

public class NotaFiscal {
        private Integer id;
        private Faturamento faturamento;
        private ValoresImpostos valoresImpostos;

        public NotaFiscal(Faturamento faturamento) {
                this.faturamento = faturamento;
        }

        public Integer getId() {
                return id;
        }

        public Faturamento getFaturamento() {
                return faturamento;
        }

        public ValoresImpostos getValoresImpostos() {
                return valoresImpostos;
        }

        public void setValoresImpostos(ValoresImpostos valoresImpostos) {
                this.valoresImpostos = valoresImpostos;
        }

        public void gerarNotaFiscalTXT() {

                        try (FileWriter caminho = new FileWriter("\\notafiscal\\NotaTXT " + faturamento.getPaciente().getNome() + ".txt");
                                PrintWriter gravarArquivo = new PrintWriter(caminho)) {

                                BigDecimal iss = new BigDecimal(
                                                faturamento.calcular(faturamento.getValor(), ValorImposto.ISS))
                                                .setScale(2, RoundingMode.HALF_UP);
                                BigDecimal pis = new BigDecimal(
                                                faturamento.calcular(faturamento.getValor(), ValorImposto.PIS))
                                                .setScale(2, RoundingMode.HALF_UP);
                                BigDecimal cofins = new BigDecimal(
                                                faturamento.calcular(faturamento.getValor(), ValorImposto.COFINS))
                                                .setScale(2, RoundingMode.HALF_UP);
                                BigDecimal irpj = new BigDecimal(
                                                faturamento.calcular(faturamento.getValor(), ValorImposto.IRPJ))
                                                .setScale(2, RoundingMode.HALF_UP);
                                BigDecimal csll = new BigDecimal(
                                                faturamento.calcular(faturamento.getValor(), ValorImposto.CSLL))
                                                .setScale(2, RoundingMode.HALF_UP);

                                String linhaArquivo = "Prestador de Serviço\n" +
                                                "Clinica: " + faturamento.getHospital().getNome() + "\n" +
                                                "CNPJ: " + faturamento.getHospital().getCnpj() + "\n\n" +

                                                "Tomador\n" +
                                                "Paciente: " + faturamento.getPaciente().getNome() + "\n" +
                                                "CPF: " + faturamento.getPaciente().getCpf() + "\n\n"

                                                + "Descrição do Serviço" + "\n" +
                                                "Tipo Serviço: " + faturamento.getAtendimento().getTipo() + "\n\n"

                                                + "Valor da Nota" + "\n" +
                                                "Valor bruto do serviço: R$ " + faturamento.getValor() + "\n\n" +

                                                "ISS\n" +
                                                "Alíquota: " + (ValorImposto.ISS.getValorPorImposto() * 100) + "%"
                                                + "\n" +
                                                "Valor: R$ "
                                                + iss
                                                + "\n\n" +

                                                "PIS\n" +
                                                "Alíquota: " + (ValorImposto.PIS.getValorPorImposto() * 100) + "%"
                                                + "\n" +
                                                "Valor: R$ "
                                                + pis
                                                + "\n\n" +

                                                "COFINS\n" +
                                                "Alíquota: " + (ValorImposto.COFINS.getValorPorImposto() * 100) + "%"
                                                + "\n" +
                                                "Valor: R$ "
                                                + cofins
                                                + "\n\n" +

                                                "IRPJ\n" +
                                                "Alíquota: " + (ValorImposto.IRPJ.getValorPorImposto() * 100) + "%"
                                                + "\n" +
                                                "Valor: R$ "
                                                + irpj
                                                + "\n\n" +

                                                "CSLL\n" +
                                                "Alíquota: " + (ValorImposto.CSLL.getValorPorImposto() * 100) + "%"
                                                + "\n" +
                                                "Valor: R$ "
                                                + csll
                                                + "\n\n" +

                                                "RESUMO DOS IMPOSTOS\n\n" +

                                                "Impostos - " + "Taxa - " + "Valor\n" +
                                                ValorImposto.ISS + " - " + (ValorImposto.ISS.getValorPorImposto() * 100)
                                                + "%"
                                                + " - R$ "
                                                + iss
                                                + "\n" +

                                                ValorImposto.PIS + " - " + (ValorImposto.PIS.getValorPorImposto() * 100)
                                                + "%"
                                                + " - R$ "
                                                + pis
                                                + "\n" +

                                                ValorImposto.COFINS + " - "
                                                + (ValorImposto.COFINS.getValorPorImposto() * 100)
                                                + "%"
                                                + " - R$ "
                                                + cofins
                                                + "\n" +

                                                ValorImposto.IRPJ + " - "
                                                + (ValorImposto.IRPJ.getValorPorImposto() * 100) + "%"
                                                + " - R$ "
                                                + irpj
                                                + "\n" +

                                                ValorImposto.CSLL + " - "
                                                + (ValorImposto.CSLL.getValorPorImposto() * 100) + "%"
                                                + " - R$ "
                                                + csll
                                                + "\n";

                                gravarArquivo.print(linhaArquivo);

                } catch (Exception e) {
                        System.err.println("Erro ao gerar nota fiscal TXT!");
                        e.printStackTrace();
                }
        }

        public void gerarNotaFiscalCSV() {
                try (FileWriter caminho = new FileWriter(
                                "\\notafiscal\\NotaCSV " + faturamento.getPaciente().getNome() + ".csv");
                                PrintWriter gravarArquivo = new PrintWriter(caminho)) {

                        BigDecimal iss = new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.ISS))
                                        .setScale(2, RoundingMode.HALF_UP);
                        BigDecimal pis = new BigDecimal(faturamento.calcular(faturamento.getValor(), ValorImposto.PIS))
                                        .setScale(2, RoundingMode.HALF_UP);
                        BigDecimal cofins = new BigDecimal(
                                        faturamento.calcular(faturamento.getValor(), ValorImposto.COFINS))
                                        .setScale(2, RoundingMode.HALF_UP);
                        BigDecimal irpj = new BigDecimal(
                                        faturamento.calcular(faturamento.getValor(), ValorImposto.IRPJ))
                                        .setScale(2, RoundingMode.HALF_UP);
                        BigDecimal csll = new BigDecimal(
                                        faturamento.calcular(faturamento.getValor(), ValorImposto.CSLL))
                                        .setScale(2, RoundingMode.HALF_UP);

                        String linhaArquivo = "Prestador de Serviço,\n" +
                                        "Clinica:," + faturamento.getHospital().getNome() + ",\n" +
                                        "CNPJ:," + faturamento.getHospital().getCnpj() + ",\n\n" +

                                        "Tomador,\n" +
                                        "Paciente:," + faturamento.getPaciente().getNome() + ",\n" +
                                        "CPF:," + faturamento.getPaciente().getCpf() + ",\n\n"

                                        + "Descrição do Serviço:" + ",\n" +
                                        "Tipo Serviço:," + faturamento.getAtendimento().getTipo() + ",\n\n"

                                        + "Valor da Nota:" + ",\n" +
                                        "Valor bruto do serviço:, R$ " + faturamento.getValor() + ",\n\n"

                                        + "ISS,\n" +
                                        "Alíquota:," + ValorImposto.ISS.getValorPorImposto() * 100 + "%" + ",\n" +
                                        "Valor:, R$ "
                                        + iss + ",\n\n" +

                                        "PIS,\n" +
                                        "Alíquota:," + ValorImposto.PIS.getValorPorImposto() * 100 + "%" + ",\n" +
                                        "Valor:, R$ "
                                        + pis + ",\n\n" +

                                        "COFINS,\n" +
                                        "Alíquota:," + ValorImposto.COFINS.getValorPorImposto() * 100 + "%" + ",\n" +
                                        "Valor:, R$ "
                                        + cofins + ",\n\n" +

                                        "IRPJ,\n" +
                                        "Alíquota:," + ValorImposto.IRPJ.getValorPorImposto() * 100 + "%" + ",\n" +
                                        "Valor:, R$ "
                                        + irpj + ",\n\n" +

                                        "CSLL,\n" + "Alíquota:, " + ValorImposto.CSLL.getValorPorImposto() * 100 + "%"
                                        + ",\n" +
                                        "Valor:, R$ "
                                        + csll + ",\n\n" +

                                        "RESUMO DOS IMPOSTOS,\n\n" +

                                        "Impostos," + "Taxa," + "Valor,\n" +
                                        ValorImposto.ISS + "," + ValorImposto.ISS.getValorPorImposto() * 100 + "%,"
                                        + "R$ " +
                                        iss +
                                        ",\n" +

                                        ValorImposto.PIS + "," + ValorImposto.PIS.getValorPorImposto() * 100 + "%,"
                                        + "R$ " +
                                        pis +
                                        ",\n" +

                                        ValorImposto.COFINS + "," + ValorImposto.COFINS.getValorPorImposto() * 100
                                        + "%,"
                                        + "R$ " +
                                        cofins +
                                        ",\n" +

                                        ValorImposto.IRPJ + "," + ValorImposto.IRPJ.getValorPorImposto() * 100 + "%,"
                                        + "R$ " +
                                        irpj +
                                        ",\n" +

                                        ValorImposto.CSLL + "," + ValorImposto.CSLL.getValorPorImposto() * 100 + "%,"
                                        + "R$ " +
                                        csll +
                                        ",";

                        gravarArquivo.print(linhaArquivo);

                } catch (Exception e) {
                        System.err.println("Erro ao gerar nota fiscal CSV!");
                        e.printStackTrace();
                }
        }
}
