package com.projeto.meuprojeto.domain.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaTest {

    @Test
    void deveLancarExcecaoQuandoMediaForaDoIntervalo() {
        assertThrows(IllegalArgumentException.class, () -> new Media(-0.1));
        assertThrows(IllegalArgumentException.class, () -> new Media(10.1));
    }

    @Test
    void deveIdentificarMediaAlta() {
        Media m = new Media(8.0);
        assertTrue(m.ehAlta());
        assertFalse(m.ehMedia());
        assertFalse(m.ehBaixa());
    }

    @Test
    void deveIdentificarMediaMedia() {
        Media m = new Media(7.5);
        assertFalse(m.ehAlta());
        assertTrue(m.ehMedia());
        assertFalse(m.ehBaixa());
    }

    @Test
    void deveIdentificarMediaBaixa() {
        Media m = new Media(6.9);
        assertFalse(m.ehAlta());
        assertFalse(m.ehMedia());
        assertTrue(m.ehBaixa());
    }

    @Test
    void equalsEHashCodeDevemConsiderarValor() {
        Media m1 = new Media(7.0);
        Media m2 = new Media(7.0);
        Media m3 = new Media(8.0);

        assertEquals(m1, m2);
        assertEquals(m1.hashCode(), m2.hashCode());
        assertNotEquals(m1, m3);
    }
}
