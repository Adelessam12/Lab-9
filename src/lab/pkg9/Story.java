package lab.pkg9;

import java.util.Date;

public class Story {
    private String storyId;
    private String authorId;
    private String content;
    private String imagePath;
    private Date timestamp;
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; 

    public Story(String storyId, String authorId, String content, String imagePath, Date timestamp) {
        this.storyId = storyId;
        this.authorId = authorId;
        this.content = content;
        this.imagePath = imagePath;
        this.timestamp = timestamp;
    }

    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - timestamp.getTime()) > EXPIRATION_TIME;
    }

    public String getStoryId() {
        return storyId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getContent() {
        return content;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Story{" +
                "storyId='" + storyId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", content='" + content + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}