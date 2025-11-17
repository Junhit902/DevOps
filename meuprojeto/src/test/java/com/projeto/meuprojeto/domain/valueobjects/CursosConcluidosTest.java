package com.projeto.meuprojeto.domain.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursosConcluidosTest {

    @Test
    void deveLancarExcecaoQuandoQuantidadeNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new CursosConcluidos(-1));
    }

    @Test
    void deveIndicarCursosSuficientesQuandoMaiorOuIgualTres() {
        CursosConcluidos c3 = new CursosConcluidos(3);
        CursosConcluidos c5 = new CursosConcluidos(5);

        assertTrue(c3.temCursosSuficientes());
        assertTrue(c5.temCursosSuficientes());
    }

    @Test
    void deveIndicarCursosInsuficientesQuandoMenorQueTres() {
        CursosConcluidos c0 = new CursosConcluidos(0);
        CursosConcluidos c2 = new CursosConcluidos(2);

        assertFalse(c0.temCursosSuficientes());
        assertFalse(c2.temCursosSuficientes());
    }

    @Test
    void equalsEHashCodeDevemConsiderarQuantidade() {
        CursosConcluidos c1 = new CursosConcluidos(3);
        CursosConcluidos c2 = new CursosConcluidos(3);
        CursosConcluidos c3 = new CursosConcluidos(4);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
        assertNotEquals(c1, c3);
    }
}
