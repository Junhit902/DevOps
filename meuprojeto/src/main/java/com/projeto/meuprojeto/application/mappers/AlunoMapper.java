package com.projeto.meuprojeto.application.mappers;

import com.projeto.meuprojeto.application.dtos.AlunoInputDTO;
import com.projeto.meuprojeto.domain.entities.Aluno;

/**
 * Mapper para converter entre DTOs e entidades de domínio
 */
public class AlunoMapper {

    private AlunoMapper() {
    }

    public static Aluno toDomain(AlunoInputDTO dto) {
        return new Aluno(
                dto.getNome(),
                dto.getCursosConcluidos(),
                dto.getMediaGlobal()
        );
    }

    public static AlunoInputDTO toDTO(Aluno aluno) {
        return new AlunoInputDTO(
                aluno.getNome(),
                aluno.getCursosConcluidos().getQuantidade(),
                aluno.getMediaGlobal().getValor()
        );
    }
}
