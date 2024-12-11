/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author DELL
 */

class GroupAdmin implements GroupRole{

    public void promoteToCoAdmin(Group group, String userId) {
        if (group.getGroupMembers().getMemberIds().contains(userId) && !group.getGroupCoAdmins().getCoAdminIds().contains(userId)) {
            group.getGroupCoAdmins().addCoAdmin(userId);
        }
    }

    public void demoteCoAdmin(Group group, String userId) {
        if (!group.getGroupMembers().getMemberIds().contains(userId) && group.getGroupCoAdmins().getCoAdminIds().contains(userId)) {
            group.getGroupCoAdmins().removeCoAdmin(userId);
        }
    }

    public void removeMember(Group group, String memberId) {
            group.getGroupMembers().removeMember(memberId);
    }

    public void deleteGroup(GroupManager manager, String groupId) {
        manager.deleteGroup(groupId);
    }

    public void managePost(Group group, String content, String userId) {
        group.addPost(content, userId);
    }
}