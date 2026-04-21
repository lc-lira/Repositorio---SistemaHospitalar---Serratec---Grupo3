package br.com.hospital.model;

public class Faturamento {
    private String nome;
    private Double valor;

    public Faturamento(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Faturamento: nome= " + nome + " , valor= " + valor + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
