/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PostManager {
        private ArrayList<Story> posts;
    private final Database database = DatabaseFactory.createDatabase();

    public StoryManager() {
        posts = new ArrayList<>();
    }

    @Override
    public void addStory(Story story) {
        posts.add(story);
        database.saveUsersToFile();
    }

    public void setStories(ArrayList<Story> stories) {
        this.posts = stories;
        database.saveUsersToFile();
    }

    @Override
    public void removeStory(Story story) {
        posts.remove(story);       
        database.saveUsersToFile();
    }

    @Override
    public ArrayList<Story> getStories() {
        return posts;
    }
}
}
