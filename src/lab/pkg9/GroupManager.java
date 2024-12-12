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
    private static final ArrayList<Group> groups = new ArrayList<>();
    private static final GroupDatabase groupDatabase = GroupDatabaseFactory.createDatabase();
    
   // public Group createGroup(String groupId, String name, String description, String groupPhoto, String adminId) {
      //  Group group = GroupFactory.createGroup(groupId, name, description, groupPhoto, adminId);
       // groups.add(group);
        //groupDatabase.saveGroupstofile();
        //return group;
  //  }


    
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
         Group group1 = new Group("123", "TheGroup", "desc", "C:\\programming 2\\connectHub\\OIP.jpeg", "admin");
         
         User mah = UserFactory.createUser("mah@","mah","mahPass",currentDate);
         System.out.println("Mah Created");
         System.out.println(group1.getGroupRequests());
         System.out.println(group1.getUsers());
         System.out.println("Mah Request");
         requestToJoin(mah, group1);
         System.out.println(group1.getGroupRequests());
         System.out.println(group1.getUsers());
         
     }
}
