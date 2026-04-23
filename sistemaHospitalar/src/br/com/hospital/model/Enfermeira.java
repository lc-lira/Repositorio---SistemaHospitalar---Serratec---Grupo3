package br.com.hospital.model;

public class Enfermeira {
  private Integer id;
  private String cre;
  private Turno turno;
  private String respNome;
  private String nome;

  public Enfermeira(Integer id, String cre, Turno turno, String respNome, String nome) {
    this.id = id;
    this.cre = cre;
    this.turno = turno;
    this.respNome = respNome;
    this.nome = nome;
  }

  public enum Turno {

    MANHA,TARDE,NOITE;
  }

  public Integer getId() {
    return id;
  }

  public String getCre() {
    return cre;
  }

  public Turno getTurno() {
    return turno;
  }

  public String getRespNome() {
    return respNome;
  }

  public String getNome() {
    return nome;
  }

}
