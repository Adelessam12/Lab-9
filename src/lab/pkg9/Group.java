/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Mahmoud Waleed
 */
public class Group {
    private final String groupId;
    private final String name;

    private final String description;
    private final String groupPhoto;
    private String AdminId;   
    private Map<String, String> users;
    private Map<String, ArrayList<Post>> posts;
    private ArrayList<String> groupRequests;

    public Group(String name, String description, String groupPhoto, String AdminId) {
        this.groupId = generateUniqueId("Group");
        this.name = name;
        this.description = description;
        this.groupPhoto = groupPhoto;
        this.AdminId = AdminId;
        this.users = new HashMap<>();
        this.posts = new HashMap<>();
        this.groupRequests = new ArrayList<>();
    }

    public Map<String, String> getUsers() {
        return users;
    }

    private String generateUniqueId(String prefix) {
        return prefix + "ID" + UUID.randomUUID();
    }
    
    public String getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getGroupPhoto() {
        return groupPhoto;
    }

    public String getAdminId() {
        return AdminId;
    }

    public void setAdminId(String AdminId) {
        this.AdminId = AdminId;
    }

    public Map<String, ArrayList<Post>> getPosts() {
        return posts;
    }

    public void setPosts(Map<String, ArrayList<Post>> posts) {
        this.posts = posts;
    }
    

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }

    public void setGroupRequests(ArrayList<String> groupRequests) {
        this.groupRequests = groupRequests;
    }
    
    public ArrayList<String> getGroupRequests() {
        return groupRequests;
    }
    
  
/*
    public void delete() {
        getCoAdminIds().clear();
        getMemberIds().clear();
        posts.clear();
    }
       public void addMember(String userId) {
        if (!memberIds.contains(userId)) {
            memberIds.add(userId);
        }
    }

    public void removeMember(String userId) {
        memberIds.remove(userId);
    }

    public void addCoAdmin(String userId) {
        if (!coAdminIds.contains(userId)) {
            coAdminIds.add(userId);
        }
    }

    public void removeCoAdmin(String userId) {
        coAdminIds.remove(userId);
    }*/

}