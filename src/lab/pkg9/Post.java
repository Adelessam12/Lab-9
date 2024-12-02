/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;


import java.util.Date;

public class Post {
    
    private String postId;
    private String authorId;
    private String content;
    private String imagePath;
    private Date timestamp;

    public Post(String postId, String authorId, String content, String imagePath, Date timestamp) {
        this.postId = postId;
        this.authorId = authorId;
        this.content = content;
        this.imagePath = null;
        this.timestamp = timestamp;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setTimestamp(Date timestamp) {
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
        return imagePath;
    }

    public Date getTimestamp() {
        return timestamp;
    }

@Override
public String toString() {
    return "Post{" +
            "postId='" + postId + '\'' +
            ", authorId='" + authorId + '\'' +
            ", content='" + content + '\'' +
            ", imagePath='" + imagePath + '\'' +
            ", timestamp=" + timestamp +
            '}';
}

}
