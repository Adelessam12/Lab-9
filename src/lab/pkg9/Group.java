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
    private final ArrayList<String> groupCoAdmins;
    private final ArrayList<String> groupMembers;

    public Group(String groupID, String creatorID, String imagePath, String groupName, String description) {
        this.groupID = groupID;
        this.creatorID = creatorID;
        this.imagePath = imagePath;
        this.groupName = groupName;
        this.description = description;
        this.groupCoAdmins = new ArrayList<>();
        this.groupMembers = new ArrayList<>();
    }
    
    public void addCoAdmin(String groupCoAdmin){
        groupCoAdmins.add(groupCoAdmin);
    }
    public void addMember(String member){
        groupMembers.add(member);
    }
    

    public ArrayList<String> getGroupCoAdmins() {
        return groupCoAdmins;
    }

    public ArrayList<String> getGroupMembers() {
        return groupMembers;
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
    
}
    
