package br.com.hospital.model;

public class Paciente {
  private Integer id;
  private String nome;
  private String cpf;
  
public Paciente(String nome) {
    this.nome = nome;
  }

  public Paciente(String nome, String cpf) {
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

  public String getCpf() {
    return cpf;
  }

  
}
