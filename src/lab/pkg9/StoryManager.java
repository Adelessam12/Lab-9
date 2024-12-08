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
public class StoryManager implements StoryManagable{
    private ArrayList<Story> stories;
    private final Database database = DatabaseFactory.createDatabase();

    public StoryManager() {
        stories = new ArrayList<>();
    }

    @Override
    public void addStory(Story story) {
        stories.add(story);
        database.saveUsersToFile();
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
        database.saveUsersToFile();
    }

    @Override
    public void removeStory(Story story) {
        stories.remove(story);       
        database.saveUsersToFile();
    }

    @Override
    public ArrayList<Story> getStories() {
        return stories;
    }
}
