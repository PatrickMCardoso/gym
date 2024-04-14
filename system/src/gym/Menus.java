/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

import java.util.Scanner;

/**
 *
 * @author ruanemanuell
 */
public class Menus {
    static Scanner scanner = new Scanner(System.in);
    
    public static int showMainMenu(){
        System.out.println("====== HealthierLifeGym ======\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Sistema de Academia\n");
        System.out.println("2 - Sistema de Pessoas\n");
        System.out.println("\nDigite a opção escolhida:");
        int menuOption = 0;
        while(menuOption < 1 || menuOption > 2){
        menuOption = Integer.parseInt(scanner.nextLine());
        }
        return menuOption;
    }
    
    public static void gymMenu(){
        System.out.println("======SISTEMA DE ACADEMIAS======\n");
    }
    
    public static void personMenu(){
        System.out.println("======SISTEMA DE PESSOAS======\n");
    }
}
