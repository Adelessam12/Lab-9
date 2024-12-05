package lab.pkg9;
import Frontend.NewsFeed;
import java.util.Date;

public class NewsFeedTest {
    public static void main(String[] args) {
       // Create current timestamp
        Date currentTimestamp = new Date();

        User user1 = new User("john.doe@example.com", "John Doe", "hashedPassword123", currentTimestamp);
        User user2 = new User("jane.smith@example.com", "Jane Smith", "hashedPassword456", currentTimestamp);
        User user3 = new User("alice.brown@example.com", "Alice Brown", "hashedPassword789", currentTimestamp);
        User user4 = new User("bob.jones@example.com", "Bob Jones", "hashedPassword101", currentTimestamp);

        // Create and add posts to user1
        Post post1 = new Post("post1", "john_doe", "Hello, this is my first post!", "path/to/image1.jpg", currentTimestamp);
        Post post2 = new Post("post2", "john_doe", "Had a great day at the beach!", "path/to/image2.jpg", currentTimestamp);
        user1.addPost(post1);
        user1.addPost(post2);

        // Create and add posts to user2
        Post post3 = new Post("post3", "jane_smith", "Feeling good today!", "path/to/image3.jpg", currentTimestamp);
        user2.addPost(post3);

        // Create and add posts to user3
        Post post4 = new Post("post4", "alice_brown", "Excited for the weekend!", "path/to/image4.jpg", currentTimestamp);
        Post post5 = new Post("post5", "alice_brown", "Just finished a great book!", "path/to/image5.jpg", currentTimestamp);
        user3.addPost(post4);
        user3.addPost(post5);

        // Create and add posts to user4
        Post post6 = new Post("post6", "bob_jones", "Lunch at my favorite cafe!", "path/to/image6.jpg", currentTimestamp);
        user4.addPost(post6);

        // Add friends
        user1.addFriend(user2);
        user1.addFriend(user3);
        user1.addFriend(user4);
        
        user2.addFriend(user1);
        user2.addFriend(user4);
        user3.addFriend(user1);
        user4.addFriend(user2);

        // Create and add stories to user1
        Story story1 = new Story("story1", "john_doe", "This is a cool story.", "path/to/story_image1.jpg", currentTimestamp);
        Story story2 = new Story("story2", "john_doe", "Had a fun workout session!", "path/to/story_image2.jpg", currentTimestamp);
        user1.addstory(story1);
        user1.addstory(story2);

        // Create and add stories to user2
        Story story3 = new Story("story3", "jane_smith", "This is Jane's story.", "path/to/story_image3.jpg", currentTimestamp);
        Story story4 = new Story("story4", "jane_smith", "Exploring new places!", "path/to/story_image4.jpg", currentTimestamp);
        user2.addstory(story3);
        user2.addstory(story4);

        // Create and add stories to user3
        Story story5 = new Story("story5", "alice_brown", "The best vacation!", "path/to/story_image5.jpg", currentTimestamp);
        Story story6 = new Story("story6", "alice_brown", "Celebrating my birthday!", "path/to/story_image6.jpg", currentTimestamp);
        user3.addstory(story5);
        user3.addstory(story6);

        // Create and add stories to user4
        Story story7 = new Story("story7", "bob_jones", "Great weekend with friends!", "path/to/story_image7.jpg", currentTimestamp);
        user4.addstory(story7);

        // Set profiles for users
        Profile profile = new Profile("my bio");
        user1.setProfile(profile);
        user2.setProfile(profile);
        user3.setProfile(profile);
        user4.setProfile(profile);

        // Create NewsFeed for user1 and load dummy data
        Database database= new Database("hello");
        ContentManager cm = new ContentManager(database);
        UserManager M= new UserManager(database);
        NewsFeed newsFeed = new NewsFeed(user1, database,cm, M);

        // Display the newsfeed window
        newsFeed.setVisible(true);
    }
}
