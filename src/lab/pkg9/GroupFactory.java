/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author DELL
 */
public class GroupFactory {

    public static Group createGroup(String groupId, String name, String description, String groupPhoto, String adminId) {

        // Create the GroupAdmin
        GroupAdmin admin = new GroupAdmin();

        // Create the GroupCoAdmins
        GroupCoAdmins groupCoAdmins = new GroupCoAdmins();

        // Create the GroupMembers
        GroupMembers groupMembers = new GroupMembers();

        // Return the new Group object
        return new Group(groupId, name, description, groupPhoto, adminId, admin, groupCoAdmins, groupMembers);
}

}
