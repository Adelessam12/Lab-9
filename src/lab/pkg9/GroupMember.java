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
 public class GroupMember implements GroupRole, memberGroupFeaturesInterface{


       private final String memberID; 
       private final Group group;

    public GroupMember(String memberID, Group group) {
        this.memberID = memberID;
        this.group = group;
    }

    @Override
    public void addPost(Post content) {
        if(group.getUsers().containsKey(memberID)){
            if(group.getPosts().containsKey(memberID)){
                group.getPosts().get(memberID).add(content);
                GroupManager.saveAll();
            }else{
                group.getPosts().put(memberID, new ArrayList<>());
                addPost(content);
            }
        }
    }
    
    @Override
    public void leaveGroup() {
         if(!memberID.equals(group.getAdminId())){
             UserManager.findUser(memberID).getGroups().remove(group.getGroupId());
             group.getUsers().remove(memberID);
             GroupManager.saveAll();
         }
    }
}
