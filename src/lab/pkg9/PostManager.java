/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PostManager implements PostManagable {

    private final ArrayList<Post> posts;

    public PostManager() {
        posts = new ArrayList<>();
    }

    @Override
    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public void removePost(Post post) {
        posts.remove(post);
    }

    @Override
    public ArrayList<Post> getPosts() {
        return posts;
    }
}
