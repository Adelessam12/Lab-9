/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

/**
 *
 * @author DELL
 */
public class DatabaseFactory {
    public static Database createDatabase() {
        UserStorage userStorage =  new FileUserStorage("database.json"); // Use the FileUserStorage implementation
        PasswordHasher passwordHasher = new SHA256PasswordHasher(); // Use the SHA-256 implementation

        
        // Create and return the Database instance
        return Database.createInstance(userStorage, passwordHasher);
    }
}