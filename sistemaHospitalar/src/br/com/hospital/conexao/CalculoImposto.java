package br.com.hospital.conexao;

import br.com.hospital.model.ValorImposto;

public interface CalculoImposto {
    Double calcular(Double salarioBruto, ValorImposto imposto);
}
