package br.com.hospital.model;

public class Enfermeira {
  private String cre;
  private String truno;
  private String respNome;
  private String nome;
  
  public Enfermeira(String cre, String truno, String respNome, String nome) {
    this.cre = cre;
    this.truno = truno;
    this.respNome = respNome;
    this.nome = nome;
  }
  
  public String getCre() {
    return cre;
  }

  public String getTruno() {
    return truno;
  }

  public String getRespNome() {
    return respNome;
  }


  public String getNome() {
    return nome;
  }

  
}
