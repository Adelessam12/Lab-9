/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface FriendManagable { // interface for Interface Segregation Principle (ISP)

    // Add a friend
    void addFriend(User user, User friend);
    // Remove a friend
    void removeFriend(User user, User friend);
    // Block a user
    void blockUser(User user, User friend);
    // Get the list of friends
    ArrayList<User> getFriendList();
    // Get the list of blocked users
    ArrayList<User> getBlockedList();
    // Check if two users are friends
    boolean isFriend(User user, User friend);
    // Check if a user is blocked
    boolean isBlocked(User user, User friend);
}

