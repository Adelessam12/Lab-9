/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author DELL
 */
public interface PasswordHasher {

    String hashPassword(String password);
    boolean verifyPassword(String rawPassword, String hashedPassword);
}