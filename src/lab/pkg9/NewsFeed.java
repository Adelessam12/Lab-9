/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author Mahmoud Waleed
 */
public class NewsFeed {
    public void displayFriendsList(User user){
        for(User friend: user.getFriendList()){
            System.out.println(friend.getUsername()+friend.isIsOnline());
        }
    }
}
