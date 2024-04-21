package gym.controller;

import gym.Menus;

public class Gym {
    public static void main(String[] args) {
        int option = Menus.mostrarMenuPrincipal();
        switch(option){
            case 1:
                Menus.academiaMenu();
            break;
            case 2:
                Menus.pessoaMenu();
            break;
        }
    }
}
