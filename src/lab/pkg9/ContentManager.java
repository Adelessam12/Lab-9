package lab.pkg9;

import java.util.UUID;

public class ContentManager implements ContentCreatable {
   
    // ContentManager now depends on abstractions
    private final Database database;

    public ContentManager(Database database) {
        this.database = database;
    }

    @Override
    public void createPost(User user, String content, String imagePath) {
        String postId = generateUniqueId("Post");
        Post newPost = new Post(postId, user.getUserId(), content, imagePath, new java.util.Date());
        user.getPostManager().addPost(newPost);
        database.saveUsersToFile();
    }

    @Override
    public void createStory(User user, String content, String imagePath) {
        String storyId = generateUniqueId("Story");
        Story newStory = new Story(storyId, user.getUserId(), content, imagePath, new java.util.Date());
        user.getStoryManager().addStory(newStory);
        database.saveUsersToFile();
    }

    private String generateUniqueId(String prefix) {
        return prefix + "ID" + UUID.randomUUID();
    }
}
