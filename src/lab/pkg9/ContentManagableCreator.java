/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

/**
 *
 * @author DELL
 */
public class ContentManagableCreator implements InstanceCreator<ContentManagable> {
    @Override
    public ContentManagable createInstance(Type type) {
        return new ContentManager();
    }
}
