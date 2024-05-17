package gym.view;

import java.util.Scanner;
import gym.model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Menus {

    static Scanner scanner = new Scanner(System.in);

    // MENU PRINCIPAL
    public static int mostrarMenuPrincipal() {
        limparTela();
        System.out.println("*********************************");
        System.out.println("*   SISTEMAS DE GERENCIAMENTO   *");
        System.out.println("*********************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Academias\n");
        System.out.println("2 - Pessoas\n");
        System.out.println("3 - Exercicios\n");
        System.out.println("4 - Aplicacao de Exercicios\n");
        System.out.println("5 - Divisao de Treino\n");
        System.out.println("6 - Divisao de Treino-Musculo\n");
        System.out.println("7 - Treino\n");
        System.out.println("8 - Treino Aplicacao\n");
        System.out.println("9 - Avaliacao Fisica\n");
        System.out.println("10 - Mensalidades\n");
        System.out.println("11 - Mensalidade Aluno\n");
        System.out.println("12 - Pagamento Recorrente\n");
        System.out.println("13 - Entrada Aluno\n");
        System.out.println("14 - Movimentacao Financeira\n");
        System.out.println("15 - Fechar\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    // ACADEMIA
    public static int academiaMenu() {
        System.out.println("****************************");
        System.out.println("*   SISTEMA DE ACADEMIAS    *");
        System.out.println("****************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar academia\n");
        System.out.println("2 - Mostrar academias\n");
        System.out.println("3 - Alterar academia\n");
        System.out.println("4 - Buscar academia\n");
        System.out.println("5 - Remover academia\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static Academia adicionarAcademiaMenu() {
        System.out.println("\n*****  ADICIONAR ACADEMIA  ******\n");
        System.out.println("Digite o nome da academia: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereco da academia: ");
        String endereco = scanner.nextLine();
        LocalDate dataAtual = LocalDate.now();
        Academia academia = new Academia(0, nome, endereco, dataAtual, dataAtual);
        return academia;
    }

    public static void mostrarTodasAcademiasMenu(Academia[] academias) {
        System.out.println("\n*****  TODAS AS ACADEMIAS  *****\n");
        if (academias.length == 0) {
            System.out.println("Nenhuma academia cadastrada.");
        } else {
            System.out.println("------------------------");
            for (Academia academia : academias) {
                System.out.println("ID: " + academia.getId());
                System.out.println("Nome: " + academia.getNome());
                System.out.println("Endereco: " + academia.getEndereco());
                System.out.println("Data de Criacao: " + formataData(academia.getDataCriacao()));
                System.out.println("Data de Modificacao: " + formataData(academia.getDataModificacao()));
                System.out.println("------------------------");
            }
        }
    }

    public static void mostrarAcademiaMenu(Academia academia) {
        System.out.println("\n*****  ACADEMIA  *****\n");
        System.out.println("ID: " + academia.getId());
        System.out.println("Nome: " + academia.getNome());
        System.out.println("Endereco: " + academia.getEndereco());
        System.out.println("Data de Criacao: " + formataData(academia.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(academia.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static int buscarAcademiaMenu(String modo) {
        System.out.println("Digite o ID da academia que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static Academia alterarAcademiaMenu(int id, Academia academiaExistente) {
        System.out.println("\n*****  ALTERAR ACADEMIA  *****\n");
        System.out.println("Digite o novo nome da academia:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite o novo endereco da academia:");
        String novoEndereco = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        Academia novaAcademia = new Academia(id, novoNome, novoEndereco, academiaExistente.getDataCriacao(), dataAtualizacao);
        return novaAcademia;
    }

    // PESSOA
    public static int pessoaMenu() {
        System.out.println("**************************");
        System.out.println("*   SISTEMA DE PESSOAS   *");
        System.out.println("**************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar pessoa\n");
        System.out.println("2 - Mostrar todas as pessoas\n");
        System.out.println("3 - Alterar pessoa\n");
        System.out.println("4 - Buscar pessoa\n");
        System.out.println("5 - Remover pessoa\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static Pessoa adicionarPessoaMenu() {
        System.out.println("\n*****  ADICIONAR PESSOA  ******\n");
        System.out.println("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o sexo da pessoa (M/F): ");
        char sexo = scanner.nextLine().charAt(0);
        System.out.println("Digite a data de nascimento (dd/MM/aaaa): ");
        LocalDate nascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Digite o login da pessoa: ");
        String login = scanner.nextLine();
        System.out.println("Digite a senha da pessoa: ");
        String senha = scanner.nextLine();
        System.out.println("Digite o tipo de usuario (1-Admin, 2-Professor, 3-Aluno):");
        int numeroTipoUsuario = Integer.parseInt(scanner.nextLine());
        String tipoUsuario = "";

        switch (numeroTipoUsuario) {
            case 1:
                tipoUsuario = "Admin";
                break;
            case 2:
                tipoUsuario = "Professor";
                break;
            default:
                tipoUsuario = "Aluno";
                break;
        }

        LocalDate dataAtual = LocalDate.now();
        Pessoa pessoa = new Pessoa(0, nome, sexo, nascimento, login, senha, tipoUsuario, dataAtual, dataAtual);
        return pessoa;
    }

    public static void mostrarTodasPessoasMenu(Pessoa[] pessoas) {
        System.out.println("\n*****  TODAS AS PESSOAS  *****\n");
        if (pessoas.length == 0) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            System.out.println("------------------------");
            for (Pessoa pessoa : pessoas) {
                System.out.println("ID: " + pessoa.getId());
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Sexo: " + pessoa.getSexo());
                System.out.println("Data de Nascimento: " + formataData(pessoa.getNascimento()));
                System.out.println("Login: " + pessoa.getLogin());
                System.out.println("Senha: " + pessoa.getSenha());
                System.out.println("Tipo de Usuario: " + pessoa.getTipoUsuario());
                System.out.println("Data de Criacao: " + formataData(pessoa.getDataCriacao()));
                System.out.println("Data de Modificacao: " + formataData(pessoa.getDataModificacao()));
                System.out.println("------------------------");
            }
        }
    }

    public static void mostrarPessoaMenu(Pessoa pessoa) {
        System.out.println("\n*****  PESSOA  *****\n");
        System.out.println("ID: " + pessoa.getId());
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Sexo: " + pessoa.getSexo());
        System.out.println("Data de Nascimento: " + formataData(pessoa.getNascimento()));
        System.out.println("Login: " + pessoa.getLogin());
        System.out.println("Senha: " + pessoa.getSenha());
        System.out.println("Tipo de Usuario: " + pessoa.getTipoUsuario());
        System.out.println("Data de Criacao: " + formataData(pessoa.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(pessoa.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static int buscarPessoaMenu(String modo) {
        System.out.println("Digite o ID da pessoa que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static Pessoa alterarPessoaMenu(int id, Pessoa pessoaExistente) {
        System.out.println("\n*****  ALTERAR PESSOA  *****\n");
        System.out.println("Digite o novo nome da pessoa:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite o novo sexo da pessoa (M/F):");
        char novoSexo = scanner.nextLine().charAt(0);
        System.out.println("Digite a nova data de nascimento (dd/MM/aaaa):");
        LocalDate novaDataNascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Digite o novo login da pessoa:");
        String novoLogin = scanner.nextLine();
        System.out.println("Digite a nova senha da pessoa:");
        String novaSenha = scanner.nextLine();
        System.out.println("Digite o novo tipo de usuario (1-Admin, 2-Professor, 3-Aluno):");
        int numeroNovoTipoUsuario = Integer.parseInt(scanner.nextLine());
        String novoTipoUsuario = "";

        switch (numeroNovoTipoUsuario) {
            case 1:
                novoTipoUsuario = "Admin";
                break;
            case 2:
                novoTipoUsuario = "Professor";
                break;
            default:
                novoTipoUsuario = "Usuario";
                break;
        }

        LocalDate dataAtualizacao = LocalDate.now();
        Pessoa novaPessoa = new Pessoa(id, novoNome, novoSexo, novaDataNascimento, novoLogin, novaSenha, novoTipoUsuario, pessoaExistente.getDataCriacao(), dataAtualizacao);
        return novaPessoa;
    }

    // EXERCICIO
    public static int exercicioMenu() {
        System.out.println("*****************************");
        System.out.println("*   SISTEMA DE EXERCICIOS   *");
        System.out.println("*****************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar exercicio\n");
        System.out.println("2 - Mostrar todos os exercicios\n");
        System.out.println("3 - Alterar exercicio\n");
        System.out.println("4 - Buscar exercicio\n");
        System.out.println("5 - Remover exercicio\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static Exercicio adicionarExerciciosMenu() {
        System.out.println("\n*****  ADICIONAR EXERCICIO  ******\n");
        System.out.println("Digite o nome do exercicio: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a descricao do exercicio: ");
        String descricao = scanner.nextLine();

        LocalDate dataAtual = LocalDate.now();
        Exercicio exercicio = new Exercicio(0, nome, descricao, dataAtual, dataAtual);
        return exercicio;
    }

    public static void mostrarTodosExerciciosMenu(Exercicio[] exercicios) {
        System.out.println("\n*****  TODOS OS EXERCICIOS  *****\n");
        System.out.println("------------------------");

        for (Exercicio exercicio : exercicios) {
            System.out.println("ID: " + exercicio.getId());
            System.out.println("Nome: " + exercicio.getNome());
            System.out.println("Descricao: " + exercicio.getDescricao());
            System.out.println("Data de Criacao: " + formataData(exercicio.getDataCriacao()));
            System.out.println("Data de Modificacao: " + formataData(exercicio.getDataModificacao()));
            System.out.println("------------------------");
        }
    }

    public static void mostrarExercicioMenu(Exercicio exercicio) {
        System.out.println("\n*****  EXERCICIO  *****\n");
        System.out.println("ID: " + exercicio.getId());
        System.out.println("Nome: " + exercicio.getNome());
        System.out.println("Descricao: " + exercicio.getDescricao());
        System.out.println("Data de Criacao: " + formataData(exercicio.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(exercicio.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static int buscarExercicioMenu(String modo) {
        System.out.println("Digite o ID do exercicio que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static Exercicio alterarExercicioMenu(int id, Exercicio exercicio) {
        System.out.println("\n*****  ALTERAR EXERCICIO  *****\n");
        System.out.println("Digite o novo nome do exercicio:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite a nova descricao do exercicio:");
        String novaDescricao = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        Exercicio novoExercicio = new Exercicio(id, novoNome, novaDescricao, exercicio.getDataCriacao(), dataAtualizacao);
        return novoExercicio;
    }

    // EXERCICIO APLICACAO
    public static int exercicioAplicacaoMenu() {
        System.out.println("******************************************");
        System.out.println("*   SISTEMA DE APLICACAO DE EXERCICIOS   *");
        System.out.println("******************************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar aplicacao de exercicio\n");
        System.out.println("2 - Mostrar todas aplicacoes de exercicios\n");
        System.out.println("3 - Alterar aplicacao de exercicio\n");
        System.out.println("4 - Buscar aplicacao de exercicio\n");
        System.out.println("5 - Remover aplicacao de exercicio\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static ExercicioAplicacao adicionarExercicioAplicacaoMenu(int idExercicio) {
        System.out.println("\n*****  ADICIONAR EXERCICIO APLICACAO  ******\n");
        System.out.println("Digite a descricao do exercicio de aplicacao: ");
        String descricao = scanner.nextLine();

        LocalDate dataAtual = LocalDate.now();
        ExercicioAplicacao exercicioAplicacao = new ExercicioAplicacao(0, idExercicio, descricao, dataAtual, dataAtual);
        return exercicioAplicacao;
    }

    public static void mostrarTodosExerciciosAplicacaoMenu(ExercicioDAO exercicioDAO, ExercicioAplicacaoDAO exercicioAplicacaoDAO) {
        System.out.println("\n*****  TODOS OS EXERCICIOS APLICACAO  *****\n");
        System.out.println("------------------------");

        ExercicioAplicacao[] exerciciosAplicacao = exercicioAplicacaoDAO.mostrarExerciciosAplicacao();

        for (ExercicioAplicacao exercicioAplicacao : exerciciosAplicacao) {
            Exercicio exercicio = exercicioDAO.buscarExercicio(exercicioAplicacao.getIdExercicio());
            if (exercicio != null) {
                System.out.println("Nome do Exercicio: " + exercicio.getNome());
                System.out.println("Descricao do Exercicio: " + exercicio.getDescricao());
                System.out.println("Descricao do Exercicio de Aplicacao: " + exercicioAplicacao.getDescricao());
                System.out.println("Data de Criacao: " + formataData(exercicioAplicacao.getDataCriacao()));
                System.out.println("Data de Modificacao: " + formataData(exercicioAplicacao.getDataModificacao()));
                System.out.println("------------------------");
            } else {
                System.out.println("Exercicio nao encontrado.");
            }
        }
    }

    public static void mostrarExercicioAplicacaoMenu(ExercicioAplicacao exercicioAplicacao) {
        System.out.println("\n*****  EXERCICIO APLICACAO  *****\n");
        System.out.println("ID: " + exercicioAplicacao.getId());
        System.out.println("Descricao: " + exercicioAplicacao.getDescricao());
        System.out.println("Data de Criacao: " + formataData(exercicioAplicacao.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(exercicioAplicacao.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static int buscarExercicioAplicacaoMenu(String modo) {
        System.out.println("Digite o ID do exercicio aplicacao que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static ExercicioAplicacao alterarExercicioAplicacaoMenu(int id, ExercicioAplicacao exercicioAplicacao) {
        System.out.println("\n*****  ALTERAR EXERCICIO APLICACAO  *****\n");
        System.out.println("Digite a nova descricao do exercicio de aplicacao:");
        String novaDescricao = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        ExercicioAplicacao novoExercicioAplicacao = new ExercicioAplicacao(id, exercicioAplicacao.getIdExercicio(), novaDescricao, exercicioAplicacao.getDataCriacao(), dataAtualizacao);
        return novoExercicioAplicacao;
    }

    //DIVISAO DE TREINO
    public static int divisaoTreinoMenu() {
        System.out.println("************************************");
        System.out.println("*   SISTEMA DE DIVISAO DE TREINOS   *");
        System.out.println("************************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar divisao de treino\n");
        System.out.println("2 - Mostrar todas as divisoes de treino\n");
        System.out.println("3 - Alterar divisao de treino\n");
        System.out.println("4 - Buscar divisao de treino\n");
        System.out.println("5 - Remover divisao de treino\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static DivisaoTreino adicionarDivisaoTreinoMenu() {
        System.out.println("\n*****  ADICIONAR DIVISAO DE TREINO  ******\n");
        System.out.println("Digite o nome da divisao de treino: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a descricao da divisao de treino: ");
        String descricao = scanner.nextLine();

        LocalDate dataAtual = LocalDate.now();
        DivisaoTreino divisaoTreino = new DivisaoTreino(0, nome, descricao, dataAtual, dataAtual);
        return divisaoTreino;
    }

    public static void mostrarTodasDivisoesTreinoMenu(DivisaoTreinoDAO divisaoTreinoDAO) {
        System.out.println("\n*****  TODOAS DIVISOES DE TREINO  *****\n");
        System.out.println("------------------------");

        DivisaoTreino[] divisoesTreino = divisaoTreinoDAO.mostrarDivisoesTreino();

        for (DivisaoTreino divisaoTreino : divisoesTreino) {
            System.out.println("ID: " + divisaoTreino.getId());
            System.out.println("Nome da Divisao: " + divisaoTreino.getNome());
            System.out.println("Descricao da Divisao: " + divisaoTreino.getDescricao());
            System.out.println("Data de Criacao: " + formataData(divisaoTreino.getDataCriacao()));
            System.out.println("Data de Modificacao: " + formataData(divisaoTreino.getDataModificacao()));
            System.out.println("------------------------");
        }
    }

    public static void mostrarDivisaoTreinoMenu(DivisaoTreino divisaoTreino) {
        System.out.println("\n*****  DIVISAO DE TREINO  *****\n");
        System.out.println("ID: " + divisaoTreino.getId());
        System.out.println("Nome da Divisao: " + divisaoTreino.getNome());
        System.out.println("Descricao da Divisao: " + divisaoTreino.getDescricao());
        System.out.println("Data de Criacao: " + formataData(divisaoTreino.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(divisaoTreino.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static int buscarDivisaoTreinoMenu(String modo) {
        System.out.println("Digite o ID da divisao de treino que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static DivisaoTreino alterarDivisaoTreinoMenu(int id, DivisaoTreino divisaoTreino) {
        System.out.println("\n*****  ALTERAR DIVISAO DE TREINO  *****\n");
        System.out.println("Digite o novo nome da divisao de treino:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite a nova descricao da divisao de treino:");
        String novaDescricao = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        DivisaoTreino novaDivisaoTreino = new DivisaoTreino(id, novoNome, novaDescricao, divisaoTreino.getDataCriacao(), dataAtualizacao);
        return novaDivisaoTreino;
    }

    // DIVISAO TREINO-MUSCULO
    public static int divisaoTreinoMusculoMenu() {
        System.out.println("*****************************************");
        System.out.println("*   SISTEMA DE DIVISAO TREINO-MUSCULO   *");
        System.out.println("*****************************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar divisao de treino-musculo\n");
        System.out.println("2 - Mostrar todas as divisoes de treino-musculo\n");
        System.out.println("3 - Alterar divisao de treino-musculo\n");
        System.out.println("4 - Buscar divisao de treino-musculo\n");
        System.out.println("5 - Remover divisao de treino-musculo\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static DivisaoTreinoMusculo adicionarDivisaoTreinoMusculoMenu(DivisaoTreinoDAO divisaoTreinoDAO) {
        System.out.println("\n*****  ADICIONAR DIVISAO TREINO-MUSCULO  ******\n");
        System.out.println("Digite o ID da divisao de treino associada à divisao de treino-musculo: ");
        int idDivisaoTreino = Integer.parseInt(scanner.nextLine());
        DivisaoTreino divisaoTreino = divisaoTreinoDAO.buscarDivisaoTreino(idDivisaoTreino);

        if (divisaoTreino != null) {
            System.out.println("Divisao de Treino associada encontrada:");
            System.out.println("ID: " + divisaoTreino.getId());
            System.out.println("Nome da Divisao: " + divisaoTreino.getNome());
            System.out.println("Descricao da Divisao: " + divisaoTreino.getDescricao());

            System.out.println("\nDigite a descricao da divisao de treino-musculo: ");
            String descricao = scanner.nextLine();

            LocalDate dataAtual = LocalDate.now();
            DivisaoTreinoMusculo divisaoTreinoMusculo = new DivisaoTreinoMusculo(0, descricao, divisaoTreino.getNome(), dataAtual, dataAtual);
            return divisaoTreinoMusculo;
        } else {
            System.out.println("Divisao de Treino associada nao encontrada.");
            return null;
        }
    }

    public static void mostrarTodasDivisoesTreinoMusculoMenu(DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO) {
        System.out.println("\n*****  TODAS DIVISOES TREINO-MUSCULO  *****\n");
        System.out.println("------------------------");

        DivisaoTreinoMusculo[] divisoesTreinoMusculo = divisaoTreinoMusculoDAO.mostrarDivisoesTreinoMusculo();

        for (DivisaoTreinoMusculo divisaoTreinoMusculo : divisoesTreinoMusculo) {
            System.out.println("ID: " + divisaoTreinoMusculo.getId());
            System.out.println("Descricao da Divisao: " + divisaoTreinoMusculo.getDescricao());
            System.out.println("Divisao de Treino: " + divisaoTreinoMusculo.getDivisaoTreino());
            System.out.println("Data de Criacao: " + formataData(divisaoTreinoMusculo.getDataCriacao()));
            System.out.println("Data de Modificacao: " + formataData(divisaoTreinoMusculo.getDataModificacao()));
            System.out.println("------------------------");
        }
    }

    public static void mostrarDivisaoTreinoMusculoMenu(DivisaoTreinoMusculo divisaoTreinoMusculo) {
        System.out.println("\n*****  DIVISAO TREINO-MUSCULO  *****\n");
        System.out.println("ID: " + divisaoTreinoMusculo.getId());
        System.out.println("Descricao da Divisao: " + divisaoTreinoMusculo.getDescricao());
        System.out.println("Divisao de Treino: " + divisaoTreinoMusculo.getDivisaoTreino());
        System.out.println("Data de Criacao: " + formataData(divisaoTreinoMusculo.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(divisaoTreinoMusculo.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static int buscarDivisaoTreinoMusculoMenu(String modo) {
        System.out.println("Digite o ID da divisao de treino-musculo que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static DivisaoTreinoMusculo alterarDivisaoTreinoMusculoMenu(int id, DivisaoTreinoMusculo divisaoTreinoMusculo) {
        System.out.println("\n*****  ALTERAR DIVISAO TREINO-MUSCULO  *****\n");
        System.out.println("Digite a nova descricao da divisao de treino-musculo:");
        String novaDescricao = scanner.nextLine();
        System.out.println("Digite a nova divisao de treino da divisao de treino-musculo:");
        String novaDivisaoTreino = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        DivisaoTreinoMusculo novaDivisaoTreinoMusculo = new DivisaoTreinoMusculo(id, novaDescricao, novaDivisaoTreino, divisaoTreinoMusculo.getDataCriacao(), dataAtualizacao);
        return novaDivisaoTreinoMusculo;
    }

    // TREINO
    public static int treinoMenu() {
        System.out.println("**************************");
        System.out.println("*   SISTEMA DE TREINOS   *");
        System.out.println("**************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar treino\n");
        System.out.println("2 - Mostrar todos os treinos\n");
        System.out.println("3 - Mostrar treino especifico\n");
        System.out.println("4 - Buscar treino\n");
        System.out.println("5 - Alterar treino\n");
        System.out.println("6 - Remover treino\n");
        System.out.println("7 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static Treino adicionarTreinoMenu(TreinoDAO treinoDAO, DivisaoTreinoDAO divisaoTreinoDAO, PessoaDAO pessoaDAO) {
        System.out.println("\n*****  ADICIONAR TREINO  *****\n");

        System.out.println("Digite o ID do aluno para associar ao treino:");
        int idAluno = Integer.parseInt(scanner.nextLine());
        Pessoa aluno = pessoaDAO.buscarPessoa(idAluno);

        if (aluno != null && aluno.getTipoUsuario().equals("Aluno")) {
            System.out.println("Aluno encontrado:");
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Tipo de Usuario: " + aluno.getTipoUsuario());

            System.out.println("Digite o objetivo do treino:");
            String objetivo = scanner.nextLine();

            System.out.println("Digite a data de inicio do treino (no formato dd/MM/aaaa):");
            LocalDate dataInicio = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));            

            System.out.println("Digite a data de termino do treino (no formato dd/MM/aaaa):");
            LocalDate dataTermino = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println("Divisoes de treino existentes:");
            DivisaoTreino[] divisoesTreino = divisaoTreinoDAO.mostrarDivisoesTreino();
            for (DivisaoTreino divisaoTreino : divisoesTreino) {
                System.out.println("ID: " + divisaoTreino.getId() + ", Nome: " + divisaoTreino.getNome() + ", Descricao: " + divisaoTreino.getDescricao());
            }

            System.out.println("Digite o ID da divisao de treino desejada:");
            int idDivisaoTreino = Integer.parseInt(scanner.nextLine());
            DivisaoTreino divisaoTreino = divisaoTreinoDAO.buscarDivisaoTreino(idDivisaoTreino);

            if (divisaoTreino != null) {
                LocalDate dataAtual = LocalDate.now();
                Treino treino = new Treino(0, aluno, objetivo, dataInicio, dataTermino, divisaoTreino, dataAtual, dataAtual);
                return treino;
            } else {
                System.out.println("Divisao de Treino nao encontrada.");
                return null;
            }
        } else {
            System.out.println("Aluno nao encontrado ou nao e do tipo 'Aluno'.");
            return null;
        }
    }

    public static void mostrarTodosTreinosMenu(TreinoDAO treinoDAO) {
        System.out.println("\n*****  TODOS OS TREINOS  *****\n");

        Treino[] treinos = treinoDAO.mostrarTreinos();

        for (Treino treino : treinos) {
            System.out.println("ID: " + treino.getId());
            System.out.println("ID do Aluno: " + treino.getIdAluno());
            System.out.println("Nome do Aluno: " + treino.getNomeAluno());
            System.out.println("Tipo de Usuario do Aluno: " + treino.getTipoUsuarioAluno());
            System.out.println("Objetivo do Treino: " + treino.getObjetivo());
            System.out.println("Data de Inicio: " + formataData(treino.getDataInicio()));
            System.out.println("Data de Termino: " + formataData(treino.getDataTermino()));
            System.out.println("ID da Divisao de Treino: " + treino.getIdDivisaoTreino());
            System.out.println("Nome da Divisao de Treino: " + treino.getNomeDivisaoTreino());
            System.out.println("Data de Criacao: " + formataData(treino.getDataCriacao()));
            System.out.println("Data de Modificacao: " + formataData(treino.getDataModificacao()));
            System.out.println("------------------------");
        }
    }

    public static void mostrarTreinoMenu(Treino treino) {
        System.out.println("\n***** TREINO *****\n");

        System.out.println("ID: " + treino.getId());
        System.out.println("ID do Aluno: " + treino.getIdAluno());
        System.out.println("Nome do Aluno: " + treino.getNomeAluno());
        System.out.println("Tipo de Usuario do Aluno: " + treino.getTipoUsuarioAluno());
        System.out.println("Objetivo do Treino: " + treino.getObjetivo());
        System.out.println("Data de Inicio: " + formataData(treino.getDataInicio()));
        System.out.println("Data de Termino: " + formataData(treino.getDataTermino()));
        System.out.println("ID da Divisao de Treino: " + treino.getIdDivisaoTreino());
        System.out.println("Nome da Divisao de Treino: " + treino.getNomeDivisaoTreino());
        System.out.println("Data de Criacao: " + formataData(treino.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(treino.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static int buscarTreinoMenu(String modo) {
        System.out.println("Digite o ID do treino que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static Treino alterarTreinoMenu(int id, Treino treino, DivisaoTreinoDAO divisaoTreinoDAO, PessoaDAO pessoaDAO) {
        System.out.println("\n*****  ALTERAR TREINO  *****\n");
        System.out.println("Digite o novo objetivo do treino:");
        String novoObjetivo = scanner.nextLine();
        System.out.println("Digite a nova data de inicio do treino (no formato dd/MM/aaaa):");
        LocalDate novaDataInicio = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Digite a nova data de termino do treino (no formato dd/MM/aaaa):");
        LocalDate novaDataTermino = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Divisoes de treino existentes:");
        DivisaoTreino[] divisoesTreino = divisaoTreinoDAO.mostrarDivisoesTreino();
        for (DivisaoTreino divisaoTreino : divisoesTreino) {
            System.out.println("ID: " + divisaoTreino.getId() + ", Nome: " + divisaoTreino.getNome() + ", Descricao: " + divisaoTreino.getDescricao());
        }

        System.out.println("Digite o ID da nova divisao de treino:");
        int idNovaDivisaoTreino = Integer.parseInt(scanner.nextLine());
        DivisaoTreino novaDivisaoTreino = divisaoTreinoDAO.buscarDivisaoTreino(idNovaDivisaoTreino);

        if (novaDivisaoTreino != null) {
            LocalDate dataAtualizacao = LocalDate.now();
            Treino novoTreino = new Treino(id, treino.getPessoa(), novoObjetivo, novaDataInicio, novaDataTermino, novaDivisaoTreino, treino.getDataCriacao(), dataAtualizacao);
            return novoTreino;
        } else {
            System.out.println("Divisao de Treino nao encontrada.");
            return null;
        }
    }

    // TREINO APLICACAO
    // AVALIACAO FISICA
    public static int avaliacaoFisicaMenu() {
        System.out.println("***********************************");
        System.out.println("*   SISTEMA DE AVALIACAO FISICA   *");
        System.out.println("***********************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Realizar avaliacao fisica\n");
        System.out.println("2 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }
     
    
    // MENSALIDADE
    public static int mensalidadeMenu() {
        System.out.println("*******************************");
        System.out.println("*   SISTEMA DE MENSALIDADES   *");
        System.out.println("*******************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar mensalidade\n");
        System.out.println("2 - Mostrar todas as mensalidades\n");
        System.out.println("3 - Alterar mensalidade\n");
        System.out.println("4 - Buscar mensalidade\n");
        System.out.println("5 - Remover mensalidade\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static Mensalidade adicionarMensalidadeMenu() {
        System.out.println("\n*****  ADICIONAR MENSALIDADE  ******\n");
        System.out.println("Digite a descricao da mensalidade: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o valor da mensalidade: ");
        double valor = Double.parseDouble(scanner.nextLine());
        System.out.println("Digite a duracao da mensalidade: ");
        int meses = Integer.parseInt(scanner.nextLine());

        LocalDate dataInicio = LocalDate.now();
        LocalDate dataFim = dataInicio.plusMonths(meses);

        Mensalidade mensalidade = new Mensalidade(0, descricao, valor, dataInicio, dataFim, dataInicio, dataInicio);
        return mensalidade;
    }

    public static void mostrarTodasMensalidadesMenu(MensalidadeDAO mensalidadeDAO) {
        System.out.println("\n*****  TODAS AS MENSALIDADES  *****\n");
        System.out.println("------------------------");

        Mensalidade[] mensalidades = mensalidadeDAO.mostrarMensalidades();

        for (Mensalidade mensalidade : mensalidades) {
            System.out.println("ID: " + mensalidade.getId());
            System.out.println("Valor: R$ " + mensalidade.getValor());
            System.out.println("Data de Inicio: " + formataData(mensalidade.getDataInicio()));
            System.out.println("Data de Fim: " + formataData(mensalidade.getDataFim()));
            System.out.println("Data de Criacao: " + formataData(mensalidade.getDataCriacao()));
            System.out.println("Data de Modificacao: " + formataData(mensalidade.getDataModificacao()));
            System.out.println("------------------------");
        }
    }

    public static void mostrarMensalidadeMenu(Mensalidade mensalidade) {
        System.out.println("\n*****  MENSALIDADE  *****\n");
        System.out.println("ID: " + mensalidade.getId());
        System.out.println("Valor: R$ " + mensalidade.getValor());
        System.out.println("Data de Inicio: " + formataData(mensalidade.getDataInicio()));
        System.out.println("Data de Fim: " + formataData(mensalidade.getDataFim()));
        System.out.println("Data de Criacao: " + formataData(mensalidade.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(mensalidade.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static int buscarMensalidadeMenu(String modo) {
        System.out.println("Digite o ID da mensalidade que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static Mensalidade alterarMensalidadeMenu(int id, Mensalidade mensalidade) {
        System.out.println("\n*****  ALTERAR MENSALIDADE  *****\n");
        System.out.println("Digite a nova descricao da mensalidade: ");
        String novaDescricao = scanner.nextLine();
        System.out.println("Digite o novo valor da mensalidade: ");
        double novoValor = Double.parseDouble(scanner.nextLine());
        System.out.println("Digite a nova duracao da mensalidade: ");
        int novosMeses = Integer.parseInt(scanner.nextLine());

        LocalDate dataAtualizacao = LocalDate.now();
        LocalDate dataFim = mensalidade.getDataInicio().plusMonths(novosMeses);
        Mensalidade novaMensalidade = new Mensalidade(id, novaDescricao, novoValor, mensalidade.getDataInicio(), dataFim, mensalidade.getDataCriacao(), dataAtualizacao);
        return novaMensalidade;
    }

    // ALUNO PAGAMENTO MENSALIDADE
    public static int mensalidadeAlunoMenu() {
        System.out.println("*****************************************");
        System.out.println("*   SISTEMA DE MENSALIDADE DOS ALUNOS   *");
        System.out.println("*****************************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Associar mensalidade a um aluno\n");
        System.out.println("2 - Mostrar todas as mensalidades de alunos\n");
        System.out.println("3 - Alterar associacao de mensalidade-aluno\n");
        System.out.println("4 - Buscar associacao de mensalidade-aluno\n");
        System.out.println("5 - Remover associacao de mensalidade-aluno\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static MensalidadeAluno associarMensalidadeAlunoMenu() {
        System.out.println("\n*****  ADICIONAR MENSALIDADE PARA ALUNO  ******\n");
        System.out.println("Digite o ID da mensalidade: ");
        int idMensalidade = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o ID do aluno: ");
        int idAluno = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o valor pago: ");
        double valorPago = Double.parseDouble(scanner.nextLine());
        System.out.println("Digite a modalidade (pix, cartao de credito, dinheiro, etc): ");
        String modalidade = scanner.nextLine();

        LocalDate dataAtual = LocalDate.now();

        MensalidadeAluno mensalidadeAluno = new MensalidadeAluno(0, idAluno, idMensalidade, dataAtual, valorPago, modalidade, dataAtual, dataAtual);
        return mensalidadeAluno;
    }

    public static void mostrarMensalidadeAlunoMenu(MensalidadeAluno mensalidadeAluno) {
        System.out.println("\n*****  MENSALIDADE ALUNO  *****\n");
        System.out.println("ID Associacao: " + mensalidadeAluno.getId());
        System.out.println("ID Aluno: " + mensalidadeAluno.getIdAluno());
        System.out.println("ID Mensalidade: " + mensalidadeAluno.getIdMensalidade());
        System.out.println("Data de Criacao: " + formataData(mensalidadeAluno.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(mensalidadeAluno.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static void mostrarTodasMensalidadesAlunoMenu(MensalidadeAluno[] mensalidadesAlunos, Pessoa[] alunos, Mensalidade[] mensalidades) {
        System.out.println("\n*****  TODAS AS MENSALIDADES DOS ALUNOS  *****\n");
        for (MensalidadeAluno mensalidadeAluno : mensalidadesAlunos) {
            System.out.println("ID Associacao: " + mensalidadeAluno.getId());
            System.out.println("ID Aluno: " + mensalidadeAluno.getIdAluno());
            System.out.println("Nome do Aluno: " + alunos[mensalidadeAluno.getIdAluno() - 1].getNome());
            System.out.println("ID Mensalidade: " + mensalidadeAluno.getIdMensalidade());
            System.out.println("Descricao da Mensalidade: " + mensalidades[mensalidadeAluno.getIdMensalidade() - 1].getDescricao());
            System.out.println("Valor Pago: " + mensalidadeAluno.getValorPago());
            System.out.println("Modalidade: " + mensalidadeAluno.getModalidade());
            System.out.println("Data de pagamento: " + formataData(mensalidadeAluno.getDataPagamento()));
            System.out.println("Data de Criacao: " + formataData(mensalidadeAluno.getDataCriacao()));
            System.out.println("Data de Modificacao: " + formataData(mensalidadeAluno.getDataModificacao()));
            System.out.println("------------------------");
        }
    }

    public static MensalidadeAluno alterarMensalidadeAlunoMenu(MensalidadeAluno mensalidadeAluno) {
        System.out.println("\n*****  ALTERAR MENSALIDADE DO ALUNO  *****\n");
        System.out.println("Digite o novo ID do aluno (atual: " + mensalidadeAluno.getIdAluno() + "): ");
        int novoIdAluno = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o novo ID da mensalidade (atual: " + mensalidadeAluno.getIdMensalidade() + "): ");
        int novoIdMensalidade = Integer.parseInt(scanner.nextLine());

        mensalidadeAluno.setIdAluno(novoIdAluno);
        mensalidadeAluno.setIdMensalidade(novoIdMensalidade);

        return mensalidadeAluno;
    }

    public static int buscarMensalidadeAlunoMenu(String modo) {
        System.out.println("Digite o ID da associacao de mensalidade-aluno que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    // PAGAMENTO RECORRENTE
    // ENTRADA ALUNO
    // MOVIMENTAcaO FINANCEIRA
    // RELATORIOS
    
    public static void limparTela() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

    public static void mostrarOpcaoInvalida() {
        System.out.println("Opcao invalida. Por favor, tente novamente.");
    }

    public static void digitarQualquerTecla() {
        System.out.println("Aperte qualquer tecla para continuar...");
        scanner.nextLine();
    }
    
    public static String formataData(LocalDate data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        return data.format(dtf);
    }

}
