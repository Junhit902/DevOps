package com.projeto.meuprojeto.infrastructure.persistence;

import com.projeto.meuprojeto.domain.entities.Aluno;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AlunoRepositoryImplTest {

    private final AlunoRepositoryImpl repo = new AlunoRepositoryImpl();

    @Test
    void deveSalvarERecuperarAlunoPorId() {
        Aluno aluno = new Aluno("Aluno Repo", 3, 8.0);
        repo.salvar(aluno);

        Optional<Aluno> encontrado = repo.obterPorId(aluno.getId());
        assertTrue(encontrado.isPresent());
        assertEquals(aluno.getId(), encontrado.get().getId());
    }

    @Test
    void deveAtualizarAlunoExistente() {
        Aluno aluno = new Aluno("Aluno Repo", 3, 7.0);
        repo.salvar(aluno);

        Aluno atualizado = new Aluno(aluno.getNome(), 4, 7.5, aluno.getId());
        repo.atualizar(atualizado);

        Optional<Aluno> encontrado = repo.obterPorId(aluno.getId());
        assertTrue(encontrado.isPresent());
        assertEquals(4, encontrado.get().getCursosConcluidos().getQuantidade());
        assertEquals(7.5, encontrado.get().getMediaGlobal().getValor());
    }

    @Test
    void deveDeletarAluno() {
        Aluno aluno = new Aluno("Aluno Repo", 3, 7.0);
        repo.salvar(aluno);

        repo.deletar(aluno.getId());

        Optional<Aluno> encontrado = repo.obterPorId(aluno.getId());
        assertTrue(encontrado.isEmpty());
    }
}
