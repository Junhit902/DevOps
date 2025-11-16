package com.projeto.meuprojeto.domain.entity;

public class Aluno {

    private final String nome;
    private final int cursosConcluidos;
    private final double mediaGlobal;

    public Aluno(String nome, int cursosConcluidos, double mediaGlobal) {
        this.nome = nome;
        this.cursosConcluidos = cursosConcluidos;
        this.mediaGlobal = mediaGlobal;
    }

    public String getNome() { return nome; }
    public int getCursosConcluidos() { return cursosConcluidos; }
    public double getMediaGlobal()    { return mediaGlobal; }
}