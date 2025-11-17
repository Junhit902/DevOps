# Correção do Pipeline Jenkins - Staging

## Problema Identificado
O pipeline estava falhando no estágio "Start container" porque os arquivos necessários para executar o Docker Compose não existiam:
- `docker-compose.staging.yml`
- `Dockerfile`

## Arquivos Criados

### 1. **docker-compose.staging.yml**
- Define o serviço Docker para a aplicação em ambiente de staging
- Mapeia a porta 8686 para 8080 (porta padrão Spring Boot)
- Configura perfil Spring como "staging"
- Inclui health check para monitorar a saúde do container

### 2. **Dockerfile**
- Build em múltiplos estágios (multi-stage build)
- Primeira stage: Compila a aplicação usando Maven
- Segunda stage: Runtime baseado em eclipse-temurin:17-jre (leve e seguro)
- Executa o JAR gerado pelo Maven

### 3. **application-staging.properties**
- Arquivo de configuração específico para o perfil de staging
- Define porta 8080
- Habilita o endpoint de health do Actuator
- Necessário para os health checks do Docker

## Dependências Adicionadas no pom.xml

### spring-boot-starter-web
- Necessário para ter um servidor web que responda aos health checks
- Fornece endpoints HTTP

### spring-boot-starter-actuator
- Fornece o endpoint `/actuator/health` usado pelo Docker Compose
- Permite monitoramento e métricas da aplicação

## Fluxo do Pipeline após as correções

1. **Checkout**: Clone do repositório (DevOps)
2. **Build**: Compila o projeto com Maven
3. **Unit Tests**: Executa testes (10 testes passando ✓)
4. **Code Analysis**: Análise com PMD
5. **Code Coverage**: Relatório JaCoCo
6. **Package**: Gera o JAR da aplicação
7. **Start container**: 
   - Docker Compose faz pull da imagem
   - Container inicia na porta 8686
   - Health check aguarda a aplicação ficar pronta
8. **Run tests against container**: Testa conectividade

## Próximas Etapas Recomendadas

1. Fazer commit dos arquivos criados no repositório
2. Revisar a Dockerfile se há otimizações desejadas
3. Executar o pipeline novamente no Jenkins
4. Monitorar os logs do container

## Teste Local (Opcional)

```bash
cd meuprojeto
mvn clean package -DskipTests
docker build -t meuprojeto:staging .
docker-compose -f docker-compose.staging.yml up -d
```
