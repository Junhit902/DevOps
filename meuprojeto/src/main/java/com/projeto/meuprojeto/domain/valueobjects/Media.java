package com.projeto.meuprojeto.usecase;

import com.projeto.meuprojeto.domain.entities.Aluno;
import com.projeto.meuprojeto.domain.valueobjects.CursosConcluidos;
import com.projeto.meuprojeto.domain.valueobjects.Media;

public class SolicitarDescontoUseCase {

    public static double solicitarDesconto(Aluno aluno) {

        CursosConcluidos cursos = aluno.getCursosConcluidos();
        Media media = aluno.getMedia();

        if (!cursos.temCursosSuficientes()) {
            return 0.0;
        }

        if (media.ehAlta()) {
            return 0.40;
        }

        if (media.ehMedia()) {
            return 0.20;
        }

        return 0.0;
    }

    public static String solicitarDescontoComMensagem(Aluno aluno) {

        CursosConcluidos cursos = aluno.getCursosConcluidos();
        Media media = aluno.getMedia();

        if (!cursos.temCursosSuficientes()) {
            return "Precisa completar pelo menos 3 cursos para ter direito ao desconto";
        }

        if (media.ehAlta()) {
            return "Desconto aplicado: 40%";
        }

        if (media.ehMedia()) {
            return "Desconto aplicado: 20%";
        }

        return "Sem desconto";
    }
}
