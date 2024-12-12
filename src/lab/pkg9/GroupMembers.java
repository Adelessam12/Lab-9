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
class GroupMembers implements GroupRole, memberGroupFeaturesInterface{

       private final String memberID; 
       private final Group group;

    public GroupMembers(String memberID, Group group) {
        this.memberID = memberID;
        this.group = group;
    }

    @Override
    public void addPost(String userId, String content) {
        if(group.getUsers().containsKey(userId))
            group.getPosts().add(content);
    }

    @Override
    public void leaveGroup() {
         if(!memberID.equals(group.getAdminId())){
             UserManager.findUser(memberID).getGroups().keySet().remove(group.getGroupId());
             group.getUsers().keySet().remove(memberID);
         }
    }

 
}
