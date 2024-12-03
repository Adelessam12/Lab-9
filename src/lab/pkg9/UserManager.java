package lab.pkg9;
import java.util.Date;

public class UserManager {

    private final Db userDatabase;

    public UserManager(Db userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean registerUser(String userId, String email, String username, String password, Date dateOfBirth) {
        if (findUser(userId) != null) {
            System.out.println("User with userId " + userId + " already exists.");
            return false;
        }

        String hashedPassword = userDatabase.hashPassword(password);
        User newUser = new User(userId, email, username, hashedPassword, dateOfBirth);
        addUser(newUser);
        System.out.println("User registered successfully.");
        return true;
    }

  
    public User findUser(String userId) {
        for (User user : userDatabase.getUsers()) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public boolean addUser(User user) {
        if (findUser(user.getUserId()) != null) {
            System.out.println("User with userId " + user.getUserId() + " already exists.");
            return false;
        } else {
            String hashedPassword = userDatabase.hashPassword(user.getHashedPassword());
            user.setHashedPassword(hashedPassword);
            userDatabase.getUsers().add(user);
            userDatabase.saveUsersToFile();
            System.out.println("User added successfully.");
            return true;
        }
    }

    public boolean deleteUser(User user) {
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

    public User login(String username, String password) {
        for (User user : userDatabase.getUsers()) {
            if (user.getUsername().equals(username) && validatePassword(user.getHashedPassword(), password)) {
                user.setIsOnline(true);
                userDatabase.saveUsersToFile();
                System.out.println("User logged in successfully.");
                return user;
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    }

    public boolean logout(User user) {
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

    private boolean validatePassword(String hashedPassword, String password) {
        return hashedPassword.equals(userDatabase.hashPassword(password));
    }

  



public class Main {
    public static void main(String[] args) {
        // Initialize the database and user manager
        Db db = new Db("C:\\Users\\user\\Downloads\\User.json");
        UserManager userManager = new UserManager(db);

        // Define user details
        String userId = "user123";
        String email = "user123@example.com";
        String username = "john_doe";
        String password = "securePassword123";
        Date dateOfBirth = new Date(1995 - 1900, 5, 15); // June 15, 1995

        // Trace 1: Register a user
        System.out.println("---- Registering User ----");
        boolean isRegistered = userManager.registerUser(userId, email, username, password, dateOfBirth);
        System.out.println("Registration successful: " + isRegistered);

        // Trace 2: Find the user
        System.out.println("---- Finding User ----");
        User foundUser = userManager.findUser(userId);
        if (foundUser != null) {
            System.out.println("User found: " + foundUser.getUsername());
        } else {
            System.out.println("User not found.");
        }

        // Trace 3: Log in the user
        System.out.println("---- Logging in User ----");
        User loggedInUser = userManager.login(username, password);
        if (loggedInUser != null) {
            System.out.println("User logged in: " + loggedInUser.getUsername());
        }

        // Trace 4: Log out the user
        System.out.println("---- Logging out User ----");
        userManager.logout(loggedInUser);

        // Trace 5: Add another user directly
        System.out.println("---- Adding User Directly ----");
        User anotherUser = new User("user456", "user456@example.com", "jane_doe", password, new Date(2000 - 1900, 3, 25));
        userManager.addUser(anotherUser);

        // Trace 6: Delete a user
        System.out.println("---- Deleting User ----");
        userManager.deleteUser(anotherUser);

        // Final state
        System.out.println("---- Final State of Users in Database ----");
        for (User user : db.getUsers()) {
            System.out.println("UserId: " + user.getUserId() + ", Username: " + user.getUsername());
        }
    }
}

}