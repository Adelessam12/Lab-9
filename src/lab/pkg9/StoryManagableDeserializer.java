package lab.pkg9;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class StoryManagableDeserializer implements JsonDeserializer<StoryManagable> {

    @Override
    public StoryManagable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        ArrayList<Story> stories = context.deserialize(
                jsonObject.get("stories"), new TypeToken<ArrayList<Story>>() {}.getType());

        StoryManager manager = new StoryManager();
        manager.setStories(stories);

        return manager;
    }
}
