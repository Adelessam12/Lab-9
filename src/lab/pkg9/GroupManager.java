/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author Mahmoud Waleed
 */
public class GroupManager {

    private final ArrayList<Group> groups;

    private ArrayList<String> groupRequests;
    private final GroupRole role;

    public GroupManager(GroupRole role) {
        groups = new ArrayList<>();
        this.role = role;
    }

    public ArrayList<String> getGroupRequests() {
        return groupRequests;
    }

    public void requestToJoin(Group group) {
        groupRequests.add(role.getUser().getUserId());
        //
    }



    public void joinGroup(Group group) {
        groups.add(group);
        group.addMember(role.getUser().getUserId());
        role.getUser().getGroups().add(group.getGroupID());
        //
    }

    public boolean isOwner(Group group) {
        return (role.getUser().getUserId().equals(group.getCreatorID()));
    }
}
