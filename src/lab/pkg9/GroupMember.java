/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author DELL
 */
 public class GroupMember implements GroupRole, memberGroupFeaturesInterface{


       private final String memberID; 
       private final Group group1;

    public GroupMember(String memberID, Group group) {
        this.memberID = memberID;
        this.group1 = group;
    }

    @Override
    public void addPost(Post content) {
                group1.getPosts().add(content);
                GroupManager.saveAll();
    }
    
    @Override
    public void leaveGroup() {
         if(!memberID.equals(group1.getAdminId())){
             UserManager.findUser(memberID).getGroups().remove(group1.getGroupId());
             group1.getUsers().remove(memberID);
             GroupManager.saveAll();
         }
    }
}
