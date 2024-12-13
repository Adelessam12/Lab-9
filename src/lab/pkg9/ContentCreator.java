package lab.pkg9;

public class ContentCreator {
   
    // ContentCreator now depends on abstractions
    private static final Database database = DatabaseFactory.createDatabase();

 
    public static void createPost(User user, String content, String imagePath) {
       
        Post newPost = new Post(user.getUserId(), content, imagePath, new java.util.Date());
        user.getPostManager().addContent(newPost);
        database.saveUsersToFile();
    }

    public static void createStory(User user, String content, String imagePath) {
        
        Story newStory = new Story(user.getUserId(), content, imagePath, new java.util.Date());
        user.getStoryManager().addContent(newStory);
        database.saveUsersToFile();
    }


}
