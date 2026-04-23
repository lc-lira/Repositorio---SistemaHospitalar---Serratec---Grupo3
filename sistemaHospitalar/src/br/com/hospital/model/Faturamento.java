package br.com.hospital.model;

import br.com.hospital.enums.ValorImposto;

public class Faturamento implements CalculoImposto {
    private Integer id;
    private Double valor;
    private Paciente paciente;
    private Hospital hospital;
    private Atendimento atendimento;

    public Faturamento(Paciente paciente, Double valor, Hospital hospital, Atendimento atendimento) {
        this.paciente = paciente;
        this.valor = valor;
        this.hospital = hospital;
        this.atendimento = atendimento;
    }

    public Faturamento(Integer id, Double valor, Paciente paciente, Hospital hospital, Atendimento atendimento) {
        this.id = id;
        this.valor = valor;
        this.paciente = paciente;
        this.hospital = hospital;
        this.atendimento = atendimento;
    }

    public Integer getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    @Override
    public Double calcular(Double valorFatura, ValorImposto imposto) {
        Double desconto = valorFatura * imposto.getValorPorImposto();
        return desconto;
    }
}
