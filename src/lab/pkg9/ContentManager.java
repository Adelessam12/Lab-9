package lab.pkg9;

import java.io.IOException;
import java.util.ArrayList;

public class ContentManager implements ContentCreatable {
    private ArrayList<Post> allPosts;
    private ArrayList<Story> allStories;
    private final ContentDatabase contentDatabase;

    public ContentManager(ContentDatabase contentDatabase) {
        this.allPosts = new ArrayList<>();
        this.allStories = new ArrayList<>();
        this.contentDatabase = contentDatabase;
    }

    @Override
    public void createPost(String userId, String content, String imagePath) {
        String postId = generateUniqueId();
        Post newPost = new Post(postId, userId, content, imagePath, new java.util.Date());
        allPosts.add(newPost);
    }

    @Override
    public void createStory(String userId, String content, String imagePath) {
        String storyId = generateUniqueId();
        Story newStory = new Story(storyId, userId, content, imagePath, new java.util.Date());
        allStories.add(newStory);
    }

    public void saveContent() throws IOException {
        contentDatabase.savePosts(allPosts);
        contentDatabase.saveStories(allStories);
    }

    public void loadContent() throws IOException {
        allPosts = contentDatabase.loadPosts();
        allStories = contentDatabase.loadStories();
    }

    private String generateUniqueId() {
        return "ID" + System.currentTimeMillis();
    }
}
