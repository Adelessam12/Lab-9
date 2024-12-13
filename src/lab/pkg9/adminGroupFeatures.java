/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author Mahmoud Waleed
 */
public interface adminGroupFeatures {
    public void promoteToCoAdmin(String userId);
    public void demoteToMember(String userId);
    public void deleteGroup();
    public void leaveGroup(String userId);
}
