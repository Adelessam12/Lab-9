/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab.pkg9;

import java.util.Map;

/**
 *
 * @author DELL
 */
public interface FriendRequestManagable {
    void setSentRequestStatus(User friend, String status);
    void setReceivedRequestStatus(User user, User friend, String status);
    Map<String, String> getSentFriendRequests();
    Map<User, String> getReceivedFriendRequests();
}
