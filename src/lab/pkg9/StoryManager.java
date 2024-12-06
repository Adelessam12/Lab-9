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

    public StoryManager() {
        stories = new ArrayList<>();
    }

    @Override
    public void addStory(Story story) {
        stories.add(story);
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }

    @Override
    public void removeStory(Story story) {
        stories.remove(story);
    }

    @Override
    public ArrayList<Story> getStories() {
        return stories;
    }
}
