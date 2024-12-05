/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Mahmoud Waleed
 */
public class FriendManagement {

    static Db db;
    
    public FriendManagement(Db db) {
        this.db = db;
    }

    public static void setSentRequestStatus(User user, User friend, String status) {
        Map m = user.getSentFriendRequestStatus();
        m.put(friend.getUsername(), status);
    }

    public static void setRecievedRequestStatus(User user, User friend, String status) {
        Map m = friend.getReceivedFriendRequestStatus();
        ArrayList<String> details = new ArrayList<>();
        details.add(user.getUsername());
        details.add(status);
        m.put(user,details);
    }

    public static void sendFriendRequest(User user, User friend) {
        setSentRequestStatus(user, friend,"Pending");
        setRecievedRequestStatus(user, friend,"Pending");
    }

    public static void acceptFriendRequest(User user, User friend) {
        for(User u: user.friendList){
            if(u.equals(friend))
                return;
        }
        setSentRequestStatus(friend, user, "Accepted");
        setRecievedRequestStatus(friend, user,"Accepted");
        user.addFriend(friend);
        friend.addFriend(user); 
    }

    public static void declineFriendRequest(User user, User friend) {
        setSentRequestStatus(friend, user, "Declined");
        setRecievedRequestStatus(friend, user, "Declined");
    }

    public static void blockFriend(User user, User friend) {
        user.removeFriend(friend);
        friend.removeFriend(user);
        user.addToBlocked(friend);
    }

    public static ArrayList<User> suggestions(User user) {
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
    public static void main(String[] args) {
         Date dateOfBirth1 = new Date(1995 - 1900, 5, 15);
        User mah = new User("Mah1","mah@","Mah","123",dateOfBirth1,false);
        Date dateOfBirth2 = new Date(1995 - 1900, 5, 15);
        User ahm = new User("Ahm1","ahm@","Ahm","1234",dateOfBirth2,false);
        sendFriendRequest(mah, ahm);
        System.out.println(mah.getSentFriendRequestStatus());
        System.out.println(ahm.getReceivedFriendRequestStatus());
        System.out.println(ahm.getSentFriendRequestStatus()+"\n");
        acceptFriendRequest(ahm, mah);
        System.out.println(mah.getSentFriendRequestStatus());
        System.out.println(ahm.getReceivedFriendRequestStatus());
        System.out.println(mah.getReceivedFriendRequestStatus()+"\n");
        blockFriend(mah, ahm);
        try{
        System.out.println(mah.getFriendList().get(0));
        }
        catch(Exception e){
            System.out.println("nothing");
        }
        Date dateOfBirth3 = new Date(1995 - 1900, 5, 15);
        User bro = new User("bro1","bro@","br0","12345",dateOfBirth3,false);
        sendFriendRequest(bro, ahm);
        System.out.println(ahm.getReceivedFriendRequestStatus());
        //System.out.println(suggestions(mah));
       // System.out.println(suggestions(ahm));
    }

}
