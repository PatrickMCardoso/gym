package gym.controller;

import gym.view.Menus;
import gym.model.AcademiaDAO;
import gym.model.PessoaDAO;

public class Gym {

    public static void main(String[] args) {
        /////////////////////////////////////////////////////////
        AcademiaDAO academiaDAO = new AcademiaDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        academiaDAO.adicionarAcademiasExemplo();
        pessoaDAO.adicionarPessoasExemplo();
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
                break;
            default:
                Menus.retornarMenu();
                break;
        }
    }
}
