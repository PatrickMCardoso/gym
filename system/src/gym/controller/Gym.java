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
        ExercicioAplicacaoDAO exercicioAplicaoDAO = new ExercicioAplicacaoDAO();

        academiaDAO.adicionarAcademiasExemplo();
        pessoaDAO.adicionarPessoasExemplo();
        exercicioDAO.adicionarExercicioExemplos();

        int opcao = 0;
        while (opcao != 4) {
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
                case 4:
                    break;
                default:
                    Menus.mostrarOpcaoInvalida();
                    Menus.digitarQualquerTecla();
                    break;
            }
        }
    }
}
