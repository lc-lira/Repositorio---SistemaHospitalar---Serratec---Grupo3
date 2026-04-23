package br.com.hospital.model;

import br.com.hospital.enums.ValorImposto;

public interface CalculoImposto {
    Double calcular(Double valorFatura, ValorImposto imposto);
}
