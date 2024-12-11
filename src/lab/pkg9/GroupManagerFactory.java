/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author DELL
 */
public class GroupManagerFactory {
    public static GroupManager createGroupManager(User user, String roleType) {
        if (user == null || roleType == null || roleType.isBlank()) {
            throw new IllegalArgumentException("User and roleType cannot be null or blank");
        }

        GroupRole role;
        switch (roleType.toLowerCase()) {
            case "member" -> role = new GroupMember(user);
            case "comember" -> role = new GroupCoAdmin(user);
            case "admin" -> role = new GroupAdmin(user);
            default -> throw new IllegalArgumentException("Invalid role type: " + roleType);
        }

        return new GroupManager(role);
    }
}
