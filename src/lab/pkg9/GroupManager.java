/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mahmoud Waleed
 */
class GroupManager {

    private static final GroupDatabase groupDatabase = GroupDatabaseFactory.createDatabase();
    private static final Database userDatabase = DatabaseFactory.createDatabase();
    private static ArrayList<Group> groups = groupDatabase.loadGroups();

    public static Group createGroup(String groupId, String name, String description, String groupPhoto, String adminId) {
        Group group = new Group(groupId, name, description, groupPhoto, adminId);
        addGroup(group);
        UserManager.findUser(adminId).getGroups().put(group.getGroupId(), new GroupAdmin(adminId, group));
        groupDatabase.saveGroupstofile();
        return group;
    }

    public static void saveAll() {
        userDatabase.saveUsersToFile();
        groupDatabase.saveGroupstofile();
    }

    public static void addGroup(Group group) {
        if (groups == null) {
            groups = new ArrayList<>();
        }
        groups.add(group);
        groupDatabase.saveGroupstofile();
    }

    public static void removeGroup(Group group) {
        groups.remove(group);
        groupDatabase.saveGroupstofile();
    }

    public static void requestToJoin(User user, Group group) {
        group.getGroupRequests().add(user.getUserId());
    }

    public static Group findGroupById(String groupId) {
        for (Group group : groups) {
            if (group.getGroupId().equals(groupId)) {
                return group;
            }
        }
        return null;
    }


}
