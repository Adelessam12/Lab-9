package lab.pkg9;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContentManagableDeserializer implements JsonDeserializer<ContentManagable> {

    @Override
    public ContentManagable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        ArrayList<Content> content = context.deserialize(
                jsonObject.get("contents"), new TypeToken<ArrayList<Content>>() {}.getType());

        ContentManagable manager = new ContentManager();
        manager.setContent(content);

        return manager;
    }
}
