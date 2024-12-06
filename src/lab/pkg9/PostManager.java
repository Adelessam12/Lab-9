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

    private ArrayList<Post> posts;

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

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
