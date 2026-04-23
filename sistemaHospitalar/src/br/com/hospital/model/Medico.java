package br.com.hospital.model;

public class Medico {

  private Integer id;
  private String nome;
  private String especialidade;
  private String crm;

  public Medico(Integer id, String nome, String especialidade, String crm) {
    this.id = id;
    this.nome = nome;
    this.especialidade = especialidade;
    this.crm = crm;
  }

  public Integer getId() {
    return id;
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
