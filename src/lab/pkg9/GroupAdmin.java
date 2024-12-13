/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;
/**
 *
 * @author DELL
 */
public class GroupAdmin extends GroupCoAdmin implements adminGroupFeatures, GroupRole {

    private Group group2;
    private String adminId;

    public GroupAdmin(String adminId, Group group) {
        super(adminId, group);
    }

    @Override
    public void promoteToCoAdmin(String memberId) {
        if (group2.getUsers().containsKey(memberId) && !memberId.equals(group2.getAdminId())) {

            if (group2.getUsers().get(memberId).contains("Member")) {
                group2.getUsers().put(memberId, "CoAdmin");
                UserManager.findUser(memberId).getGroups().put(group2.getGroupId(), new GroupCoAdmin(memberId, group2));
                GroupManager.saveAll();
            }
        }
    }

    @Override
    public void demoteToMember(String memberId) {
        if (group2.getUsers().containsKey(memberId) && !memberId.equals(group2.getAdminId())) {
            if (group2.getUsers().get(memberId).contains("CoAdmin")) {
                group2.getUsers().put(memberId, "Member");
                UserManager.findUser(memberId).getGroups().put(group2.getGroupId(), new GroupMember(memberId, group2));
                GroupManager.saveAll();
            }
        }
    }

    @Override
    public void deleteGroup() {
        for (String userId : group2.getUsers().keySet()) {
            removeMember(userId);
        }
        UserManager.findUser(adminId).getGroups().remove(group2.getGroupId());
        GroupManager.removeGroup(group2);
        GroupManager.saveAll();

    }

    @Override
    public void leaveGroup() {

        if (group2.getUsers().isEmpty()) {
            deleteGroup();
            return;
        }
        for (String userID : group2.getUsers().keySet()) {
            if (group2.getUsers().get(userID).contains("CoAdmin")) {
                group2.setAdminId(userID);
                UserManager.findUser(adminId).getGroups().remove(group2.getGroupId());
                GroupManager.saveAll();
                return;
            }
        }
        UserManager.findUser(adminId).getGroups().remove(group2.getGroupId());
        group2.setAdminId(group2.getUsers().keySet().iterator().next());//sets first normal member to admin
        GroupManager.saveAll();
    }

    @Override
    public void removeMember(String memberId) {
        if (group2.getUsers().containsKey(memberId) && !memberId.equals(group2.getAdminId())) {
            group2.getUsers().remove(memberId);
            UserManager.findUser(memberId).getGroups().remove(group2.getGroupId());
            GroupManager.saveAll();
        }

    }

}
