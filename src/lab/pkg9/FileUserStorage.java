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
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create(); // Create a Gson instance with pretty-printing
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String json = prettyGson.toJson(users); // Convert the entire list to a JSON array
            writer.write(json);                    // Write the JSON array to the file
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
            return gson.fromJson(reader, userListType); // Deserialize JSON array
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Returning an empty list.");
            return new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
