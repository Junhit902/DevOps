package com.projeto.meuprojeto.usecase;

import com.projeto.meuprojeto.domain.entities.Aluno;

public class SolicitarDescontoUseCase {

    public static double solicitarDesconto(Aluno aluno) {

        // Value Objects
        int cursos = aluno.getCursosConcluidos().getQuantidade();
        double media = aluno.getMedia().getValor(); // já já corrijo isso também

        // Regras de desconto
        if (!aluno.getCursosConcluidos().temCursosSuficientes()) {
            return 0.0;
        }

        if (media >= 8.0) {
            return 0.40;
        } else if (media >= 7.0) {
            return 0.20;
        }

        return 0.0;
    }

    public static String solicitarDescontoComMensagem(Aluno aluno) {

        int cursos = aluno.getCursosConcluidos().getQuantidade();
        double media = aluno.getMedia().getValor(); // idem aqui

        if (!aluno.getCursosConcluidos().temCursosSuficientes()) {
            return "Precisa completar pelo menos 3 cursos para ter direito ao desconto";
        }

        if (media >= 8.0) {
            return "Desconto aplicado: 40%";
        } else if (media >= 7.0) {
            return "Desconto aplicado: 20%";
        }

        return "Sem desconto";
    }
}
