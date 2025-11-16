package com.projeto.meuprojeto.domain.repositories;

import com.projeto.meuprojeto.domain.entities.Aluno;
import java.util.Optional;

/**
 * Interface do repositório para a entidade Aluno
 */
public interface AlunoRepository {

    void salvar(Aluno aluno);

    Optional<Aluno> obterPorId(String id);

    void atualizar(Aluno aluno);

    void deletar(String id);
}
