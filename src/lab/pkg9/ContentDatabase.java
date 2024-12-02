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

    public void savePosts(ArrayList<Post> posts) throws IOException {
        try (Writer writer = new FileWriter(postsFilePath)) {
            Gson gson = new Gson();
            gson.toJson(posts, writer);
        }
    }

    public ArrayList<Post> loadPosts() throws IOException {
        try (Reader reader = new FileReader(postsFilePath)) {
            Gson gson = new Gson();
            Type postListType = new TypeToken<ArrayList<Post>>() {}.getType();
            return gson.fromJson(reader, postListType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public void saveStories(ArrayList<Story> stories) throws IOException {
        try (Writer writer = new FileWriter(storiesFilePath)) {
            Gson gson = new Gson();
            gson.toJson(stories, writer);
        }
    }

    public ArrayList<Story> loadStories() throws IOException {
        try (Reader reader = new FileReader(storiesFilePath)) {
            Gson gson = new Gson();
            Type storyListType = new TypeToken<ArrayList<Story>>() {}.getType();
            return gson.fromJson(reader, storyListType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
