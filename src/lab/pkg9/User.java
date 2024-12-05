package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class User {

    private final String userId;
    private final String email;
    private final String username;
    private String hashedPassword;
    private final Date dateOfBirth;
    private boolean isOnline;
    //new updates 
    private final ArrayList<Story> stories;
    private final ArrayList<Post> posts;
    private final ArrayList<User> friendList;
    private final ArrayList<User> blockedList;
    private Profile profile;

    // two mab objects to store the id && satuts 
    private Map<String, String> sentFriendRequestStatus;
    private Map<User, String> receivedFriendRequestStatus;


    public User(String email, String username, String hashedPassword, Date dateOfBirth) {
        this.userId = generateUserId();

        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.dateOfBirth = dateOfBirth;
        
        profile = new Profile(null);

        this.isOnline = false;
        stories = new ArrayList<>();
        friendList = new ArrayList<>();
        blockedList = new ArrayList<>();
        this.posts = new ArrayList<>();

        sentFriendRequestStatus = new HashMap<>();
        receivedFriendRequestStatus = new HashMap<>();
    }

    public String generateUserId(){
        return "User" + System.currentTimeMillis();
    } 
    

    public void setProfile(Profile profile) {
        this.profile = profile;
 
    
 
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public ArrayList<Story> getStories() {
        return stories;
    }

    public void removeFriend(User friend) {
        friendList.remove(friend);
    }

    public void addToBlocked(User friend) {
        blockedList.add(friend);
    }

    public ArrayList<User> getFriendList() {
        return friendList;
    }

    public ArrayList<User> getBlockedList() {
        return blockedList;
    }

    public void addFriend(User user) {
        if (!friendList.contains(user)) {
            // The next two Lines ensures that A is friend to B and B is a friend to A
            friendList.add(user);       // Add the user to the current user's friend list
            user.friendList.add(this);  // Add the current user to the friend's list
            // this keyword is refrence to the object who called add friend method 
        }
    }

    public Map<String, String> getSentFriendRequestStatus() {
        return sentFriendRequestStatus;
    }

    public void setSentFriendRequestStatus(Map<String, String> sentFriendRequestStatus) {
        this.sentFriendRequestStatus = sentFriendRequestStatus;
    }

    public Map<User, String> getReceivedFriendRequestStatus() {
        return receivedFriendRequestStatus;
    }

    public void setReceivedFriendRequestStatus(Map<User, String> receivedFriendRequestStatus) {
        this.receivedFriendRequestStatus = receivedFriendRequestStatus;
    }

    public Profile getProfile() {
        return profile;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void addstory(Story story) {
        this.stories.add(story);
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", email=" + email + ", username=" + username + ", hashedPassword=" + hashedPassword + ", dateOfBirth=" + dateOfBirth + ", isOnline=" + isOnline + '}';
    }

}
