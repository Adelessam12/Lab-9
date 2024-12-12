package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;

public class GroupDatabaseTest {

    public static void main(String[] args) {
        // Create an instance of GroupDatabase
        GroupStorage groupStorage;
        //Database db = DatabaseFactory.createDatabase();

        // Create and add some groups
       // User user = UserManager.findUser("ID6a789467-a365-48a4-98ff-a46764273bc8");
        Group group1 = GroupFactory.createGroup("G2", "C2", "path/to/image2.jpg", "Group 2", "Second group description");

        GroupManager g = new GroupManager();
        GroupRole role = new GroupAdmin();
        GroupAdmin admin1 = (GroupAdmin) role;
      Group GROUP1=  g.createGroup("g1", "adel  ", "hello    ", null, "ID6a789467-a365-48a4-98ff-a46764273bc8");    // Save groups to file
       

        // Clear in-memory group data to test loading
        GroupDatabase gdb = GroupDatabaseFactory.createDatabase();
gdb.addGroup(GROUP1);
        // Load groups from file
        // Display loaded groups
        ArrayList<Group> loadedGroups = gdb.loadGroups();
        System.out.println("Loaded Groups:");
        for (Group group : loadedGroups) {
            System.out.println("Group ID: " + group.getGroupId()
                    + ", Name: " + group.getName()
                    + ", Description: " + group.getDescription());
        }
    }
}
