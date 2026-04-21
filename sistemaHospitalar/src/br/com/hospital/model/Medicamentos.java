package br.com.hospital.model;

import java.time.LocalDate;

public class Medicamentos {
  private String prescricao;
  private LocalDate data; 
  private String medicamento;
  private Double dosagem;
  
  public Medicamentos(String prescricao, LocalDate data, String medicamento, Double dosagem) {
    this.prescricao = prescricao;
    this.data = data;
    this.medicamento = medicamento;
    this.dosagem = dosagem;
  }

  public String getPrescricao() {
    return prescricao;
  }

  public LocalDate getData() {
    return data;
  }

  public String getMedicamento() {
    return medicamento;
  }

  public Double getDosagem() {
    return dosagem;
  }

  
  
}
