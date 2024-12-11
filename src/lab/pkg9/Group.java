/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Mahmoud Waleed
 */
public class Group {
    private final String groupID;
    private final String creatorID;
    private final String imagePath;
    private final String groupName;
    private final String description;
    private Map<String, String> users;
    private ArrayList<String> groupRequests;


    public Group(String groupID, String creatorID, String imagePath, String groupName, String description) {
        this.groupID = groupID;
        this.creatorID = creatorID;
        this.imagePath = imagePath;
        this.groupName = groupName;
        this.description = description;
        
    }

    public ArrayList<String> getGroupRequests() {
        return groupRequests;
    }
    public void setUsers(User user, String status) {
        users.put(user.getUserId(), status);
    }

    public String getGroupID() {
        return groupID;
    }

    public String getCreatorID() {
        return creatorID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getUsers() {
        return users;
    }
    
}
    
