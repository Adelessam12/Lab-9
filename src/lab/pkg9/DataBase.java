package lab.pkg9;

import java.util.ArrayList;

public final class Database {
    private final UserStorage userStorage;
    private final PasswordHasher passwordHasher;
    ArrayList<User> users= new ArrayList<>();

    public Database(UserStorage userStorage, PasswordHasher passwordHasher) {
        this.userStorage = userStorage;
        this.passwordHasher = passwordHasher;       
        users = this.userStorage.loadUsersFromJson();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean saveUsersToFile() {
        return userStorage.saveUsersToJson(users);
    }

    public String hashPassword(String password) {
        return passwordHasher.hashPassword(password);
    }
}
