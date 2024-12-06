
 package lab.pkg9;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;

public class FriendRequestManagableDeserializer implements JsonDeserializer<FriendRequestManagable> {

    @Override
    public FriendRequestManagable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        HashMap<String, String> sentFriendRequests = context.deserialize(
                jsonObject.get("sentFriendRequests"), new TypeToken<HashMap<String, String>>() {}.getType());

        HashMap<String, String> receivedFriendRequests = context.deserialize(
                jsonObject.get("receivedFriendRequests"), new TypeToken<HashMap<String, String>>() {}.getType());

        FriendRequestManager manager = new FriendRequestManager();
        manager.setSentFriendRequests(sentFriendRequests);
        manager.setReceivedFriendRequests(receivedFriendRequests);

        return manager;
    }
}
