package gym.controller;

import gym.view.Menus;
import gym.model.*;

public class Gym {

    public static void main(String[] args) {
        /////////////////////////////////////////////////////////
        AcademiaDAO academiaDAO = new AcademiaDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();
        ExercicioDAO exercicioDAO = new ExercicioDAO();

        academiaDAO.adicionarAcademiasExemplo();
        pessoaDAO.adicionarPessoasExemplo();
        exercicioDAO.adicionarExercicioExemplos();
        ////////////////////////////////////////////////////////////

        int option = Menus.mostrarMenuPrincipal();
        switch (option) {
            case 1:
                Menus.academiaMenu();
                break;
            case 2:
                Menus.pessoaMenu();
                break;
            case 3:
                Menus.exercicioMenu();
                break;
            case 4:
                break;
            default:
                Menus.retornarMenu();
                break;
        }
    }
}
