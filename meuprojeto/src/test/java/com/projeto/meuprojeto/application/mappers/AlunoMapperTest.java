package com.projeto.meuprojeto.application.mappers;

import com.projeto.meuprojeto.application.dtos.AlunoInputDTO;
import com.projeto.meuprojeto.domain.entities.Aluno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoMapperTest {

    @Test
    void toDomainDeveMapearCamposCorretamente() {
        AlunoInputDTO dto = new AlunoInputDTO("Joao", 3, 8.5);

        Aluno aluno = AlunoMapper.toDomain(dto);

        assertNotNull(aluno);
        assertEquals("Joao", aluno.getNome());
        assertEquals(3, aluno.getCursosConcluidos().getQuantidade());
        assertEquals(8.5, aluno.getMediaGlobal().getValor());
    }
}
