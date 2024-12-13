package lab.pkg9;

import java.util.Date;

public class UserManager {

    // Static fields to hold the single instance of dependencies
    private static final UserRepository userRepository;
    private static final  PasswordHasher passwordHasher;

    // Static block to initialize dependencies (using a factory or directly)
    static {
        // Create the Database singleton instance
        Database database = DatabaseFactory.createDatabase();

        // Initialize dependencies
        userRepository = new DatabaseUserRepository(database);
        passwordHasher = new SHA256PasswordHasher();
    }

    // Static method to register a user
    public static boolean registerUser(String email, String username, String password, Date dateOfBirth) {
        
        String hashedPassword = passwordHasher.hashPassword(password);
        User newUser = UserFactory.createUser(email, username, hashedPassword, dateOfBirth);
        boolean success = userRepository.addUser(newUser);
        if (success) {
            System.out.println("User registered successfully.");
//            Database db = DatabaseFactory.createDatabase();
//            db.saveUsersToFile();
        }
        return success;
    }

    // Static method to find a user by ID
    public static User findUser(String userId) {
        return userRepository.findUserById(userId);
    }

    // Static method to delete a user by ID
    public static boolean deleteUser(String userId) {
        User user = findUser(userId);
        if (user != null) {
            boolean success = userRepository.removeUser(userId);
            if (success) {
                System.out.println("User deleted successfully.");
            }
            return success;
        } else {
            System.out.println("User with userId " + userId + " not found.");
            return false;
        }
    }

    // Static method to login a user
    public static User login(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user != null && passwordHasher.verifyPassword(password, user.getHashedPassword())) {
            user.setIsOnline(true);
            userRepository.updateUser(user);
            System.out.println("User logged in successfully.");
            return user;
        } else {
            System.out.println("Invalid email or password.");
            return null;
        }
    }

    // Static method to logout a user
    public static boolean logout(User user) {
        if (user != null) {
            user.setIsOnline(false);
            userRepository.updateUser(user);
            System.out.println("User logged out successfully.");
            return true;
        } else {
            System.out.println("User not found.");
            return false;
        }
    }
}
