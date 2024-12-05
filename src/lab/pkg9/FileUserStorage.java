/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class FileUserStorage implements UserStorage {
    private final String filename;

    public FileUserStorage(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean saveUsers(ArrayList<User> users) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(users, writer);
            System.out.println("Users saved to file successfully.");
            return true;
        } catch (IOException e) {
            System.err.println("Error saving users to file: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<User> loadUsers() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            ArrayList<User> users = gson.fromJson(reader, userListType);
            if (users == null) {
                users = new ArrayList<>();
            }
            System.out.println("Users loaded from file successfully.");
            return users;
        } catch (IOException e) {
            System.err.println("Error loading users from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}