package br.com.hospital.model;

public class Laboratorio {
  private String exame;
  
  public enum classificacao {
    interno, externo;
  }

  public Laboratorio(String exame) {
    this.exame = exame;
  }

  public String getExame() {
    return exame;
  }

  
}
