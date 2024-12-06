/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;
import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

// FriendRequestManagable InstanceCreator
public class FriendRequestManagableCreator implements InstanceCreator<FriendRequestManagable> {
    @Override
    public FriendRequestManagable createInstance(Type type) {
        // Initialize the FriendRequestManager with its internal maps
        FriendRequestManager manager = new FriendRequestManager();      
        return manager;
    }
}
