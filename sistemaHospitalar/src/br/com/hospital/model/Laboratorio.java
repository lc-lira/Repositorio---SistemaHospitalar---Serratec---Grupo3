package br.com.hospital.model;

public class Laboratorio {

  private Integer id;
  private String exame;

  public enum classificacao {
    INTERNO, EXTERNO;
  }

  public Laboratorio(Integer id, String exame) {
    this.id = id;
    this.exame = exame;
  }

  public Integer getId() {
    return id;
  }

  public String getExame() {
    return exame;
  }

}
