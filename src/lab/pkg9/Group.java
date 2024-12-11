/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author Mahmoud Waleed
 */
class Group {
    private final String groupId;
    private final String name;
    private final String description;
    private final String groupPhoto;
    private final String AdminId;   
    
    private final GroupAdmin admin;
    private final GroupCoAdmins groupCoAdmins;
    private final GroupMembers groupMembers;  
    private final ArrayList<String> posts;

    public Group(String groupId, String name, String description, String groupPhoto, String AdminId, GroupAdmin admin, GroupCoAdmins groupCoAdmins, GroupMembers groupMembers) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.groupPhoto = groupPhoto;
        this.AdminId = AdminId;
        this.admin = admin;
        this.groupCoAdmins = groupCoAdmins;
        this.groupMembers = groupMembers;
        this.posts = new ArrayList<>();
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

    public ArrayList<String> getPosts() {
        return posts;
    }
  

    public void addPost(String content, String userId) {
        if (groupMembers.getMemberIds().contains(userId) || groupCoAdmins.getCoAdminIds().contains(userId) || userId.equals(AdminId)) {
            posts.add(content);
        }
    }
    
    public void leaveGroup(String userId){
        if(!userId.equals(AdminId)){
            if(getGroupCoAdmins().getCoAdminIds().contains(userId)){
                getGroupCoAdmins().getCoAdminIds().remove(userId);
            }else if(getGroupMembers().getMemberIds().contains(userId)){
                 getGroupMembers().getMemberIds().remove(userId);
            }
        }
    }

    public GroupAdmin getAdmin() {
        return admin;
    }

    public GroupCoAdmins getGroupCoAdmins() {
        return groupCoAdmins;
    }

    public GroupMembers getGroupMembers() {
        return groupMembers;
    }

    public void delete() {
        groupCoAdmins.getCoAdminIds().clear();
        groupMembers.getMemberIds().clear();
        posts.clear();
    }
}