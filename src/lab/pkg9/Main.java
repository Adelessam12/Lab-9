package lab.pkg9;

import java.util.Date;
import lab.Frontend.GroupPage;


public class Main {
    public static void main(String[] args) {
        // Create a mock group for testing
        Database dp = DatabaseFactory.createDatabase();
        // Add mock users to the group
        User adminUser = UserFactory.createUser("a", "a", "a", new Date());
               
        User coadmin =  UserFactory.createUser("b", "b", "b", new Date());
        dp.addUser(adminUser);
        dp.addUser(coadmin);
        Group group =GroupManager.createGroup("ahmed", "a7a", "C:\\Users\\Dell\\Documents\\GitHub\\Lab-9\\OIP.jpeg", adminUser.getUserId());



       

        GroupAdmin admin = new GroupAdmin(adminUser.getUserId(), group);
        GroupManager.requestToJoin(coadmin, group);
        System.out.println(group);
        admin.approveRequest(coadmin.getUserId());
        //admin.promoteToCoAdmin(coadmin.getUserId());
//       

//         Add posts to the group
       // Post post1 = new Post("post123", adminUser.getUserId(), "Hello, this is the first post!", null, new Date());
       // admin.addPost(post1);

//         Create a GroupPage for the admin user
      
            GroupPage page= new GroupPage(group, adminUser);
            page.setVisible(true);
     
    }
}
