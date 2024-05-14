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
        System.out.println("1 - Academias\n");
        System.out.println("2 - Pessoas\n");
        System.out.println("3 - Exercicios\n");
        System.out.println("4 - Aplicação de Exercicios\n");
        System.out.println("5 - Divisão de Treino\n");
        System.out.println("6 - Divisão de Treino-Músculo\n");
        System.out.println("7 - Treino\n");
        System.out.println("8 - Treino Aplicação\n");
        System.out.println("9 - Avaliação Física\n");
        System.out.println("10 - Mensalidades\n");
        System.out.println("11 - Mensalidade Aluno\n");
        System.out.println("12 - Pagamento Recorrente\n");
        System.out.println("13 - Entrada Aluno\n");
        System.out.println("14 - Movimentação Financeira\n");
        System.out.println("15 - Fechar\n");
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

    // DIVISÃO TREINO-MUSCULO
    public static int divisaoTreinoMusculoMenu() {
        System.out.println("======SISTEMA DE GERENCIAMENTO DE DIVISÕES DE TREINO-MÚSCULO======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Adicionar divisão de treino-músculo\n");
        System.out.println("2 - Mostrar todas as divisões de treino-músculo\n");
        System.out.println("3 - Alterar divisão de treino-músculo\n");
        System.out.println("4 - Buscar divisão de treino-músculo\n");
        System.out.println("5 - Remover divisão de treino-músculo\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static DivisaoTreinoMusculo adicionarDivisaoTreinoMusculoMenu(DivisaoTreinoDAO divisaoTreinoDAO) {
        System.out.println("Digite o ID da divisão de treino associada à divisão de treino-músculo: ");
        int idDivisaoTreino = Integer.parseInt(scanner.nextLine());
        DivisaoTreino divisaoTreino = divisaoTreinoDAO.buscarDivisaoTreino(idDivisaoTreino);

        if (divisaoTreino != null) {
            System.out.println("Divisão de Treino associada encontrada:");
            System.out.println("ID: " + divisaoTreino.getId());
            System.out.println("Nome da Divisão: " + divisaoTreino.getNome());
            System.out.println("Descrição da Divisão: " + divisaoTreino.getDescricao());

            System.out.println("\nDigite a descrição da divisão de treino-músculo: ");
            String descricao = scanner.nextLine();

            LocalDate dataAtual = LocalDate.now();
            DivisaoTreinoMusculo divisaoTreinoMusculo = new DivisaoTreinoMusculo(0, descricao, divisaoTreino.getNome(), dataAtual, dataAtual);
            return divisaoTreinoMusculo;
        } else {
            System.out.println("Divisão de Treino associada não encontrada.");
            return null;
        }
    }

    public static void mostrarTodasDivisoesTreinoMusculoMenu(DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO) {
        System.out.println("------------------------");

        DivisaoTreinoMusculo[] divisoesTreinoMusculo = divisaoTreinoMusculoDAO.mostrarDivisoesTreinoMusculo();

        for (DivisaoTreinoMusculo divisaoTreinoMusculo : divisoesTreinoMusculo) {
            System.out.println("ID: " + divisaoTreinoMusculo.getId());
            System.out.println("Descrição da Divisão: " + divisaoTreinoMusculo.getDescricao());
            System.out.println("Divisão de Treino: " + divisaoTreinoMusculo.getDivisaoTreino());
            System.out.println("Data de Criação: " + divisaoTreinoMusculo.getDataCriacao());
            System.out.println("Data de Modificação: " + divisaoTreinoMusculo.getDataModificacao());
            System.out.println("------------------------");
        }
    }

    public static void mostrarDivisaoTreinoMusculoMenu(DivisaoTreinoMusculo divisaoTreinoMusculo) {
        System.out.println("ID: " + divisaoTreinoMusculo.getId());
        System.out.println("Descrição da Divisão: " + divisaoTreinoMusculo.getDescricao());
        System.out.println("Divisão de Treino: " + divisaoTreinoMusculo.getDivisaoTreino());
        System.out.println("Data de Criação: " + divisaoTreinoMusculo.getDataCriacao());
        System.out.println("Data de Modificação: " + divisaoTreinoMusculo.getDataModificacao());
        System.out.println("------------------------");
    }

    public static int buscarDivisaoTreinoMusculoMenu(String modo) {
        System.out.println("Digite o ID da divisão de treino-músculo que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static DivisaoTreinoMusculo alterarDivisaoTreinoMusculoMenu(int id, DivisaoTreinoMusculo divisaoTreinoMusculo) {
        System.out.println("Digite a nova descrição da divisão de treino-músculo:");
        String novaDescricao = scanner.nextLine();
        System.out.println("Digite a nova divisão de treino da divisão de treino-músculo:");
        String novaDivisaoTreino = scanner.nextLine();
        LocalDate dataAtualizacao = LocalDate.now();
        DivisaoTreinoMusculo novaDivisaoTreinoMusculo = new DivisaoTreinoMusculo(id, novaDescricao, novaDivisaoTreino, divisaoTreinoMusculo.getDataCriacao(), dataAtualizacao);
        return novaDivisaoTreinoMusculo;
    }

    // TREINO
    /*
    public static int treinoMenu() {
        System.out.println("======SISTEMA DE GERENCIAMENTO DE TREINOS======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Adicionar treino\n");
        System.out.println("2 - Mostrar todos os treinos\n");
        System.out.println("3 - Mostrar treino específico\n");
        System.out.println("4 - Buscar treino\n");
        System.out.println("5 - Alterar treino\n");
        System.out.println("6 - Remover treino\n");
        System.out.println("7 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static Treino adicionarTreinoMenu(TreinoDAO treinoDAO, DivisaoTreinoDAO divisaoTreinoDAO, PessoaDAO pessoaDAO) {
        System.out.println("======ADICIONAR TREINO======\n");

        System.out.println("Pessoas existentes com tipo de usuário 'Aluno':");
        Pessoa[] pessoas = pessoaDAO.buscarPessoasPorTipo("Aluno");
        for (Pessoa pessoa : pessoas) {
            System.out.println("ID: " + pessoa.getId() + ", Nome: " + pessoa.getNome() + ", Tipo de Usuário: " + pessoa.getTipoUsuario());
        }

        System.out.println("Digite o ID do aluno para associar ao treino:");
        int idAluno = Integer.parseInt(scanner.nextLine());
        Pessoa aluno = pessoaDAO.buscarPessoaPorId(idAluno);

        if (aluno != null && aluno.getTipoUsuario().equals("Aluno")) {
            System.out.println("Aluno encontrado:");
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Tipo de Usuário: " + aluno.getTipoUsuario());

            System.out.println("Digite o objetivo do treino:");
            String objetivo = scanner.nextLine();

            System.out.println("Digite a data de início do treino (no formato yyyy-MM-dd):");
            LocalDate dataInicio = LocalDate.parse(scanner.nextLine());

            System.out.println("Digite a data de término do treino (no formato yyyy-MM-dd):");
            LocalDate dataTermino = LocalDate.parse(scanner.nextLine());

            System.out.println("Divisões de treino existentes:");
            DivisaoTreino[] divisoesTreino = divisaoTreinoDAO.mostrarDivisoesTreino();
            for (DivisaoTreino divisaoTreino : divisoesTreino) {
                System.out.println("ID: " + divisaoTreino.getId() + ", Nome: " + divisaoTreino.getNome() + ", Descrição: " + divisaoTreino.getDescricao());
            }

            System.out.println("Digite o ID da divisão de treino desejada:");
            int idDivisaoTreino = Integer.parseInt(scanner.nextLine());
            DivisaoTreino divisaoTreino = divisaoTreinoDAO.buscarDivisaoTreino(idDivisaoTreino);

            if (divisaoTreino != null) {
                LocalDate dataAtual = LocalDate.now();
                Treino treino = new Treino(0, aluno.getId(), aluno.getNome(), aluno.getTipoUsuario(), objetivo, dataInicio, dataTermino, divisaoTreino.getId(), divisaoTreino.getNome(), dataAtual, dataAtual);
                return treino;
            } else {
                System.out.println("Divisão de Treino não encontrada.");
                return null;
            }
        } else {
            System.out.println("Aluno não encontrado ou não é do tipo 'Aluno'.");
            return null;
        }
    }

    public static void mostrarTodosTreinosMenu(TreinoDAO treinoDAO) {
        System.out.println("======TODOS OS TREINOS======\n");

        Treino[] treinos = treinoDAO.mostrarTreinos();

        for (Treino treino : treinos) {
            System.out.println("ID: " + treino.getId());
            System.out.println("ID do Aluno: " + treino.getIdAluno());
            System.out.println("Nome do Aluno: " + treino.getNomeAluno());
            System.out.println("Tipo de Usuário do Aluno: " + treino.getTipoUsuarioAluno());
            System.out.println("Objetivo do Treino: " + treino.getObjetivo());
            System.out.println("Data de Início: " + treino.getDataInicio());
            System.out.println("Data de Término: " + treino.getDataTermino());
            System.out.println("ID da Divisão de Treino: " + treino.getIdDivisaoTreino());
            System.out.println("Nome da Divisão de Treino: " + treino.getNomeDivisaoTreino());
            System.out.println("Data de Criação: " + treino.getDataCriacao());
            System.out.println("Data de Modificação: " + treino.getDataModificacao());
            System.out.println("------------------------");
        }
    }

    public static void mostrarTreinoMenu(Treino treino) {
        System.out.println("======TREINO======\n");

        System.out.println("ID: " + treino.getId());
        System.out.println("ID do Aluno: " + treino.getIdAluno());
        System.out.println("Nome do Aluno: " + treino.getNomeAluno());
        System.out.println("Tipo de Usuário do Aluno: " + treino.getTipoUsuarioAluno());
        System.out.println("Objetivo do Treino: " + treino.getObjetivo());
        System.out.println("Data de Início: " + treino.getDataInicio());
        System.out.println("Data de Término: " + treino.getDataTermino());
        System.out.println("ID da Divisão de Treino: " + treino.getIdDivisaoTreino());
        System.out.println("Nome da Divisão de Treino: " + treino.getNomeDivisaoTreino());
        System.out.println("Data de Criação: " + treino.getDataCriacao());
        System.out.println("Data de Modificação: " + treino.getDataModificacao());
        System.out.println("------------------------");
    }

    public static int buscarTreinoMenu(String modo) {
        System.out.println("======BUSCAR TREINO======\n");
        System.out.println("Digite o ID do treino que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static Treino alterarTreinoMenu(int id, Treino treino, DivisaoTreinoDAO divisaoTreinoDAO) {
        System.out.println("Digite o novo objetivo do treino:");
        String novoObjetivo = scanner.nextLine();
        System.out.println("Digite a nova data de início do treino (no formato yyyy-MM-dd):");
        LocalDate novaDataInicio = LocalDate.parse(scanner.nextLine());

        System.out.println("Digite a nova data de término do treino (no formato yyyy-MM-dd):");
        LocalDate novaDataTermino = LocalDate.parse(scanner.nextLine());

        System.out.println("Divisões de treino existentes:");
        DivisaoTreino[] divisoesTreino = divisaoTreinoDAO.mostrarDivisoesTreino();
        for (DivisaoTreino divisaoTreino : divisoesTreino) {
            System.out.println("ID: " + divisaoTreino.getId() + ", Nome: " + divisaoTreino.getNome() + ", Descrição: " + divisaoTreino.getDescricao());
        }

        System.out.println("Digite o ID da nova divisão de treino:");
        int idNovaDivisaoTreino = Integer.parseInt(scanner.nextLine());
        DivisaoTreino novaDivisaoTreino = divisaoTreinoDAO.buscarDivisaoTreino(idNovaDivisaoTreino);

        if (novaDivisaoTreino != null) {
            LocalDate dataAtualizacao = LocalDate.now();
            Treino novoTreino = new Treino(id, treino.getIdAluno(), treino.getNomeAluno(), treino.getTipoUsuarioAluno(), novoObjetivo, novaDataInicio, novaDataTermino, novaDivisaoTreino.getId(), novaDivisaoTreino.getNome(), treino.getDataCriacao(), dataAtualizacao);
            return novoTreino;
        } else {
            System.out.println("Divisão de Treino não encontrada.");
            return null;
        }
*/

    
    // TREINO APLICAÇÃO
    // MENSALIDADE
    public static int mensalidadeMenu() {
        System.out.println("======SISTEMA DE GERENCIAMENTO DE MENSALIDADES======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Adicionar mensalidade\n");
        System.out.println("2 - Mostrar todas as mensalidades\n");
        System.out.println("3 - Alterar mensalidade\n");
        System.out.println("4 - Buscar mensalidade\n");
        System.out.println("5 - Remover mensalidade\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static Mensalidade adicionarMensalidadeMenu() {
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
        System.out.println("------------------------");

        Mensalidade[] mensalidades = mensalidadeDAO.mostrarMensalidades();

        for (Mensalidade mensalidade : mensalidades) {
            System.out.println("ID: " + mensalidade.getId());
            System.out.println("Valor: R$ " + mensalidade.getValor());
            System.out.println("Data de Início: " + mensalidade.getDataInicio());
            System.out.println("Data de Fim: " + mensalidade.getDataFim());
            System.out.println("Data de Criação: " + mensalidade.getDataCriacao());
            System.out.println("Data de Modificação: " + mensalidade.getDataModificacao());
            System.out.println("------------------------");
        }
    }

    public static void mostrarMensalidadeMenu(Mensalidade mensalidade) {
        System.out.println("ID: " + mensalidade.getId());
        System.out.println("Valor: R$ " + mensalidade.getValor());
        System.out.println("Data de Início: " + mensalidade.getDataInicio());
        System.out.println("Data de Fim: " + mensalidade.getDataFim());
        System.out.println("Data de Criação: " + mensalidade.getDataCriacao());
        System.out.println("Data de Modificação: " + mensalidade.getDataModificacao());
        System.out.println("------------------------");
    }

    public static int buscarMensalidadeMenu(String modo) {
        System.out.println("Digite o ID da mensalidade que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static Mensalidade alterarMensalidadeMenu(int id, Mensalidade mensalidade) {
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
        System.out.println("======SISTEMA DE GERENCIAMENTO DE MENSALIDADES DE ALUNOS======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Associar mensalidade a um aluno\n");
        System.out.println("2 - Mostrar todas as mensalidades de alunos\n");
        System.out.println("3 - Alterar associação de mensalidade-aluno\n");
        System.out.println("4 - Buscar associação de mensalidade-aluno\n");
        System.out.println("5 - Remover associação de mensalidade-aluno\n");
        System.out.println("6 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static MensalidadeAluno associarMensalidadeAlunoMenu() {
        System.out.println("Digite o ID do aluno: ");
        int idAluno = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o ID da mensalidade: ");
        int idMensalidade = Integer.parseInt(scanner.nextLine());

        LocalDate dataAtual = LocalDate.now();

        MensalidadeAluno mensalidadeAluno = new MensalidadeAluno(0, idMensalidade, idAluno, dataAtual, dataAtual);
        return mensalidadeAluno;
    }

    public static void mostrarMensalidadeAlunoMenu(MensalidadeAluno mensalidadeAluno) {
        System.out.println("ID Associação: " + mensalidadeAluno.getId());
        System.out.println("ID Aluno: " + mensalidadeAluno.getIdAluno());
        System.out.println("ID Mensalidade: " + mensalidadeAluno.getIdMensalidade());
        System.out.println("Data de Criação: " + mensalidadeAluno.getDataCriacao());
        System.out.println("Data de Modificação: " + mensalidadeAluno.getDataModificacao());
        System.out.println("------------------------");
    }

    public static void mostrarTodasMensalidadesAlunoMenu(MensalidadeAluno[] mensalidadesAlunos) {
        for (MensalidadeAluno mensalidadeAluno : mensalidadesAlunos) {
            System.out.println("ID Associação: " + mensalidadeAluno.getId());
            System.out.println("ID Aluno: " + mensalidadeAluno.getIdAluno());
            System.out.println("ID Mensalidade: " + mensalidadeAluno.getIdMensalidade());
            System.out.println("Data de Criação: " + mensalidadeAluno.getDataCriacao());
            System.out.println("Data de Modificação: " + mensalidadeAluno.getDataModificacao());
            System.out.println("------------------------");
        }
    }

    public static MensalidadeAluno alterarMensalidadeAlunoMenu(MensalidadeAluno mensalidadeAluno) {
        System.out.println("Digite o novo ID do aluno (atual: " + mensalidadeAluno.getIdAluno() + "): ");
        int novoIdAluno = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o novo ID da mensalidade (atual: " + mensalidadeAluno.getIdMensalidade() + "): ");
        int novoIdMensalidade = Integer.parseInt(scanner.nextLine());

        mensalidadeAluno.setIdAluno(novoIdAluno);
        mensalidadeAluno.setIdMensalidade(novoIdMensalidade);

        return mensalidadeAluno;
    }

    public static int buscarMensalidadeAlunoMenu(String modo) {
        System.out.println("Digite o ID da associação de mensalidade-aluno que deseja " + modo + ": ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    // PAGAMENTO RECORRENTE
    // ENTRADA ALUNO
    // MOVIMENTAÇÃO FINANCEIRA
    // RELATÓRIOS
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
