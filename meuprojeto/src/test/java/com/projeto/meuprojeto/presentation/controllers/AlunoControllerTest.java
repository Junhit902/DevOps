package com.projeto.meuprojeto.presentation.controllers;

import com.projeto.meuprojeto.application.dtos.AlunoInputDTO;
import com.projeto.meuprojeto.application.dtos.DescontoOutputDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoControllerTest {

    private final AlunoController controller = new AlunoController();

    @Test
    void deveCriarAlunoComDadosBasicos() {
        AlunoInputDTO dto = new AlunoInputDTO("Aluno Teste", 3, 8.0);

        var aluno = controller.criarAluno(dto);

        assertNotNull(aluno.getId());
        assertEquals("Aluno Teste", aluno.getNome());
        assertEquals(3, aluno.getCursosConcluidos().getQuantidade());
        assertEquals(8.0, aluno.getMediaGlobal().getValor());
    }

    @Test
    void deveRetornarDesconto40QuandoElegivel() {
        double desconto = controller.obterDesconto("Aluno 40", 3, 8.1);
        assertEquals(0.40, desconto, 1e-6);
    }

    @Test
    void deveRetornarMensagemSemCursosSuficientes() {
        String msg = controller.obterMensagemDesconto("Aluno", 2, 9.0);
        assertEquals("Precisa completar pelo menos 3 cursos para ter direito ao desconto", msg);
    }

    @Test
    void deveRetornarDetalhesDesconto20() {
        DescontoOutputDTO detalhes = controller.obterDetalhesDesconto("Aluno 20", 3, 7.5);

        assertNotNull(detalhes);
        assertEquals(0.20, detalhes.getPercentual(), 1e-6);
        assertTrue(detalhes.getDescricao().contains("20"));
    }
}
