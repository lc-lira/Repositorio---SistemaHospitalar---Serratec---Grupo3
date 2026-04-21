package br.com.hospital.conexao;
/* RESUMO DOS IMPOSTOS
Impostos Valor
ISS 3,00% R$ 150,00
PIS 0,65% R$ 32,50
COFINS 3,00% R$ 150,00
IRPJ 1,20% R$ 60,00
CSLL 1,08% R$ 54,00*/

public interface CalculoImposto {
    Double calcularINSS(Double salarioBruto);

    Double calcularPIS(Double salarioBruto);

    Double calcularCOFINS(Double salarioBruto);

    Double calcularIRPJ(Double salarioBruto);

    Double calcularCSLL(Double salarioBruto);
}
