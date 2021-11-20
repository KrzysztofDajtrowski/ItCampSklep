package pl.camp.it.sklep.internetowy.authenticate;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.sklep.internetowy.database.Database;
import pl.camp.it.sklep.internetowy.model.User;

public class Authenticator {

        public static final String MD5_SEED = "96z6Gva6LwjzxHPBvobEDvtwsH7EQFW0skX7";
        private static final Authenticator instance = new Authenticator();

        private Authenticator() {
        }

        public boolean authenticate(String login, String password) {
            Database database = Database.getInstance();
            User user = database.getUserByLogin(login);
            return user != null && user.getPassword().equals(DigestUtils.md5Hex(MD5_SEED + password));
        }

        public static Authenticator getInstance() {
            return instance;
        }

}
