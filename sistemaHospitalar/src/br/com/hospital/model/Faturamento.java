package br.com.hospital.model;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.hospital.enums.ValorImposto;

public class Faturamento implements CalculoImposto {
    private Integer id;
    private String nome;
    private String cpf;
    private Double valor;
    private String cnpj;
    private String nomeHospital;
    private String tipo;

    public Faturamento(Integer id, String nome, String cpf, Double valor, String cnpj, String nomeHospital,
            String tipo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.valor = valor;
        this.cnpj = cnpj;
        this.nomeHospital = nomeHospital;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getValor() {
        return valor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeHospital() {
        return nomeHospital;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public Double calcular(Double valorFatura, ValorImposto imposto) {
        Double desconto = valorFatura * imposto.getValorPorImposto();
        return desconto;
    }

}
