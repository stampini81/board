# Board

Projeto de gestão de boards (DIO) com persistência MySQL e migrações via Liquibase.

---

## ✨ Sobre o Desafio DIO

Este projeto foi desenvolvido como parte do desafio prático da DIO para fortalecer meu portfólio e destacar meu perfil profissional. Aqui, apliquei conceitos de versionamento com Git, persistência com MySQL, migrações automatizadas com Liquibase e boas práticas em Java.

Repositório original para consulta: https://github.com/digitalinnovationone/board

---

## O que este projeto faz?

Sistema de gestão de boards (quadros de tarefas) com API RESTful para criar, listar, atualizar e remover boards e tarefas. Persistência em MySQL e migrações gerenciadas pelo Liquibase.

### Funcionalidades principais
- CRUD de boards e tarefas
- Busca e listagem paginada
- Migrações automáticas via Liquibase
- Build com Gradle

---

## Requisitos
- Java 11+ (o projeto foi testado com Java 11 no devcontainer)
  - Se preferir usar Java 17+, atualize seu JDK antes do build.
- MySQL 8+ (ou Docker)
- Gradle Wrapper (incluso)
- VS Code (recomendado)

> Observação: se você estiver usando um ambiente diferente do devcontainer, garanta que a versão do Java usada seja compatível com as dependências do projeto.

---

## Configuração do banco
Recomendado usar Docker:

- Subir serviços:
  - `docker compose up -d`

Credenciais padrão (ajuste via variáveis de ambiente se necessário):
- DB_URL (exemplo): `jdbc:mysql://localhost:3306/board?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC`
- DB_USER: `board`
- DB_PASSWORD: `board`

---

## Build e execução
1. Subir DB: `docker compose up -d`
2. Build: `./gradlew clean build`

Executar a aplicação:
- Via Gradle (se disponível): `./gradlew run`
- Ou executar o JAR gerado:
  - `java -jar build/libs/*.jar`

> Nota: a task `bootRun` não existe neste projeto — use `run` ou execute o JAR.

---

## Como verificar que está funcionando (passo a passo)
1. Subir banco:
   - `docker compose up -d`
2. Build:
   - `./gradlew clean build`
3. Executar:
   - `./gradlew run`  OU `java -jar build/libs/<nome>-<versao>.jar`
4. Checar migrações:
   - `cat liquibase.log` — procurar por mensagens de sucesso (ex.: "Successfully released change log lock" ou menções a update completado)
5. Ver tabelas no MySQL (via container):
   - `docker compose exec board-mysql mysql -u board -pboard -e "USE board; SHOW TABLES;"`
6. Descobrir endpoints:
   - `grep -R --line-number "@RequestMapping\|@GetMapping\|@PostMapping" src | sed -n '1,200p'`
   - Testar um endpoint (exemplo): `curl -i http://localhost:8080/boards` (substitua pelo mapping encontrado)
7. Logs e troubleshooting:
   - Ver logs da aplicação no terminal onde executou `./gradlew run` ou no output do container/serviço.
   - Se falhar ao conectar no DB, confirme DB_URL/DB_USER/DB_PASSWORD e se o container MySQL está saudável (`docker compose ps`).
8. Checar tarefas Gradle disponíveis:
   - `./gradlew tasks --all`

---

## Ajustes comuns
- Se preferir usar JDK 17:
  - Instale/ative JDK 17 no ambiente e refaça o build: `sudo apt install -y openjdk-17-jdk && ./gradlew clean build`
- Se não tiver cliente mysql local e quiser inspecionar DB:
  - `docker compose exec board-mysql mysql -u board -pboard -e "USE board; SHOW TABLES;"`

---

## Dicas para o repositório DIO
- Sincronizar fork com upstream:
  - `git remote add upstream https://github.com/digitalinnovationone/board.git` (se ainda não existir)
  - `git fetch upstream && git rebase upstream/master`
- Manter as credenciais via variáveis de ambiente, não commitá-las no código.

---

## Licença
Baseado no projeto da DIO. Consulte a licença do repositório original.
