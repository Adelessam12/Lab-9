package lab.pkg9;

import java.util.Date;

public class Story extends Content{

    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; 
    public Story(String storyId, String authorId, String content, String imagePath, Date timestamp) {
        super(storyId, authorId, content, imagePath, timestamp);
    }

    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - this.getTimestamp().getTime()) > EXPIRATION_TIME;
    }

    
}
