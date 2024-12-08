/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface UserRepository {
    User findUserById(String userId);
    User findUserByEmail(String email);
    boolean addUser(User user);
    boolean removeUser(String userId);
    boolean updateUser(User user);
    ArrayList<User> getAllUsers();
}
