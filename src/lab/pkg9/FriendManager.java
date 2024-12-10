/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author DELL
 */
//manages the lower-level details of friendships.
public class FriendManager implements FriendManagable {

    private  ArrayList<String> friendList= new ArrayList<>();
    private  ArrayList<String> blockedList=new ArrayList<>();
    private  FriendRequestManagable friendRequestManager;
    // Constructor to initialize friend and blocked lists
    public FriendManager(FriendRequestManagable friendRequestManager) {

        this.friendRequestManager = friendRequestManager;
    }

    @Override
    public FriendRequestManagable getFriendRequestManager() {
        return friendRequestManager;
    }

    public void setFriendList(ArrayList<String> friendList) {
        this.friendList = friendList;
    }

    public void setBlockedList(ArrayList<String> blockedList) {
        this.blockedList = blockedList;
    }

    public void setFriendRequestManager(FriendRequestManagable friendRequestManager) {
        this.friendRequestManager = friendRequestManager;
    }

    // Add a friend
    @Override
    public void addFriend(User user, User friend) {
        if (!isFriend(user, friend)) {
            friendList.add(friend.getUserId());
            friend.getFriendManager().addFriend(friend, user); // Ensure bidirectional friendship
        }
    }

    // Remove a friend
    @Override
    public void removeFriend(User user, User friend) {
        if (isFriend(user, friend)) {
            friendList.remove(friend.getUserId());
            friend.getFriendManager().removeFriend(friend, user);
            user.getFriendRequestManagable().getSentFriendRequests().remove(friend.getUserId());
            Map<String, String> receivedRequests = friend.getFriendRequestManagable().getReceivedFriendRequests();
            receivedRequests.remove(user.getUserId()); // Removing removed user from both maps
        }
    }

    // Block a user
    @Override
    public void blockUser(User user, User friend) {
        blockedList.add(friend.getUserId());
        removeFriend(user, friend);
    }

    @Override
    public ArrayList<String> getFriendList() {
        return friendList;
    }

    @Override
    public ArrayList<String> getBlockedList() {
        return blockedList;
    }

    // Check if two users are friends
    @Override
    public boolean isFriend(User user, User friend) {
        return friendList.contains(friend.getUserId());
    }

    // Check if a user is blocked
    @Override
    public boolean isBlocked(User user, User friend) {
        return blockedList.contains(friend.getUserId());
    }
}
