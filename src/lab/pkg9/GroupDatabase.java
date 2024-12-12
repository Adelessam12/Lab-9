package lab.pkg9;

import java.util.ArrayList;

public final class GroupDatabase {

    private static GroupDatabase instance; // Singleton instance
    private final GroupStorage groupStorage;

    private ArrayList<Group> Groups;

    // Private constructor to prevent direct instantiation
    private GroupDatabase(GroupStorage groupStorage) {
        this.groupStorage = groupStorage;
        this.Groups = this.groupStorage.loadFromFile();
    }

    // Package-private method to allow Factory access
    static synchronized GroupDatabase createInstance(GroupStorage groupStorage) {
        if (instance == null) {
            instance = new GroupDatabase(groupStorage);
        }
        return instance;
    }

    public boolean saveGroupstofile() {
        return groupStorage.saveToFile(Groups);
    }

    public ArrayList<Group> loadGroups() {
        return Groups;
    }
}
