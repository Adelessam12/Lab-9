/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author DELL
 */
public class GroupDatabaseFactory {
    public static GroupDatabase createDatabase() {
        GroupStorage groupStorage =  new GroupStorage(); // Use the FileUserStorage implementation
   

        
        // Create and return the Database instance
        return GroupDatabase.createInstance(groupStorage);
    }
}
