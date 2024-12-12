package lab.pkg9;

import java.util.Date;
import lab.Frontend.GroupPage;


public class Main {
    public static void main(String[] args) {
        // Create a mock group for testing

        // Add mock users to the group
        User adminUser = UserManager.findUser("IDcfc29e3b-a0ce-4be4-9ba4-7f673e06f644");
        Group group =GroupManager.createGroup("g2", "ahmed", "a7a", "C:\\Users\\Dell\\Documents\\GitHub\\Lab-9\\OIP.jpeg", "IDcfc29e3b-a0ce-4be4-9ba4-7f673e06f644");
       
                User coadmin = UserManager.findUser("IDcd754062-b7a0-4507-abc7-3a568ffbaea0");


       
//         Assign roles to users
        GroupAdmin admin = new GroupAdmin("admin", group);
        GroupManager.requestToJoin(coadmin, group);
        System.out.println(group);
        //admin.approveRequest("ID5145364b-2c3d-4625-adb6-865e88e17871");
       // admin.promoteToCoAdmin("ID2809dc45-fe8d-4437-9577-1c14d9c3e1d2");
//       

//         Add posts to the group
       // Post post1 = new Post("post123", adminUser.getUserId(), "Hello, this is the first post!", null, new Date());
       // admin.addPost(post1);

//         Create a GroupPage for the admin user
      
            GroupPage page= new GroupPage(group, adminUser);
            page.setVisible(true);
     
    }
}
