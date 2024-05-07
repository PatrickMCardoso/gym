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
        System.out.println("====== HealthierLifeGym ======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Sistema de Academia\n");
        System.out.println("2 - Sistema de Pessoas\n");
        System.out.println("3 - Sistema de Exercicios\n");
        System.out.println("4 - Sistema de Aplicação de Exercicios\n");
        System.out.println("5 - Sistema de Divisão de Exercícios\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    
    // ACADEMIA
    public static int academiaMenu() {
        System.out.println("======SISTEMA DE ACADEMIAS======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Adicionar academia\n");
        System.out.println("2 - Mostrar academias\n");
        System.out.println("3 - Alterar academia\n");
        System.out.println("4 - Buscar academia\n");
        System.out.println("5 - Remover academia\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static Academia adicionarAcademiaMenu() {
        System.out.println("Digite o nome da academia: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereço da academia: ");
        String endereco = scanner.nextLine();
        LocalDate dataAtual = LocalDate.now();
        Academia academia = new Academia(0, nome, endereco, dataAtual, dataAtual);
        return academia;
    }

    public static void mostrarTodasAcademiasMenu(Academia[] academias) {
        if (academias.length == 0) {
            System.out.println("Nenhuma academia cadastrada.");
        } else {
            System.out.println("------------------------");
            for (Academia academia : academias) {
                System.out.println("ID: " + academia.getId());
                System.out.println("Nome: " + academia.getNome());
                System.out.println("Endereço: " + academia.getEndereço());
                System.out.println("Data de Criação: " + academia.getDataCriacao());
                System.out.println("Data de Modificação: " + academia.getDataModificacao());
                System.out.println("------------------------");
            }
        }
    }

    public static void mostrarAcademiaMenu(Academia academia) {
        System.out.println("ID: " + academia.getId());
        System.out.println("Nome: " + academia.getNome());
        System.out.println("Endereço: " + academia.getEndereço());
        System.out.println("Data de Criação: " + academia.getDataCriacao());
        System.out.println("Data de Modificação: " + academia.getDataModificacao());
        System.out.println("------------------------");
    }

    public static int buscarAcademiaMenu(String modo) {
        System.out.println("Digite o ID da academia que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static Academia alterarAcademiaMenu(int id, Academia academiaExistente) {
        System.out.println("Digite o novo nome da academia:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite o novo endereço da academia:");
        String novoEndereco = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        Academia novaAcademia = new Academia(id, novoNome, novoEndereco, academiaExistente.getDataCriacao(), dataAtualizacao);
        return novaAcademia;
    }
    
    
    // PESSOA
    public static int pessoaMenu() {
        System.out.println("======SISTEMA DE GERENCIAMENTO DE PESSOAS======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Adicionar pessoa\n");
        System.out.println("2 - Mostrar todas as pessoas\n");
        System.out.println("3 - Alterar pessoa\n");
        System.out.println("4 - Buscar pessoa\n");
        System.out.println("5 - Remover pessoa\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static Pessoa adicionarPessoaMenu() {
        System.out.println("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o sexo da pessoa (M/F): ");
        char sexo = scanner.nextLine().charAt(0);
        System.out.println("Digite a data de nascimento (DD-MM-YYYY): ");
        LocalDate nascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Digite o login da pessoa: ");
        String login = scanner.nextLine();
        System.out.println("Digite a senha da pessoa: ");
        String senha = scanner.nextLine();
        System.out.println("Digite o tipo de usuário (1-Admin, 2-Professor, 3-Aluno):");
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
        if (pessoas.length == 0) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            System.out.println("------------------------");
            for (Pessoa pessoa : pessoas) {
                System.out.println("ID: " + pessoa.getId());
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Sexo: " + pessoa.getSexo());
                System.out.println("Data de Nascimento: " + pessoa.getNascimento());
                System.out.println("Login: " + pessoa.getLogin());
                System.out.println("Senha: " + pessoa.getSenha());
                System.out.println("Tipo de Usuário: " + pessoa.getTipoUsuario());
                System.out.println("Data de Criação: " + pessoa.getDataCriacao());
                System.out.println("Data de Modificação: " + pessoa.getDataModificacao());
                System.out.println("------------------------");
            }
        }
    }

    public static void mostrarPessoaMenu(Pessoa pessoa) {
        System.out.println("ID: " + pessoa.getId());
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Sexo: " + pessoa.getSexo());
        System.out.println("Data de Nascimento: " + pessoa.getNascimento());
        System.out.println("Login: " + pessoa.getLogin());
        System.out.println("Senha: " + pessoa.getSenha());
        System.out.println("Tipo de Usuário: " + pessoa.getTipoUsuario());
        System.out.println("Data de Criação: " + pessoa.getDataCriacao());
        System.out.println("Data de Modificação: " + pessoa.getDataModificacao());
        System.out.println("------------------------");
    }

    public static int buscarPessoaMenu(String modo) {
        System.out.println("Digite o ID da pessoa que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static Pessoa alterarPessoaMenu(int id, Pessoa pessoaExistente) {
        System.out.println("Digite o novo nome da pessoa:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite o novo sexo da pessoa (M/F):");
        char novoSexo = scanner.nextLine().charAt(0);
        System.out.println("Digite a nova data de nascimento (DD-MM-YYYY):");
        LocalDate novaDataNascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Digite o novo login da pessoa:");
        String novoLogin = scanner.nextLine();
        System.out.println("Digite a nova senha da pessoa:");
        String novaSenha = scanner.nextLine();
        System.out.println("Digite o novo tipo de usuário (1-Admin, 2-Professor, 3-Aluno):");
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
    
    
    // EXERCÍCIO
    public static int exercicioMenu() {
        System.out.println("======SISTEMA DE GERENCIAMENTO DE EXERCÍCIOS======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Adicionar exercício\n");
        System.out.println("2 - Mostrar todos os exercícios\n");
        System.out.println("3 - Alterar exercício\n");
        System.out.println("4 - Buscar exercício\n");
        System.out.println("5 - Remover exercício\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static Exercicio adicionarExerciciosMenu() {
        System.out.println("Digite o nome do exercício: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição do exercício: ");
        String descricao = scanner.nextLine();

        LocalDate dataAtual = LocalDate.now();
        Exercicio exercicio = new Exercicio(0, nome, descricao, dataAtual, dataAtual);
        return exercicio;
    }
    
    public static void mostrarTodosExerciciosMenu(Exercicio[] exercicios) {
        System.out.println("------------------------");

        for (Exercicio exercicio : exercicios) {
            System.out.println("ID: " + exercicio.getId());
            System.out.println("Nome: " + exercicio.getNome());
            System.out.println("Descrição: " + exercicio.getDescricao());
            System.out.println("Data de Criação: " + exercicio.getDataCriacao());
            System.out.println("Data de Modificação: " + exercicio.getDataModificacao());
            System.out.println("------------------------");
        }
    }

    public static void mostrarExercicioMenu(Exercicio exercicio) {
        System.out.println("ID: " + exercicio.getId());
        System.out.println("Nome: " + exercicio.getNome());
        System.out.println("Descrição: " + exercicio.getDescricao());
        System.out.println("Data de Criação: " + exercicio.getDataCriacao());
        System.out.println("Data de Modificação: " + exercicio.getDataModificacao());
        System.out.println("------------------------");
    }

    public static int buscarExercicioMenu(String modo) {
        System.out.println("Digite o ID do exercicio que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static Exercicio alterarExercicioMenu(int id, Exercicio exercicio) {
        System.out.println("Digite o novo nome do exercício:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite a nova descrição do exercício:");
        String novaDescricao = scanner.nextLine();
                LocalDate dataAtualizacao = LocalDate.now();
        Exercicio novoExercicio = new Exercicio(id, novoNome, novaDescricao, exercicio.getDataCriacao(), dataAtualizacao);
        return novoExercicio;
    }
    
    // EXERCÍCIO APLICAÇÃO
    public static int exercicioAplicacaoMenu() {
        System.out.println("======SISTEMA DE GERENCIAMENTO DE EXERCÍCIOS DE APLICAÇÃO======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Adicionar exercício de aplicação\n");
        System.out.println("2 - Mostrar todos os exercícios de aplicação\n");
        System.out.println("3 - Alterar exercício de aplicação\n");
        System.out.println("4 - Buscar exercício de aplicação\n");
        System.out.println("5 - Remover exercício de aplicação\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static ExercicioAplicacao adicionarExercicioAplicacaoMenu(int idExercicio) {
            System.out.println("Digite a descrição do exercício de aplicação: ");
            String descricao = scanner.nextLine();

            LocalDate dataAtual = LocalDate.now();
            ExercicioAplicacao exercicioAplicacao = new ExercicioAplicacao(0, idExercicio, descricao, dataAtual, dataAtual);
            return exercicioAplicacao;
    }


    public static void mostrarTodosExerciciosAplicacaoMenu(ExercicioDAO exercicioDAO, ExercicioAplicacaoDAO exercicioAplicacaoDAO) {
        System.out.println("------------------------");

        ExercicioAplicacao[] exerciciosAplicacao = exercicioAplicacaoDAO.mostrarExerciciosAplicacao();

        for (ExercicioAplicacao exercicioAplicacao : exerciciosAplicacao) {
            Exercicio exercicio = exercicioDAO.buscarExercicio(exercicioAplicacao.getIdExercicio());
            if (exercicio != null) {
                System.out.println("Nome do Exercício: " + exercicio.getNome());
                System.out.println("Descrição do Exercício: " + exercicio.getDescricao());
                System.out.println("Descrição do Exercício de Aplicação: " + exercicioAplicacao.getDescricao());
                System.out.println("Data de Criação: " + exercicioAplicacao.getDataCriacao());
                System.out.println("Data de Modificação: " + exercicioAplicacao.getDataModificacao());
                System.out.println("------------------------");
            } else {
                System.out.println("Exercício não encontrado.");
            }
        }
    }


    public static void mostrarExercicioAplicacaoMenu(ExercicioAplicacao exercicioAplicacao) {
        System.out.println("ID: " + exercicioAplicacao.getId());
        System.out.println("Descrição: " + exercicioAplicacao.getDescricao());
        System.out.println("Data de Criação: " + exercicioAplicacao.getDataCriacao());
        System.out.println("Data de Modificação: " + exercicioAplicacao.getDataModificacao());
        System.out.println("------------------------");
    }

    public static int buscarExercicioAplicacaoMenu(String modo) {
        System.out.println("Digite o ID do exercício aplicação que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static ExercicioAplicacao alterarExercicioAplicacaoMenu(int id, ExercicioAplicacao exercicioAplicacao) {
        System.out.println("Digite a nova descrição do exercício de aplicação:");
        String novaDescricao = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        ExercicioAplicacao novoExercicioAplicacao = new ExercicioAplicacao(id, exercicioAplicacao.getIdExercicio(), novaDescricao, exercicioAplicacao.getDataCriacao(), dataAtualizacao);
        return novoExercicioAplicacao;
    }

    //DIVISÃO DE TREINO
    public static int divisaoTreinoMenu() {
        System.out.println("======SISTEMA DE GERENCIAMENTO DE DIVISÕES DE TREINO======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Adicionar divisão de treino\n");
        System.out.println("2 - Mostrar todas as divisões de treino\n");
        System.out.println("3 - Alterar divisão de treino\n");
        System.out.println("4 - Buscar divisão de treino\n");
        System.out.println("5 - Remover divisão de treino\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static DivisaoTreino adicionarDivisaoTreinoMenu() {
        System.out.println("Digite o nome da divisão de treino: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição da divisão de treino: ");
        String descricao = scanner.nextLine();

        LocalDate dataAtual = LocalDate.now();
        DivisaoTreino divisaoTreino = new DivisaoTreino(0, nome, descricao, dataAtual, dataAtual);
        return divisaoTreino;
    }

    public static void mostrarTodasDivisoesTreinoMenu(DivisaoTreinoDAO divisaoTreinoDAO) {
        System.out.println("------------------------");

        DivisaoTreino[] divisoesTreino = divisaoTreinoDAO.mostrarDivisoesTreino();

        for (DivisaoTreino divisaoTreino : divisoesTreino) {
            System.out.println("ID: " + divisaoTreino.getId());
            System.out.println("Nome da Divisão: " + divisaoTreino.getNome());
            System.out.println("Descrição da Divisão: " + divisaoTreino.getDescricao());
            System.out.println("Data de Criação: " + divisaoTreino.getDataCriacao());
            System.out.println("Data de Modificação: " + divisaoTreino.getDataModificacao());
            System.out.println("------------------------");
        }
    }

    public static void mostrarDivisaoTreinoMenu(DivisaoTreino divisaoTreino) {
        System.out.println("ID: " + divisaoTreino.getId());
        System.out.println("Nome da Divisão: " + divisaoTreino.getNome());
        System.out.println("Descrição da Divisão: " + divisaoTreino.getDescricao());
        System.out.println("Data de Criação: " + divisaoTreino.getDataCriacao());
        System.out.println("Data de Modificação: " + divisaoTreino.getDataModificacao());
        System.out.println("------------------------");
    }

    public static int buscarDivisaoTreinoMenu(String modo) {
        System.out.println("Digite o ID da divisão de treino que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static DivisaoTreino alterarDivisaoTreinoMenu(int id, DivisaoTreino divisaoTreino) {
        System.out.println("Digite o novo nome da divisão de treino:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite a nova descrição da divisão de treino:");
        String novaDescricao = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        DivisaoTreino novaDivisaoTreino = new DivisaoTreino(id, novoNome, novaDescricao, divisaoTreino.getDataCriacao(), dataAtualizacao);
        return novaDivisaoTreino;
    }

    
    public static void limparTela() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

    public static void mostrarOpcaoInvalida() {
        System.out.println("Opção inválida. Por favor, tente novamente.");
    }

    public static void digitarQualquerTecla() {
        System.out.println("Aperte qualquer tecla para continuar...");
        scanner.nextLine();
    }
}
