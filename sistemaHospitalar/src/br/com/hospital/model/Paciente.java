package br.com.hospital.model;

public class Paciente {
  private Integer id;
  private String nome;
  private Integer cpf;
  
  public Paciente(Integer id, String nome, Integer cpf) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    return "id: " + id + ", nome: " + nome + ", cpf: " + cpf;
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public Integer getCpf() {
    return cpf;
  }

  
}
