package br.com.hospital.model;

public class Medico {
  private String nome;
  private String especialidade;
  private String crm;
  
  public Medico(String nome, String especialidade, String crm) {
    this.nome = nome;
    this.especialidade = especialidade;
    this.crm = crm;
  }
  public String getNome() {
    return nome;
  }
  public String getEspecialidade() {
    return especialidade;
  }
  public String getCrm() {
    return crm;
  }

  
}
