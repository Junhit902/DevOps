package com.projeto.meuprojeto.infrastructure.config;

import com.projeto.meuprojeto.domain.repositories.AlunoRepository;
import com.projeto.meuprojeto.infrastructure.persistence.AlunoRepositoryImpl;

/**
 * Configuração de beans para injeção de dependência
 */
public class BeanConfiguration {

    public static AlunoRepository alunoRepository() {
        return new AlunoRepositoryImpl();
    }
}
