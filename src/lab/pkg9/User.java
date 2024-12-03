package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private String userId;
    private String email;
    private String username;
    private String hashedPassword;
    private Date dateOfBirth;
    private boolean isOnline;
    public ArrayList<User> friendList = new ArrayList<>();
    public ArrayList<User> blockedList = new ArrayList<>();
    public static ArrayList<User> allUsers = new ArrayList<>();
    private String sentFriendRequestStatus;
    private String receivedFriendRequestStatus;
    
    public User(){
        allUsers.add(this);
    }

    public String getSentFriendRequestStatus() {
        return sentFriendRequestStatus;
    }

    public void setSentFriendRequestStatus(String sentFriendRequestStatus) {
        this.sentFriendRequestStatus = sentFriendRequestStatus;
    }

    public String getReceivedFriendRequestStatus() {
        return receivedFriendRequestStatus;
    }

    public void setReceivedFriendRequestStatus(String receivedFriendRequestStatus) {
        this.receivedFriendRequestStatus = receivedFriendRequestStatus;
    }

    public User(String userId, String email, String username, String hashedPassword, Date dateOfBirth, boolean isOnline) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.dateOfBirth = dateOfBirth;
        this.isOnline = isOnline;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", email=" + email + ", username=" + username + ", hashedPassword=" + hashedPassword + ", dateOfBirth=" + dateOfBirth + ", isOnline=" + isOnline + '}';
    }

}
