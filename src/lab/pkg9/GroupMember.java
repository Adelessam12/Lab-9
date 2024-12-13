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


       protected final String memberID; 
       protected final Group group;

    public GroupMember(String memberID, Group group) {
        this.memberID = memberID;
        this.group = group;
    }

    @Override
    public void addPost(Post content) {
                group.getPosts().add(content);
                GroupManager.saveAll();
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
