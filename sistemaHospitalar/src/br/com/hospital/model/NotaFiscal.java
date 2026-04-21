package br.com.hospital.model;

public class NotaFiscal {
  private Integer idFatura;
  private String nomeEmissor;
  private String paciente;
  private String descricao;
  private Integer vpPis;
  private Integer vpCofins;
  private Integer vpIss;
  private Integer vpIropj;
  private Integer vpCsll;
  
  public NotaFiscal(Integer idFatura, String nomeEmissor, String paciente, String descricao, Integer vpPis,
      Integer vpCofins, Integer vpIss, Integer vpIropj, Integer vpCsll) {
    this.idFatura = idFatura;
    this.nomeEmissor = nomeEmissor;
    this.paciente = paciente;
    this.descricao = descricao;
    this.vpPis = vpPis;
    this.vpCofins = vpCofins;
    this.vpIss = vpIss;
    this.vpIropj = vpIropj;
    this.vpCsll = vpCsll;
  }

  @Override
  public String toString() {
    return "idFatura: " + idFatura + ", nomeEmissor: " + nomeEmissor + ", paciente: " + paciente
        + ", descricao: " + descricao + ", vpPis: " + vpPis + ", vpCofins: " + vpCofins + ", vpIss: " + vpIss + ", vpIropj: "
        + vpIropj + ", vpCsll: " + vpCsll;
  }

 

  
}
