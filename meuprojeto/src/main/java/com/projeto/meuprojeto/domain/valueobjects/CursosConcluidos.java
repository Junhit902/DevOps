package com.projeto.meuprojeto.domain.valueobjects;

/**
 * Value Object para representar a quantidade de cursos concluídos
 */
public class CursosConcluidos {

    private static final int CURSOS_MINIMOS = 3;
    private final int quantidade;

    public CursosConcluidos(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade de cursos não pode ser negativa");
        }
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean temCursosSuficientes() {
        return quantidade >= CURSOS_MINIMOS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursosConcluidos)) return false;
        CursosConcluidos that = (CursosConcluidos) o;
        return quantidade == that.quantidade;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(quantidade);
    }

    @Override
    public String toString() {
        return "CursosConcluidos{" +
                "quantidade=" + quantidade +
                '}';
    }
}
