package br.com.hospital.model;

import java.util.ArrayList;
import java.util.List;

import br.com.hospital.exceptions.ErroPlano;

public class Hospital {

      private Integer id;
      private String nome;
      private String cnpj;

      List<Alas> alas = new ArrayList<Alas>();
      List<PlanodeSaude> planosDeSaude = new ArrayList<PlanodeSaude>();
      
      public Hospital(String nome, String cnpj){
        this.nome = nome;
        this.cnpj = cnpj;
      }

      public Hospital(Integer id, String cnpj, List<Alas> alas, String nome) {
        this.id = id;
        this.cnpj = cnpj;
        this.alas = alas;
        this.nome = nome;
      }

      @Override
      public String toString() {
        return "Cnpj: " + cnpj + ", alas: " + alas + ", planodeSaude: " + planosDeSaude;
      }

      public String getCnpj() {
        return cnpj;
      }

      public boolean checarPlanos(PlanodeSaude planoDeSaude){
        for (PlanodeSaude plano : planosDeSaude) {

          if (plano.equals(planoDeSaude)) { 
            return true;
          }
        }
        return false;
      }

      public void adicionarPlanos(PlanodeSaude planoDeSaude) throws ErroPlano{
        if (checarPlanos(planoDeSaude)) {
          throw new ErroPlano("Plano já existente!");
        };
        planosDeSaude.add(planoDeSaude);
      }

      public void removerPlanos(PlanodeSaude planoDeSaude) throws ErroPlano{
        if (!checarPlanos(planoDeSaude)) {
          throw new ErroPlano("Plano não existe!");
        }
        planosDeSaude.remove(planoDeSaude);
      }

      public String getNome() {
        return nome;
      }

      public List<Alas> getAlas() {
        return alas;
      }

      public List<PlanodeSaude> getPlanosDeSaude() {
        return planosDeSaude;
      }


}
