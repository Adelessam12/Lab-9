package lab.pkg9;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public final class Db {

    private final String filename;
    private ArrayList<User> users;

    public Db(String filename) {
        this.filename = filename;
        users = new ArrayList<>();
        loadUsersFromFile();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

   public boolean saveUsersToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Enable pretty printing for readability
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(users, writer);
            System.out.println("Users saved to file successfully.");
            return true;
        } catch (IOException e) {
            System.err.println("Error saving users to file: " + e.getMessage());
            return false;
        }
    }

  public boolean loadUsersFromFile() {
    Gson gson = new Gson();
    try (FileReader reader = new FileReader(filename)) {
        Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
        users = gson.fromJson(reader, userListType);
        if (users == null) {
            users = new ArrayList<>(); // Ensure the list is not null
        }
        System.out.println("Users loaded from file successfully.");
        return true;
    } catch (IOException e) {
        System.err.println("Error loading users from file: " + e.getMessage());
        users = new ArrayList<>(); // Initialize an empty list if loading fails
        return false;
    }
}
    String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
   
}
