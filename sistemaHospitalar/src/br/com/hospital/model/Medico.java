package br.com.hospital.model;

public class Medico extends Pessoa {

  private Integer id;
  private String especialidade;
  private String crm;

  public Medico(String nome, Integer id, String especialidade, String crm) {
    super(nome);
    this.id = id;
    this.especialidade = especialidade;
    this.crm = crm;
  }
  

  @Override
  public String toString() {
    return "Medico [id=" + id + ", especialidade=" + especialidade + ", crm=" + crm + "]";
  }


  public Integer getId() {
    return id;
  }

  public String getEspecialidade() {
    return especialidade;
  }

  public String getCrm() {
    return crm;
  }

}
