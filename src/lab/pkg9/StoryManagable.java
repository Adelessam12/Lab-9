/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface StoryManagable {
    void addStory(Story story);
    public void removeStory(Story story);
    public ArrayList<Story> getStories();
}
