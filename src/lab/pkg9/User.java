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
    private Profile profile; // Composition for profile details
    private ArrayList<Post> posts; // User's posts
    private ArrayList<User> friends; // Friend list

    public User(String userId, String email, String username, String hashedPassword, Date dateOfBirth, boolean isOnline, Profile profile) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.dateOfBirth = dateOfBirth;
        this.isOnline = isOnline;
        this.profile = profile;
        this.posts = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    // Getters and setters for all attributes
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
}
