/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class UserFactory {

    public static User createUser(
            String email,
            String username,
            String hashedPassword,
            Date dateOfBirth
    ) {
        // Hash the password before passing it to the User constructor
      
        // Create the manager instances (or pass in existing ones)
        Map<String, String> sentFriendRequests = new HashMap<>();
        Map<User, String> receivedFriendRequests = new HashMap<>();
        ArrayList<String> friendList = new ArrayList<>();
        ArrayList<String> blockedList = new ArrayList<>();
        ArrayList<Post> posts = new ArrayList<>();
        ArrayList<Story> stories = new ArrayList<>();
        FriendRequestManagable friendRequestManager = new FriendRequestManager(sentFriendRequests, receivedFriendRequests);
        FriendManagable friendManager = new FriendManager(friendList, blockedList);
        PostManagable postManager = new PostManager(posts);
        StoryManagable storyManager = new StoryManager(stories);
        // Create and return the User instance
        return new User(email, username, hashedPassword, dateOfBirth, friendRequestManager, friendManager, postManager, storyManager);
    }
}
