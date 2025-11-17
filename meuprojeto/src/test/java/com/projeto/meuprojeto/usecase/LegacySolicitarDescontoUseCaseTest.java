package com.projeto.meuprojeto.usecase;

import com.projeto.meuprojeto.domain.entities.Aluno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegacySolicitarDescontoUseCaseTest {

    @Test
    void deveRetornarQuarentaPorCentoQuandoMediaAltaETresCursos() {
        Aluno aluno = new Aluno("Aluno", 3, 8.0);
        double desconto = LegacySolicitarDescontoUseCase.solicitarDesconto(aluno);
        assertEquals(0.40, desconto, 1e-6);
    }

    @Test
    void deveRetornarVintePorCentoQuandoMediaMediaETresCursos() {
        Aluno aluno = new Aluno("Aluno", 3, 7.5);
        double desconto = LegacySolicitarDescontoUseCase.solicitarDesconto(aluno);
        assertEquals(0.20, desconto, 1e-6);
    }

    @Test
    void deveRetornarZeroQuandoMediaBaixaOuCursosInsuficientes() {
        Aluno alunoMediaBaixa = new Aluno("Aluno", 3, 6.5);
        Aluno alunoPoucosCursos = new Aluno("Aluno", 2, 9.0);

        assertEquals(0.0, LegacySolicitarDescontoUseCase.solicitarDesconto(alunoMediaBaixa), 1e-6);
        assertEquals(0.0, LegacySolicitarDescontoUseCase.solicitarDesconto(alunoPoucosCursos), 1e-6);
    }

    @Test
    void deveRetornarMensagemCursosInsuficientes() {
        Aluno aluno = new Aluno("Aluno", 2, 9.0);
        String msg = LegacySolicitarDescontoUseCase.solicitarDescontoComMensagem(aluno);
        assertEquals("Precisa completar pelo menos 3 cursos para ter direito ao desconto", msg);
    }

    @Test
    void deveRetornarMensagemSemDescontoDisponivel() {
        Aluno aluno = new Aluno("Aluno", 3, 6.5);
        String msg = LegacySolicitarDescontoUseCase.solicitarDescontoComMensagem(aluno);
        assertEquals("Sem desconto disponível", msg);
    }

    @Test
    void deveRetornarMensagemDeDescontoAplicado40() {
        Aluno aluno = new Aluno("Aluno", 3, 8.5);
        String msg = LegacySolicitarDescontoUseCase.solicitarDescontoComMensagem(aluno);
        assertTrue(msg.contains("40%"));
    }

    @Test
    void deveRetornarMensagemDeDescontoAplicado20() {
        Aluno aluno = new Aluno("Aluno", 3, 7.3);
        String msg = LegacySolicitarDescontoUseCase.solicitarDescontoComMensagem(aluno);
        assertTrue(msg.contains("20%"));
    }
}
