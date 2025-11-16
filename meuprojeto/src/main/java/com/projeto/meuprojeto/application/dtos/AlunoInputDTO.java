package com.projeto.meuprojeto.application.dtos;

/**
 * DTO para entrada de dados do aluno
 */
public class AlunoInputDTO {

    private String nome;
    private int cursosConcluidos;
    private double mediaGlobal;

    public AlunoInputDTO() {
    }

    public AlunoInputDTO(String nome, int cursosConcluidos, double mediaGlobal) {
        this.nome = nome;
        this.cursosConcluidos = cursosConcluidos;
        this.mediaGlobal = mediaGlobal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCursosConcluidos() {
        return cursosConcluidos;
    }

    public void setCursosConcluidos(int cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }

    public double getMediaGlobal() {
        return mediaGlobal;
    }

    public void setMediaGlobal(double mediaGlobal) {
        this.mediaGlobal = mediaGlobal;
    }

    @Override
    public String toString() {
        return "AlunoInputDTO{" +
                "nome='" + nome + '\'' +
                ", cursosConcluidos=" + cursosConcluidos +
                ", mediaGlobal=" + mediaGlobal +
                '}';
    }
}
