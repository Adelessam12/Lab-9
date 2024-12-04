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
private  final ArrayList<Story> stories;
    private final ArrayList<User> friendList;
    private final ArrayList<User> blockedList;
    private Profile profile;
    private final ArrayList<Post> posts;

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

    }

    public ArrayList<Story> getStories() {
        return stories;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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
