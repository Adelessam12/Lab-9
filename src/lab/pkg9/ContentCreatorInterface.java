/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author Dell
 */
public interface ContentCreatorInterface {
    void createPost(User user, String content, String imagePath);
    void createStory(User user, String content, String imagePath);
}
