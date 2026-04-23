package br.com.hospital.model;

import java.time.LocalDate;

public class ExamesLaudos {
  private Integer id;
  private LocalDate dataHora;
  private LocalDate dataResultado;
  private Tipo tipo;
  private Double custo;
  private String descricao;
  private String resultado;
  private String anexo;

  public ExamesLaudos(Integer id, LocalDate dataHora, LocalDate dataResultado, Tipo tipo, Double custo,
      String descricao, String resultado, String anexo) {
    this.id = id;
    this.dataHora = dataHora;
    this.dataResultado = dataResultado;
    this.tipo = tipo;
    this.custo = custo;
    this.descricao = descricao;
    this.resultado = resultado;
    this.anexo = anexo;
  }

  public enum Tipo {
    SANGUE, IMAGEM, URINA, RAIO_X, TOMOGRAFIA, ENDOSCOPIA;
  }

  public Integer getId() {
    return id;
  }

  public LocalDate getDataHora() {
    return dataHora;
  }

  public LocalDate getDataResultado() {
    return dataResultado;
  }

  public Tipo getTipo() {
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
