package lab.pkg9;

import java.util.Date;
import lab.Frontend.GroupPage;


public class Main {
    public static void main(String[] args) {
        // Create a mock group for testing

        // Add mock users to the group
        User adminUser = UserFactory.createUser("admin", "admin", "A7A", new Date());
        Group group =GroupManager.createGroup("g2", "ahmed", "a7a", null, "admin");
       
                User coadmin = UserFactory.createUser("coadmin123", "Co-Admin User", "coAdminProfilePath.jpg", new Date());

                        User member = UserFactory.createUser("member123", "Member User", "memberProfilePath.jpg", new Date());

       
        // Assign roles to users
        GroupAdmin admin = new GroupAdmin("admin", group);
        GroupManager.requestToJoin(member, group);
        admin.approveRequest("coadmin123");
        admin.promoteToCoAdmin("coadmin123");
       

        // Add posts to the group
        Post post1 = new Post("post123", adminUser.getUserId(), "Hello, this is the first post!", null, new Date());
        admin.addPost(post1);

        // Create a GroupPage for the admin user
      
            GroupPage page= new GroupPage(group, adminUser);
            page.setVisible(true);
     
    }
}
