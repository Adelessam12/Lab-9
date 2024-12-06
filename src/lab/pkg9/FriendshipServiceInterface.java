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
    void sendFriendRequest(User friend);
    void acceptFriendRequest(User friend);
    void declineFriendRequest(User friend);
    void blockFriend(User friend);
    ArrayList<User> suggestions();
}