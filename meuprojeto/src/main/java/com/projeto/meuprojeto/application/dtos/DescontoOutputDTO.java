package com.projeto.meuprojeto.application.dtos;

/**
 * DTO para saída de dados do desconto
 */
public class DescontoOutputDTO {

    private double percentual;
    private String descricao;
    private String mensagem;

    public DescontoOutputDTO(double percentual, String descricao, String mensagem) {
        this.percentual = percentual;
        this.descricao = descricao;
        this.mensagem = mensagem;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "DescontoOutputDTO{" +
                "percentual=" + percentual +
                ", descricao='" + descricao + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
