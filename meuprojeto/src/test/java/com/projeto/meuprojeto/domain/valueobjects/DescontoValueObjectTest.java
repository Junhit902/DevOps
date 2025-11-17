package com.projeto.meuprojeto.domain.valueobjects;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class DescontoValueObjectTest {

    @Test
    void constantesDevemTerPercentuaisEsperados() {
        assertEquals(0.40, Desconto.DESCONTO_40_PORCENTO.getPercentual());
        assertEquals(0.20, Desconto.DESCONTO_20_PORCENTO.getPercentual());
        assertEquals(0.0, Desconto.SEM_DESCONTO.getPercentual());
    }

    @Test
    void temDescontoDeveRetornarCorretamente() {
        assertTrue(Desconto.DESCONTO_40_PORCENTO.temDesconto());
        assertTrue(Desconto.DESCONTO_20_PORCENTO.temDesconto());
        assertFalse(Desconto.SEM_DESCONTO.temDesconto());
    }

    @Test
    void descricaoDeveSerCorreta() {
        assertEquals("40%", Desconto.DESCONTO_40_PORCENTO.getDescricao());
        assertEquals("20%", Desconto.DESCONTO_20_PORCENTO.getDescricao());
        assertEquals("0%", Desconto.SEM_DESCONTO.getDescricao());
    }

    @Test
    void equalsEHashCodeDevemFuncionar() {
        Desconto a = Desconto.DESCONTO_40_PORCENTO;
        Desconto b = Desconto.DESCONTO_40_PORCENTO;

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, Desconto.DESCONTO_20_PORCENTO);
        assertFalse(a.equals(null));
    }

    @Test
    void construtorDeveValidarPercentual() throws NoSuchMethodException {
        Constructor<Desconto> ctor = Desconto.class.getDeclaredConstructor(double.class, String.class);
        ctor.setAccessible(true);

        InvocationTargetException ex1 = assertThrows(InvocationTargetException.class, () -> ctor.newInstance(-0.1, "-10%"));
        assertTrue(ex1.getCause() instanceof IllegalArgumentException);
        assertEquals("Percentual deve estar entre 0.0 e 1.0", ex1.getCause().getMessage());

        InvocationTargetException ex2 = assertThrows(InvocationTargetException.class, () -> ctor.newInstance(1.1, "110%"));
        assertTrue(ex2.getCause() instanceof IllegalArgumentException);
        assertEquals("Percentual deve estar entre 0.0 e 1.0", ex2.getCause().getMessage());
    }
}