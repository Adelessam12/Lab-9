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
    private final Database database = DatabaseFactory.createDatabase();

    public PostManager() {
        posts = new ArrayList<>();
    }

    @Override
    public void addPost(Post post) {
        posts.add(post);
        database.saveUsersToFile();
    }

    public void setPosts(ArrayList<Post> post) {
        this.posts = post;
        database.saveUsersToFile();
    }

    @Override
    public void removePost(Post post) {
        posts.remove(post);
        database.saveUsersToFile();
    }

    @Override
    public ArrayList<Post> getPosts() {
        return posts;
    }
}
