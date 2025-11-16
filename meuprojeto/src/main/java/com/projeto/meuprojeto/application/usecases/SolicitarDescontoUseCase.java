package com.projeto.meuprojeto.application.usecases;

import com.projeto.meuprojeto.application.dtos.DescontoOutputDTO;
import com.projeto.meuprojeto.domain.entities.Aluno;
import com.projeto.meuprojeto.domain.services.DescontoService;
import com.projeto.meuprojeto.domain.valueobjects.Desconto;

/**
 * Use Case para solicitar desconto
 * Orquestra a lógica de aplicação para calcular desconto de um aluno
 */
public class SolicitarDescontoUseCase {

    private final DescontoService descontoService;

    public SolicitarDescontoUseCase() {
        this.descontoService = new DescontoService();
    }

    public SolicitarDescontoUseCase(DescontoService descontoService) {
        this.descontoService = descontoService;
    }

    /**
     * Executa o caso de uso para obter o desconto de um aluno
     */
    public double executar(Aluno aluno) {
        Desconto desconto = descontoService.calcularDesconto(aluno);
        return desconto.getPercentual();
    }

    /**
     * Executa o caso de uso retornando uma mensagem
     */
    public String executarComMensagem(Aluno aluno) {
        return descontoService.gerarMensagemDesconto(aluno);
    }

    /**
     * Executa o caso de uso retornando um DTO completo
     */
    public DescontoOutputDTO executarComDetalhes(Aluno aluno) {
        Desconto desconto = descontoService.calcularDesconto(aluno);
        String mensagem = descontoService.gerarMensagemDesconto(aluno);
        
        return new DescontoOutputDTO(
                desconto.getPercentual(),
                desconto.getDescricao(),
                mensagem
        );
    }

    // Métodos estáticos para compatibilidade com testes existentes
    private static final SolicitarDescontoUseCase instancia = new SolicitarDescontoUseCase();

    public static double solicitarDesconto(Aluno aluno) {
        return instancia.executar(aluno);
    }

    public static String solicitarDescontoComMensagem(Aluno aluno) {
        return instancia.executarComMensagem(aluno);
    }
}
