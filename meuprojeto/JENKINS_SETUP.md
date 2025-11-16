# Guia de Resolução do Erro do Jenkins - Jenkinsfile.staging

## Problema
```
ERROR: Unable to find Jenkinsfile.staging from git https://github.com/Junhit902/DevOps.git
```

## Solução

O arquivo `Jenkinsfile.staging` foi criado com sucesso na raiz do projeto. Agora você precisa fazer o seguinte:

### 1. Adicionar o arquivo ao Git
```bash
cd C:\Users\thiag\git\repository3\meuprojeto
git add Jenkinsfile.staging
```

### 2. Fazer commit do arquivo
```bash
git commit -m "Add Jenkinsfile.staging for CI/CD pipeline"
```

### 3. Fazer push para o repositório remoto
```bash
git push origin main
# ou git push origin develop
# ou git push origin master
# (depende de qual branch você está usando)
```

### 4. No Jenkins
- Volte ao Jenkins
- Acione a construção do Pipeline_Staging novamente
- O Jenkins agora encontrará o arquivo `Jenkinsfile.staging`

## O que o Jenkinsfile.staging faz

O arquivo criado define um pipeline que:

1. **Checkout** - Faz clone do repositório
2. **Build** - Compila o projeto com Maven
3. **Unit Tests** - Executa os testes unitários
4. **Code Analysis** - Executa análise com PMD
5. **Code Coverage** - Gera relatório de cobertura com JaCoCo
6. **Package** - Empacota a aplicação em JAR
7. **Deploy to Staging** - Deploy para ambiente de staging (quando branch é 'develop')

## Personalizações Recomendadas

Se necessário, você pode editar o arquivo `Jenkinsfile.staging` para:

- Ajustar as versões do Java/Maven conforme seu servidor Jenkins
- Modificar os comandos de deploy para staging
- Adicionar notificações (email, Slack)
- Ajustar timeouts e configurações de retenção de builds

## Verificação

Após fazer o push, verifique no GitHub se o arquivo está lá:
https://github.com/Junhit902/DevOps

Pronto! O erro deverá estar resolvido.
