package br.com.hospital.model;

public enum ValorImposto {
    /*
     * RESUMO DOS IMPOSTOS
     * Impostos Valor
     * ISS 3,00% R$ 150,00
     * PIS 0,65% R$ 32,50
     * COFINS 3,00% R$ 150,00
     * IRPJ 1,20% R$ 60,00
     * CSLL 1,08% R$ 54,00
     */

    INSS(0.03), PIS(0.0065), COFINS(0.03), IRPJ (0.012), CSLL(0.0108);

    Double valorPorImposto;

    private ValorImposto(Double valorPorImposto) {
        this.valorPorImposto = valorPorImposto;
    }

    public Double getValorPorImposto() {
        return valorPorImposto;
    }

}
