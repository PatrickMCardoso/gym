package gym.controller;

import gym.model.*;
import gym.view.Menus;
import gym.view.Relatorios;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gym {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AcademiaDAO academiaDAO = new AcademiaDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();
        ExercicioDAO exercicioDAO = new ExercicioDAO();
        ExercicioAplicacaoDAO exercicioAplicacaoDAO = new ExercicioAplicacaoDAO();
        DivisaoTreinoDAO divisaoTreinoDAO = new DivisaoTreinoDAO();
        DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO = new DivisaoTreinoMusculoDAO(divisaoTreinoDAO);
        TreinoDAO treinoDAO = new TreinoDAO(pessoaDAO, divisaoTreinoDAO);
        TreinoAplicacaoDAO treinoAplicacaoDAO = new TreinoAplicacaoDAO();
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();
        MensalidadeAlunoDAO mensalidadeAlunoDAO = new MensalidadeAlunoDAO();
        PagamentoRecorrenteDAO pagamentoRecorrenteDAO = new PagamentoRecorrenteDAO();
        Calendario calendario = new Calendario(LocalDate.now());
        MovimentacaoFinanceiraDAO movimentacaoFinanceiraDAO = new MovimentacaoFinanceiraDAO();

        divisaoTreinoDAO.adicionarDivisaoTreinoExemplos();
        academiaDAO.adicionarAcademiasExemplo();
        pessoaDAO.adicionarPessoasExemplo();
        exercicioDAO.adicionarExercicioExemplos();
        mensalidadeDAO.adicionarMensalidadesExemplo();
        exercicioAplicacaoDAO.adicionarExerciciosAplicacaoExemplos();
        treinoDAO.adicionarTreinoExemplos();

        int opcao = 0;
        while (opcao != 17) {
            // VERIFICANDO SE AS FUNÇÕES DE CHECAR SE A MENSALIDADE DOS ALUNOS ESTÃO VENCIDAS ESTÁ FUNCIONANDO (DEU CERTO),  
            // ACREDITO QUE SÓ PODEREMOS USÁ-LAS QUANDO O LOGIN E AS PERMISSÕES DE CADA TIPO DE USUARIO ESTIVEREM CERTINHAS,
            // DEIXANDO ISSO AQUI PARA NÃO ESQUERCEMOS DE HABILITÁ-LAS ANTES DE ENVIAR A VERSÃO FINAL

            /*
            MensalidadeAluno[] mensalidadesAlunos = mensalidadeAlunoDAO.mostrarMensalidadesAluno();
            int[] mensalidadesVencidas = calendario.checarVencimentos(mensalidadesAlunos);
            for (int i = 0; i < mensalidadesVencidas.length; i++) {
                System.out.println(mensalidadesVencidas[i]);
            }
             */
            opcao = Menus.mostrarMenuPrincipal();
            switch (opcao) {
                //ACADEMIA
                case 1: {
                    int opcaoAcademia = 0;
                    while (opcaoAcademia != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoAcademia = Menus.academiaMenu();
                        switch (opcaoAcademia) {
                            case 1: {
                                academiaDAO.adicionarAcademia(Menus.adicionarAcademiaMenu());
                            }
                            break;
                            case 2: {
                                Academia[] academias = academiaDAO.mostrarAcademias();
                                Menus.mostrarTodasAcademiasMenu(academias);
                            }
                            break;
                            case 3: {
                                if (academiaDAO.mostrarAcademias().length == 0) {
                                    System.out.println("Nenhuma academia cadastrada. Impossivel alterar.");
                                } else {
                                    int id = Menus.buscarAcademiaMenu("alterar");
                                    Academia academiaExistente = academiaDAO.buscarAcademia(id);
                                    if (academiaExistente != null) {
                                        Academia novaAcademia = Menus.alterarAcademiaMenu(id, academiaExistente);
                                        academiaDAO.alterarAcademia(id, novaAcademia);
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
                                if (academiaDAO.mostrarAcademias().length == 0) {
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
                break;
                //PESSOA
                case 2: {
                    int opcaoPessoa = 0;
                    while (opcaoPessoa != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoPessoa = Menus.pessoaMenu();
                        switch (opcaoPessoa) {
                            case 1: {
                                Pessoa novaPessoa = Menus.adicionarPessoaMenu();
                                pessoaDAO.adicionarPessoa(novaPessoa);
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
                                        pessoaDAO.alterarPessoa(id, novaPessoa);
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
                break;
                //EXERCICIO
                case 3: {
                    int opcaoExercicio = 0;
                    while (opcaoExercicio != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoExercicio = Menus.exercicioMenu();
                        switch (opcaoExercicio) {
                            case 1: {
                                Exercicio exercicio = Menus.adicionarExerciciosMenu();
                                exercicioDAO.adicionarExercicio(exercicio);
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
                                    exercicioDAO.alterarExercicio(idAlteracao, novoExercicio);
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
                break;
                //APLICACAO EXERCICIO
                case 4: {
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
                                    exercicioAplicacaoDAO.adicionarExercicioAplicacao(exercicioAplicacao.getIdExercicio(), exercicioAplicacao.getDescricao());
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
                                        exercicioAplicacaoDAO.alterarExercicioAplicacao(idAlteracao, novoExercicioAplicacao);
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
                break;
                //DIVISAO TREINO
                case 5: {
                    int opcaoDivisao = 0;
                    while (opcaoDivisao != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoDivisao = Menus.divisaoTreinoMenu();
                        switch (opcaoDivisao) {
                            case 1: {
                                DivisaoTreino divisaoTreino = Menus.adicionarDivisaoTreinoMenu();
                                divisaoTreinoDAO.adicionarDivisaoTreino(divisaoTreino.getNome(), divisaoTreino.getDescricao());
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
                                    divisaoTreinoDAO.alterarDivisaoTreino(idAlteracao, novaDivisaoTreino.getNome(), novaDivisaoTreino.getDescricao());
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
                break;
                //DIVISAO TREINO-MUSCULO
                case 6: {
                    int opcaoDivisaoTreinoMusculo = 0;
                    while (opcaoDivisaoTreinoMusculo != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoDivisaoTreinoMusculo = Menus.divisaoTreinoMusculoMenu();
                        switch (opcaoDivisaoTreinoMusculo) {
                            case 1:
                                Menus.adicionarDivisaoTreinoMusculoMenu(divisaoTreinoMusculoDAO, divisaoTreinoDAO);
                                break;
                            case 2:
                                Menus.mostrarTodasDivisoesTreinoMusculoMenu(divisaoTreinoMusculoDAO);
                                break;
                            case 3:
                                int idParaAlterar = Menus.buscarDivisaoTreinoMusculoMenu("alterar");
                                Menus.alterarDivisaoTreinoMusculoMenu(divisaoTreinoMusculoDAO, idParaAlterar);
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
                break;
                //TREINO
                case 7: {
                    int opcaoTreino = 0;
                    while (opcaoTreino != 7) {
                        Menus.digitarQualquerTecla();
                        opcaoTreino = Menus.treinoMenu();
                        switch (opcaoTreino) {
                            case 1: {
                                Treino treino = Menus.adicionarTreinoMenu(treinoDAO, divisaoTreinoDAO, pessoaDAO);
                                if (treino != null) {
                                    treinoDAO.adicionarTreino(treino);
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
                                        treinoDAO.alterarTreino(idAlteracao, novoTreino);
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
                break;
                //TREINO APLICACAO
                case 8: {
                    int opcaoTreinoAplicacao = 0;
                    while (opcaoTreinoAplicacao != 5) {
                        Menus.digitarQualquerTecla();
                        opcaoTreinoAplicacao = Menus.treinoAplicacaoMenu();
                        switch (opcaoTreinoAplicacao) {
                            case 1: {
                                Menus.adicionarTreinoAplicacaoMenu(treinoAplicacaoDAO, divisaoTreinoDAO, exercicioDAO, exercicioAplicacaoDAO, treinoDAO);
                            }
                            break;
                            case 2:
                                Menus.mostrarTodasTreinoAplicacoesMenu(treinoAplicacaoDAO, pessoaDAO, exercicioDAO, divisaoTreinoDAO);
                                break;
                            case 3:
                                Menus.alterarTreinoAplicacaoMenu(treinoAplicacaoDAO);
                                break;
                            case 4:
                                Menus.removerTreinoAplicacaoMenu(treinoAplicacaoDAO);
                                break;
                            default:
                                Menus.mostrarOpcaoInvalida();
                                break;
                        }
                    }
                }
                break;

                //AVALIACAO FISICA
                case 9: {
                    int opcaoAvaliacaoFisica = 0;
                    while (opcaoAvaliacaoFisica != 2) {
                        Menus.digitarQualquerTecla();
                        opcaoAvaliacaoFisica = Menus.avaliacaoFisicaMenu();
                        switch (opcaoAvaliacaoFisica) {
                            case 1: {
                                AvaliacaoFisica avaliacaoFisica = Menus.calcularIMC(pessoaDAO, treinoDAO);
                                if (avaliacaoFisica != null) {
                                    MovimentacaoFinanceira movimentacaoAvaliacaoFisica = new MovimentacaoFinanceira(0, 20.0,
                                            "entrada", "Pagamento de avaliacao fisica do aluno de id " + avaliacaoFisica.getPessoa().getId(), LocalDate.now(), LocalDate.now());
                                    movimentacaoFinanceiraDAO.adicionarMovimentacao(movimentacaoAvaliacaoFisica);
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
                break;
                //MENSALIDADE
                case 10: {
                    int opcaoMensalidade = 0;
                    while (opcaoMensalidade != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoMensalidade = Menus.mensalidadeMenu();
                        switch (opcaoMensalidade) {
                            case 1: {
                                Mensalidade mensalidade = Menus.adicionarMensalidadeMenu();
                                mensalidadeDAO.adicionarMensalidade(mensalidade);
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
                                    mensalidadeDAO.alterarMensalidade(idAlteracao, novaMensalidade);
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
                break;
                //MENSALIDADE ALUNO
                case 11: {
                    int opcaoMensalidadeAluno = 0;
                    while (opcaoMensalidadeAluno != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoMensalidadeAluno = Menus.mensalidadeAlunoMenu();
                        switch (opcaoMensalidadeAluno) {
                            case 1: {
                                MensalidadeAluno mensalidadeAluno = Menus.associarMensalidadeAlunoMenu();
                                Mensalidade[] mensalidades = mensalidadeDAO.mostrarMensalidades();
                                LocalDate dataVencimento = mensalidadeAlunoDAO.ajustarDataVencimento(LocalDate.now(), mensalidades[mensalidadeAluno.getIdMensalidade() - 1].getDataFim());
                                mensalidadeAluno.setDataVencimento(dataVencimento);
                                Pessoa aluno = pessoaDAO.buscarPessoa(mensalidadeAluno.getIdAluno());
                                if (pessoaDAO.checarTipoPessoa("Aluno", aluno)) {
                                    mensalidadeAlunoDAO.adicionarMensalidadeAluno(mensalidadeAluno);
                                    System.out.println("Associacao de mensalidade a aluno adicionada com sucesso!");
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
                                    mensalidadeAlunoDAO.alterarMensalidadeAluno(idAlteracao, novaMensalidadeAluno);
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
                break;
                //PAGAMENTO RECORRENTE
                case 12: {
                    int opcaoPagamento = 0;
                    while (opcaoPagamento != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoPagamento = Menus.pagamentoRecorrenteMenu();
                        switch (opcaoPagamento) {
                            case 1: {
                                PagamentoRecorrente pagamentoRecorrente = Menus.adicionarPagamentoRecorrenteMenu();
                                pagamentoRecorrenteDAO.adicionarPagamento(pagamentoRecorrente);
                                MovimentacaoFinanceira movimentacaoPagamento = new MovimentacaoFinanceira(0, pagamentoRecorrente.getValor(),
                                        "entrada", "Pagamento de mensalidade do aluno de id" + pagamentoRecorrente.getIdPessoa(), LocalDate.now(), LocalDate.now());
                                movimentacaoFinanceiraDAO.adicionarMovimentacao(movimentacaoPagamento);
                                System.out.println("Pagamento recorrente adicionado com sucesso!");
                            }
                            break;
                            case 2: {
                                PagamentoRecorrente[] pagamentos = pagamentoRecorrenteDAO.mostrarPagamentos();
                                Pessoa[] pessoas = pessoaDAO.mostrarPessoas();
                                Menus.mostrarTodosPagamentosRecorrentesMenu(pagamentos, pessoas);
                            }
                            break;
                            case 3: {
                                int idAlteracao = Menus.buscarPagamentoRecorrenteMenu("alterar");
                                PagamentoRecorrente pagamentoExistente = pagamentoRecorrenteDAO.buscarPagamento(idAlteracao);
                                if (pagamentoExistente != null) {
                                    PagamentoRecorrente novoPagamento = Menus.alterarPagamentoRecorrenteMenu(idAlteracao, pagamentoExistente);
                                    pagamentoRecorrenteDAO.alterarPagamento(idAlteracao, novoPagamento);
                                    System.out.println("Pagamento recorrente alterado com sucesso!");
                                } else {
                                    System.out.println("Pagamento recorrente nao encontrado.");
                                }
                            }
                            break;
                            case 4: {
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
                            case 5: {
                                int idRemocao = Menus.buscarPagamentoRecorrenteMenu("remover");
                                pagamentoRecorrenteDAO.removerPagamento(idRemocao);
                                System.out.println("Pagamento recorrente removido com sucesso!");
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
                break;
                case 13:
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
                    break;
                case 14:
                    break;
                case 15:
                    int opcaoRelatorio = 0;
                    while (opcaoRelatorio != 3) {
                        Menus.digitarQualquerTecla();
                        opcaoRelatorio = Menus.relatoriosMenu();
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
                                //RELATORIO DE FICHA DE TREINO DO ALUNO
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
    }
}
