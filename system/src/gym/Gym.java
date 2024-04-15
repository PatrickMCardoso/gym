package gym;

public class Gym {
    public static void main(String[] args) {
        int option = Menus.showMainMenu();
        switch(option){
            case 1:
                Menus.gymMenu();
            break;
            case 2:
                Menus.personMenu();
            break;
        }
    }
}
