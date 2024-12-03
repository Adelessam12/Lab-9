/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author Dell
 */
public interface ContentCreatable {
    void createPost(String userId, String content, String imagePath);
    void createStory(String userId, String content, String imagePath);
}
