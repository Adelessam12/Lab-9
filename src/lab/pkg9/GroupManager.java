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
class GroupManager {
    private final ArrayList<Group> groups;
    private final GroupDatabase groupDatabase;
    
    public GroupManager() {
        this.groups = new ArrayList<>();
        groupDatabase = GroupDatabaseFactory.createDatabase();
    }

    public Group createGroup(String groupId, String name, String description, String groupPhoto, String adminId) {
        Group group = GroupFactory.createGroup(groupId, name, description, groupPhoto, adminId);
        groups.add(group);
        groupDatabase.saveGroupstofile();
        return group;
    }

    public void deleteGroup(String groupId) {
        Group group = findGroupById(groupId);
        if (group != null) {
            groups.remove(group);
        groupDatabase.saveGroupstofile();
        }
    }

    private Group findGroupById(String groupId) {
        for (Group group : groups) {
            if (group.getGroupId().equals(groupId)) {
                return group;
            }
        }
        return null;
    }
}
