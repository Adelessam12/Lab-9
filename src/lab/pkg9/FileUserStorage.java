package lab.pkg9;

import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileUserStorage implements UserStorage {

    private final String filename;
    private final Gson gson;

    public FileUserStorage(String filename) {
        this.filename = filename;

        // Create a Gson instance with custom InstanceCreators
        this.gson = new GsonBuilder()
                .registerTypeAdapter(FriendManagable.class, new FriendManagableCreator())
                .registerTypeAdapter(PostManagable.class, new PostManagableCreator())
                .registerTypeAdapter(StoryManagable.class, new StoryManagableCreator())
                .create();
    }

    // Save users to JSON file
    @Override
    public boolean saveUsersToJson(ArrayList<User> users) {
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String json = prettyGson.toJson(users);
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
        try (Reader reader = new FileReader(filename)) {
            Type userListType = new TypeToken<ArrayList<User>>() {
            }.getType();
            ArrayList<User> users = gson.fromJson(reader, userListType); // Deserialize JSON array

            // Debugging: Log the loaded users
            if (users != null) {
                System.out.println("Loaded users from file:");
                for (User user : users) {
                    System.out.println(user); // Ensure User has a proper `toString` method
                }
            } else {
                System.out.println("No users found in the file.");
            }
            return users != null ? users : new ArrayList<>();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename + ". Returning an empty list.");
            return new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Unexpected error during deserialization: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
            return new ArrayList<>();
        }
    }

}
