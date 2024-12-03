/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Mahmoud Waleed
 */
public class Friend_Management {
    Db db;

    Db db;
    
    public Friend_Management(Db db) {
        this.db = db;
    }

    public void setSentRequestStatus(User friend, User user, String status) {
        Map m = friend.getSentFriendRequestStatus();
        m.put(user.getUserId(), status);
    }

    public void setRecievedRequestStatus(User user, User friend, String status) {
        Map m = friend.getReceivedFriendRequestStatus();
        m.put(user.getUsername(), status);
    }

    public void sendFriendRequest(User user, User friend) {
        setSentRequestStatus(user, friend, "Pending");
        setSentRequestStatus(friend, user, "Pending");
    }

    public void acceptFriendRequest(User user, User friend) {
        setRecievedRequestStatus(friend, user, "Accepted");
        setSentRequestStatus(user, friend, "Accepted");
        user.addFriend(friend);
        friend.addFriend(user);
    }

    public void declineFriendRequest(User user, User friend) {
        setSentRequestStatus(user, friend, "Declined");
        setRecievedRequestStatus(friend, user, "Declined");
    }

    public void removeFriend(User user, User friend) {
        user.removeFriend(friend);
        friend.removeFriend(user);
    }

    public void blockFriend(User user, User friend) {
        user.removeFriend(friend);
        friend.removeFriend(user);
        user.addToBlocked(friend);
    }

    public ArrayList<User> suggestions(User user) {
        ArrayList<User> suggestions = new ArrayList<>();
        for (User suggested : db.getUsers()) {
            if (!suggested.equals(user) && !user.getFriendList().contains(suggested) && !user.getBlockedList().contains(suggested)) {
                suggestions.add(suggested);
                for (User commonFriend : user.getFriendList()) {
                    if (suggested.getFriendList().contains(commonFriend)) {
                        System.out.println("Has mutual friends");
                    }
                }

            }
        }
        return suggestions;
    }

}
