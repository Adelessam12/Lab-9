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
class GroupCoAdmins extends GroupMembers implements coAdminGroupFeatures {

   private final String coAdminID = null;
   private final Group group = null;

    public GroupCoAdmins(String coAdminID, Group group) {
       super(coAdminID,group);
    }

    @Override
    public void approveRequest(String userId) {
       group.getGroupRequests().remove(userId);
       group.getUsers().put(userId, "Member");
    }

    @Override
    public void declineRequest(String userId) {
        group.getGroupRequests().remove(userId);
    }

    @Override
    public void removeMember(String memberId) {
       if(group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())){
           if(group.getUsers().get(memberId).contains("Member")){
             group.getUsers().remove(memberId);
             UserManager.findUser(memberId).getGroups().remove(group.getGroupId());
           }
       }
           
    }

   @Override
    public void deletePost(String content, String memberId) {
         if(group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())){
           if(group.getUsers().get(memberId).contains("Member"))
               group.getPosts().remove(content);
         }
    }

    @Override
    public void editPost(String content, String memberId, String newContnent) {
        //hmmmmmmmmmmmmmmmmmmmmm
         if(group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())){
           if(group.getUsers().get(memberId).contains("Member")){
               int index = group.getPosts().indexOf(content);
               ArrayList<String> newList = group.getPosts();
               newList.get(index).replace(content, newContnent);
               group.setPosts(newList);            
           }
         }
    }
    
   


 
}
