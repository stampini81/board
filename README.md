# Board

[![CI](https://github.com/stampini81/board/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/stampini81/board/actions/workflows/ci.yml)

Projeto de gestão de boards (DIO) com persistência MySQL e migrações via Liquibase.

## Requisitos
- Java 17+
- MySQL 8+ (ou Docker Desktop)
- Gradle Wrapper (já incluso)
- VS Code (recomendado) com Extension Pack for Java

## Configuração do Banco
Você pode usar Docker (recomendado):
- `docker-compose up -d`

Ou localmente (usuário/senha padrão esperados: board/board, DB: board). Ajuste as variáveis abaixo se necessário.

## Variáveis de Ambiente
A aplicação lê as credenciais do banco de ambiente com defaults:
- `DB_URL` (default: `jdbc:mysql://localhost:3306/board?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC`)
- `DB_USER` (default: `board`)
- `DB_PASSWORD` (default: `board`)

Exemplo no PowerShell (Windows):
- `$env:DB_URL="jdbc:mysql://localhost:3306/board?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"`
- `$env:DB_USER="board"`
- `$env:DB_PASSWORD="board"`

## Build e Execução
- Windows PowerShell:
  - `./gradlew.bat clean build`
  - `./gradlew.bat run`
- VS Code: use as tasks "Gradle: build" e "Gradle: run" (arquivo `.vscode/tasks.json`).

As migrações Liquibase são executadas no início da aplicação e registradas em `liquibase.log`.

## Dicas
- Sincronizar fork com repositório original:
  - `git remote add upstream https://github.com/digitalinnovationone/board.git`
  - `git fetch upstream` e `git rebase upstream/master`
- Editar as credenciais via variáveis de ambiente ao invés de alterar código.

## Licença
Baseada no projeto da DIO. Consulte a licença do repositório original.
