package br.com.hospital.model;

public class Paciente extends Pessoa {
  private Integer id;
  private String cpf;

  public Paciente(String nome, Integer id, String cpf) {
    super(nome);
    this.id = id;
    this.cpf = cpf;
  }

  public Paciente(String nome, String cpf) {
    super(nome);
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    return "Paciente [id=" + id + ", cpf=" + cpf + "]";
  }

  public Integer getId() {
    return id;
  }

  public String getCpf() {
    return cpf;
  }

}
