/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface FriendshipServiceInterface {
    void sendFriendRequest(User user, User friend);
    void acceptFriendRequest(User user, User friend);
    void declineFriendRequest(User user, User friend);
    void blockFriend(User user, User friend);
    ArrayList<User> suggestions(User user);
}
