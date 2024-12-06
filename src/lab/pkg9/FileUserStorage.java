package lab.pkg9;


import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileUserStorage implements UserStorage {

    private final String filename;
    private Gson gson;

    public FileUserStorage(String filename) {
        this.filename = filename;

        // Create a Gson instance with custom InstanceCreators
        this.gson = new GsonBuilder()
            .registerTypeAdapter(FriendRequestManagable.class, new FriendRequestManagableCreator())
            .registerTypeAdapter(FriendManagable.class, new FriendManagableCreator())
            .registerTypeAdapter(PostManagable.class, new PostManagableCreator())
            .registerTypeAdapter(StoryManagable.class, new StoryManagableCreator())
            .create();
    }

    // Save users to JSON file
    @Override
    public boolean saveUsersToJson(ArrayList<User> users) {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(users, writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Load users from JSON file
    @Override
    public ArrayList<User> loadUsersFromJson() {
        try (Reader reader = new FileReader(filename)) {
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            return gson.fromJson(reader, userListType);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Returning an empty list.");
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
