/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg9;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class StoryManagableCreator implements InstanceCreator<StoryManagable> {
    @Override
    public StoryManagable createInstance(Type type) {
        return new StoryManager();
    }
}
