/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class GroupRoleTypeAdapter extends TypeAdapter<GroupRole> {
    private final Gson gson = new Gson();

    @Override
    public void write(JsonWriter out, GroupRole value) throws IOException {
        // Serialize the object with a type field
        JsonObject jsonObject = gson.toJsonTree(value).getAsJsonObject();
        if (value instanceof GroupMember) {
            jsonObject.addProperty("type", "GroupMember");
        } else if (value instanceof GroupAdmin) {
            jsonObject.addProperty("type", "GroupAdmin");
        } else if (value instanceof GroupCoAdmin) {
            jsonObject.addProperty("type", "GroupCoAdmin");
        }
        gson.toJson(jsonObject, out);
    }

    @Override
    public GroupRole read(JsonReader in) throws IOException {
        JsonObject jsonObject = JsonParser.parseReader(in).getAsJsonObject();
        String type = jsonObject.get("type").getAsString();

        // Deserialize based on the type field
        switch (type) {
            case "GroupMember" -> {
                return gson.fromJson(jsonObject, GroupMember.class);
            }
            case "GroupAdmin" -> {
                return gson.fromJson(jsonObject, GroupAdmin.class);
            }
            case "GroupCoAdmin" -> {
                return gson.fromJson(jsonObject, GroupCoAdmin.class);
            }
            default -> throw new JsonIOException("Unknown GroupRole type: " + type);
        }
    }
}
