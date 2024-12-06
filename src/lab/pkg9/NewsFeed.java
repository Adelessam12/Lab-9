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
public class NewsFeed {
    public void displayFriendsList(User user){
          ArrayList<User> friends= new ArrayList<>();
       for(String friendid : user.getFriendManager().getFriendList())
       {
           friends.add(UserManager.findUser(friendid));
       }
        for(User friend: friends){
            System.out.println(friend.getUsername()+friend.isIsOnline());
        }
    }
}
