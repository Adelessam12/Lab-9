package lab.pkg9;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FriendManagableDeserializer implements JsonDeserializer<FriendManagable> {

    @Override
    public FriendManagable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        // Deserialize fields manually
        ArrayList<String> friendList = context.deserialize(jsonObject.get("friendList"), new TypeToken<ArrayList<String>>() {}.getType());
        ArrayList<String> blockedList = context.deserialize(jsonObject.get("blockedList"), new TypeToken<ArrayList<String>>() {}.getType());
        FriendRequestManager friendRequestManager = context.deserialize(jsonObject.get("friendRequestManager"), FriendRequestManager.class);

        // Create a new FriendManager instance with the deserialized data
        FriendManager friendManager = new FriendManager(friendRequestManager);
        friendManager.setFriendList(friendList);
        friendManager.setBlockedList(blockedList);

        return friendManager;
    }
}
