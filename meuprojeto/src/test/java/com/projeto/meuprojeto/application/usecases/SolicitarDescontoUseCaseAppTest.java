package com.projeto.meuprojeto.application.usecases;

import com.projeto.meuprojeto.adapter.DadosAlunos;
import com.projeto.meuprojeto.application.dtos.DescontoOutputDTO;
import com.projeto.meuprojeto.domain.entities.Aluno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolicitarDescontoUseCaseAppTest {

    private final SolicitarDescontoUseCase useCase = new SolicitarDescontoUseCase();

    @Test
    void deveCalcularDesconto40PorCentoQuandoMediaAltaETresCursos() {
        Aluno aluno = DadosAlunos.CESAR; // já configurado com média alta e 3 cursos

        DescontoOutputDTO dto = useCase.executarComDetalhes(aluno);

        assertNotNull(dto);
        assertEquals(0.40, dto.getPercentual(), 1e-6);
        assertTrue(dto.getDescricao().contains("40"));
    }

    @Test
    void deveCalcularDesconto20PorCentoQuandoMediaMediaETresCursos() {
        Aluno aluno = DadosAlunos.GUSTAVO; // média intermediária e 3 cursos

        DescontoOutputDTO dto = useCase.executarComDetalhes(aluno);

        assertNotNull(dto);
        assertEquals(0.20, dto.getPercentual(), 1e-6);
        assertTrue(dto.getDescricao().contains("20"));
    }

    @Test
    void deveNaoConcederDescontoQuandoMediaBaixa() {
        Aluno aluno = DadosAlunos.THIAGO; // média baixa

        DescontoOutputDTO dto = useCase.executarComDetalhes(aluno);

        assertNotNull(dto);
        assertEquals(0.0, dto.getPercentual(), 1e-6);
    }

    @Test
    void deveRetornarMensagemCursosInsuficientes() {
        Aluno aluno = DadosAlunos.VINICIUS; // menos de 3 cursos

        String msg = useCase.executarComMensagem(aluno);

        assertEquals("Precisa completar pelo menos 3 cursos para ter direito ao desconto", msg);
    }
}
