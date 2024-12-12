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

class GroupAdmin extends GroupCoAdmins implements adminGroupFeatures{ 
       private Group group;
       private String adminId;
       private final GroupDatabase gDB;

    public GroupAdmin(String adminId, Group group, GroupDatabase gDB) {
        super(adminId, group);
        this.gDB = gDB;
    }

    @Override
    public void promoteToCoAdmin(String memberId) {
        if(group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())){
           if(group.getUsers().get(memberId).contains("Member")){
               group.getUsers().put(memberId, "CoAdmin");
           }
               }
    }

    @Override
    public void demoteToMember(String memberId) {
        if(group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())){
           if(group.getUsers().get(memberId).contains("CoAdmmin")){
               group.getUsers().put(memberId, "Member");
           }
               }
    }

    @Override
    public void deleteGroup() {
        for(String userId: group.getUsers().keySet()){
            removeMember(userId);
        }
        gDB.removeGroup(group);
        
    }
    
       @Override
    public void leaveGroup(){
        if(adminId.equals(group.getAdminId()))
        {
            if(group.getUsers().isEmpty())
                deleteGroup();
            for(String userID: group.getUsers().keySet()){
                if(group.getUsers().get(userID).contains("CoAdmin")){
                    group.setAdminId(userID);
                     return;
                }
            }
            group.setAdminId(group.getUsers().keySet().iterator().next());//sets first normal member to admin
        }
    }
    @Override
    public void removeMember(String memberId) {
       if(group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())){
           if(group.getUsers().get(memberId).contains("Member") || group.getUsers().get(memberId).contains("CoAdmin")){
             group.getUsers().remove(memberId);
             UserManager.findUser(memberId).getGroups().remove(group.getGroupId());
           }
       }
           
    }
      @Override
    public void deletePost(String content, String memberId) {
         if(group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())){
           if(group.getUsers().get(memberId).contains("Member") || group.getUsers().get(memberId).contains("CoAdmin"))
               group.getPosts().remove(content);
         }
    }
    @Override
    public void editPost(String content, String memberId, String newContnent) {
        //hmmmmmmmmmmmmmmmmmmmmm
         if(group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())){
           if(group.getUsers().get(memberId).contains("Member") || group.getUsers().get(memberId).contains("CoAdmin")){
               int index = group.getPosts().indexOf(content);
               ArrayList<String> newList = group.getPosts();
               newList.get(index).replace(content, newContnent);
               group.setPosts(newList);            
           }
         }
    }

}