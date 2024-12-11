package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;

public class GroupDatabaseTest {

    public static void main(String[] args) {
        // Create an instance of GroupDatabase
        GroupStorage groupStorage;

        // Create and add some groups
        User user = UserFactory.createUser("hi", "wtf", "A7A", new Date());
        Group group1 = new Group("G1", "C1", "path/to/image1.jpg", "Group 1", "First group description");
        Group group2 = new Group("G2", "C2", "path/to/image2.jpg", "Group 2", "Second group description");

        GroupManager g = new GroupManager(new GroupAdmin(user));

        // Save groups to file
        
        // Clear in-memory group data to test loading
        GroupDatabase gdb = GroupDatabaseFactory.createDatabase();
        groupStorage = new GroupStorage();
        gdb.addGroup(group2);
        gdb.addGroup(group1);

        // Load groups from file
        // Display loaded groups
        ArrayList<Group> loadedGroups = gdb.loadGroups();
        System.out.println("Loaded Groups:");
        for (Group group : loadedGroups) {
            System.out.println("Group ID: " + group.getGroupID()
                    + ", Name: " + group.getGroupName()
                    + ", Description: " + group.getDescription());
        }
    }
}
