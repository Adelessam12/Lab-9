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
    private final User user;

    public GroupManager(User user) {
        groups = new ArrayList<>();
        this.user = user;
    }

    public void requestToJoin(Group group) {
        group.getGroupRequests().add(user.getUserId());
    }

    public void joinGroup(Group group) {
        group.setUsers(user.getUserId(), "Member");
        user.getGroups().add(group.getGroupID());
    }

    public void leaveGroup(Group group) {
        group.getUsers().remove(user.getUserId());
        user.getGroups().remove(group.getGroupID());
    }

    public void addGroup(Group group) {
        groups.add(group);
        Database database = DatabaseFactory.createDatabase();
        database.saveUsersToFile();
    }

    public void removeMember(Group group) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void approveRequest(Group group) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void declineRequest(Group group) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void promote(Group group) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void demote(Group group) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void addPost() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void editPost() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deletePost() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
