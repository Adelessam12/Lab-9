/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author DELL
 */
public class GroupCoAdmin extends GroupMember implements coAdminGroupFeatures, GroupRole {
    
    public GroupCoAdmin(String memberID, String groupId) {
       super(memberID,groupId);
    }

    @Override
    public void approveRequest(String userId) {
        Group group = GroupManager.findGroupById(groupId);
       if(group.getGroupRequests().contains(userId)){
       group.getGroupRequests().remove(userId);
       group.getUsers().put(userId, "Member");
       UserManager.findUser(userId).getGroups().put(group.getGroupId(), new GroupMember(userId, groupId));
       GroupManager.saveAll();
       }
    }

    @Override
    public void declineRequest(String userId) {
        Group group = GroupManager.findGroupById(groupId);
        group.getGroupRequests().remove(userId);
        GroupManager.saveAll();
    }

    @Override
    public void removeMember(String memberId) {
        Group group = GroupManager.findGroupById(groupId);
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
        Group group = GroupManager.findGroupById(groupId);
            if(group.getPosts().contains(content)){
                   group.getPosts().remove(content);
               }
        GroupManager.saveAll();
    }


  @Override
    public void editPost(Post content, String newContent, String imagePath) {
        Group group = GroupManager.findGroupById(groupId);
            if(group.getPosts().contains(content)){
                content.setContent(newContent);
                if(imagePath!=null)
                    content.setImagePath(imagePath);
            }
            GroupManager.saveAll();
    }
}

 
