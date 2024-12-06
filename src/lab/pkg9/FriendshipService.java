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
    public void sendFriendRequest(User user, User friend) {
        user.getFriendRequestManagable().setSentRequestStatus(friend, "Pending");
         friend.getFriendRequestManagable().setReceivedRequestStatus(user, friend, "Pending");
    }

    @Override
    public void acceptFriendRequest(User user, User friend) {
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
    public void declineFriendRequest(User user, User friend) {
        user.getFriendRequestManagable().setSentRequestStatus(user, "Declined");
        user.getFriendRequestManagable().setReceivedRequestStatus(user, friend, "Declined");
    }

    @Override
    public void blockFriend(User user, User friend) {
        user.getFriendManager().blockUser(user, friend);
    }

    @Override
    public ArrayList<User> suggestions(User user) {
        ArrayList<User> suggestions = new ArrayList<>();

        for (User suggested : db.getUsers()) {
            if (!user.equals(suggested) && canBeSuggested(user, suggested) && hasCommonFriends(suggested)) {

                {
                    if (!user.equals(suggested)) {
                        suggestions.add(suggested);
                    }
                }
            }
        }
        for (User suggested : db.getUsers()) {
            if (!user.equals(suggested)) {
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
                && !user.getFriendRequestManagable().getSentFriendRequests().containsKey(suggested.getUsername());
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

//    public static void main(String[] args) {
//        Date dateOfBirth1 = new Date(1995 - 1900, 5, 15);
//        User mah = new User("Mah1", "mah@", "Mah", "123", dateOfBirth1, false);
//        Date dateOfBirth2 = new Date(1995 - 1900, 5, 15);
//        User ahm = new User("Ahm1", "ahm@", "Ahm", "1234", dateOfBirth2, false);
//        sendFriendRequest(ahm, mah);
//        
//        System.out.println(mah.getSentFriendRequestStatus());
//        System.out.println(ahm.getReceivedFriendRequestStatus());
//        System.out.println(ahm.getSentFriendRequestStatus() + "\n");
//        //acceptFriendRequest(ahm, mah);
//        System.out.println(mah.getSentFriendRequestStatus());
//        System.out.println(ahm.getReceivedFriendRequestStatus());
//        System.out.println(mah.getReceivedFriendRequestStatus() + "\n");
//        //blockFriend(mah, ahm);
//        try {
//            System.out.println(mah.getFriendList().get(0));
//        } catch (Exception e) {
//            System.out.println("nothing");
//        }
//        Date dateOfBirth3 = new Date(1995 - 1900, 5, 15);
//        User bro = new User("bro1", "bro@", "br0", "12345", dateOfBirth3, false);
//        sendFriendRequest(bro, ahm);
//        System.out.println(ahm.getReceivedFriendRequestStatus());
//        //System.out.println(suggestions(mah));
//        // System.out.println(suggestions(ahm));       
//        FriendsPage f = new FriendsPage(mah, db);
//        f.setVisible(true);
//    }
//   }
}
