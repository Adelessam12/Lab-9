package lab.pkg9;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class PostManagableDeserializer implements JsonDeserializer<ContentManagable> {

    @Override
    public ContentManagable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        ArrayList<Content> posts = context.deserialize(
                jsonObject.get("posts"), new TypeToken<ArrayList<Post>>() {}.getType());

        PostManager manager = new PostManager();
        manager.setContent(posts);

        return manager;
    }
}
