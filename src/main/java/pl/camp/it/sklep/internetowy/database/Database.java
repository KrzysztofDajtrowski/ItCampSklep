package pl.camp.it.sklep.internetowy.database;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.sklep.internetowy.authenticate.Authenticator;
import pl.camp.it.sklep.internetowy.model.Product;
import pl.camp.it.sklep.internetowy.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private Map<String, Product> products = new HashMap<>();
    private List<User> users = new ArrayList<>();

    private static final Database instance = new Database();

    private Database() {
        this.products.put("1", new Product("1", "Mlekowita", "Mleko 2%", 30));
        this.products.put("2", new Product("2", "Nike", "Blue121", 2));
        this.products.put("3", new Product("3", "DDD", "SSSS", 20));
        this.products.put("4", new Product("4", "Tarnawa", "Parasol Majorka", 10));
        this.products.put("5", new Product("5", "Grupa Azoty", "Saletrosan 26 1t", 5));
        this.products.put("6", new Product("6", "ASD", "SDF", 0));
        this.users.add(new User("admin", DigestUtils.md5Hex(Authenticator.MD5_SEED + "admin")));
    }

    public User getUserByLogin(String login) {
        for (User user : this.users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }

    public Product findProductByCode(String productCode) {
        Product product = this.products.get(productCode);
        if (product == null || !product.isAvailable()) {
            return null;
        } else {
            return product;
        }
    }


    public Map<String, Product> getProducts() {
        return products;
    }

    public static Database getInstance() {
        return instance;
    }

}
