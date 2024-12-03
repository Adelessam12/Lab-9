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

    private final ArrayList<User> friendList;
    private final ArrayList<User> blockedList;
    private Profile profile;
    private final ArrayList<Post> posts;
    private final ArrayList<User> friends;

    public User(String userId, String email, String username, String hashedPassword, Date dateOfBirth) {

        this.userId = userId;
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.dateOfBirth = dateOfBirth;
        profile = new Profile(null, null, null);
        this.isOnline = false;
        friendList = new ArrayList<>();
        blockedList = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.friends = new ArrayList<>();

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

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void addFriend(User friend) {
        this.friends.add(friend);
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
