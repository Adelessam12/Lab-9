package lab.pkg9.p1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class Db {

    private String filename;
    private ArrayList<User> users = new ArrayList<>();

    public Db(String filename) {
        this.filename = filename;
        loadUsersFromFile();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void saveUsersToFile() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(users, writer); 
            System.out.println("Users saved to file successfully.");
        } catch (IOException e) {
            System.err.println("Error saving users to file: " + e.getMessage());
        }
    }

    public void loadUsersFromFile() {
        Gson gson = new Gson();
        users.clear();

        try (FileReader reader = new FileReader(filename)) {
            Type userListType = new TypeToken<ArrayList<User>>() {
            }.getType();
            users = gson.fromJson(reader, userListType); 
            System.out.println("Users loaded from file successfully.");
        } catch (IOException e) {
            System.err.println("Error loading users from file: " + e.getMessage());
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
