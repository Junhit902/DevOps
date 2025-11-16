package com.projeto.meuprojeto.domain.valueobjects;

/**
 * Value Object para representar o desconto concedido ao aluno
 */
public class Desconto {

    public static final Desconto DESCONTO_40_PORCENTO = new Desconto(0.40, "40%");
    public static final Desconto DESCONTO_20_PORCENTO = new Desconto(0.20, "20%");
    public static final Desconto SEM_DESCONTO = new Desconto(0.0, "0%");

    private final double percentual;
    private final String descricao;

    private Desconto(double percentual, String descricao) {
        if (percentual < 0.0 || percentual > 1.0) {
            throw new IllegalArgumentException("Percentual deve estar entre 0.0 e 1.0");
        }
        this.percentual = percentual;
        this.descricao = descricao;
    }

    public double getPercentual() {
        return percentual;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean temDesconto() {
        return percentual > 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Desconto)) return false;
        Desconto desconto = (Desconto) o;
        return Double.compare(desconto.percentual, percentual) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(percentual);
    }

    @Override
    public String toString() {
        return descricao;
    }
}
