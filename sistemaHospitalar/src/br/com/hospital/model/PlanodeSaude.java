package br.com.hospital.model;

import java.time.LocalDate;

public class PlanodeSaude {
    private LocalDate dataCredenciamento; 
    private String nomeDoplano;
    private String telefone;

    public enum cobertura{
      regional, nacional;
    }

    public PlanodeSaude(LocalDate dataCredenciamento, String nomeDoplano, String telefone) {
      this.dataCredenciamento = dataCredenciamento;
      this.nomeDoplano = nomeDoplano;
      this.telefone = telefone;
    }

    public LocalDate getDataCredenciamento() {
      return dataCredenciamento;
    }

    public String getNomeDoplano() {
      return nomeDoplano;
    }

    public String getTelefone() {
      return telefone;
    }

    
}
