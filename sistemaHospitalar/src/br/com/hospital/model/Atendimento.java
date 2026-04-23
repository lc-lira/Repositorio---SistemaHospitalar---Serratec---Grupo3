package br.com.hospital.model;

import java.time.LocalDate;

public class Atendimento {
  
  private Integer id;
  private Medico medico;
  private Paciente paciente;
  private LocalDate dataHora;
  private Tipo tipo;
  private Status status;
  private String observacoes;

  public Atendimento(Tipo tipo) {
    this.tipo = tipo;
  }

  public enum Status {
    REALIZADO, AGENDADO, CANCELADO;
  }

  public enum Tipo {
    CONSULTA, EMERGENCIA, REVISAO;
  }

  public Integer getId() {
    return id;
  }

  public Medico getMedico() {
    return medico;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public LocalDate getDataHora() {
    return dataHora;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public String getStatus() {
    return status;
  }

  public String getObservacoes() {
    return observacoes;
  }



}
