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
public class GroupManager implements GroupManagable {
    private ArrayList<Group> groups; 

    public GroupManager() {
        groups = new ArrayList<>();
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    @Override
    public void requestToJoin(User user, Group group) {
        group.getGroupRequests().add(user.getUserId());
    }
    @Override
    public void joinGroup(User user, Group group) {
      group.setUsers(user, "Member");
    }


    @Override
    public void leaveGroup(User user, Group group) {
        group.getUsers().remove(user.getUserId());
    }
    
    @Override
    public void addGroup(Group group) {
        groups.add(group);
        Database database = DatabaseFactory.createDatabase();
        database.saveUsersToFile();
    }
    
}
