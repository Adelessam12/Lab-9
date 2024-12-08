/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */

public class DatabaseUserRepository implements UserRepository {
    private final Database database;

    public DatabaseUserRepository(Database database) {
        this.database = database;
    }

    @Override
    public User findUserById(String userId) {
        return database.getUsers().stream()
            .filter(user -> user.getUserId().equals(userId))
            .findFirst()
            .orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        return database.getUsers().stream()
            .filter(user -> user.getEmail().equals(email))
            .findFirst()
            .orElse(null);
    }

    @Override
    public boolean addUser(User user) {
        ArrayList<User> users = database.getUsers();
        users.add(user);
        return database.saveUsersToFile();
    }

    @Override
    public boolean removeUser(String userId) {
        User user = findUserById(userId);
        if (user != null) {
            database.getUsers().remove(user);
            return database.saveUsersToFile();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return database.saveUsersToFile();
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return database.getUsers();
    }
}
