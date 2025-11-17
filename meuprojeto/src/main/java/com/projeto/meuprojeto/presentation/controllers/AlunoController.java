package com.projeto.meuprojeto.presentation.controllers;

import com.projeto.meuprojeto.application.dtos.AlunoInputDTO;
import com.projeto.meuprojeto.application.dtos.DescontoOutputDTO;
import com.projeto.meuprojeto.application.mappers.AlunoMapper;
import com.projeto.meuprojeto.application.usecases.SolicitarDescontoUseCase;
import com.projeto.meuprojeto.domain.entities.Aluno;
import com.projeto.meuprojeto.domain.repositories.AlunoRepository;
import com.projeto.meuprojeto.infrastructure.config.BeanConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gerenciar operações relacionadas a alunos
 */
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final SolicitarDescontoUseCase solicitarDescontoUseCase;

    public AlunoController() {
        this.alunoRepository = BeanConfiguration.alunoRepository();
        this.solicitarDescontoUseCase = new SolicitarDescontoUseCase();
    }

    /**
     * Cria um novo aluno
     */
    @PostMapping
    public Aluno criarAluno(@RequestBody AlunoInputDTO dto) {
        Aluno aluno = AlunoMapper.toDomain(dto);
        alunoRepository.salvar(aluno);
        return aluno;
    }

    /**
     * Obtém o desconto de um aluno
     */
    @GetMapping("/desconto")
    public double obterDesconto(@RequestParam String nomeAluno,
                                @RequestParam int cursosConcluidos,
                                @RequestParam double mediaGlobal) {
        Aluno aluno = new Aluno(nomeAluno, cursosConcluidos, mediaGlobal);
        return solicitarDescontoUseCase.executar(aluno);
    }

    /**
     * Obtém a mensagem de desconto de um aluno
     */
    @GetMapping("/mensagem")
    public String obterMensagemDesconto(@RequestParam String nomeAluno,
                                        @RequestParam int cursosConcluidos,
                                        @RequestParam double mediaGlobal) {
        Aluno aluno = new Aluno(nomeAluno, cursosConcluidos, mediaGlobal);
        return solicitarDescontoUseCase.executarComMensagem(aluno);
    }

    /**
     * Obtém os detalhes do desconto de um aluno
     */
    @GetMapping("/detalhes")
    public DescontoOutputDTO obterDetalhesDesconto(@RequestParam String nomeAluno,
                                                   @RequestParam int cursosConcluidos,
                                                   @RequestParam double mediaGlobal) {
        Aluno aluno = new Aluno(nomeAluno, cursosConcluidos, mediaGlobal);
        return solicitarDescontoUseCase.executarComDetalhes(aluno);
    }
}