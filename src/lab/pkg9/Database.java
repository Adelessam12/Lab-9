package lab.pkg9;

import java.util.ArrayList;

public final class Database {
    private static Database instance; // Singleton instance
    private final UserStorage userStorage;
    private final PasswordHasher passwordHasher;
    private ArrayList<User> users;

    // Private constructor to prevent direct instantiation
    private Database(UserStorage userStorage, PasswordHasher passwordHasher) {
        this.userStorage = userStorage;
        this.passwordHasher = passwordHasher;
        this.users = this.userStorage.loadUsersFromJson();
    }

    // Package-private method to allow Factory access
    static synchronized Database createInstance(UserStorage userStorage, PasswordHasher passwordHasher) {
        if (instance == null) {
            instance = new Database(userStorage, passwordHasher);
        }
        return instance;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        if(users == null){
            users = new ArrayList<>();
        }
        users.add(user);
        saveUsersToFile();
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