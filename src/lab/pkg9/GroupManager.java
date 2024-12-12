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

    public static void main(String args[]) {
        Date currentDate = new Date();
        User admin = UserFactory.createUser("ahm@", "ahm", "mahPass", currentDate);
        Group group1 = GroupManager.createGroup("123", "TheGroup", "desc", "C:\\programming 2\\connectHub\\OIP.jpeg", admin.getUserId());
        User mah = UserFactory.createUser("mah@", "mah", "mahPass", currentDate);
        System.out.println("Mah Created");
        System.out.println(group1.getGroupRequests());
        System.out.println(group1.getUsers());
        System.out.println("Mah Request");
        requestToJoin(mah, group1);
        admin.getGroups().get(group1.getGroupId()).
        System.out.println(group1.getGroupRequests());
        System.out.println(group1.getUsers());

    }
}
