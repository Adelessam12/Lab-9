package lab.pkg9;

import java.util.ArrayList;

public final class Database {
    private final UserStorage userStorage;
    private final PasswordHasher passwordHasher;
    private final ArrayList<User> users;

    public Database(UserStorage userStorage, PasswordHasher passwordHasher) {
        this.userStorage = userStorage;
        this.passwordHasher = passwordHasher;
        this.users = userStorage.loadUsersFromJson();
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
