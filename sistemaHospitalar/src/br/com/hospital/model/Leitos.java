package br.com.hospital.model;

public class Leitos {
  private Integer id;
  private String identificador;
  private Status status;

  public enum Status {
    LIVRE, OCUPADO, RESERVADO;
  }

  public Leitos(Integer id, Status status, String identificador) {
    this.id = id;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public String getIdentificador() {
    return identificador;
  }

  public Status getStatus() {
    return status;
  }

}
