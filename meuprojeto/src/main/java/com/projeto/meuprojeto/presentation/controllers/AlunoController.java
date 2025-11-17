package com.projeto.meuprojeto.presentation.controllers;

import com.projeto.meuprojeto.application.dtos.AlunoInputDTO;
import com.projeto.meuprojeto.application.dtos.DescontoOutputDTO;
import com.projeto.meuprojeto.application.mappers.AlunoMapper;
import com.projeto.meuprojeto.application.usecases.SolicitarDescontoUseCase;
import com.projeto.meuprojeto.domain.entities.Aluno;
import com.projeto.meuprojeto.domain.repositories.AlunoRepository;
import com.projeto.meuprojeto.infrastructure.config.BeanConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final SolicitarDescontoUseCase solicitarDescontoUseCase;

    public AlunoController() {
        this.alunoRepository = BeanConfiguration.alunoRepository();
        this.solicitarDescontoUseCase = new SolicitarDescontoUseCase();
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody AlunoInputDTO dto) {
        Aluno aluno = AlunoMapper.toDomain(dto);
        alunoRepository.salvar(aluno);
        return aluno;
    }

    @GetMapping("/desconto")
    public double obterDesconto(
            @RequestParam String nome,
            @RequestParam int cursos,
            @RequestParam double media
    ) {
        Aluno aluno = new Aluno(nome, cursos, media);
        return solicitarDescontoUseCase.executar(aluno);
    }

    @GetMapping("/mensagem")
    public String obterMensagemDesconto(
            @RequestParam String nome,
            @RequestParam int cursos,
            @RequestParam double media
    ) {
        Aluno aluno = new Aluno(nome, cursos, media);
        return solicitarDescontoUseCase.executarComMensagem(aluno);
    }

    @GetMapping("/detalhes")
    public DescontoOutputDTO obterDetalhesDesconto(
            @RequestParam String nome,
            @RequestParam int cursos,
            @RequestParam double media
    ) {
        Aluno aluno = new Aluno(nome, cursos, media);
        return solicitarDescontoUseCase.executarComDetalhes(aluno);
    }
}
