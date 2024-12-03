/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author Mahmoud Waleed
 */
public class Friend_Management {    
    public void sendFriendRequest(User user, User friend){
        user.setSentFriendRequestStatus("Pending");
        friend.setReceivedFriendRequestStatus("Pending");
        
    }
    
     public void acceptFriendRequest(User user, User friend){
        friend.setReceivedFriendRequestStatus("accepted");
        user.setSentFriendRequestStatus("accepted");
        user.friendList.add(friend);
        friend.friendList.add(user);
    }
     
    public void declineFriendRequest(User user, User friend){
        user.setSentFriendRequestStatus("declined");
        friend.setSentFriendRequestStatus("deleted");
    }
    
    public void removeFriend(User user, User friend){
        user.friendList.remove(friend);
        friend.friendList.remove(user);
    }
    
    public void blockFriend(User user, User friend){
        user.friendList.remove(friend);
        friend.friendList.remove(user);
        user.blockedList.add(friend);
    }
    
    public ArrayList<User> suggestions(User user){
        ArrayList<User> suggestions = new ArrayList<>();
        for(User suggested: User.allUsers){
            if(!User.allUsers.contains(user)&&!suggested.equals(user)){
                suggestions.add(user);
                for(User commonFriend: user.friendList){
                    if(suggested.friendList.contains(commonFriend))
                        System.out.println("Has mustual friends");
                }
            
            }
        }
        return suggestions;
    }
    
}
