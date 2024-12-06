package lab.pkg9;

import java.util.ArrayList;
import java.util.Date;

public class UserManager {
    
    private static Database userDatabase;
    
    // Static method to initialize the database
    public static void initializeDatabase(Database db) {
        userDatabase = db;
    }

    public static boolean registerUser(String userId, String email, String username, String password, Date dateOfBirth, boolean isOnline) {
        if (userDatabase == null) {
            System.out.println("Database not initialized.");
            return false;
        }

        if (findUser(userId) != null) {
            System.out.println("User with userId " + userId + " already exists.");
            return false;
        }

        String hashedPassword = userDatabase.hashPassword(password);
        User newUser = UserFactory.createUser(email, username, hashedPassword, dateOfBirth);
        addUser(newUser);
        System.out.println("User registered successfully.");
        userDatabase.saveUsersToFile();
        return true;
    }

    public static User findUser(String userId) {
        if (userDatabase == null || userId == null || userDatabase.getUsers() == null) {
            System.out.println("User database is null or userId is invalid.");
            return null;
        }

        for (User user : userDatabase.getUsers()) {
            if (user.getUserId().equals(userId)) {
                System.out.println(user);
                return user;
            }
        }
        return null; // Return null if user is not found
    }

    public static boolean addUser(User user) {
        if (userDatabase == null) {
            System.out.println("Database not initialized.");
            return false;
        }

        if (user == null) {
            System.out.println("User cannot be null.");
            return false;
        }

        if (userDatabase.getUsers() == null) {
            userDatabase.users = new ArrayList<>();
            userDatabase.users.add(user);
            userDatabase.saveUsersToFile();
        } else if (findUser(user.getUserId()) != null) {
            System.out.println("User with userId " + user.getUserId() + " already exists.");
            return false;
        } else {
            try {
                String hashedPassword = user.getHashedPassword();
                if (hashedPassword == null) {
                    System.out.println("Failed to hash password.");
                    return false;
                }
                user.setHashedPassword(hashedPassword);
                userDatabase.getUsers().add(user);
                boolean saved = userDatabase.saveUsersToFile();
                if (saved) {
                    System.out.println("User added successfully.");
                    return true;
                } else {
                    System.out.println("Error saving user to file.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("An error occurred while adding the user: " + e.getMessage());
                // Optional: to log full stack trace for debugging
                return false;
            }
        }
        return true;
    }

    public static boolean deleteUser(User user) {
        if (userDatabase == null) {
            System.out.println("Database not initialized.");
            return false;
        }

        User existingUser = findUser(user.getUserId());
        if (existingUser != null) {
            userDatabase.getUsers().remove(existingUser);
            userDatabase.saveUsersToFile();
            System.out.println("User deleted successfully.");
            return true;
        } else {
            System.out.println("User with userId " + user.getUserId() + " not found.");
            return false;
        }
    }

    public static User login(String email, String password) {
        if (userDatabase == null) {
            System.out.println("Database not initialized.");
            return null;
        }

        // Iterate over users to find the user with the given email
        for (User user : userDatabase.getUsers()) {
            // Check if email matches and the password is valid
            if (user.getEmail().equals(email) && validatePassword(user.getHashedPassword(), password)) {
                user.setIsOnline(true);  // Set the user to online
                userDatabase.saveUsersToFile();  // Save the updated users to the file
                System.out.println("User logged in successfully.");
                return user;
            }
        }
        System.out.println("Invalid email or password.");
        return null;  // Return null if no matching user is found
    }

    public static boolean logout(User user) {
        if (userDatabase == null) {
            System.out.println("Database not initialized.");
            return false;
        }

        if (user != null) {
            user.setIsOnline(false);
            userDatabase.saveUsersToFile();
            System.out.println("User logged out successfully.");
            return true;
        } else {
            System.out.println("User not found.");
            return false;
        }
    }

    private static boolean validatePassword(String hashedPassword, String password) {
        // Hash the entered password and compare it with the stored hashed password
        String hashedInputPassword = userDatabase.hashPassword(password);
        System.out.println("Hashed input password: " + hashedInputPassword + "   Stored hashed password: " + hashedPassword);
        return hashedPassword.equals(hashedInputPassword);  // Return true if passwords match
    }

}
