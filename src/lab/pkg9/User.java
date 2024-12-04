package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lab.pkg9.Post;
import lab.pkg9.Profile;
import lab.pkg9.Story;

public class User {

    private final String userId;
    private final String email;
    private final String username;
    private  String hashedPassword;
    private final Date dateOfBirth;
    private  boolean isOnline;

private  final ArrayList<Story> stories;
    private final ArrayList<User> friendList;
    private final ArrayList<User> blockedList;
    private  Profile profile;
    private final ArrayList<Post> posts;



    private Map<String, String> sentFriendRequestStatus;
    private Map<String, String> receivedFriendRequestStatus;


    public User(String userId, String email, String username, String hashedPassword, Date dateOfBirth) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.dateOfBirth = dateOfBirth;

        profile = new Profile( null);

    

        this.isOnline = false;
        stories=new ArrayList<>();
        friendList = new ArrayList<>();
        blockedList = new ArrayList<>();
        this.posts = new ArrayList<>();

sentFriendRequestStatus = new HashMap<>();
        receivedFriendRequestStatus = new HashMap<>();
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

 
    public void removeFriend(User friend){
        friendList.remove(friend);
    }
    
    public void addToBlocked(User friend){
        friendList.add(friend);
    }
    

    public ArrayList<User> getFriendList() {
        return friendList;
    }



    public ArrayList<User> getBlockedList() {
        return blockedList;
    }

public void addFriend(User user) {
    if (!friendList.contains(user)) {
        friendList.add(user);
        user.friendList.add(this);  // Add the current user to the friend's list
    }
}


    public Map<String, String> getSentFriendRequestStatus() {
        return sentFriendRequestStatus;
    }

    public void setSentFriendRequestStatus(Map<String, String> sentFriendRequestStatus) {
        this.sentFriendRequestStatus = sentFriendRequestStatus;
    }

    public Map<String, String> getReceivedFriendRequestStatus() {
        return receivedFriendRequestStatus;
    }

    public void setReceivedFriendRequestStatus(Map<String, String> receivedFriendRequestStatus) {
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

    
    public void addstory (Story story)
    {
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
