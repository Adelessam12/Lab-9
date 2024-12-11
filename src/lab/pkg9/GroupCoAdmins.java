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
class GroupCoAdmins implements GroupRole {

    private final ArrayList<String> coAdminIds;

    public GroupCoAdmins() {
        this.coAdminIds = new ArrayList<>();
    }

    public ArrayList<String> getCoAdminIds() {
        return coAdminIds;
    }

    public void approveMembership(Group group, String userId) {
        group.getGroupMembers().addMember(userId);
    }

    public void addCoAdmin(String userId) {
        if (!coAdminIds.contains(userId)) {
            coAdminIds.add(userId);
        }
    }

    public void removeCoAdmin(String userId) {
        coAdminIds.remove(userId);
    }

    public void removeMember(Group group, String memberId) {
           group.getGroupMembers().removeMember(memberId);
    }

    public void managePost(Group group, String content, String userId) {
          group.addPost(content, userId);
    }
}
