package br.com.hospital.model;

public class Alas{ 
  private Tipo tipo;
  static private Integer leitosDisponiveis;
  private Enfermeira enfermeira;
  
  public enum Tipo {
  
    UTI, EMERGENCIA, ENFERMARIA, PEDIATRIA, MATERNIDADADE, CARDIOLOGIA;
    
  }
 
  public Alas(Tipo tipo, Enfermeira enfermeira) {
    this.tipo = tipo;
    this.enfermeira = enfermeira;
  }
  
  public Tipo getTipo() {
    return tipo;
  }
  public static Integer getLeitos() {
    return leitosDisponiveis;
  }


  public static Integer getLeitosDisponiveis() {
    return leitosDisponiveis;
  }


  public Enfermeira getEnfermeira() {
    return enfermeira;
  }
}
