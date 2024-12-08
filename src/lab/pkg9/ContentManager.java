/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ContentManager implements ContentManagable {

    private ArrayList<Content> contents;

    public ContentManager() {
        contents = new ArrayList<>();
    }

    @Override
    public void addContent(Content content) {
        contents.add(content);

        Database database = DatabaseFactory.createDatabase();
        database.saveUsersToFile();
    }

    @Override
    public void setContent(ArrayList<Content> content) {
        contents = content;
    }

    @Override
    public void removeContent(Content content) {
        contents.remove(content);

        Database database = DatabaseFactory.createDatabase();
        database.saveUsersToFile();
    }

    @Override
    public ArrayList<Content> getContent() {
        return contents;
    }
}
