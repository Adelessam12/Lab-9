package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User {
    private final String userId;
    private final String email;
    private final String username;
    private String hashedPassword;
    private final Date dateOfBirth;
    private boolean isOnline;
    private Profile profile;
    
    //private final ArrayList<String> groups;
    private  Map<String, GroupMember> groups;
    
    private final FriendManagable friendManager;
    private final ContentManagable postManager;
    private final ContentManagable storyManager;

    // Constructor
    public User(
        String email,
        String username,
        String hashedPassword,
        Date dateOfBirth,
        FriendManagable friendManager,
        ContentManagable postManager,
        ContentManagable storyManager
    ) {
        this.userId = generateUserId();
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.dateOfBirth = dateOfBirth;
        this.isOnline = false;
        this.profile = new Profile(null);
        this.friendManager = friendManager;
        this.postManager = postManager;
        this.storyManager = storyManager;
        groups = new HashMap<>();
    }

    public void setGroups(Map<String, GroupMember> groups) {
        this.groups = groups;
    }

    public Map<String, GroupMember> getGroups() {
        return groups;
    }


    
    public FriendRequestManagable getFriendRequestManagable(){
        return getFriendManager().getFriendRequestManager();
    }
    
    public FriendManagable getFriendManager() {
        return friendManager;
    }

    
    public ContentManagable getPostManager() {
        return postManager;
    }

    public ContentManagable getStoryManager() {
        return storyManager;
    }
    
    private String generateUserId() {
        return "ID" + UUID.randomUUID();
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
    public Profile getProfile() {
        return profile;
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
