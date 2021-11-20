package pl.camp.it.sklep.internetowy.GUI;

public class GUI {
    private static final GUI instance = new GUI();


    private GUI() {
    }

    public void showMenu() {
        System.out.println("1. Lista produktów");
        System.out.println("2. Kup produkt");
        System.out.println("3. Wyjdź");

    }

    public static GUI getInstance() {
        return instance;
    }
}
