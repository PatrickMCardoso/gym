# Gym System

Sistema completo para gestão de academias, alunos, treinos, mensalidades e relatórios financeiros. Desenvolvido em Java, com persistência em MySQL e geração de relatórios em PDF.

---

## Repositório Complementar

> Este projeto pode ser utilizado em conjunto com o repositório [mysql-connector-j](./mysql-connector-j-8.4.0/) para integração com o banco de dados MySQL.

---

## Índice

- [Visão Geral](#visão-geral)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura e Arquitetura](#estrutura-e-arquitetura)
- [Instalação e Execução](#instalação-e-execução)
- [Documentação da API](#documentação-da-api)
- [Boas Práticas](#boas-práticas)
- [Licença](#licença)

---

## Visão Geral

O Gym System é um sistema desktop para academias, permitindo o cadastro e gerenciamento de alunos, treinos, exercícios, mensalidades, pagamentos recorrentes, avaliações físicas e geração de relatórios em PDF. O sistema segue o padrão MVC, garantindo organização e escalabilidade.

---

## Tecnologias Utilizadas

- **Java SE 8+**
- **JDBC** (Java Database Connectivity)
- **MySQL**
- **iTextPDF** (Geração de relatórios PDF)
- **Ant** (Automação de build)
- **VS Code** (Recomendado para edição)
- **NetBeans/Eclipse** (Opcional)

---

## Estrutura e Arquitetura

O projeto segue o padrão MVC e está organizado da seguinte forma:

```text
system/
├── build.xml                # Script de build Ant
├── manifest.mf              # Manifesto do projeto
├── lib/                     # Dependências e bibliotecas
│   └── itextpdf-5.5.6.jar   # Biblioteca para PDF
├── nbproject/               # Configurações NetBeans
├── src/
│   └── gym/
│       ├── controller/      # Lógica de controle e conexão
│       ├── model/           # Entidades e DAOs
│       └── view/            # Menus e relatórios
├── relatorio_movimentacao.pdf
├── relatorio_treino_aplicacao_usuario_3.pdf
└── mysql-connector-j-8.4.0/ # Driver JDBC MySQL
```

- **controller/**: Fluxo do sistema, conexão com banco, inicialização.
- **model/**: Entidades (Academia, Pessoa, Treino, etc.) e DAOs (acesso ao banco).
- **view/**: Interface textual, menus e geração de relatórios.

---

## Instalação e Execução

### Pré-requisitos
- Java 8 ou superior
- MySQL Server
- VS Code ou outro editor Java

### Variáveis de Ambiente
- Configure o usuário e senha do MySQL em `SQLConnection.java` se necessário.

### Instalação das Dependências

Coloque os arquivos JAR na pasta `lib/` ou na raiz do projeto:
- `itextpdf-5.5.6.jar`
- `mysql-connector-j-8.4.0.jar`

### Criação do Banco de Dados

Crie o banco de dados `gym` no MySQL:
```sql
CREATE DATABASE gym;
```

### Compilação

No terminal, execute:
```bash
javac -cp .:lib/itextpdf-5.5.6.jar:lib/mysql-connector-j-8.4.0.jar src/gym/model/*.java src/gym/controller/*.java src/gym/view/*.java
```

### Execução

```bash
java -cp .:lib/itextpdf-5.5.6.jar:lib/mysql-connector-j-8.4.0.jar src/gym/controller/Gym
```

### Seed/Migrations

As tabelas são criadas automaticamente na primeira execução via método `SQLConnection.criarTabelas()`.
Dados de exemplo são inseridos pelos métodos `adicionar*Exemplo()` dos DAOs.

---

## Documentação da API

Este sistema não expõe uma API HTTP, mas toda a lógica está documentada nos arquivos de código-fonte. Para entender os métodos disponíveis, consulte os arquivos em `src/gym/model/`, `src/gym/controller/` e `src/gym/view/`.

---

## Boas Práticas

- Padrão MVC
- DAO para acesso a dados
- Uso de PreparedStatement para segurança
- Tratamento de exceções
- Separação clara de responsabilidades
- Geração de relatórios em PDF
- Uso de Java Collections e LocalDate
- Código comentado e organizado

---

## Licença

Este projeto está licenciado sob a licença MIT.

