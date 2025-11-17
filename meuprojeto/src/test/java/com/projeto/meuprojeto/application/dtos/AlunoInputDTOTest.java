package com.projeto.meuprojeto.application.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoInputDTOTest {

    @Test
    void gettersESettersDevemFuncionar() {
        AlunoInputDTO dto = new AlunoInputDTO();
        dto.setNome("Teste");
        dto.setCursosConcluidos(5);
        dto.setMediaGlobal(9.5);

        assertEquals("Teste", dto.getNome());
        assertEquals(5, dto.getCursosConcluidos());
        assertEquals(9.5, dto.getMediaGlobal());
    }

    @Test
    void construtorComArgumentosDeveInicializarCampos() {
        AlunoInputDTO dto = new AlunoInputDTO("Joao", 3, 8.0);

        assertEquals("Joao", dto.getNome());
        assertEquals(3, dto.getCursosConcluidos());
        assertEquals(8.0, dto.getMediaGlobal());
        assertTrue(dto.toString().contains("Joao"));
    }
}
