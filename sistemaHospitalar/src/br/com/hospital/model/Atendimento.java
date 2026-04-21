package br.com.hospital.model;

import java.time.LocalDate;

public class Atendimento {
  private String medico;
  private String paciente;
  private LocalDate dataHora; 
  private String tipo;
  private String status;
  private String observacoes;
  
  public Atendimento(String medico, String paciente, LocalDate dataHora, String tipo, String status, String observacoes) {
    this.medico = medico;
    this.paciente = paciente;
    this.dataHora = dataHora;
    this.tipo = tipo;
    this.status = status;
    this.observacoes = observacoes;
  }

  public String getMedico() {
    return medico;
  }

  public String getPaciente() {
    return paciente;
  }

  public LocalDate getDataHora() {
    return dataHora;
  }

  public String getTipo() {
    return tipo;
  }

  public String getStatus() {
    return status;
  }

  public String getObservacoes() {
    return observacoes;
  }



}
