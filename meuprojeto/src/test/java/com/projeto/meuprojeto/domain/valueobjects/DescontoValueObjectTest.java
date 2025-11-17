package com.projeto.meuprojeto.domain.valueobjects;

import org.junit.jupiter.api.Test;

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
    void construtorDeveValidarPercentual() {
        assertThrows(IllegalArgumentException.class, () -> {
            // acesso via reflexão para testar validação de percentual inválido
            java.lang.reflect.Constructor<Desconto> ctor = Desconto.class.getDeclaredConstructor(double.class, String.class);
            ctor.setAccessible(true);
            ctor.newInstance(-0.1, "-10%");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            java.lang.reflect.Constructor<Desconto> ctor = Desconto.class.getDeclaredConstructor(double.class, String.class);
            ctor.setAccessible(true);
            ctor.newInstance(1.1, "110%");
        });
    }
}
