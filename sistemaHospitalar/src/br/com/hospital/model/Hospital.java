package br.com.hospital.model;

public class Hospital {

  private Integer id;
  private String nome;
  private String cnpj;

  public Hospital(String nome, String cnpj) {
    this.nome = nome;
    this.cnpj = cnpj;
  }

  public Hospital(Integer id, String cnpj, String nome) {
    this.id = id;
    this.cnpj = cnpj;
    this.nome = nome;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getNome() {
    return nome;
  }

  public Integer getId() {
    return id;
  }

}
