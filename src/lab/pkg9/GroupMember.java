/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author DELL
 */
public class GroupMember extends GroupRole{
    private User user;
    public GroupMember(User user) {
        super(user);
    }
    
    public void leaveGroup(Group group) {
            group.getGroupMembers().remove(user.getUserId());
            user.getGroups().remove(group.getGroupID());
            //
    }
       
}
