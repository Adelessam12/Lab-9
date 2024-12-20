/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;
/**
 *
 * @author DELL
 */
public class GroupAdmin extends GroupCoAdmin implements adminGroupFeatures, coAdminGroupFeatures, GroupRole {


    public GroupAdmin(String memberID, String groupId) {
        super(memberID, groupId);
    }

    @Override
    public void promoteToCoAdmin(String memberId) {
        Group group = GroupManager.findGroupById(groupId);
        if (group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())) {

            if (group.getUsers().get(memberId).contains("Member")) {
                group.getUsers().put(memberId, "CoAdmin");
                UserManager.findUser(memberId).getGroups().put(group.getGroupId(), new GroupCoAdmin(memberId, groupId));
                GroupManager.saveAll();
            }
        }
    }

    @Override
    public void demoteToMember(String memberId) {
        Group group = GroupManager.findGroupById(groupId);
        if (group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())) {
            if (group.getUsers().get(memberId).contains("CoAdmin")) {
                group.getUsers().put(memberId, "Member");
                UserManager.findUser(memberId).getGroups().put(group.getGroupId(), new GroupMember(memberId, groupId));
                GroupManager.saveAll();
            }
        }
    }

    @Override
    public void deleteGroup() {
        Group group = GroupManager.findGroupById(groupId);
        for (String userId : group.getUsers().keySet()) {
            removeMember(userId);
        }
        UserManager.findUser(memberID).getGroups().remove(group.getGroupId());
        GroupManager.removeGroup(group);
        GroupManager.saveAll();

    }

    @Override
   public void leaveGroup(String userId) {
        Group group = GroupManager.findGroupById(groupId);

        System.out.println(UserManager.findUser(userId));
        UserManager.findUser(userId).getGroups().put(groupId, new GroupAdmin(userId, groupId));
        UserManager.findUser(group.getAdminId()).getGroups().remove(group.getGroupId());
        group.getUsers().remove(userId);
        group.setAdminId(userId);
        GroupManager.saveAll();
    }
    @Override
    public void removeMember(String memberId) {
        Group group = GroupManager.findGroupById(groupId);
        if (group.getUsers().containsKey(memberId) && !memberId.equals(group.getAdminId())) {
            group.getUsers().remove(memberId);
            UserManager.findUser(memberId).getGroups().remove(group.getGroupId());
            GroupManager.saveAll();
        }

    }

}
