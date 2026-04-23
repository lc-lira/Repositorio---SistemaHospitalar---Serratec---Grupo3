package br.com.hospital.model;

public class ValoresImpostos {
    private Double pis;
    private Double cofins;
    private Double iss;
    private Double irpj;
    private Double csll;

    public ValoresImpostos(Double pis, Double cofins, Double iss, Double irpj, Double csll) {
        this.pis = pis;
        this.cofins = cofins;
        this.iss = iss;
        this.irpj = irpj;
        this.csll = csll;
    }

    public Double getIss() {
        return iss;
    }

    public Double getPis() {
        return pis;
    }

    public Double getCofins() {
        return cofins;
    }

    public Double getIrpj() {
        return irpj;
    }

    public Double getCsll() {
        return csll;
    }

}
