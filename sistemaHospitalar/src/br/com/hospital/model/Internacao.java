package br.com.hospital.model;

import java.time.LocalDate;

public class Internacao {

  private Integer id;
  private Paciente paciente;
  private LocalDate dataEntrada, dataSaida;
  private Leitos leitos;

  public Internacao(Integer id, Paciente paciente, LocalDate dataEntrada, LocalDate dataSaida, Leitos leitos) {
    this.id = id;
    this.paciente = paciente;
    this.dataEntrada = dataEntrada;
    this.dataSaida = dataSaida;
    this.leitos = leitos;
  }

  public Integer getId() {
    return id;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public LocalDate getDataEntrada() {
    return dataEntrada;
  }

  public LocalDate getDataSaida() {
    return dataSaida;
  }

  public Leitos getLeitos() {
    return leitos;
  }

}
