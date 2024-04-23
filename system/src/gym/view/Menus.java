/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.view;

import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import gym.model.Academia;
import gym.model.AcademiaDAO;
import gym.model.Pessoa;
import gym.model.PessoaDAO;

/**
 *
 * @author ruanemanuell
 */
public class Menus {

    static Scanner scanner = new Scanner(System.in);
    static AcademiaDAO academiaDAO = new AcademiaDAO();
    static PessoaDAO pessoaDAO = new PessoaDAO();

    public static int mostrarMenuPrincipal() {
        limparTela();
        System.out.println("====== HealthierLifeGym ======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Sistema de Academia\n");
        System.out.println("2 - Sistema de Pessoas\n");
        System.out.println("3 - Sair\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static void academiaMenu() {
        int menuOption = 0;
        while (menuOption != 6) {
            menuOption = 0;
            System.out.println("======SISTEMA DE ACADEMIAS======\n");
            System.out.println("Escolha uma opção:\n");
            System.out.println("1 - Adicionar academia\n");
            System.out.println("2 - Mostrar academias\n");
            System.out.println("3 - Alterar academia\n");
            System.out.println("4 - Buscar academia\n");
            System.out.println("5 - Remover academia\n");
            System.out.println("6 - Sair\n");
            System.out.println("\nDigite a opção escolhida:");
            menuOption = Integer.parseInt(scanner.nextLine());
            switch (menuOption) {
                case 1: {                    
                    System.out.println("Digite o nome da academia: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o endereço da academia: ");
                    String endereco = scanner.nextLine();
                    
                    LocalDate dataAtual = LocalDate.now();
                    Academia academia = new Academia(0, nome, endereco, dataAtual, dataAtual);
                    academiaDAO.adicionarAcademia(academia);
                    break;
                }
                case 2: {
                    Academia[] academias = academiaDAO.mostrarAcademias();
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
                    break;
                }
                case 3: {
                    if (academiaDAO.mostrarAcademias().length == 0) {
                        System.out.println("Nenhuma academia cadastrada. Impossível alterar.");
                    } else {
                        System.out.println("Digite o ID da academia que deseja alterar:");
                        int id = Integer.parseInt(scanner.nextLine());
                        Academia academiaExistente = academiaDAO.buscarAcademia(id);
                        if (academiaExistente != null) {
                            System.out.println("Digite o novo nome da academia:");
                            String novoNome = scanner.nextLine();
                            System.out.println("Digite o novo endereço da academia:");
                            String novoEndereco = scanner.nextLine();
                            LocalDate dataAtualizacao = LocalDate.now();
                            Academia novaAcademia = new Academia(id, novoNome, novoEndereco, academiaExistente.getDataCriacao(), dataAtualizacao);
                            academiaDAO.alterarAcademia(id, novaAcademia);
                            System.out.println("Academia alterada com sucesso.");
                        } else {
                            System.out.println("Academia não encontrada.");
                        }
                    }
                    break;
                }          
                case 4: { 
                    System.out.println("Digite o ID da academia que deseja buscar:");
                    int idBusca = Integer.parseInt(scanner.nextLine());
                    Academia academiaBuscada = academiaDAO.buscarAcademia(idBusca);
                    if (academiaBuscada != null) {
                        System.out.println("Academia encontrada:");
                        System.out.println("ID: " + academiaBuscada.getId());
                        System.out.println("Nome: " + academiaBuscada.getNome());
                        System.out.println("Endereço: " + academiaBuscada.getEndereço());
                        System.out.println("Data de Criação: " + academiaBuscada.getDataCriacao());
                        System.out.println("Data de Modificação: " + academiaBuscada.getDataModificacao());
                    } else {
                        System.out.println("Academia não encontrada.");
                    }
                    break;
                }  
                case 5: {
                    if (academiaDAO.mostrarAcademias().length == 0) {
                        System.out.println("Nenhuma academia cadastrada. Impossível remover.");
                    } else {
                        System.out.println("Digite o ID da academia que deseja remover:");
                        int id = Integer.parseInt(scanner.nextLine());
                        academiaDAO.removerAcademia(id);
                        System.out.println("Academia removida com sucesso.");
                    }
                    break;
                }
                case 6: {
                    mostrarMenuPrincipal();
                    break;
                }
                default:
                    mostrarOpcaoInvalida();
                    break;
            }
            digitarQualquerTecla();
        }
    }

    public static void pessoaMenu() {
        int menuOption = 0;
        while (menuOption != 6) {
            menuOption = 0;
            System.out.println("======SISTEMA DE GERENCIAMENTO DE PESSOAS======\n");
            System.out.println("Escolha uma opção:\n");
            System.out.println("1 - Adicionar pessoa\n");
            System.out.println("2 - Mostrar todas as pessoas\n");
            System.out.println("3 - Alterar pessoa\n");
            System.out.println("4 - Buscar pessoa\n");
            System.out.println("5 - Remover pessoa\n");
            System.out.println("6 - Sair\n");
            System.out.println("\nDigite a opção escolhida:");
            menuOption = Integer.parseInt(scanner.nextLine());

            switch (menuOption) {
                case 1: {             
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
                    System.out.println("Digite o tipo de usuário (1-Admin, 2-User): ");
                    String tipoUsuario = Integer.parseInt(scanner.nextLine()) == 1 ? "Admin" : "User";

                    LocalDate dataAtual = LocalDate.now();
                    Pessoa pessoa = new Pessoa(0, nome, sexo, nascimento, login, senha, tipoUsuario, dataAtual, dataAtual); 
                    pessoaDAO.adicionarPessoa(pessoa);
                    break;
                }
                case 2: {
                    Pessoa[] pessoas = pessoaDAO.mostrarPessoas();

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
                    break;
                }
                case 3: { 
                    System.out.println("Digite o ID da pessoa que deseja alterar:");
                    int idAlteracao = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite o novo login:");
                    String novoLogin = scanner.nextLine();
                    System.out.println("Digite a nova senha:");
                    String novaSenha = scanner.nextLine();
                    System.out.println("Digite o novo tipo de usuário (1-Admin, 2-User):");
                    String novoTipoUsuario = Integer.parseInt(scanner.nextLine()) == 1 ? "Admin" : "User";

                    pessoaDAO.alterarPessoa(idAlteracao, novoLogin, novaSenha, novoTipoUsuario);
                    System.out.println("Pessoa alterada com sucesso!");
                    break;
                }
                case 4: { 
                    System.out.println("Digite o ID da pessoa que deseja buscar:");
                    int idBusca = Integer.parseInt(scanner.nextLine());
                    Pessoa pessoaBuscada = pessoaDAO.buscarPessoa(idBusca);
                    if (pessoaBuscada != null) {
                        System.out.println("Pessoa encontrada:");
                        System.out.println("ID: " + pessoaBuscada.getId());
                        System.out.println("Nome: " + pessoaBuscada.getNome());
                        System.out.println("Login: " + pessoaBuscada.getLogin());
                        System.out.println("Senha: " + pessoaBuscada.getSenha());
                        System.out.println("Tipo de Usuário: " + pessoaBuscada.getTipoUsuario());
                        System.out.println("Data de Criação: " + pessoaBuscada.getDataCriacao());
                        System.out.println("Data de Modificação: " + pessoaBuscada.getDataModificacao());
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;
                }
                case 5: { 
                    System.out.println("Digite o ID da pessoa que deseja remover:");
                    int idRemocao = Integer.parseInt(scanner.nextLine());
                    pessoaDAO.removerPessoa(idRemocao);
                    System.out.println("Pessoa removida com sucesso!");
                    break;
                }
                case 6:
                    mostrarMenuPrincipal();
                    break;
                default:
                    mostrarOpcaoInvalida();
                    break;
            }
            digitarQualquerTecla();
        }
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

    public static void retornarMenu() {
        mostrarOpcaoInvalida();
        digitarQualquerTecla();
        mostrarMenuPrincipal();
    }
}
