package br.com.hospital.model;

import java.time.LocalDate;

public class PlanodeSaude {

  private Integer id;
  private LocalDate dataCredenciamento;
  private String nomeDoplano;
  private String telefone;
  private Cobertura cobertura;

  public enum Cobertura {
    REGIONAL, NACIONAL;
  }

  public PlanodeSaude(Integer id, LocalDate dataCredenciamento, String nomeDoplano, String telefone,
      Cobertura cobertura) {
    this.id = id;
    this.dataCredenciamento = dataCredenciamento;
    this.nomeDoplano = nomeDoplano;
    this.telefone = telefone;
    this.cobertura = cobertura;
  }

  public Integer getId() {
    return id;
  }

  public LocalDate getDataCredenciamento() {
    return dataCredenciamento;
  }

  public String getNomeDoplano() {
    return nomeDoplano;
  }

  public String getTelefone() {
    return telefone;
  }

  public Cobertura getCobertura() {
    return cobertura;
  }

}
