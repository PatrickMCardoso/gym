package gym.view;

import java.util.Scanner;
import java.util.ArrayList;
import gym.model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class Menus {

    static Scanner scanner = new Scanner(System.in);

    // MENU INICIO
    public static int menuIniciar() {
        System.out.println("**************************************");
        System.out.println("*  BEM VINDO AO SISTEMA DA ACADEMIA  *");
        System.out.println("**************************************\n");
        System.out.println("------------------------");
        System.out.println("\nDigite a opcao escolhida:");
        System.out.println("1 - Fazer login\n");
        System.out.println("2 - SAIR\n");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    // MENU INICIO
    public static String[] menuLogin() {
        System.out.println("**********************");
        System.out.println("*  SISTEMA DE LOGIN  *");
        System.out.println("**********************\n");
        System.out.println("------------------------");
        System.out.println("\nDigite seu login:");
        String login = scanner.nextLine();
        System.out.println("\nDigite sua senha:");
        String senha = scanner.nextLine();

        String[] loginSenha = {login, senha};

        return loginSenha;
    }

    // MENU ADMIN
    public static int mostrarMenuAdmin() {
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
        System.out.println("9 - Avaliacao Fisica (custo de R$ 20)\n");
        System.out.println("10 - Mensalidades\n");
        System.out.println("11 - Mensalidade Aluno\n");
        System.out.println("12 - Pagamento Recorrente\n");
        System.out.println("13 - Calendario\n");
        System.out.println("14 - Entrada Aluno\n");
        System.out.println("15 - Relatorios\n");
        System.out.println("16 - Fechar\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    // MENU PROFESSOR
    public static int mostrarMenuProfessor() {
        limparTela();
        System.out.println("******************************************");
        System.out.println("*   SISTEMAS DE GERENCIAMENTO DE ALUNO   *");
        System.out.println("******************************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Exercicios\n");
        System.out.println("2 - Aplicacao de Exercicios\n");
        System.out.println("3 - Divisao de Treino\n");
        System.out.println("4 - Divisao de Treino-Musculo\n");
        System.out.println("5 - Treino\n");
        System.out.println("6 - Treino Aplicacao\n");
        System.out.println("7 - Avaliacao Fisica (custo de R$ 20)\n");
        System.out.println("8 - Entrada Aluno\n");
        System.out.println("9 - Relatorios\n");
        System.out.println("10 - Fechar\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    //MENU ALUNO
    public static int mostrarMenuAluno() {
        limparTela();
        System.out.println("*********************************");
        System.out.println("*      GERENCIAMENTO ALUNO      *");
        System.out.println("*********************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Avaliacao Fisica (custo de R$ 20)\n");
        System.out.println("2 - Entrada Aluno\n");
        System.out.println("3 - Relatorios\n");
        System.out.println("4 - Fechar\n");
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

    public static void mostrarTodasAcademiasMenu(ArrayList<Academia> academias) {
        System.out.println("\n*****  TODAS AS ACADEMIAS  *****\n");
        if (academias.isEmpty()) {
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
        return Integer.parseInt(scanner.nextLine());
    }

    public static Academia alterarAcademiaMenu(int id, Academia academiaExistente) {
        System.out.println("\n*****  ALTERAR ACADEMIA  *****\n");
        System.out.println("Digite o novo nome da academia:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite o novo endereco da academia:");
        String novoEndereco = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        return new Academia(id, novoNome, novoEndereco, academiaExistente.getDataCriacao(), dataAtualizacao);
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

    public static void mostrarTodasPessoasMenu(ArrayList<Pessoa> pessoas) {
        System.out.println("\n*****  TODAS AS PESSOAS  *****\n");
        if (pessoas.isEmpty()) {
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

    public static void mostrarTodosExerciciosMenu(ArrayList<Exercicio> exercicios) {
        System.out.println("\n*****  TODOS OS EXERCICIOS  *****\n");
        if (exercicios.isEmpty()) {
            System.out.println("Nenhum exercicio cadastrado.");
        } else {
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
        return Integer.parseInt(scanner.nextLine());
    }

    public static Exercicio alterarExercicioMenu(int id, Exercicio exercicioExistente) {
        System.out.println("\n*****  ALTERAR EXERCICIO  *****\n");
        System.out.println("Digite o novo nome do exercicio:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite a nova descricao do exercicio:");
        String novaDescricao = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        return new Exercicio(id, novoNome, novaDescricao, exercicioExistente.getDataCriacao(), dataAtualizacao);
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

        ArrayList<ExercicioAplicacao> exerciciosAplicacao = exercicioAplicacaoDAO.mostrarExerciciosAplicacao();

        if (exerciciosAplicacao.isEmpty()) {
            System.out.println("Nenhuma aplicacao de exercicio cadastrada.");
        } else {
            for (ExercicioAplicacao exercicioAplicacao : exerciciosAplicacao) {
                Exercicio exercicio = exercicioDAO.buscarExercicio(exercicioAplicacao.getIdExercicio());
                if (exercicio != null) {
                    System.out.println("------------------------");
                    System.out.println("Nome do Exercicio: " + exercicio.getNome());
                    System.out.println("Descricao do Exercicio: " + exercicio.getDescricao());
                    System.out.println("Descricao do Exercicio de Aplicacao: " + exercicioAplicacao.getDescricao());
                    System.out.println("Data de Criacao: " + formataData(exercicioAplicacao.getDataCriacao()));
                    System.out.println("Data de Modificacao: " + formataData(exercicioAplicacao.getDataModificacao()));
                } else {
                    System.out.println("Exercicio nao encontrado.");
                }
            }
        }
    }

    public static void mostrarExercicioAplicacaoMenu(ExercicioAplicacao exercicioAplicacao, ExercicioDAO exercicioDAO) {
        System.out.println("\n*****  EXERCICIO APLICACAO  *****\n");
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

    // DIVISAO DE TREINO
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

    public static void mostrarTodasDivisoesTreinoMenu(ArrayList<DivisaoTreino> divisoesTreino) {
        System.out.println("\n*****  TODAS DIVISOES DE TREINO  *****\n");
        if (divisoesTreino.isEmpty()) {
            System.out.println("Nenhuma divisao de treino cadastrada.");
        } else {
            System.out.println("------------------------");
            for (DivisaoTreino divisaoTreino : divisoesTreino) {
                System.out.println("ID: " + divisaoTreino.getId());
                System.out.println("Nome da Divisao: " + divisaoTreino.getNome());
                System.out.println("Descricao da Divisao: " + divisaoTreino.getDescricao());
                System.out.println("Data de Criacao: " + formataData(divisaoTreino.getDataCriacao()));
                System.out.println("Data de Modificacao: " + formataData(divisaoTreino.getDataModificacao()));
                System.out.println("------------------------");
            }
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
        return Integer.parseInt(scanner.nextLine());
    }

    public static DivisaoTreino alterarDivisaoTreinoMenu(int id, DivisaoTreino divisaoTreinoExistente) {
        System.out.println("\n*****  ALTERAR DIVISAO DE TREINO  *****\n");
        System.out.println("Digite o novo nome da divisao de treino:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite a nova descricao da divisao de treino:");
        String novaDescricao = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        return new DivisaoTreino(id, novoNome, novaDescricao, divisaoTreinoExistente.getDataCriacao(), dataAtualizacao);
    }

    // DIVISAO TREINO-MUSCULO
    public static int divisaoTreinoMusculoMenu() {
        System.out.println("*****************************************");
        System.out.println("* SISTEMA DE DIVISAO DE TREINO MUSCULAR *");
        System.out.println("*****************************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar divisao de treino muscular\n");
        System.out.println("2 - Mostrar todas as divisoes de treino muscular\n");
        System.out.println("3 - Alterar divisao de treino muscular\n");
        System.out.println("4 - Buscar divisao de treino muscular\n");
        System.out.println("5 - Remover divisao de treino muscular\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void adicionarDivisaoTreinoMusculoMenu(DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO, DivisaoTreinoDAO divisaoTreinoDAO) {
        System.out.println("\n*****  ADICIONAR DIVISAO DE TREINO MUSCULAR  ******\n");
        System.out.println("Informe o ID do aluno: ");
        int alunoId = Integer.parseInt(scanner.nextLine());

        divisaoTreinoDAO.mostrarTodasDivisoesTreinoMenu();
        System.out.println("Informe o ID da divisao de treino que deseja escolher: ");
        int escolhaId = Integer.parseInt(scanner.nextLine());
        DivisaoTreino divisaoTreinoEscolhida = divisaoTreinoDAO.buscarDivisaoTreino(escolhaId);

        if (divisaoTreinoEscolhida != null) {
            String[] letras = divisaoTreinoEscolhida.getNome().split("");
            String[] tiposExercicios = new String[letras.length];
            String[] todosTipos = new String[]{"PEITO", "COSTAS", "OMBROS", "BICEPS", "TRICEPS", "PANTURRILHA", "GLUTEO", "COXA", "ABDOMEN", "AEROBICO"};

            System.out.println("Opcoes de exercicios:");
            for (int i = 0; i < todosTipos.length; i++) {
                System.out.println((i + 1) + " - " + todosTipos[i]);
            }

            for (int i = 0; i < letras.length; i++) {
                System.out.println("Informe os exercicios para " + letras[i] + " (separados por virgula): ");
                String entrada = scanner.nextLine();
                String[] partes = entrada.replaceAll("\\s+", "").split(",");
                String[] tipos = new String[partes.length];

                for (int j = 0; j < partes.length; j++) {
                    int indice = Integer.parseInt(partes[j]);
                    tipos[j] = todosTipos[indice - 1];
                }
                tiposExercicios[i] = String.join(", ", tipos);
            }

            LocalDate dataAtual = LocalDate.now();
            DivisaoTreinoMusculo divisaoTreinoMusculo = new DivisaoTreinoMusculo(0, alunoId, divisaoTreinoEscolhida, dataAtual, dataAtual, tiposExercicios);
            divisaoTreinoMusculoDAO.adicionarDivisaoTreinoMusculo(divisaoTreinoMusculo, dataAtual);
        } else {
            System.out.println("Divisao de treino nao encontrada.");
        }
    }

    public static void mostrarTodasDivisoesTreinoMusculoMenu(ArrayList<DivisaoTreinoMusculo> divisoesTreinoMusculo) {
        System.out.println("\n*****  TODAS AS DIVISOES DE TREINO MUSCULAR  *****\n");

        if (divisoesTreinoMusculo.isEmpty()) {
            System.out.println("Nenhuma divisao de treino muscular cadastrada.");
        } else {
            for (DivisaoTreinoMusculo divisaoTreinoMusculo : divisoesTreinoMusculo) {
                System.out.println("------------------------");
                System.out.println("ID: " + divisaoTreinoMusculo.getId());
                System.out.println("Aluno ID: " + divisaoTreinoMusculo.getAlunoId());
                System.out.println("Divisao: " + divisaoTreinoMusculo.getDivisaoTreino().getNome());
                String[] letras = divisaoTreinoMusculo.getDivisaoTreino().getNome().split("");
                String[] tiposExercicios = divisaoTreinoMusculo.getTiposExercicios();
                for (int i = 0; i < letras.length; i++) {
                    System.out.println(letras[i] + " - " + tiposExercicios[i]);
                }
            }
        }
    }

    public static void mostrarDivisaoTreinoMusculoMenu(DivisaoTreinoMusculo divisaoTreinoMusculo) {
        System.out.println("\n*****  DIVISAO DE TREINO MUSCULAR  *****\n");
        System.out.println("ID da DTM: " + divisaoTreinoMusculo.getId());
        System.out.println("Aluno ID: " + divisaoTreinoMusculo.getAlunoId());
        System.out.println("Divisao: " + divisaoTreinoMusculo.getDivisaoTreino().getNome());
        String[] letras = divisaoTreinoMusculo.getDivisaoTreino().getNome().split("");
        String[] tiposExercicios = divisaoTreinoMusculo.getTiposExercicios();
        for (int i = 0; i < letras.length; i++) {
            System.out.println(letras[i] + " - " + tiposExercicios[i]);
        }
        System.out.println("------------------------");
    }

    public static int buscarDivisaoTreinoMusculoMenu(String modo) {
        System.out.println("Digite o ID da divisao de treino muscular que deseja " + modo + ": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void alterarDivisaoTreinoMusculoMenu(int id, DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO) {
        DivisaoTreinoMusculo divisaoTreinoMusculo = divisaoTreinoMusculoDAO.buscarDivisaoTreinoMusculo(id);
        if (divisaoTreinoMusculo != null) {
            String[] letras = divisaoTreinoMusculo.getDivisaoTreino().getNome().split("");
            String[] tiposExercicios = new String[letras.length];
            String[] todosTipos = new String[]{"PEITO", "COSTAS", "OMBROS", "BICEPS", "TRICEPS", "PANTURRILHA", "GLUTEO", "COXA", "ABDOMEN", "AEROBICO"};

            System.out.println("Opcoes de exercicios:");
            for (int i = 0; i < todosTipos.length; i++) {
                System.out.println((i + 1) + " - " + todosTipos[i]);
            }

            for (int i = 0; i < letras.length; i++) {
                System.out.println("Informe os exercicios para " + letras[i] + " (separados por virgula): ");
                String entrada = scanner.nextLine();
                String[] partes = entrada.replaceAll("\\s+", "").split(",");
                String[] tipos = new String[partes.length];

                for (int j = 0; j < partes.length; j++) {
                    int indice = Integer.parseInt(partes[j]);
                    tipos[j] = todosTipos[indice - 1];
                }
                tiposExercicios[i] = String.join(", ", tipos);
            }

            divisaoTreinoMusculo.setTiposExercicios(tiposExercicios);
            divisaoTreinoMusculo.setDataModificacao(LocalDate.now());

            divisaoTreinoMusculoDAO.alterarDivisaoTreinoMusculo(id, divisaoTreinoMusculo, LocalDate.now()); 

            System.out.println("Divisao de treino muscular alterada com sucesso.");
        } else {
            System.out.println("Divisao de treino muscular nao encontrada.");
        }
    }

    public static void removerDivisaoTreinoMusculoMenu(DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO, int id) {
        DivisaoTreinoMusculo divisaoTreinoMusculo = divisaoTreinoMusculoDAO.buscarDivisaoTreinoMusculo(id);
        if (divisaoTreinoMusculo != null) {
            divisaoTreinoMusculoDAO.removerDivisaoTreinoMusculo(id);
            System.out.println("Divisao de treino muscular removida com sucesso.");
        } else {
            System.out.println("Divisao de treino muscular nao encontrada.");
        }
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
            ArrayList<DivisaoTreino> divisoesTreino = divisaoTreinoDAO.mostrarDivisoesTreino();
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

    public static void mostrarTodosTreinosMenu(ArrayList<Treino> treinos) {
        System.out.println("\n*****  TODOS OS TREINOS  *****\n");

        if (treinos.isEmpty()) {
            System.out.println("Nenhum treino encontrado.");
        } else {
            for (Treino treino : treinos) {
                System.out.println("ID do Treino: " + treino.getId());
                System.out.println("ID do Aluno: " + treino.getPessoa().getId());
                System.out.println("Nome do Aluno: " + treino.getPessoa().getNome());
                System.out.println("Tipo de Usuario do Aluno: " + treino.getPessoa().getTipoUsuario());
                System.out.println("Objetivo do Treino: " + treino.getObjetivo());
                System.out.println("Data de Inicio: " + formataData(treino.getDataInicio()));
                System.out.println("Data de Termino: " + formataData(treino.getDataTermino()));

                if (treino.getDivisaoTreino() != null) {
                    System.out.println("ID da Divisao de Treino: " + treino.getDivisaoTreino().getId());
                    System.out.println("Nome da Divisao de Treino: " + treino.getDivisaoTreino().getNome());
                } else {
                    System.out.println("Divisao de Treino nao associada.");
                }

                System.out.println("Data de Criacao: " + formataData(treino.getDataCriacao()));
                System.out.println("Data de Modificacao: " + formataData(treino.getDataModificacao()));
                System.out.println("------------------------");
            }
        }
    }

    public static void mostrarTreinoMenu(Treino treino) {
        System.out.println("\n***** TREINO *****\n");

        System.out.println("ID do Treino: " + treino.getId());
        System.out.println("ID do Aluno: " + treino.getPessoa().getId());
        System.out.println("Nome do Aluno: " + treino.getPessoa().getNome());
        System.out.println("Tipo de Usuario do Aluno: " + treino.getPessoa().getTipoUsuario());
        System.out.println("Objetivo do Treino: " + treino.getObjetivo());
        System.out.println("Data de Inicio: " + formataData(treino.getDataInicio()));
        System.out.println("Data de Termino: " + formataData(treino.getDataTermino()));
        System.out.println("ID da Divisao de Treino: " + treino.getDivisaoTreino().getId());
        System.out.println("Nome da Divisao de Treino: " + treino.getDivisaoTreino().getNome());
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
        ArrayList<DivisaoTreino> divisoesTreino = divisaoTreinoDAO.mostrarDivisoesTreino();
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
    public static int treinoAplicacaoMenu() {
        System.out.println("***********************************");
        System.out.println("*   SISTEMA DE TREINO APLICACAO   *");
        System.out.println("***********************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar Treino Aplicacao\n");
        System.out.println("2 - Mostrar Todos os Treinos Aplicacao\n");
        System.out.println("3 - Remover Treino Aplicacao\n");
        System.out.println("4 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static String[] adicionarTreinoAplicacaoMenu(TreinoAplicacaoDAO treinoAplicacaoDAO, DivisaoTreinoDAO divisaoTreinoDAO, TreinoDAO treinoDAO, ExercicioDAO exercicioDAO, ExercicioAplicacaoDAO exercicioAplicacaoDAO, DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO) {
        System.out.println("Informe o ID do usuario: ");
        int usuarioId = Integer.parseInt(scanner.nextLine());

        ArrayList<DivisaoTreino> divisoesTreino = divisaoTreinoDAO.mostrarDivisoesTreino();
        mostrarTodasDivisoesTreinoMenu(divisoesTreino);

        System.out.println("Informe o ID da divisao de treino escolhida: ");
        int divisaoTreinoId = Integer.parseInt(scanner.nextLine());
        DivisaoTreino divisaoTreino = divisaoTreinoDAO.buscarDivisaoTreino(divisaoTreinoId);

        if (divisaoTreino == null) {
            System.out.println("Divisao de treino nao encontrada.");
            return new String[0];
        }

        ArrayList<Treino> treinos = treinoDAO.mostrarTreinos();
        for (Treino treino : treinos) {
            System.out.println("ID do Treino: " + treino.getId() + " - Objetivo: " + treino.getObjetivo());
        }
        System.out.println("Informe o ID do treino escolhido: ");
        int treinoId = Integer.parseInt(scanner.nextLine());
        Treino treino = treinoDAO.buscarTreino(treinoId);

        if (treino == null) {
            System.out.println("Treino nao encontrado.");
            return new String[0];
        }

        System.out.println("Informe o ID da divisao de treino musculo escolhida: ");
        int divisaoTreinoMusculoId = Integer.parseInt(scanner.nextLine());
        DivisaoTreinoMusculo divisaoTreinoMusculo = divisaoTreinoMusculoDAO.buscarDivisaoTreinoMusculo(divisaoTreinoMusculoId);

        if (divisaoTreinoMusculo == null) {
            System.out.println("Divisao de treino musculo nao encontrada.");
            return new String[0];
        }

        String[] nomesExercicios = new String[100];
        String[] tiposExercicios = divisaoTreino.getNome().split("");
        int index = 0;

        for (String tipoExercicio : tiposExercicios) {
            System.out.println("Quantos exercicios deseja para " + tipoExercicio + "?");
            int numExercicios = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numExercicios; i++) {
                System.out.println("Informe o nome do exercicio " + (i + 1) + " para " + tipoExercicio + ": ");
                String nomeExercicio = scanner.nextLine();
                nomesExercicios[index++] = nomeExercicio;
                Exercicio exercicio = exercicioDAO.buscarExercicioPorNome(nomeExercicio);

                if (exercicio != null) {
                    ExercicioAplicacao exercicioAplicacao = exercicioAplicacaoDAO.buscarExercicioAplicacao(exercicio.getId());
                    if (exercicioAplicacao != null) {
                        LocalDate dataAtual = LocalDate.now();
                        TreinoAplicacao treinoAplicacao = new TreinoAplicacao(0, usuarioId, treino, exercicio, exercicioAplicacao, divisaoTreino, divisaoTreinoMusculo, dataAtual, dataAtual);
                        treinoAplicacaoDAO.adicionarTreinoAplicacao(treinoAplicacao, dataAtual); 
                    } else {
                        System.out.println("Exercicio aplicacao nao encontrado.");
                    }
                } else {
                    System.out.println("Exercicio nao encontrado.");
                }
            }
        }
        return nomesExercicios;
    }

    public static void mostrarTreinoAplicacaoMenu(TreinoAplicacaoDAO treinoAplicacaoDAO, TreinoDAO treinoDAO, DivisaoTreinoDAO divisaoTreinoDAO, DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO) {
        System.out.println("Informe o ID do usuario: ");
        int usuarioId = Integer.parseInt(scanner.nextLine());
        
        ArrayList<TreinoAplicacao> treinoAplicacoesUsuario = treinoAplicacaoDAO.listarTodosPorUsuario(usuarioId);

        if (treinoAplicacoesUsuario.isEmpty()) {
            System.out.println("Nenhuma ficha de treino encontrada para este usuario.");
            return;
        }

        System.out.println("\n***** FICHA DE TREINO DO USUARIO *****");
        System.out.println("*****        TASMANIAN GYM         *****\n");

        for (TreinoAplicacao treinoAplicacao : treinoAplicacoesUsuario) {

            DivisaoTreinoMusculo divisaoTreinoMusculo = divisaoTreinoMusculoDAO.buscarPrimeiraDivisaoTreinoMusculoPorAluno(treinoAplicacao.getId());
            if (divisaoTreinoMusculo != null) {
                System.out.println("ID da Ficha de Treino: " + treinoAplicacao.getId());
                System.out.println("ID do Usuario: " + treinoAplicacao.getUsuarioId());

                Treino treino = treinoDAO.buscarTreino(treinoAplicacao.getTreino().getId());

                if (treino != null) {
                    System.out.println("Divisao de Treino: " + treinoAplicacao.getDivisaoTreino().getNome());
                    System.out.println("Objetivo do Treino: " + treino.getObjetivo());
                    System.out.println("Data de Inicio do Treino: " + formataData(treino.getDataInicio()));
                    System.out.println("Data de Termino do Treino: " + formataData(treino.getDataTermino()));

                    mostrarDivisaoTreinoMusculoMenu(divisaoTreinoMusculo);

                    System.out.println("Data de Criacao: " + formataData(treinoAplicacao.getDataCriacao()));
                    System.out.println("Data de Modificacao: " + formataData(treinoAplicacao.getDataModificacao()));

                } else {
                    System.out.println("Treino nao encontrado para este usuario.");
                }

                System.out.println("------------------------");
            }
        }
    }

    public static void removerTreinoAplicacaoMenu(TreinoAplicacaoDAO treinoAplicacaoDAO) {
        System.out.println("Informe o ID da ficha de treino que deseja remover: ");
        int id = Integer.parseInt(scanner.nextLine());
        TreinoAplicacao treinoAplicacao = treinoAplicacaoDAO.buscarTreinoAplicacao(id);

        if (treinoAplicacao != null) {
            treinoAplicacaoDAO.removerTreinoAplicacao(id);
            System.out.println("Ficha de treino removida com sucesso.");
        } else {
            System.out.println("Ficha de treino nao encontrada.");
        }
    }

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

    public static AvaliacaoFisica calcularIMC(PessoaDAO pessoaDAO, TreinoDAO treinoDAO) {
        System.out.println("\n*****  REALIZAR AVALIACAO FISICA  *****\n");

        System.out.println("Digite seu nome para buscar seus dados:");
        String nomePessoa = scanner.nextLine();
        ArrayList<Pessoa> pessoas = pessoaDAO.mostrarPessoas();

        Pessoa pessoaEncontrada = null;
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomePessoa)) {
                pessoaEncontrada = pessoa;
                break;
            }
        }

        if (pessoaEncontrada != null) {
            System.out.println("Pessoa encontrada:");
            System.out.println("ID: " + pessoaEncontrada.getId());
            System.out.println("Nome: " + pessoaEncontrada.getNome());
            System.out.println("Tipo de Usuario: " + pessoaEncontrada.getTipoUsuario());

            Treino ultimoTreino = null;
            ArrayList<Treino> treinos = treinoDAO.mostrarTreinos();
            for (Treino treino : treinos) {
                if (treino.getPessoa().getId() == pessoaEncontrada.getId()) {
                    ultimoTreino = treino;
                    break;
                }
            }

            if (ultimoTreino != null) {
                System.out.println("Ultimo treino encontrado:");
                System.out.println("Data de Inicio: " + formataData(ultimoTreino.getDataInicio()));
                System.out.println("Data de Termino: " + formataData(ultimoTreino.getDataTermino()));

                System.out.println("Digite o peso (kg):");
                double peso = Double.parseDouble(scanner.nextLine());

                System.out.println("Digite a altura (m):");
                double altura = Double.parseDouble(scanner.nextLine());

                System.out.println("Digite o indice de satisfacao com o seu resultado (0 a 10):");
                int indiceSatisfacao = Integer.parseInt(scanner.nextLine());

                LocalDate dataAtual = LocalDate.now();
                AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica(0, pessoaEncontrada, ultimoTreino, peso, altura, indiceSatisfacao);
                avaliacaoFisica.setDataCriacao(dataAtual);
                avaliacaoFisica.setDataModificacao(dataAtual);

                DecimalFormat df = new DecimalFormat("#.00");
                String imcFormatado = df.format(avaliacaoFisica.getImc());
                System.out.println("\nIndice de Massa Corporal(IMC): " + imcFormatado);

                System.out.println("\nInforme sua idade para visualizar Tabela do IMC: ");
                int idade = Integer.parseInt(scanner.nextLine());
                mostrarTabelaIMC(idade);

                return avaliacaoFisica;
            } else {
                System.out.println("Nenhum treino foi encontrado para voce.");
                return null;
            }
        } else {
            System.out.println("Pessoa nao encontrada.");
            return null;
        }
    }

    private static void mostrarTabelaIMC(int idade) {
        System.out.println("\n*****  TABELA DE IMC  *****\n");
        if (idade < 18) {
            System.out.println("Para menores de 18 anos:");
            System.out.println("Baixo peso: IMC < 18.5");
            System.out.println("Peso normal: IMC entre 18.5 e 24.9");
            System.out.println("Sobrepeso: IMC entre 25 e 29.9");
            System.out.println("Obesidade: IMC >= 30");
        } else if (idade <= 64) {
            System.out.println("Para adultos entre 18 e 64 anos:");
            System.out.println("Baixo peso: IMC < 18.5");
            System.out.println("Peso normal: IMC entre 18.5 e 24.9");
            System.out.println("Sobrepeso: IMC entre 25 e 29.9");
            System.out.println("Obesidade Grau I: IMC entre 30 e 34.9");
            System.out.println("Obesidade Grau II: IMC entre 35 e 39.9");
            System.out.println("Obesidade Grau III: IMC >= 40");
        } else {
            System.out.println("Para idosos com 65 anos ou mais:");
            System.out.println("Baixo peso: IMC < 22");
            System.out.println("Peso normal: IMC entre 22 e 27");
            System.out.println("Sobrepeso: IMC > 27");
        }
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

        Mensalidade mensalidade = new Mensalidade(0, descricao, valor, dataInicio, dataFim, meses, dataInicio, dataInicio);
        return mensalidade;
    }

    public static void mostrarTodasMensalidadesMenu(ArrayList<Mensalidade> mensalidades) {
        System.out.println("\n*****  TODAS AS MENSALIDADES  *****\n");
        System.out.println("------------------------");

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
        Mensalidade novaMensalidade = new Mensalidade(id, novaDescricao, novoValor, mensalidade.getDataInicio(), dataFim, novosMeses, mensalidade.getDataCriacao(), dataAtualizacao);
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
        System.out.println("Digite a modalidade \n 1 - Pix \n 2 - Pagamento Recorrente \n 3 - Dinheiro \n 4 - Debito: ");
        int modalidadeNumero = Integer.parseInt(scanner.nextLine());

        String modalidade;

        switch (modalidadeNumero) {
            case 2 ->
                modalidade = "Pagamento Recorrente";
            case 3 ->
                modalidade = "Dinheiro";
            case 4 ->
                modalidade = "Debito";
            default -> {
                modalidade = "Pix";
            }
        }

        LocalDate dataAtual = LocalDate.now();

        MensalidadeAluno mensalidadeAluno = new MensalidadeAluno(0, idAluno, idMensalidade, dataAtual, dataAtual, 0.0, modalidade, dataAtual, dataAtual);
        return mensalidadeAluno;
    }

    public static void mostrarMensalidadeAlunoMenu(MensalidadeAluno mensalidadeAluno, ArrayList<Pessoa> alunos, ArrayList<Mensalidade> mensalidades) {
        System.out.println("\n*****  MENSALIDADE ALUNO  *****\n");
        System.out.println("ID Associacao: " + mensalidadeAluno.getId());
        System.out.println("ID Aluno: " + mensalidadeAluno.getIdAluno());
        System.out.println("Nome do Aluno: " + alunos.get(mensalidadeAluno.getIdAluno() - 1).getNome());
        System.out.println("ID Mensalidade: " + mensalidadeAluno.getIdMensalidade());
        System.out.println("Descricao da mensalidade: " + mensalidades.get(mensalidadeAluno.getIdMensalidade() - 1).getDescricao());
        System.out.println("Data de Criacao: " + formataData(mensalidadeAluno.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(mensalidadeAluno.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static void mostrarTodasMensalidadesAlunoMenu(ArrayList<MensalidadeAluno> mensalidadesAlunos, ArrayList<Pessoa> alunos, ArrayList<Mensalidade> mensalidades) {
        System.out.println("\n*****  TODAS AS MENSALIDADES DOS ALUNOS  *****\n");
        for (MensalidadeAluno mensalidadeAluno : mensalidadesAlunos) {
            System.out.println("ID Associacao: " + mensalidadeAluno.getId());
            System.out.println("ID Aluno: " + mensalidadeAluno.getIdAluno());
            System.out.println("Nome do Aluno: " + alunos.get(mensalidadeAluno.getIdAluno() - 1).getNome());
            System.out.println("ID Mensalidade: " + mensalidadeAluno.getIdMensalidade());
            System.out.println("Descricao da Mensalidade: " + mensalidades.get(mensalidadeAluno.getIdMensalidade() - 1).getDescricao());
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
    public static int pagamentoRecorrenteMenu() {
        System.out.println("*******************************");
        System.out.println("*   SISTEMA DE PAGAMENTOS     *");
        System.out.println("*        RECORRENTES          *");
        System.out.println("*******************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Adicionar pagamento recorrente\n");
        System.out.println("2 - Mostrar todos os pagamentos recorrentes\n");
        System.out.println("3 - Alterar pagamento recorrente\n");
        System.out.println("4 - Buscar pagamento recorrente\n");
        System.out.println("5 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static PagamentoRecorrente adicionarPagamentoRecorrenteMenu() {
        System.out.println("\n*****  ADICIONAR PAGAMENTO RECORRENTE  ******\n");
        System.out.println("Digite o ID da mensalidade do aluno: ");
        int idMensalidadeAluno = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o ID da pessoa: ");
        int idPessoa = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o token do cartao de credito: ");
        String cartaoDeCredito = scanner.nextLine();

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataDeInicio = dataAtual;
        PagamentoRecorrente pagamentoRecorrente = new PagamentoRecorrente(0, idPessoa, idMensalidadeAluno, dataAtual, cartaoDeCredito, 0.0, dataDeInicio, 0, dataAtual, dataAtual);
        return pagamentoRecorrente;
    }

    public static void mostrarTodosPagamentosRecorrentesMenu(ArrayList<PagamentoRecorrente> pagamentos, ArrayList<Pessoa> pessoas) {
        System.out.println("\n*****  TODOS OS PAGAMENTOS RECORRENTES  *****\n");
        System.out.println("------------------------");

        for (PagamentoRecorrente pagamento : pagamentos) {
            System.out.println("ID: " + pagamento.getId());
            System.out.println("ID Pessoa: " + pagamento.getIdPessoa());
            System.out.println("Nome da Pessoa: " + pessoas.get(pagamento.getIdPessoa() - 1).getNome());
            System.out.println("Cartao de Credito: " + pagamento.getCartaoDeCredito());
            System.out.println("Valor: R$ " + pagamento.getValor());
            System.out.println("Data de Inicio: " + formataData(pagamento.getDataDeInicio()));
            System.out.println("Numero de Meses Autorizados: " + pagamento.getNumeroDeMeses());
            System.out.println("Data de Criacao: " + formataData(pagamento.getDataCriacao()));
            System.out.println("Data de Modificacao: " + formataData(pagamento.getDataModificacao()));
            System.out.println("------------------------");
        }
    }

    public static void mostrarPagamentoRecorrenteMenu(PagamentoRecorrente pagamento, ArrayList<Pessoa> pessoas) {
        System.out.println("\n*****  PAGAMENTO RECORRENTE  *****\n");
        System.out.println("ID: " + pagamento.getId());
        System.out.println("ID Pessoa: " + pagamento.getIdPessoa());
        System.out.println("Nome da Pessoa: " + pessoas.get(pagamento.getIdPessoa() - 1).getNome());
        System.out.println("Cartao de Credito: " + pagamento.getCartaoDeCredito());
        System.out.println("Valor: R$ " + pagamento.getValor());
        System.out.println("Data de Inicio: " + formataData(pagamento.getDataDeInicio()));
        System.out.println("Numero de Meses Autorizados: " + pagamento.getNumeroDeMeses());
        System.out.println("Data de Criacao: " + formataData(pagamento.getDataCriacao()));
        System.out.println("Data de Modificacao: " + formataData(pagamento.getDataModificacao()));
        System.out.println("------------------------");
    }

    public static PagamentoRecorrente alterarPagamentoRecorrenteMenu(int id, PagamentoRecorrente pagamentoRecorrente) {
        System.out.println("\n*****  ALTERAR PAGAMENTO RECORRENTE  *****\n");
        System.out.println("Digite o novo ID da mensalidade do aluno: ");
        int novoIdMensalidadeAluno = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o novo ID da pessoa: ");
        int novoIdPessoa = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o novo token do cartao de credito: ");
        String novoCartaoDeCredito = scanner.nextLine();

        LocalDate dataAtual = LocalDate.now();
        LocalDate novaDataDeInicio = dataAtual;
        PagamentoRecorrente novoPagamentoRecorrente = new PagamentoRecorrente(id, novoIdPessoa, novoIdMensalidadeAluno, dataAtual, novoCartaoDeCredito, 0.0, novaDataDeInicio, 0, pagamentoRecorrente.getDataCriacao(), dataAtual);
        return novoPagamentoRecorrente;
    }

    public static int buscarPagamentoRecorrenteMenu(String modo) {
        System.out.println("Digite o ID do pagamento recorrente que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    //CALENDARIO
    public static int calendarioMenu(Calendario calendario) {
        System.out.println("*******************************");
        System.out.println("*        CALENDARIO           *");
        System.out.println("*     DATA ATUAL: " + formataData(calendario.getDataAtual()) + "  *");
        System.out.println("*******************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Avancar dia no calendario\n");
        System.out.println("2 - Diminuir dia no calendario\n");
        System.out.println("3 - Sair\n");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static void avancarCalendarioMenu() {
        System.out.println("Dia do calendario avancado com sucesso!: \n");
    }

    public static void diminuirCalendarioMenu() {
        System.out.println("Dia do calendario diminuido com sucesso! \n");
    }

    // ENTRADA ALUNOS
    public static int entradaAlunoMenu() {
        System.out.println("*****************************************");
        System.out.println("*       SISTEMA DE ENTRADA DE ALUNOS    *");
        System.out.println("*****************************************\n");
        System.out.println("Escolha uma opcao:\n");
        System.out.println("1 - Fazer entrada de aluno");
        System.out.println("2 - Sair");
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    // RELATORIOS
    public static int relatoriosMenu(String tipoUsuarioLogado) {
        System.out.println("*******************************");
        System.out.println("*        RELATORIOS           *");
        System.out.println("*******************************\n");
        System.out.println("Escolha uma opcao:\n");
        if (tipoUsuarioLogado.equals("Admin")) {
            System.out.println("1 - Relatorio com toda a movimentacao financeira da academia em um dado mes\n");
            System.out.println("2 - Ficha de treino do aluno\n");
            System.out.println("3 - Sair\n");
        } else {
            System.out.println("1 - Ficha de treino do aluno\n");
            System.out.println("2 - Sair\n");
        }
        System.out.println("\nDigite a opcao escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static int[] relatorioMovimentacao() {
        System.out.println("Digite o numero do mes desejado (1 a 12):");
        int mes = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o ano desejado:");
        int ano = Integer.parseInt(scanner.nextLine());

        int mesAno[] = {mes, ano};
        return mesAno;
    }

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
