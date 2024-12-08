package lab.pkg9;

import java.util.UUID;

public class ContentCreator implements ContentCreatorInterface {
   
    // ContentCreator now depends on abstractions
    private final Database database = DatabaseFactory.createDatabase();

    @Override
    public void createPost(User user, String content, String imagePath) {
        String postId = generateUniqueId("Post");
        Post newPost = new Post(postId, user.getUserId(), content, imagePath, new java.util.Date());
        user.getPostManager().addContent(newPost);
        database.saveUsersToFile();
    }

    @Override
    public void createStory(User user, String content, String imagePath) {
        String storyId = generateUniqueId("Story");
        Story newStory = new Story(storyId, user.getUserId(), content, imagePath, new java.util.Date());
        user.getStoryManager().addContent(newStory);
        database.saveUsersToFile();
    }

    private String generateUniqueId(String prefix) {
        return prefix + "ID" + UUID.randomUUID();
    }
}
