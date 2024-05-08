package gym.controller;

import gym.model.*;
import gym.view.Menus;
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
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();

        academiaDAO.adicionarAcademiasExemplo();
        pessoaDAO.adicionarPessoasExemplo();
        exercicioDAO.adicionarExercicioExemplos();

        int opcao = 0;
        while (opcao != 7) {
            opcao = Menus.mostrarMenuPrincipal();
            switch (opcao) {
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
                                    System.out.println("Nenhuma academia cadastrada. Impossível alterar.");
                                } else {
                                    int id = Menus.buscarAcademiaMenu("alterar");
                                    Academia academiaExistente = academiaDAO.buscarAcademia(id);
                                    if (academiaExistente != null) {
                                        Academia novaAcademia = Menus.alterarAcademiaMenu(id, academiaExistente);
                                        academiaDAO.alterarAcademia(id, novaAcademia);
                                        System.out.println("Academia alterada com sucesso.");
                                    } else {
                                        System.out.println("Academia não encontrada.");
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
                                    System.out.println("Academia não encontrada.");
                                }
                            }
                            break;
                            case 5: {
                                if (academiaDAO.mostrarAcademias().length == 0) {
                                    System.out.println("Nenhuma academia cadastrada. Impossível remover.");
                                } else {
                                    int id = Menus.buscarAcademiaMenu("remover");
                                    academiaDAO.removerAcademia(id);
                                    System.out.println("Academia removida com sucesso.");
                                }
                            }
                            break;
                            case 6:
                                break;
                            default:
                                Menus.mostrarOpcaoInvalida();
                                break;
                        }
                    }
                }
                break;
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
                                    System.out.println("Nenhuma pessoa cadastrada. Impossível alterar.");
                                } else {
                                    int id = Menus.buscarPessoaMenu("alterar");
                                    Pessoa pessoaExistente = pessoaDAO.buscarPessoa(id);
                                    if (pessoaExistente != null) {
                                        Pessoa novaPessoa = Menus.alterarPessoaMenu(id, pessoaExistente);
                                        pessoaDAO.alterarPessoa(id, novaPessoa);
                                        System.out.println("Pessoa alterada com sucesso.");
                                    } else {
                                        System.out.println("Pessoa não encontrada.");
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
                                    System.out.println("Pessoa não encontrada.");
                                }
                            }
                            break;
                            case 5: {
                                if (pessoaDAO.mostrarPessoas().length == 0) {
                                    System.out.println("Nenhuma pessoa cadastrada. Impossível remover.");
                                } else {
                                    int idRemocao = Menus.buscarPessoaMenu("remover");
                                    pessoaDAO.removerPessoa(idRemocao);
                                    System.out.println("Pessoa removida com sucesso.");
                                }
                            }
                            break;
                            case 6:
                                break;
                            default:
                                Menus.mostrarOpcaoInvalida();
                                break;
                        }
                    }
                }
                break;
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
                                    System.out.println("Exercício alterado com sucesso!");
                                } else {
                                    System.out.println("Exercicio não encontrado.");
                                }

                            }
                            break;
                            case 4: {
                                int idBusca = Menus.buscarExercicioMenu("buscar");
                                Exercicio exercicioBuscado = exercicioDAO.buscarExercicio(idBusca);
                                if (exercicioBuscado != null) {
                                    Menus.mostrarExercicioMenu(exercicioBuscado);
                                } else {
                                    System.out.println("Exercício não encontrado.");
                                }
                            }
                            break;
                            case 5: {
                                int idRemocao = Menus.buscarExercicioMenu("remover");
                                exercicioDAO.removerExercicio(idRemocao);
                                System.out.println("Exercício removido com sucesso!");
                            }
                            break;
                            case 6:
                                break;
                            default:
                                Menus.mostrarOpcaoInvalida();
                                break;
                        }
                    }
                }
                break;
                case 4:
                    int opcaoExercicioAplicacao = 0;
                    while (opcaoExercicioAplicacao != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoExercicioAplicacao = Menus.exercicioAplicacaoMenu();
                        switch (opcaoExercicioAplicacao) {
                            case 1: {
                                System.out.println("Digite o ID do exercício existente: ");
                                int idExercicio = Integer.parseInt(scanner.nextLine());
                                Exercicio exercicioExistente = exercicioDAO.buscarExercicio(idExercicio);
                                if (exercicioExistente != null) {
                                    ExercicioAplicacao exercicioAplicacao = Menus.adicionarExercicioAplicacaoMenu(idExercicio);
                                    exercicioAplicacaoDAO.adicionarExercicioAplicacao(exercicioAplicacao.getIdExercicio(), exercicioAplicacao.getDescricao());
                                } else {
                                    System.out.println("Exercício não encontrado.");
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
                                        System.out.println("Exercício aplicação alterado com sucesso!");
                                    } else {
                                        System.out.println("Exercício aplicação alterado com sucesso!");
                                    }
                                } else {
                                    System.out.println("Exercício aplicação não encontrado.");
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
                                        System.out.println("Exercício aplicação não encontrado.");
                                    }
                                } else {
                                    System.out.println("Exercício aplicação não encontrado.");
                                }
                            }
                            break;
                            case 5: {
                                int idRemocao = Menus.buscarExercicioAplicacaoMenu("remover");
                                ExercicioAplicacao exercicioAplicacaoBuscado = exercicioAplicacaoDAO.buscarExercicioAplicacao(idRemocao);
                                if (exercicioAplicacaoBuscado != null) {
                                    if (exercicioDAO.buscarExercicio(exercicioAplicacaoBuscado.getIdExercicio()) != null) {
                                        exercicioAplicacaoDAO.removerExercicioAplicacao(idRemocao);
                                        System.out.println("Exercício aplicação removido com sucesso!");
                                    } else {
                                        System.out.println("Exercício aplicação não encontrado.");
                                    }
                                } else {
                                    System.out.println("Exercício aplicação não encontrado.");
                                }
                            }
                            break;
                            case 6:
                                break;
                            default:
                                Menus.mostrarOpcaoInvalida();
                                break;
                        }
                    }
                    break;
                case 5:
                    int opcaoDivisao = 0;
                    while (opcaoDivisao != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoDivisao = Menus.divisaoTreinoMenu();
                        switch (opcaoDivisao) {
                            case 1: {
                                DivisaoTreino divisaoTreino = Menus.adicionarDivisaoTreinoMenu();
                                divisaoTreinoDAO.adicionarDivisaoTreino(divisaoTreino.getNome(), divisaoTreino.getDescricao());
                                System.out.println("Divisão de Treino adicionada com sucesso!");
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
                                    System.out.println("Divisão de Treino alterada com sucesso!");
                                } else {
                                    System.out.println("Divisão de Treino não encontrada.");
                                }
                            }
                            break;
                            case 4: {
                                int idBusca = Menus.buscarDivisaoTreinoMenu("buscar");
                                DivisaoTreino divisaoTreinoBuscada = divisaoTreinoDAO.buscarDivisaoTreino(idBusca);
                                if (divisaoTreinoBuscada != null) {
                                    Menus.mostrarDivisaoTreinoMenu(divisaoTreinoBuscada);
                                } else {
                                    System.out.println("Divisão de Treino não encontrada.");
                                }
                            }
                            break;
                            case 5: {
                                int idRemocao = Menus.buscarDivisaoTreinoMenu("remover");
                                divisaoTreinoDAO.removerDivisaoTreino(idRemocao);
                                System.out.println("Divisão de Treino removida com sucesso!");
                            }
                            break;
                            case 6:
                                break;
                            default:
                                Menus.mostrarOpcaoInvalida();
                                break;
                        }
                    }
                    break;
                case 6:
                    int opcaoMensalidade = 0;
                    while (opcaoMensalidade != 6) {
                        Menus.digitarQualquerTecla();
                        opcaoMensalidade = Menus.mensalidadeMenu(); 
                        switch (opcaoMensalidade) {
                            case 1: {
                                Mensalidade mensalidade = Menus.adicionarMensalidadeMenu();
                                mensalidadeDAO.adicionarMensalidade(mensalidade.getValor(), mensalidade.getDataInicio(), mensalidade.getDataFim());
                                System.out.println("Mensalidade adicionada com sucesso!");
                            }
                            break;
                            case 2: {
                                Menus.mostrarTodasMensalidadesMenu(mensalidadeDAO);
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
                                    System.out.println("Mensalidade não encontrada.");
                                }
                            }
                            break;
                            case 4: {
                                int idBusca = Menus.buscarMensalidadeMenu("buscar");
                                Mensalidade mensalidadeBuscada = mensalidadeDAO.buscarMensalidade(idBusca);
                                if (mensalidadeBuscada != null) {
                                    Menus.mostrarMensalidadeMenu(mensalidadeBuscada);
                                } else {
                                    System.out.println("Mensalidade não encontrada.");
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
                                break;
                            default:
                                Menus.mostrarOpcaoInvalida();
                                break;
                        }
                    }
                    break;
                case 7:
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    Menus.digitarQualquerTecla();
                    break;
            }
        }
    }
}
