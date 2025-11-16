package com.projeto.meuprojeto.domain.services;

import com.projeto.meuprojeto.domain.entities.Aluno;
import com.projeto.meuprojeto.domain.valueobjects.Desconto;

/**
 * Domain Service para calcular descontos
 * Contém a lógica de negócio relacionada ao cálculo de descontos
 */
public class DescontoService {

    /**
     * Calcula o desconto baseado na quantidade de cursos e na média do aluno
     */
    public Desconto calcularDesconto(Aluno aluno) {
        if (!aluno.getCursosConcluidos().temCursosSuficientes()) {
            return Desconto.SEM_DESCONTO;
        }

        double media = aluno.getMediaGlobal().getValor();
        if (media >= 8.0) {
            return Desconto.DESCONTO_40_PORCENTO;
        }
        if (media >= 7.0) {
            return Desconto.DESCONTO_20_PORCENTO;
        }

        return Desconto.SEM_DESCONTO;
    }

    /**
     * Gera uma mensagem apropriada baseada na situação do aluno
     */
    public String gerarMensagemDesconto(Aluno aluno) {
        if (!aluno.getCursosConcluidos().temCursosSuficientes()) {
            return "Precisa completar pelo menos 3 cursos para ter direito ao desconto";
        }

        Desconto desconto = calcularDesconto(aluno);
        if (!desconto.temDesconto()) {
            return "Sem desconto disponível";
        }

        return "Desconto aplicado: " + desconto.getDescricao();
    }
}
