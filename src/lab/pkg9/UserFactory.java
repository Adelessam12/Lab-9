/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.Date;

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
        FriendRequestManagable friendRequestManager = new FriendRequestManager();
        FriendManagable friendManager = new FriendManager();
        PostManagable postManager = new PostManager();
        StoryManagable storyManager = new StoryManager();
        // Create and return the User instance
        return new User(email, username, hashedPassword, dateOfBirth, friendRequestManager, friendManager, postManager, storyManager);
    }
}
