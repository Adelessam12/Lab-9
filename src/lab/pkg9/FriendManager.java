/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
//manages the lower-level details of friendships.
public class FriendManager implements FriendManagable{

    private final ArrayList<User> friendList;
    private final ArrayList<User> blockedList;

    // Constructor to initialize friend and blocked lists
    public FriendManager(ArrayList<User> friendList, ArrayList<User> blockedList) {
        this.friendList = friendList;
        this.blockedList = blockedList;
    }

    // Add a friend
    @Override
    public void addFriend(User user, User friend) {
        if (!isFriend(user, friend)) {
            friendList.add(friend);
            friend.getFriendManager().addFriend(friend, user); // Ensure bidirectional friendship
        }
    }

    // Remove a friend
    public void removeFriend(User user, User friend) {
        if (isFriend(user, friend)) {
            friendList.remove(friend);
            friend.getFriendManager().removeFriend(friend, user);
        }

    }

    // Block a user
    @Override
    public void blockUser(User user, User friend) {
        blockedList.add(friend);
        removeFriend(user, friend);
    }

    @Override
    public ArrayList<User> getFriendList() {
        return friendList;
    }

    @Override
    public ArrayList<User> getBlockedList() {
        return blockedList;
    }

    // Check if two users are friends
    @Override
    public boolean isFriend(User user, User friend) {
        return friendList.contains(friend);
    }

    // Check if a user is blocked
    @Override
    public boolean isBlocked(User user, User friend) {
        return blockedList.contains(friend);
    }
}
