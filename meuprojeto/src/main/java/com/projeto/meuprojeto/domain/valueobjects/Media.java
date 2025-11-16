package com.projeto.meuprojeto.domain.valueobjects;

/**
 * Value Object para representar a média global do aluno
 */
public class Media {

    private final double valor;

    public Media(double valor) {
        if (valor < 0.0 || valor > 10.0) {
            throw new IllegalArgumentException("Média deve estar entre 0.0 e 10.0");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public boolean ehAlta() {
        return valor >= 8.0;
    }

    public boolean ehMedia() {
        return valor >= 7.0 && valor < 8.0;
    }

    public boolean ehBaixa() {
        return valor < 7.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return Double.compare(media.valor, valor) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(valor);
    }

    @Override
    public String toString() {
        return String.format("%.2f", valor);
    }
}
