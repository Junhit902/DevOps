package com.projeto.meuprojeto.application.usecases;

import com.projeto.meuprojeto.application.dtos.AlunoInputDTO;
import com.projeto.meuprojeto.application.mappers.AlunoMapper;
import com.projeto.meuprojeto.domain.entities.Aluno;
import com.projeto.meuprojeto.domain.repositories.AlunoRepository;

import java.util.Optional;

/**
 * Use Case para obter informações de um aluno
 */
public class ObterInformacoesAlunoUseCase {

    private final AlunoRepository alunoRepository;

    public ObterInformacoesAlunoUseCase(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    /**
     * Obtém as informações de um aluno pelo ID
     */
    public Optional<AlunoInputDTO> executar(String id) {
        return alunoRepository.obterPorId(id)
                .map(AlunoMapper::toDTO);
    }

    /**
     * Obtém a entidade de domínio do aluno pelo ID
     */
    public Optional<Aluno> executarDomain(String id) {
        return alunoRepository.obterPorId(id);
    }
}
