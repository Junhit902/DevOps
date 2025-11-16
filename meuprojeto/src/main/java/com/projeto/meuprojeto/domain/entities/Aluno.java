package com.projeto.meuprojeto.domain.entities;

import com.projeto.meuprojeto.domain.valueobjects.CursosConcluidos;
import com.projeto.meuprojeto.domain.valueobjects.Media;

/**
 * Entidade de domínio que representa um Aluno
 */
public class Aluno {

    private final String id;
    private final String nome;
    private final CursosConcluidos cursosConcluidos;
    private final Media mediaGlobal;

    public Aluno(String nome, int cursosConcluidos, double mediaGlobal) {
        this(nome, cursosConcluidos, mediaGlobal, null);
    }

    public Aluno(String nome, int cursosConcluidos, double mediaGlobal, String id) {
        this.nome = nome;
        this.cursosConcluidos = new CursosConcluidos(cursosConcluidos);
        this.mediaGlobal = new Media(mediaGlobal);
        this.id = id != null ? id : gerarId();
    }

    private String gerarId() {
        return nome.toLowerCase().replace(" ", "_") + "_" + System.nanoTime();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CursosConcluidos getCursosConcluidos() {
        return cursosConcluidos;
    }

    public Media getMediaGlobal() {
        return mediaGlobal;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cursosConcluidos=" + cursosConcluidos +
                ", mediaGlobal=" + mediaGlobal +
                '}';
    }
}
