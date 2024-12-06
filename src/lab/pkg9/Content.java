/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Content {
    
    private final String postId;
    private final String authorId;
    private final String content;
    private final String imagePath;
    private final Date timestamp;

    public Content(String postId, String authorId, String content, String imagePath, Date timestamp) {
        this.postId = postId;
        this.authorId = authorId;
        this.content = content;
        this.imagePath = imagePath;
        this.timestamp = timestamp;
    }
    
    public String getPostId() {
        return postId;
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
}
