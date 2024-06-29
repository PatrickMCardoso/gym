package gym.controller;

import gym.model.*;
import gym.view.Menus;
import gym.view.Relatorios;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Gym {

    static Scanner scanner = new Scanner(System.in);
    static AcademiaDAO academiaDAO = new AcademiaDAO();
    static PessoaDAO pessoaDAO = new PessoaDAO();
    static ExercicioDAO exercicioDAO = new ExercicioDAO();
    static ExercicioAplicacaoDAO exercicioAplicacaoDAO = new ExercicioAplicacaoDAO();
    static DivisaoTreinoDAO divisaoTreinoDAO = new DivisaoTreinoDAO();
    static DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO = new DivisaoTreinoMusculoDAO(divisaoTreinoDAO);
    static TreinoDAO treinoDAO = new TreinoDAO(pessoaDAO, divisaoTreinoDAO);
    static TreinoAplicacaoDAO treinoAplicacaoDAO = new TreinoAplicacaoDAO();
    static MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();
    static MensalidadeAlunoDAO mensalidadeAlunoDAO = new MensalidadeAlunoDAO();
    static PagamentoRecorrenteDAO pagamentoRecorrenteDAO = new PagamentoRecorrenteDAO();
    static Calendario calendario = new Calendario(LocalDate.now());
    static MovimentacaoFinanceiraDAO movimentacaoFinanceiraDAO = new MovimentacaoFinanceiraDAO();
    static EntradaAlunoDAO entradaAlunoDAO = new EntradaAlunoDAO();
    

    public static void opcaoAcademia() {
        int opcaoAcademia = 0;        
        while (opcaoAcademia != 6) {
            Menus.digitarQualquerTecla();
            opcaoAcademia = Menus.academiaMenu();
            switch (opcaoAcademia) {
                case 1: {
                    academiaDAO.adicionarAcademia(Menus.adicionarAcademiaMenu(), calendario.getDataAtual());
                }
                break;
                case 2: {
                    ArrayList<Academia> academias = academiaDAO.mostrarAcademias();
                    Menus.mostrarTodasAcademiasMenu(academias);
                }
                break;
                case 3: {
                    if (academiaDAO.mostrarAcademias().isEmpty()) {
                        System.out.println("Nenhuma academia cadastrada. Impossivel alterar.");
                    } else {
                        int id = Menus.buscarAcademiaMenu("alterar");
                        Academia academiaExistente = academiaDAO.buscarAcademia(id);
                        if (academiaExistente != null) {
                            Academia novaAcademia = Menus.alterarAcademiaMenu(id, academiaExistente);
                            academiaDAO.alterarAcademia(id, novaAcademia, calendario.getDataAtual());
                            System.out.println("Academia alterada com sucesso.");
                        } else {
                            System.out.println("Academia nao encontrada.");
                        }
                    }
                }
                break;
                case 4: {
                    int idBusca = Menus.buscarAcademiaMenu("buscar");
                    Academia academiaBuscada = academiaDAO.buscarAcademia(idBusca);
                    if (academiaBuscada != null) {
                        Menus.mostrarAcademiaMenu(academiaBuscada);
                    } else {
                        System.out.println("Academia nao encontrada.");
                    }
                }
                break;
                case 5: {
                    if (academiaDAO.mostrarAcademias().isEmpty()) {
                        System.out.println("Nenhuma academia cadastrada. Impossivel remover.");
                    } else {
                        int id = Menus.buscarAcademiaMenu("remover");
                        academiaDAO.removerAcademia(id);
                        System.out.println("Academia removida com sucesso.");
                    }
                }
                break;
                case 6:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoPessoa() {
        int opcaoPessoa = 0;
        while (opcaoPessoa != 6) {
            Menus.digitarQualquerTecla();
            opcaoPessoa = Menus.pessoaMenu();
            switch (opcaoPessoa) {
                case 1: {
                    Pessoa novaPessoa = Menus.adicionarPessoaMenu();
                    pessoaDAO.adicionarPessoa(novaPessoa, calendario.getDataAtual());
                    System.out.println("Pessoa adicionada com sucesso!");
                }
                break;
                case 2: {
                    Pessoa[] pessoas = pessoaDAO.mostrarPessoas();
                    Menus.mostrarTodasPessoasMenu(pessoas);
                }
                break;
                case 3: {
                    if (pessoaDAO.mostrarPessoas().length == 0) {
                        System.out.println("Nenhuma pessoa cadastrada. Impossivel alterar.");
                    } else {
                        int id = Menus.buscarPessoaMenu("alterar");
                        Pessoa pessoaExistente = pessoaDAO.buscarPessoa(id);
                        if (pessoaExistente != null) {
                            Pessoa novaPessoa = Menus.alterarPessoaMenu(id, pessoaExistente);
                            pessoaDAO.alterarPessoa(id, novaPessoa, calendario.getDataAtual());
                            System.out.println("Pessoa alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa nao encontrada.");
                        }
                    }
                }
                break;
                case 4: {
                    int idBusca = Menus.buscarPessoaMenu("buscar");
                    Pessoa pessoaBuscada = pessoaDAO.buscarPessoa(idBusca);
                    if (pessoaBuscada != null) {
                        Menus.mostrarPessoaMenu(pessoaBuscada);
                    } else {
                        System.out.println("Pessoa nao encontrada.");
                    }
                }
                break;
                case 5: {
                    if (pessoaDAO.mostrarPessoas().length == 0) {
                        System.out.println("Nenhuma pessoa cadastrada. Impossivel remover.");
                    } else {
                        int idRemocao = Menus.buscarPessoaMenu("remover");
                        pessoaDAO.removerPessoa(idRemocao);
                        System.out.println("Pessoa removida com sucesso.");
                    }
                }
                break;
                case 6:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoExercicio() {
        int opcaoExercicio = 0;
        while (opcaoExercicio != 6) {
            Menus.digitarQualquerTecla();
            opcaoExercicio = Menus.exercicioMenu();
            switch (opcaoExercicio) {
                case 1: {
                    Exercicio exercicio = Menus.adicionarExerciciosMenu();
                    exercicioDAO.adicionarExercicio(exercicio, calendario.getDataAtual());
                }
                break;
                case 2: {
                    Exercicio[] exercicios = exercicioDAO.mostrarExercicios();
                    Menus.mostrarTodosExerciciosMenu(exercicios);
                }
                break;
                case 3: {
                    int idAlteracao = Menus.buscarExercicioMenu("alterar");
                    Exercicio exercicioExistente = exercicioDAO.buscarExercicio(idAlteracao);
                    if (exercicioExistente != null) {
                        Exercicio novoExercicio = Menus.alterarExercicioMenu(idAlteracao, exercicioExistente);
                        exercicioDAO.alterarExercicio(idAlteracao, novoExercicio, calendario.getDataAtual());
                        System.out.println("Exercicio alterado com sucesso!");
                    } else {
                        System.out.println("Exercicio nao encontrado.");
                    }

                }
                break;
                case 4: {
                    int idBusca = Menus.buscarExercicioMenu("buscar");
                    Exercicio exercicioBuscado = exercicioDAO.buscarExercicio(idBusca);
                    if (exercicioBuscado != null) {
                        Menus.mostrarExercicioMenu(exercicioBuscado);
                    } else {
                        System.out.println("Exercicio nao encontrado.");
                    }
                }
                break;
                case 5: {
                    int idRemocao = Menus.buscarExercicioMenu("remover");
                    exercicioDAO.removerExercicio(idRemocao);
                    System.out.println("Exercicio removido com sucesso!");
                }
                break;
                case 6:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoExercicioAplicacao() {
        int opcaoExercicioAplicacao = 0;
        while (opcaoExercicioAplicacao != 6) {
            Menus.digitarQualquerTecla();
            opcaoExercicioAplicacao = Menus.exercicioAplicacaoMenu();
            switch (opcaoExercicioAplicacao) {
                case 1: {
                    System.out.println("Digite o ID do exercicio existente: ");
                    int idExercicio = Integer.parseInt(scanner.nextLine());
                    Exercicio exercicioExistente = exercicioDAO.buscarExercicio(idExercicio);
                    if (exercicioExistente != null) {
                        ExercicioAplicacao exercicioAplicacao = Menus.adicionarExercicioAplicacaoMenu(idExercicio);
                        exercicioAplicacaoDAO.adicionarExercicioAplicacao(exercicioAplicacao.getIdExercicio(), exercicioAplicacao.getDescricao(), calendario.getDataAtual());
                    } else {
                        System.out.println("Exercicio nao encontrado.");
                    }
                }
                break;
                case 2: {
                    Menus.mostrarTodosExerciciosAplicacaoMenu(exercicioDAO, exercicioAplicacaoDAO);
                }
                break;

                case 3: {
                    int idAlteracao = Menus.buscarExercicioAplicacaoMenu("alterar");
                    ExercicioAplicacao exercicioAplicacaoExistente = exercicioAplicacaoDAO.buscarExercicioAplicacao(idAlteracao);
                    if (exercicioAplicacaoExistente != null) {
                        if (exercicioDAO.buscarExercicio(exercicioAplicacaoExistente.getIdExercicio()) != null) {
                            ExercicioAplicacao novoExercicioAplicacao = Menus.alterarExercicioAplicacaoMenu(idAlteracao, exercicioAplicacaoExistente);
                            exercicioAplicacaoDAO.alterarExercicioAplicacao(idAlteracao, novoExercicioAplicacao, calendario.getDataAtual());
                            System.out.println("Exercicio aplicacao alterado com sucesso!");
                        } else {
                            System.out.println("Exercicio aplicacao alterado com sucesso!");
                        }
                    } else {
                        System.out.println("Exercicio aplicacao nao encontrado.");
                    }
                }
                break;
                case 4: {
                    int idBusca = Menus.buscarExercicioAplicacaoMenu("buscar");
                    ExercicioAplicacao exercicioAplicacaoBuscado = exercicioAplicacaoDAO.buscarExercicioAplicacao(idBusca);
                    if (exercicioAplicacaoBuscado != null) {
                        if (exercicioDAO.buscarExercicio(exercicioAplicacaoBuscado.getIdExercicio()) != null) {
                            Menus.mostrarExercicioAplicacaoMenu(exercicioAplicacaoBuscado);
                        } else {
                            System.out.println("Exercicio aplicacao nao encontrado.");
                        }
                    } else {
                        System.out.println("Exercicio aplicacao nao encontrado.");
                    }
                }
                break;
                case 5: {
                    int idRemocao = Menus.buscarExercicioAplicacaoMenu("remover");
                    ExercicioAplicacao exercicioAplicacaoBuscado = exercicioAplicacaoDAO.buscarExercicioAplicacao(idRemocao);
                    if (exercicioAplicacaoBuscado != null) {
                        if (exercicioDAO.buscarExercicio(exercicioAplicacaoBuscado.getIdExercicio()) != null) {
                            exercicioAplicacaoDAO.removerExercicioAplicacao(idRemocao);
                            System.out.println("Exercicio aplicacao removido com sucesso!");
                        } else {
                            System.out.println("Exercicio aplicacao nao encontrado.");
                        }
                    } else {
                        System.out.println("Exercicio aplicacao nao encontrado.");
                    }
                }
                break;
                case 6:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoDivisaoTreino() {
        int opcaoDivisao = 0;
        while (opcaoDivisao != 6) {
            Menus.digitarQualquerTecla();
            opcaoDivisao = Menus.divisaoTreinoMenu();
            switch (opcaoDivisao) {
                case 1: {
                    DivisaoTreino divisaoTreino = Menus.adicionarDivisaoTreinoMenu();
                    divisaoTreinoDAO.adicionarDivisaoTreino(divisaoTreino.getNome(), divisaoTreino.getDescricao(), calendario.getDataAtual());
                    System.out.println("Divisao de Treino adicionada com sucesso!");
                }
                break;
                case 2: {
                    Menus.mostrarTodasDivisoesTreinoMenu(divisaoTreinoDAO);
                }
                break;
                case 3: {
                    int idAlteracao = Menus.buscarDivisaoTreinoMenu("alterar");
                    DivisaoTreino divisaoTreinoExistente = divisaoTreinoDAO.buscarDivisaoTreino(idAlteracao);
                    if (divisaoTreinoExistente != null) {
                        DivisaoTreino novaDivisaoTreino = Menus.alterarDivisaoTreinoMenu(idAlteracao, divisaoTreinoExistente);
                        divisaoTreinoDAO.alterarDivisaoTreino(idAlteracao, novaDivisaoTreino.getNome(), novaDivisaoTreino.getDescricao(), calendario.getDataAtual());
                        System.out.println("Divisao de Treino alterada com sucesso!");
                    } else {
                        System.out.println("Divisao de Treino nao encontrada.");
                    }
                }
                break;
                case 4: {
                    int idBusca = Menus.buscarDivisaoTreinoMenu("buscar");
                    DivisaoTreino divisaoTreinoBuscada = divisaoTreinoDAO.buscarDivisaoTreino(idBusca);
                    if (divisaoTreinoBuscada != null) {
                        Menus.mostrarDivisaoTreinoMenu(divisaoTreinoBuscada);
                    } else {
                        System.out.println("Divisao de Treino nao encontrada.");
                    }
                }
                break;
                case 5: {
                    int idRemocao = Menus.buscarDivisaoTreinoMenu("remover");
                    divisaoTreinoDAO.removerDivisaoTreino(idRemocao);
                    System.out.println("Divisao de Treino removida com sucesso!");
                }
                break;
                case 6:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoDivisaoTreinoMusculo() {
        int opcaoDivisaoTreinoMusculo = 0;
        while (opcaoDivisaoTreinoMusculo != 6) {
            Menus.digitarQualquerTecla();
            opcaoDivisaoTreinoMusculo = Menus.divisaoTreinoMusculoMenu();
            switch (opcaoDivisaoTreinoMusculo) {
                case 1:
                    Menus.adicionarDivisaoTreinoMusculoMenu(divisaoTreinoMusculoDAO, divisaoTreinoDAO, calendario.getDataAtual());
                    break;
                case 2:
                    Menus.mostrarTodasDivisoesTreinoMusculoMenu(divisaoTreinoMusculoDAO);
                    break;
                case 3:
                    int idParaAlterar = Menus.buscarDivisaoTreinoMusculoMenu("alterar");
                    Menus.alterarDivisaoTreinoMusculoMenu(divisaoTreinoMusculoDAO, idParaAlterar, calendario.getDataAtual());
                    break;
                case 4:
                    int idParaBuscar = Menus.buscarDivisaoTreinoMusculoMenu("buscar");
                    DivisaoTreinoMusculo divisaoTreinoMusculo = divisaoTreinoMusculoDAO.buscarDivisaoTreinoMusculo(idParaBuscar);
                    if (divisaoTreinoMusculo != null) {
                        Menus.mostrarDivisaoTreinoMusculoMenu(divisaoTreinoMusculo);
                    } else {
                        System.out.println("Divisao de treino muscular nao encontrada.");
                    }
                    break;
                case 5:
                    int idParaRemover = Menus.buscarDivisaoTreinoMusculoMenu("remover");
                    Menus.removerDivisaoTreinoMusculoMenu(divisaoTreinoMusculoDAO, idParaRemover);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoTreino() {
        int opcaoTreino = 0;
        while (opcaoTreino != 7) {
            Menus.digitarQualquerTecla();
            opcaoTreino = Menus.treinoMenu();
            switch (opcaoTreino) {
                case 1: {
                    Treino treino = Menus.adicionarTreinoMenu(treinoDAO, divisaoTreinoDAO, pessoaDAO);
                    if (treino != null) {
                        treinoDAO.adicionarTreino(treino, calendario.getDataAtual());
                        System.out.println("Treino adicionado com sucesso!");
                    }
                }
                break;
                case 2: {
                    Menus.mostrarTodosTreinosMenu(treinoDAO);
                }
                break;
                case 3: {
                    int idBusca = Menus.buscarTreinoMenu("mostrar");
                    Treino treinoBuscado = treinoDAO.buscarTreino(idBusca);
                    if (treinoBuscado != null) {
                        Menus.mostrarTreinoMenu(treinoBuscado);
                    } else {
                        System.out.println("Treino nao encontrado.");
                    }

                }
                break;
                case 4: {
                    int idBusca = Menus.buscarTreinoMenu("buscar");
                    Treino treinoBuscado = treinoDAO.buscarTreino(idBusca);
                    if (treinoBuscado != null) {
                        Menus.mostrarTreinoMenu(treinoBuscado);
                    } else {
                        System.out.println("Treino nao encontrado.");
                    }
                }
                break;
                case 5: {
                    int idAlteracao = Menus.buscarTreinoMenu("alterar");
                    Treino treinoExistente = treinoDAO.buscarTreino(idAlteracao);
                    if (treinoExistente != null) {
                        Treino novoTreino = Menus.alterarTreinoMenu(idAlteracao, treinoExistente, divisaoTreinoDAO, pessoaDAO);
                        if (novoTreino != null) {
                            treinoDAO.alterarTreino(idAlteracao, novoTreino, calendario.getDataAtual());
                            System.out.println("Treino alterado com sucesso!");
                        }
                    } else {
                        System.out.println("Treino nao encontrado.");
                    }
                }
                break;

                case 6: {
                    int idRemocao = Menus.buscarTreinoMenu("remover");
                    treinoDAO.removerTreino(idRemocao);
                    System.out.println("Treino removido com sucesso!");
                }
                break;
                case 7:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoTreinoAplicacao() {
        int opcaoTreinoAplicacao = 0;
        String[] nomesExercicios = new String[100];
        while (opcaoTreinoAplicacao != 4) {
            Menus.digitarQualquerTecla();
            opcaoTreinoAplicacao = Menus.treinoAplicacaoMenu();
            switch (opcaoTreinoAplicacao) {
                case 1: {
                    nomesExercicios = Menus.adicionarTreinoAplicacaoMenu(treinoAplicacaoDAO, divisaoTreinoDAO, treinoDAO, exercicioDAO, exercicioAplicacaoDAO, divisaoTreinoMusculoDAO);
                }
                break;
                case 2: {
                    Menus.mostrarTreinoAplicacaoMenu(treinoAplicacaoDAO, treinoDAO, divisaoTreinoDAO, divisaoTreinoMusculoDAO);
                }
                break;
                case 3: {
                    Menus.removerTreinoAplicacaoMenu(treinoAplicacaoDAO);
                }
                break;
                case 4:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoAvaliacaoFisica() {
        int opcaoAvaliacaoFisica = 0;
        while (opcaoAvaliacaoFisica != 2) {
            Menus.digitarQualquerTecla();
            opcaoAvaliacaoFisica = Menus.avaliacaoFisicaMenu();
            switch (opcaoAvaliacaoFisica) {
                case 1: {
                    AvaliacaoFisica avaliacaoFisica = Menus.calcularIMC(pessoaDAO, treinoDAO);
                    if (avaliacaoFisica != null) {
                        MovimentacaoFinanceira movimentacaoAvaliacaoFisica = new MovimentacaoFinanceira(0, 20.0,
                                "entrada", "Pagamento de avaliacao fisica do aluno de id " + avaliacaoFisica.getPessoa().getId(), calendario.getDataAtual(), calendario.getDataAtual());
                        movimentacaoFinanceiraDAO.adicionarMovimentacao(movimentacaoAvaliacaoFisica, calendario.getDataAtual());
                        System.out.println("\nAvaliacao fisica realizada com sucesso.\n");
                    }
                }
                break;
                case 2:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoMensalidade() {
        int opcaoMensalidade = 0;
        while (opcaoMensalidade != 6) {
            Menus.digitarQualquerTecla();
            opcaoMensalidade = Menus.mensalidadeMenu();
            switch (opcaoMensalidade) {
                case 1: {
                    Mensalidade mensalidade = Menus.adicionarMensalidadeMenu();
                    mensalidadeDAO.adicionarMensalidade(mensalidade, calendario.getDataAtual());
                    System.out.println("Mensalidade adicionada com sucesso!");
                }
                break;
                case 2: {
                    Mensalidade[] mensalidades = mensalidadeDAO.mostrarMensalidades();
                    Menus.mostrarTodasMensalidadesMenu(mensalidades);
                }
                break;
                case 3: {
                    int idAlteracao = Menus.buscarMensalidadeMenu("alterar");
                    Mensalidade mensalidadeExistente = mensalidadeDAO.buscarMensalidade(idAlteracao);
                    if (mensalidadeExistente != null) {
                        Mensalidade novaMensalidade = Menus.alterarMensalidadeMenu(idAlteracao, mensalidadeExistente);
                        mensalidadeDAO.alterarMensalidade(idAlteracao, novaMensalidade, calendario.getDataAtual());
                        System.out.println("Mensalidade alterada com sucesso!");
                    } else {
                        System.out.println("Mensalidade nao encontrada.");
                    }
                }
                break;
                case 4: {
                    int idBusca = Menus.buscarMensalidadeMenu("buscar");
                    Mensalidade mensalidadeBuscada = mensalidadeDAO.buscarMensalidade(idBusca);
                    if (mensalidadeBuscada != null) {
                        Menus.mostrarMensalidadeMenu(mensalidadeBuscada);
                    } else {
                        System.out.println("Mensalidade nao encontrada.");
                    }
                }
                break;
                case 5: {
                    int idRemocao = Menus.buscarMensalidadeMenu("remover");
                    mensalidadeDAO.removerMensalidade(idRemocao);
                    System.out.println("Mensalidade removida com sucesso!");
                }
                break;
                case 6:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoMensalidadeAluno() {
        int opcaoMensalidadeAluno = 0;
        while (opcaoMensalidadeAluno != 6) {
            Menus.digitarQualquerTecla();
            opcaoMensalidadeAluno = Menus.mensalidadeAlunoMenu();
            switch (opcaoMensalidadeAluno) {
                case 1: {
                    MensalidadeAluno mensalidadeAluno = Menus.associarMensalidadeAlunoMenu();
                    Mensalidade[] mensalidades = mensalidadeDAO.mostrarMensalidades();
                    LocalDate dataVencimento = mensalidadeAlunoDAO.ajustarDataVencimento(calendario.getDataAtual(), mensalidades[mensalidadeAluno.getIdMensalidade() - 1].getDataFim());
                    mensalidadeAluno.setDataVencimento(dataVencimento);
                    mensalidadeAluno.setValorPago(mensalidades[mensalidadeAluno.getIdMensalidade() - 1].getValor());
                    Pessoa aluno = pessoaDAO.buscarPessoa(mensalidadeAluno.getIdAluno());

                    if (pessoaDAO.checarTipoPessoa("Aluno", aluno)) {
                        mensalidadeAlunoDAO.adicionarMensalidadeAluno(mensalidadeAluno, calendario.getDataAtual());
                        System.out.println("Associacao de mensalidade a aluno adicionada com sucesso!");
                        if (mensalidadeAluno.getModalidade().equals("Pagamento Recorrente") == false) {
                            MovimentacaoFinanceira movimentacaoPagamento = new MovimentacaoFinanceira(0, mensalidadeAluno.getValorPago(),
                                    "entrada", "Pagamento de mensalidade do aluno de id " + mensalidadeAluno.getIdAluno(), calendario.getDataAtual(), calendario.getDataAtual());
                            movimentacaoFinanceiraDAO.adicionarMovimentacao(movimentacaoPagamento, calendario.getDataAtual());
                        } else {
                            System.out.println("Agora deve adicionar o Pagamento Recorrente do aluno!");
                        }
                    } else {
                        System.out.println("ID digitado nao eh aluno!");
                    }
                }
                break;
                case 2: {
                    MensalidadeAluno[] mensalidadeAlunos = mensalidadeAlunoDAO.mostrarMensalidadesAluno();
                    Pessoa[] alunos = pessoaDAO.mostrarPessoas();
                    Mensalidade[] mensalidades = mensalidadeDAO.mostrarMensalidades();
                    Menus.mostrarTodasMensalidadesAlunoMenu(mensalidadeAlunos, alunos, mensalidades);
                }
                break;
                case 3: {
                    int idAlteracao = Menus.buscarMensalidadeAlunoMenu("alterar");
                    MensalidadeAluno mensalidadeAlunoExistente = mensalidadeAlunoDAO.buscarMensalidadeAluno(idAlteracao);
                    if (mensalidadeAlunoExistente != null) {
                        MensalidadeAluno novaMensalidadeAluno = Menus.alterarMensalidadeAlunoMenu(mensalidadeAlunoExistente);
                        mensalidadeAlunoDAO.alterarMensalidadeAluno(idAlteracao, novaMensalidadeAluno, calendario.getDataAtual());
                        System.out.println("Associacao de mensalidade a aluno alterada com sucesso!");
                    } else {
                        System.out.println("Associacao de mensalidade a aluno nao encontrada.");
                    }
                }
                break;
                case 4: {
                    int idBusca = Menus.buscarMensalidadeAlunoMenu("buscar");
                    MensalidadeAluno mensalidadeAlunoBuscada = mensalidadeAlunoDAO.buscarMensalidadeAluno(idBusca);
                    if (mensalidadeAlunoBuscada != null) {
                        Pessoa[] pessoas = pessoaDAO.mostrarPessoas();
                        Mensalidade[] mensalidades = mensalidadeDAO.mostrarMensalidades();
                        Menus.mostrarMensalidadeAlunoMenu(mensalidadeAlunoBuscada, pessoas, mensalidades);
                    } else {
                        System.out.println("Associacao de mensalidade a aluno nao encontrada.");
                    }
                }
                break;
                case 5: {
                    int idRemocao = Menus.buscarMensalidadeAlunoMenu("remover");
                    mensalidadeAlunoDAO.removerMensalidadeAluno(idRemocao);
                    System.out.println("Associacao de mensalidade a aluno removida com sucesso!");
                }
                break;
                case 6:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoPagamentoRecorrente() {
        int opcaoPagamento = 0;
        while (opcaoPagamento != 5) {
            Menus.digitarQualquerTecla();
            opcaoPagamento = Menus.pagamentoRecorrenteMenu();
            switch (opcaoPagamento) {
                case 1: {
                    PagamentoRecorrente pagamentoRecorrente = Menus.adicionarPagamentoRecorrenteMenu();
                    MensalidadeAluno mensalidadeAluno = mensalidadeAlunoDAO.buscarMensalidadeAluno(pagamentoRecorrente.getIdMensalidadeAluno());
                    if (mensalidadeAluno != null) {
                        Mensalidade mensalidade = mensalidadeDAO.buscarMensalidade(mensalidadeAluno.getIdMensalidade());
                        pagamentoRecorrente.setValor(mensalidadeAluno.getValorPago());
                        pagamentoRecorrente.setNumeroDeMeses(mensalidade.getTermino());
                        pagamentoRecorrenteDAO.adicionarPagamento(pagamentoRecorrente, calendario.getDataAtual());
                        MovimentacaoFinanceira movimentacaoPagamento = new MovimentacaoFinanceira(0, pagamentoRecorrente.getValor(),
                                "entrada", "Pagamento de mensalidade do aluno de id " + pagamentoRecorrente.getIdPessoa() + ", aprovado por " + pagamentoRecorrente.getNumeroDeMeses() + " meses", calendario.getDataAtual(), calendario.getDataAtual());
                        movimentacaoFinanceiraDAO.adicionarMovimentacao(movimentacaoPagamento, calendario.getDataAtual());
                        System.out.println("Pagamento recorrente adicionado com sucesso!");
                    } else {
                        System.out.println("Erro ao adicionar pagamento recorrente. Tente novamente");
                    }
                }
                break;
                case 2: {
                    PagamentoRecorrente[] pagamentos = pagamentoRecorrenteDAO.mostrarPagamentos();
                    Pessoa[] pessoas = pessoaDAO.mostrarPessoas();
                    Menus.mostrarTodosPagamentosRecorrentesMenu(pagamentos, pessoas);
                }
                break;
                case 3: {
                    int idBusca = Menus.buscarPagamentoRecorrenteMenu("buscar");
                    PagamentoRecorrente pagamentoBuscado = pagamentoRecorrenteDAO.buscarPagamento(idBusca);
                    if (pagamentoBuscado != null) {
                        Pessoa[] pessoas = pessoaDAO.mostrarPessoas();
                        Menus.mostrarPagamentoRecorrenteMenu(pagamentoBuscado, pessoas);
                    } else {
                        System.out.println("Pagamento recorrente nao encontrado.");
                    }
                }
                break;
                case 4: {
                    int idRemocao = Menus.buscarPagamentoRecorrenteMenu("remover");
                    pagamentoRecorrenteDAO.removerPagamento(idRemocao);
                    System.out.println("Pagamento recorrente removido com sucesso!");
                }
                break;
                case 5:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoCalendario() {
        int opcaoCalendario = 0;
        while (opcaoCalendario != 3) {
            Menus.digitarQualquerTecla();
            opcaoCalendario = Menus.calendarioMenu(calendario);
            switch (opcaoCalendario) {
                case 1: {
                    Menus.avancarCalendarioMenu();
                    calendario.avancarDia();
                    if (calendario.checarQuintoDiaUtil() == true) {
                        Pessoa[] pessoas = pessoaDAO.mostrarPessoas();
                        movimentacaoFinanceiraDAO.pagarDespesasAcademia(pessoas, calendario.getDataAtual());
                    } else if (calendario.checarTerminoMes() == true) {
                        Pessoa[] pessoas = pessoaDAO.mostrarPessoas();
                        MensalidadeAluno[] mensalidades = mensalidadeAlunoDAO.mostrarMensalidadesAluno();
                        int[] idsAlunosAdimplentes = calendario.checarAlunosAdimplentes(mensalidades);
                        Relatorios.relatorioAlunosAdimplentes(mensalidades, pessoas, calendario.getDataAtual(), idsAlunosAdimplentes);
                    }
                }
                break;
                case 2: {
                    Menus.avancarCalendarioMenu();
                    calendario.diminuirDia();
                }
                break;
                case 3:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoEntradaAluno(Pessoa pessoaLogada) {
        int opcaoEntradaAluno = 0;
        while (opcaoEntradaAluno != 2) {
            Menus.digitarQualquerTecla();
            opcaoEntradaAluno = Menus.entradaAlunoMenu();
            switch (opcaoEntradaAluno) {
                case 1: {
                    int[] alunosVencidos = calendario.checarAlunosVencidos(mensalidadeAlunoDAO.mostrarMensalidadesAluno());
                    boolean mensalidadeVencida = false;
                    for (int i = 0; i < alunosVencidos.length; i++) {
                        if (pessoaLogada.getId() == alunosVencidos[i]) {
                            mensalidadeVencida = true;
                        }
                    }
                    if (mensalidadeVencida && pessoaLogada.getTipoUsuario().equals("Aluno")) {
                        System.out.println("Mensalidade vencida! Procure alguem na recepcao para registrar o pagamento.");
                    } else {
                        EntradaAluno entradaAluno = new EntradaAluno(0, calendario.getDataAtual(), calendario.getDataAtual(), calendario.getDataAtual());
                        entradaAlunoDAO.adicionarEntradaAluno(entradaAluno);
                        System.out.println("Entrada aluno registrada com sucesso");
                    }
                }
                break;
                case 2:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    break;
            }
        }
    }

    public static void opcaoRelatorio(String tipoUsuarioLogado) {
        int opcaoRelatorio = 0;
        while (opcaoRelatorio != 3) {
            Menus.digitarQualquerTecla();
            opcaoRelatorio = Menus.relatoriosMenu(tipoUsuarioLogado);
            if (tipoUsuarioLogado.equals("Admin")) {
                switch (opcaoRelatorio) {
                    case 1: {
                        int mesAnoRelatorio[] = Menus.relatorioMovimentacao();
                        int mes = mesAnoRelatorio[0];
                        int ano = mesAnoRelatorio[1];
                        MovimentacaoFinanceira[] movimentacoes = movimentacaoFinanceiraDAO.mostrarMovimentacoes();
                        Relatorios.relatorioMovimentacaoFinanceira(movimentacoes, mes, ano);
                    }
                    break;
                    case 2: {
                        Menus.mostrarTreinoAplicacaoMenu(treinoAplicacaoDAO, treinoDAO, divisaoTreinoDAO, divisaoTreinoMusculoDAO);
                    }
                    break;
                    case 3:
                        System.out.println("\nSaindo...");
                        break;
                    default:
                        Menus.mostrarOpcaoInvalida();
                        break;
                }
            } else {
                switch (opcaoRelatorio) {
                    case 1: {
                        Menus.mostrarTreinoAplicacaoMenu(treinoAplicacaoDAO, treinoDAO, divisaoTreinoDAO, divisaoTreinoMusculoDAO);
                    }
                    break;
                    case 2:
                        System.out.println("\nSaindo...");
                        break;
                    default:
                        Menus.mostrarOpcaoInvalida();
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SQLConnection.criarTabelas();
        
        
        academiaDAO.recuperarDadosAcademia();
        
        academiaDAO.adicionarAcademiasExemplo();
        pessoaDAO.adicionarPessoasExemplo();
        divisaoTreinoDAO.adicionarDivisaoTreinoExemplos();
        exercicioDAO.adicionarExercicioExemplos();
        mensalidadeDAO.adicionarMensalidadesExemplo();
        exercicioAplicacaoDAO.adicionarExerciciosAplicacaoExemplos();
        treinoDAO.adicionarTreinoExemplos();

        //MENU INICIO
        int opcaoInicio = Menus.menuIniciar();

        while (opcaoInicio != 2) {
            Menus.limparTela();
            boolean loginSucedido = false;
            Pessoa pessoaLogada = null;
            while (!loginSucedido) {
                String[] loginSenha = Menus.menuLogin();
                String login = loginSenha[0];
                String senha = loginSenha[1];
                Pessoa[] loginsCadastrados = pessoaDAO.mostrarPessoas();

                for (Pessoa loginCadastrado : loginsCadastrados) {
                    if (loginCadastrado.getLogin().equals(login) && loginCadastrado.getSenha().equals(senha)) {
                        loginSucedido = true;
                        pessoaLogada = loginCadastrado;
                    }
                }

                if (!loginSucedido) {
                    System.out.println("Login invalido! Tente novamente...");
                    Menus.digitarQualquerTecla();
                    Menus.limparTela();
                }
            }

            if (pessoaLogada != null) {
                String tipoUsuarioLogado = pessoaLogada.getTipoUsuario();

                if (tipoUsuarioLogado.equals("Admin")) {
                    //MENU ADMIN
                    int opcaoAdmin = 0;
                    while (opcaoAdmin != 16) {
                        opcaoAdmin = Menus.mostrarMenuAdmin();
                        switch (opcaoAdmin) {
                            //ACADEMIA
                            case 1: {
                                opcaoAcademia();
                            }
                            break;
                            //PESSOA
                            case 2: {
                                opcaoPessoa();
                            }
                            break;
                            //EXERCICIO
                            case 3: {
                                opcaoExercicio();
                            }
                            break;
                            //APLICACAO EXERCICIO
                            case 4: {
                                opcaoExercicioAplicacao();
                            }
                            break;
                            //DIVISAO TREINO
                            case 5: {
                                opcaoDivisaoTreino();
                            }
                            break;
                            //DIVISAO TREINO-MUSCULO
                            case 6: {
                                opcaoDivisaoTreinoMusculo();
                            }
                            break;
                            //TREINO
                            case 7: {
                                opcaoTreino();
                            }
                            break;
                            //TREINO APLICACAO
                            case 8: {
                                opcaoTreinoAplicacao();
                            }
                            break;
                            //AVALIACAO FISICA
                            case 9: {
                                opcaoAvaliacaoFisica();
                            }
                            break;
                            //MENSALIDADE
                            case 10: {
                                opcaoMensalidade();
                            }
                            break;
                            //MENSALIDADE ALUNO
                            case 11: {
                                opcaoMensalidadeAluno();
                            }
                            break;
                            //PAGAMENTO RECORRENTE
                            case 12: {
                                opcaoPagamentoRecorrente();
                            }
                            break;
                            //CALENDARIO
                            case 13: {
                                opcaoCalendario();
                            }
                            break;
                            // ENTRADA ALUNO
                            case 14: {
                                opcaoEntradaAluno(pessoaLogada);
                            }
                            break;
                            //RELATORIOS
                            case 15: {
                                opcaoRelatorio(tipoUsuarioLogado);
                            }
                            break;
                            case 16:
                                System.out.println("\nEncerrando programa...\n");
                                break;
                            default:
                                Menus.mostrarOpcaoInvalida();
                                Menus.digitarQualquerTecla();
                                break;
                        }
                    }
                } else if (tipoUsuarioLogado.equals("Professor")) {
                    //MENU PROFESSOR
                    int opcaoProfessor = 0;
                    while (opcaoProfessor != 10) {
                        opcaoProfessor = Menus.mostrarMenuProfessor();
                        switch (opcaoProfessor) {
                            //EXERCICIO
                            case 1: {
                                opcaoExercicio();
                            }
                            break;
                            //APLICACAO EXERCICIO
                            case 2: {
                                opcaoExercicioAplicacao();
                            }
                            break;
                            //DIVISAO TREINO
                            case 3: {
                                opcaoDivisaoTreino();
                            }
                            break;
                            //DIVISAO TREINO-MUSCULO
                            case 4: {
                                opcaoDivisaoTreinoMusculo();
                            }
                            break;
                            //TREINO
                            case 5: {
                                opcaoTreino();
                            }
                            break;
                            //TREINO APLICACAO
                            case 6: {
                                opcaoTreinoAplicacao();
                            }
                            break;
                            //AVALIACAO FISICA
                            case 7: {
                                opcaoAvaliacaoFisica();
                            }
                            break;
                            // ENTRADA ALUNO
                            case 8: {
                                opcaoEntradaAluno(pessoaLogada);
                            }
                            break;
                            //RELATORIOS
                            case 9: {
                                opcaoRelatorio(tipoUsuarioLogado);
                            }
                            break;
                            case 10:
                                System.out.println("\nEncerrando programa...\n");
                                break;
                            default:
                                Menus.mostrarOpcaoInvalida();
                                Menus.digitarQualquerTecla();
                                break;
                        }
                    }
                } else {
                    //MENU ALUNO
                    int opcaoAluno = 0;
                    while (opcaoAluno != 4) {
                        opcaoAluno = Menus.mostrarMenuAluno();
                        switch (opcaoAluno) {
                            //AVALIACAO FISICA
                            case 1: {
                                opcaoAvaliacaoFisica();
                            }
                            break;
                            case 2: {
                                // ENTRADA ALUNO
                                opcaoEntradaAluno(pessoaLogada);
                            }
                            break;
                            //RELATORIOS
                            case 3: {
                                opcaoRelatorio(tipoUsuarioLogado);
                            }
                            break;
                            case 4:
                                System.out.println("\nEncerrando programa...\n");
                                break;
                            default:
                                Menus.mostrarOpcaoInvalida();
                                Menus.digitarQualquerTecla();
                                break;
                        }
                    }
                }

            }
        }
    }
}
