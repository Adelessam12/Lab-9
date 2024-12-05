package lab.pkg9;

import java.io.IOException;
import java.util.ArrayList;

public class ContentManager implements ContentCreatable {
   

    public ContentManager() {
      
    }

    @Override
    public void createPost(User user, String content, String imagePath) {
        String postId = generateUniqueId();
        Post newPost = new Post(postId, user.getUserId(), content, imagePath, new java.util.Date());
        user.addPost(newPost);
       
    }

    @Override
    public void createStory(User user, String content, String imagePath) {
        String storyId = generateUniqueId();
        Story newStory = new Story(storyId, user.getUserId(), content, imagePath, new java.util.Date());
        user.addstory(newStory);
    }

  
    private String generateUniqueId() {
        return "ID" + System.currentTimeMillis();
    }
}
