/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author DELL
 */
public class Content {

    private final String postId;
    private final String authorId;
    private String content;
    private String imagePath;
    private final Date timestamp;

    public Content(String authorId, String content, String imagePath, Date timestamp) {
        postId = generateUniqueId("Content");
        this.authorId = authorId;
        this.content = content;
        this.imagePath = imagePath;
        this.timestamp = timestamp;
    }

    public String getPostId() {
        return postId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getContent() {
        return content;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Post{"
                + "postId='" + postId + '\''
                + ", authorId='" + authorId + '\''
                + ", content='" + content + '\''
                + ", imagePath='" + imagePath + '\''
                + ", timestamp=" + timestamp
                + '}';
    }

    private static String generateUniqueId(String prefix) {
        return prefix + "ID" + UUID.randomUUID();
    }
}
