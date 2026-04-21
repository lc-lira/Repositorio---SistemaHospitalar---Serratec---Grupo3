package br.com.hospital.model;

import java.time.LocalDate;

public class ExamesLaudos {
  private LocalDate dataHora; 
  private LocalDate dataResultado; 
  private String tipo;
  private Double custo;
  private String descricao;
  private String resultado;
  private String anexo;
  
  public ExamesLaudos(LocalDate dataHora, LocalDate dataResultado, String tipo, Double custo, String descricao,
      String resultado, String anexo) {
    this.dataHora = dataHora;
    this.dataResultado = dataResultado;
    this.tipo = tipo;
    this.custo = custo;
    this.descricao = descricao;
    this.resultado = resultado;
    this.anexo = anexo;
  }

  public LocalDate getDataHora() {
    return dataHora;
  }

  public LocalDate getDataResultado() {
    return dataResultado;
  }

  public String getTipo() {
    return tipo;
  }

  public Double getCusto() {
    return custo;
  }

  public String getDescricao() {
    return descricao;
  }

  public String getResultado() {
    return resultado;
  }

  public String getAnexo() {
    return anexo;
  }

  
}
