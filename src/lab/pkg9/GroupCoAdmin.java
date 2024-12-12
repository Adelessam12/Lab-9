/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author DELL
 */
class GroupCoAdmin extends GroupMember implements coAdminGroupFeatures, GroupRole {

   private String coAdminID;
   private Group group;
    
    public GroupCoAdmin(String coAdminID, Group group) {
       super(coAdminID,group);  
    }

    @Override
    public void approveRequest(String userId) {
       group.getGroupRequests().remove(userId);
       group.getUsers().put(userId, "Member");
       UserManager.findUser(userId).getGroups().put(group.getGroupId(), new GroupMember(userId, group));
       GroupManager.saveAll();
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
    public void deletePost(String memberId, String content) {
        if (group.getUsers().containsKey(memberId) && group.getPosts().containsKey(memberId)){
            if(group.getPosts().get(memberId).contains(content)){
               group.getPosts().get(memberId).remove(content);
               if(group.getPosts().get(memberId).isEmpty()){
                   group.getPosts().remove(memberId);
               }
            }
        }
        GroupManager.saveAll();
    }

    @Override
    public void editPost(String memberId, String content, String newContent) {
        //hmmmmmmmmmmmmmmmmmmmmm
        if (group.getUsers().containsKey(memberId) && group.getPosts().containsKey(memberId)) {
            if(group.getPosts().get(memberId).contains(content)){
                deletePost(memberId, content);
                User user = UserManager.findUser(memberId);
                //user.getGroups().get(group.getGroupId()).((GroupMember)addPost)(newContent);
            }    
        }
    }
    
}
    
   


 
