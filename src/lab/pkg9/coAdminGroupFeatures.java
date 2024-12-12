/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author Mahmoud Waleed
 */
public interface coAdminGroupFeatures {
    public void approveRequest(String userId);
    public void declineRequest(String userId);
    public void removeMember(String memberId);
    public void deletePost(String content, String userId);
    public void editPost(String content, String userId, String newContent);
}
