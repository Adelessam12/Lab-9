package lab.pkg9;

import com.google.gson.reflect.TypeToken;
import com.google.gson.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileUserStorage implements UserStorage {

    private final String filename;
    private final Gson gson;

    public FileUserStorage(String filename) {
        this.filename = filename;

        // Create a Gson instance with custom Deserializers
        this.gson = new GsonBuilder()
                .registerTypeAdapter(FriendRequestManagable.class, new FriendRequestManagableDeserializer())
                .registerTypeAdapter(FriendManagable.class, new FriendManagableDeserializer())
                .registerTypeAdapter(PostManagable.class, new PostManagableDeserializer())
                .registerTypeAdapter(StoryManagable.class, new StoryManagableDeserializer())
                .setPrettyPrinting()
                .create();
    }

    // Save users to JSON file
    @Override
    public boolean saveUsersToJson(ArrayList<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String json = gson.toJson(users);
            System.out.println("Serialized JSON: " + json); // Log serialized JSON
            writer.write(json);
            return true;
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
            return false;
        }
    }

    // Load users from JSON file
    @Override
    public ArrayList<User> loadUsersFromJson() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Define the type of ArrayList<User>
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            ArrayList<User> users = gson.fromJson(reader, userListType);

            if (users != null) {
                for (User user : users) {
                    System.out.println("Loaded User: " + user);
                }
            } else {
                System.out.println("No users found in the JSON file.");
            }
            return users;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return new ArrayList<>(); // Return an empty list on error
    }
}
