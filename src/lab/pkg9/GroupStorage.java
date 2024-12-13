package lab.pkg9;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * A utility class to manage saving and loading groups using Gson.
 * Provides functionality to save and load an ArrayList of Group objects.
 * @author Mahmoud Waleed
 */
public class GroupStorage {

    private static final String FILE_PATH = "groups.json";

    public GroupStorage() {
    }

    /**
     * Saves the provided list of groups to a JSON file.
     * @param groups The list of Group objects to save.
     * @return true if the save operation is successful, false otherwise.
     */
    public boolean saveToFile(ArrayList<Group> groups) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(groups, writer);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving groups to file: " + e.getMessage());
            return false;
        }
    }

    /**
     * Loads the groups from a JSON file and returns them as an ArrayList.
     * @return An ArrayList of Group objects loaded from the file, or an empty list if an error occurs.
     */
    public ArrayList<Group> loadFromFile() {
    try (FileReader reader = new FileReader(FILE_PATH)) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Group>>() {}.getType();
        ArrayList<Group> loadedGroups = gson.fromJson(reader, type);
        System.out.println("Loaded groups: " + loadedGroups); // Debugging output
        return loadedGroups != null ? loadedGroups : new ArrayList<>();
    } catch (IOException e) {
        System.err.println("Error loading groups from file: " + e.getMessage());
        return new ArrayList<>();
    }
//      public ArrayList<User> loadUsersFromJson() {
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            // Define the type of ArrayList<User>
//            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
//            ArrayList<User> users = gson.fromJson(reader, userListType);
//
//            if (users == null) {
//              users = new ArrayList<>();
//            } 
//            return users;
//        } catch (FileNotFoundException e) {
//            //System.out.println("File not found: " + filename);
//        } catch (IOException e) {
//          //  System.out.println("Error loading users: " + e.getMessage());
//        }
//        return new ArrayList<>(); // Return an empty list on error
//    }
}

}
