package gym.controller;

import gym.view.Menus;

public class Gym {

    public static void main(String[] args){
        Menus menu = new Menus();
        int option = menu.mostrarMenuPrincipal();
        switch (option) {
            case 1 -> menu.academiaMenu();
            case 2 -> menu.pessoaMenu();
            case 3 -> menu.exercicioMenu();
            case 4 -> {}
            default -> menu.exercicioMenu();
        }
    }
}
