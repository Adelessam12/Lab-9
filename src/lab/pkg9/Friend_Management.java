/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author Mahmoud Waleed
 */
public class Friend_Management {    
    public void sendFriendRequest(Friend friend, User user){
        friend.setFriendRequestStatus("Pending");
        
    }
    
     public void acceptFriendRequest(User user, Friend friend){
        friend.setFriendRequestStatus("accepted");
        user.friendList.add(friend.getFriend());
        friend.getFriend().friendList.add(user);
    }
     
    public void declineFriendRequest(User user, Friend friend){
        friend.setFriendRequestStatus("declined");
    }
    
    public void removeFriend(User user, Friend friend){
        user.friendList.remove(friend.getFriend());
        friend.getFriend().friendList.remove(user);
    }
    
    public void blockFriend(User user, Friend friend){
        user.friendList.remove(friend.getFriend());
        friend.getFriend().friendList.remove(user);
    }
    
    
}
