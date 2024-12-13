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
public class GroupCoAdmin extends GroupMember implements coAdminGroupFeatures, GroupRole {
    
    public GroupCoAdmin(String memberID, Group group) {
       super(memberID,group);
    }

    @Override
    public void approveRequest(String userId) {
       if(group.getGroupRequests().contains(userId)){
       group.getGroupRequests().remove(userId);
       group.getUsers().put(userId, "Member");
       UserManager.findUser(userId).getGroups().put(group.getGroupId(), new GroupMember(userId, group));
       GroupManager.saveAll();
       }
    }

    @Override
    public void declineRequest(String userId) {
        group.getGroupRequests().remove(userId);
        GroupManager.saveAll();
    }

    @Override
    public void removeMember(String memberId) {
       if(group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())){
           if(group.getUsers().get(memberId).contains("Member")){
             group.getUsers().remove(memberId);
             UserManager.findUser(memberId).getGroups().remove(group.getGroupId());
             GroupManager.saveAll();
           }
       }
           
    }

    @Override

    public void deletePost(Post content) {
            if(group.getPosts().contains(content)){
                   group.getPosts().remove(content);
               }
        GroupManager.saveAll();
    }


  @Override
    public void editPost(Post content, String newContent, String imagePath) {
            if(group.getPosts().contains(content)){
                content.setContent(newContent);
                if(imagePath!=null)
                    content.setImagePath(imagePath);
            }
            GroupManager.saveAll();
    }
}

 
