package lab.pkg9;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContentDatabase {
    private final String postsFilePath;
    private final String storiesFilePath;

    public ContentDatabase(String postsFilePath, String storiesFilePath) {
        this.postsFilePath = postsFilePath;
        this.storiesFilePath = storiesFilePath;
    }

    // Save Posts to JSON file
    public void savePosts(ArrayList<Post> posts) throws IOException {
        try (Writer writer = new FileWriter(postsFilePath)) {
            Gson gson = new Gson();
            gson.toJson(posts, writer);
        }
    }

    // Load Posts from JSON file
    public ArrayList<Post> loadPosts() throws IOException {
        try (Reader reader = new FileReader(postsFilePath)) {
            Gson gson = new Gson();
            Type postListType = new TypeToken<ArrayList<Post>>() {}.getType();
            return gson.fromJson(reader, postListType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Return empty list if file doesn't exist
        }
    }

    // Save Stories to JSON file
    public void saveStories(ArrayList<Story> stories) throws IOException {
        try (Writer writer = new FileWriter(storiesFilePath)) {
            Gson gson = new Gson();
            gson.toJson(stories, writer);
        }
    }

    // Load Stories from JSON file
    public ArrayList<Story> loadStories() throws IOException {
        try (Reader reader = new FileReader(storiesFilePath)) {
            Gson gson = new Gson();
            Type storyListType = new TypeToken<ArrayList<Story>>() {}.getType();
            return gson.fromJson(reader, storyListType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Return empty list if file doesn't exist
        }
    }
}
