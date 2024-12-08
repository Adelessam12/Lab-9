/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class FriendRequestManager implements FriendRequestManagable{ //manages request statuses.
    
    private  Map<String, String> sentFriendRequests;
    private  Map<String, String> receivedFriendRequests;

    public FriendRequestManager() {
        sentFriendRequests = new HashMap<>();
        receivedFriendRequests = new HashMap<>();
    }
    
    @Override
    public void setSentRequestStatus(User friend, String status) {
        sentFriendRequests.put(friend.getUserId(), status);
    }

    @Override
    public  void setReceivedRequestStatus(User friend, String status) {
        receivedFriendRequests.put(friend.getUserId(), status);
    }
    @Override
     public Map<String, String> getSentFriendRequests(){
        return sentFriendRequests;
     }
    @Override
    public Map<String, String> getReceivedFriendRequests(){
        return receivedFriendRequests;
    }

    public void setSentFriendRequests(Map<String, String> sentFriendRequests) {
        this.sentFriendRequests = sentFriendRequests;
    }

    public void setReceivedFriendRequests(Map<String, String> receivedFriendRequests) {
        this.receivedFriendRequests = receivedFriendRequests;
    }

}
