package pl.camp.it.sklep.internetowy;

import pl.camp.it.sklep.internetowy.GUI.GUI;
import pl.camp.it.sklep.internetowy.authenticate.Authenticator;
import pl.camp.it.sklep.internetowy.database.Database;
import pl.camp.it.sklep.internetowy.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        Database database = Database.getInstance();
        GUI gui = GUI.getInstance();
        Authenticator authenticator = Authenticator.getInstance();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++) {
            //logowanie
            System.out.println("Login:");
            String login = reader.readLine();
            System.out.println("Password:");
            String password = reader.readLine();

            if (!authenticator.authenticate(login, password)) {
                System.out.println("Nieprawidłowe dane !!");
            } else {
                break;
            }

            if(i == 2) {
                return;
            }
        }

        while(true){
            gui.showMenu();

            String choose = reader.readLine();
            switch (choose) {
                case "1":
                    for (Product prod : database.getProducts().values()) {
                        if(prod.isAvailable()) {
                            System.out.println(prod);
                        }
                    }
                    break;
                case "2":
                    System.out.println("Podaj kod produktu który chcesz kupic: ");
                    Product product = database.findProductByCode(reader.readLine());
                    if(product == null) {
                        System.out.println("Nie ma takiego produktu, lub jest niedostepny !!");
                    } else {

                        System.out.println("Dostępne "+ product.getQuantity()+" szt. Ile chcesz zakupić?: ");
                        String quantity = reader.readLine();
                        int number = Integer.parseInt(quantity);
                        if(product.isAvailable() && number < product.getQuantity()){
                            product.setQuantity(product.getQuantity() - number);
                        }
                        else{
                            System.out.println("Bledna ilosc sztuk");
                        }
                    }
                    break;
                case "3":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Nieprawidłowy wybór");
            }
        }

    }
}
