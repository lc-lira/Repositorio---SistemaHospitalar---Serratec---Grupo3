package br.com.hospital.model;

public class Leitos {
  private Integer id;
  private String identificador;
  private Status status;
  
  public enum Status{
      LIVRE, OCUPADO, RESERVADO;  
  }
  
  public Leitos(Integer id, Status status, String identificador) {
    this.id = id;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public Status getStatusAtual() {
    return status;
  }
  public String getIdentificador() {
    return identificador;
  }

  public Status getStatus() {
    return status;
  }

  public void ocuparLeito(){
    if (status == Status.LIVRE) {
      status = Status.OCUPADO;
    }
  }
  public void desocuparLeito(){
    if (status == Status.OCUPADO) {
      status = Status.LIVRE;
    }
  }

  public void reservarLeito(){
    if (status == Status.LIVRE) {
      status = Status.RESERVADO;
    }
  }

  public void tirarReserva(){
    if (status == Status.RESERVADO) {
      status = Status.LIVRE;
    }
  }
}
