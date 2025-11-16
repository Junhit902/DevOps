package com.projeto.meuprojeto.usecase;

import com.projeto.meuprojeto.domain.entities.Aluno;

public final class SolicitarDescontoUseCase {

    private SolicitarDescontoUseCase() {}

    /**
     * Retorna o percentual de desconto como valor entre 0.0 e 1.0
     */
    public static double solicitarDesconto(Aluno aluno) {
        if (aluno.getCursosConcluidos() < 3) return 0.0;

        double media = aluno.getMediaGlobal();
        if (media >= 8.0) return 0.40;
        if (media >= 7.0) return 0.20;
        return 0.0;
    }

    /**
     * Retorna uma mensagem apropriada dependendo do aluno
     */
    public static String solicitarDescontoComMensagem(Aluno aluno) {
        if (aluno.getCursosConcluidos() < 3) {
            return "Precisa completar pelo menos 3 cursos para ter direito ao desconto";
        }

        double desc = solicitarDesconto(aluno);
        if (desc <= 0.0) return "Sem desconto disponível";
        if (desc == 0.40) return "Desconto aplicado: 40%";
        if (desc == 0.20) return "Desconto aplicado: 20%";
        return "Desconto aplicado";
    }
}
