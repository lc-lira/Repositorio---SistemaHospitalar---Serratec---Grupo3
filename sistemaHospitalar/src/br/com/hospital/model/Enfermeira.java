package br.com.hospital.model;

public class Enfermeira extends Pessoa {
  private Integer id;
  private String cre;
  private Turno turno;
  private String respNome;

  public enum Turno {

    MANHA, TARDE, NOITE;
  }

  public Enfermeira(String nome, Integer id, String cre, Turno turno, String respNome) {
    super(nome);
    this.id = id;
    this.cre = cre;
    this.turno = turno;
    this.respNome = respNome;
  }

  
  @Override
  public String toString() {
    return "Enfermeira [id: " + id + ", cre=" + cre + ", turno=" + turno + ", respNome=" + respNome + "]";
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

}
