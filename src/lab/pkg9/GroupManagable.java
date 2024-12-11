/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author Mahmoud Waleed
 */
public interface GroupManagable {
    public void requestToJoin(User user, Group group);
    public void joinGroup(User user, Group group);
    public void leaveGroup(User user, Group group);
    public void addGroup(Group group);    
    public void removeMember(Group group);
    public void approveRequest(User user, Group group);
    public void declineRequest(User user, Group group);
    public void promote(User user, Group group);
    public void demote(User user, Group group);
    public void addPost();
    public void editPost();
    public void deletePost();
    
}
