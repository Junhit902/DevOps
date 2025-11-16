package com.projeto.meuprojeto.infrastructure.persistence;

import com.projeto.meuprojeto.domain.entities.Aluno;
import com.projeto.meuprojeto.domain.repositories.AlunoRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Implementação em memória do repositório de Aluno
 * Em um cenário real, isso seria um repositório com banco de dados
 */
public class AlunoRepositoryImpl implements AlunoRepository {

    private final Map<String, Aluno> alunos = new HashMap<>();

    @Override
    public void salvar(Aluno aluno) {
        alunos.put(aluno.getId(), aluno);
    }

    @Override
    public Optional<Aluno> obterPorId(String id) {
        return Optional.ofNullable(alunos.get(id));
    }

    @Override
    public void atualizar(Aluno aluno) {
        alunos.put(aluno.getId(), aluno);
    }

    @Override
    public void deletar(String id) {
        alunos.remove(id);
    }
}
