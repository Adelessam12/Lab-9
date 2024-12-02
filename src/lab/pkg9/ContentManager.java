package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;

public class ContentManager implements ContentCreatable {
    private ArrayList<Post> allPosts;
    private ArrayList<Story> allStories;

    public ContentManager() {
        this.allPosts = new ArrayList<>();
        this.allStories = new ArrayList<>();
    }

    @Override
    public void createPost(String userId, String content, String imagePath) {
        String postId = generateUniqueId();
        Post newPost = new Post(postId, userId, content, imagePath, new Date());
        allPosts.add(newPost);
        System.out.println("Post created: " + newPost);
    }

    @Override
    public void createStory(String userId, String content, String imagePath) {
        String storyId = generateUniqueId();
        Story newStory = new Story(storyId, userId, content, imagePath, new Date());
        allStories.add(newStory);
        System.out.println("Story created: " + newStory);
    }

    public ArrayList<Post> getAllPosts() {
        return allPosts;
    }

    public ArrayList<Story> getAllStories() {
        return allStories;
    }

    private String generateUniqueId() {
        return "ID" + System.currentTimeMillis();
    }

    public void removeExpiredStories() {
        allStories.removeIf(Story::isExpired);
    }


}
