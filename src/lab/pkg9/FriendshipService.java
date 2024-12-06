/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 *
 * @author Mahmoud Waleed + Ahmed Alaa+Adel Essam
 *
 */
public class FriendshipService implements FriendshipServiceInterface {

    private final Database db;
    private final User user;

    public FriendshipService(Database db, User user) {
        this.db = db;
        this.user = user;
    }

    @Override
    public void sendFriendRequest(User friend) {
        user.getFriendRequestManagable().setSentRequestStatus(friend, "Pending");
         friend.getFriendRequestManagable().setReceivedRequestStatus(user, friend, "Pending");
    }

    @Override
    public void acceptFriendRequest(User friend) {
        // Check if the users are already friends
        if (user.getFriendManager().isFriend(user, friend)) {
            return; // Already friends
        }

        // Set friend request status to Accepted
        user.getFriendRequestManagable().setSentRequestStatus(user, "Accepted");
        user.getFriendRequestManagable().setReceivedRequestStatus(user, friend, "Accepted");

        // Add to each other's friend list
        user.getFriendManager().addFriend(user, friend);
    }

    @Override
    public void declineFriendRequest(User friend) {
        user.getFriendRequestManagable().setSentRequestStatus(user, "Declined");
        user.getFriendRequestManagable().setReceivedRequestStatus(user, friend, "Declined");
    }

    @Override
    public void blockFriend(User friend) {
        user.getFriendManager().blockUser(user, friend);
    }

    @Override
    public ArrayList<User> suggestions() {
        ArrayList<User> suggestions = new ArrayList<>();

        for (User suggested : db.getUsers()) {
            if (canBeSuggested(user, suggested) && hasCommonFriends(suggested)) {

                {
                    if (canBeSuggested(user, suggested)) {
                        suggestions.add(suggested);
                    }
                }
            }
        }
        for (User suggested : db.getUsers()) {
            if (canBeSuggested(user, suggested)) {
                suggestions.add(suggested);
            }
        }
        // Remove duplicate suggestions
        return new ArrayList<>(new LinkedHashSet<>(suggestions));
    }

    //method to check if a user can be suggested
    private boolean canBeSuggested(User user, User suggested) {
        return !user.equals(suggested)
                && !user.getFriendManager().isFriend(user, suggested)
                && !user.getFriendManager().isBlocked(user, suggested)
                && !user.getFriendRequestManagable().getReceivedFriendRequests().containsKey(suggested.getUserId());
    }

    //method to check for common friends
    private boolean hasCommonFriends(User suggested) {
        ArrayList<User> friends = new ArrayList<>();
        for (String friendId : user.getFriendManager().getFriendList()) {
            friends.add(UserManager.findUser(friendId));
        }
        for (User friend : friends) {
            if (user.getFriendManager().isFriend(suggested, friend)) {
                return true;
            }
        }
        return false;
    }
}
