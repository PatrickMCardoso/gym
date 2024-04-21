/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

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
        int menuOption = 0;
        menuOption = Integer.parseInt(scanner.nextLine());
        return menuOption;
    }

    public static void academiaMenu() {
        int menuOption = 0;
        while (menuOption != 3) {
            menuOption = 0;
            System.out.println("======SISTEMA DE ACADEMIAS======\n");
            System.out.println("Escolha uma opção:\n");
            System.out.println("1 - Adicionar academia\n");
            System.out.println("2 - Mostrar academias\n");
            System.out.println("3 - Sair\n");
            System.out.println("\nDigite a opção escolhida:");
            menuOption = Integer.parseInt(scanner.nextLine());
            switch (menuOption) {
                case 1: {
                    Academia academia = new Academia();
                    System.out.println("Digite o nome da academia: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o endereço da academia: ");
                    String endereco = scanner.nextLine();
                    academia.setNome(nome);
                    academia.setEndereço(endereco);
                    academiaDAO.adicionarAcademia(academia);
                    break;
                }
                case 2: {
                    List<Academia> academias = academiaDAO.mostrarAcademias();

                    System.out.println("------------------------");

                    for (int i = 0; i < academias.size(); i++) {
                        Academia academia = academias.get(i);
                        System.out.println("ID: " + academia.getId());
                        System.out.println("Nome: " + academia.getNome());
                        System.out.println("Endereço: " + academia.getEndereço());
                        System.out.println("Data de Criação: " + academia.getDataCriacao());
                        System.out.println("Data de Modificação: " + academia.getDataModificacao());
                        System.out.println("------------------------");
                    }
                    break;
                }
                case 3: {
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
        while (menuOption != 3) {
            menuOption = 0;
            System.out.println("======SISTEMA DE GERENCIAMENTO DE PESSOAS======\n");
            System.out.println("Escolha uma opção:\n");
            System.out.println("1 - Adicionar pessoa\n");
            System.out.println("2 - Mostrar todas as pessoas\n");
            System.out.println("3 - Sair\n");
            System.out.println("\nDigite a opção escolhida:");
            menuOption = Integer.parseInt(scanner.nextLine());

            switch (menuOption) {
                case 1: {
                    Pessoa pessoa = new Pessoa();
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

                    pessoa.setNome(nome);
                    pessoa.setSexo(sexo);
                    pessoa.setNascimento(nascimento);
                    pessoa.setLogin(login);
                    pessoa.setSenha(senha);
                    pessoa.setTipoUsuario(tipoUsuario);
                    pessoaDAO.adicionarPessoa(pessoa);
                    break;
                }
                case 2: {
                    List<Pessoa> pessoas = pessoaDAO.mostrarPessoas();

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
                case 3:
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
