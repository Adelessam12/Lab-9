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
       protected final String groupId;

    public GroupMember(String memberID, String groupId) {
        this.memberID = memberID;
        this.groupId = groupId;
    }

    @Override
    public void addPost(Post content) {
                Group group = GroupManager.findGroupById(groupId);
                group.getPosts().add(content);
                GroupManager.saveAll();
    }
    
    @Override
    public void leaveGroup() {
        Group group = GroupManager.findGroupById(groupId);
         if(!memberID.equals(group.getAdminId())){
             UserManager.findUser(memberID).getGroups().remove(group.getGroupId());
             group.getUsers().remove(memberID);
             GroupManager.saveAll();
         }
    }
}
