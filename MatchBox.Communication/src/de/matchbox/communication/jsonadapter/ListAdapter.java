/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.jsonadapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import de.matchbox.communication.shared.abiturklassen.List;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Pascal
 */
public class ListAdapter implements JsonSerializer<List>, JsonDeserializer<List> {

    @Override
    public JsonElement serialize(List t, Type type, JsonSerializationContext jsc) {
        ArrayList<ListContainerObject> lContainerObjects = new ArrayList<>();
        t.toFirst();
        while (t.hasAccess()) {
            lContainerObjects.add(new ListContainerObject(t.getObject().getClass().getCanonicalName(), jsc.serialize(t.getObject()).getAsString()));
            t.next();
        }
        return jsc.serialize(lContainerObjects);
    }

    @Override
    public List deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        List lReturn = new List();
        
        Type fooType = new TypeToken<ArrayList<ListContainerObject>>() {
        }.getType();
        ArrayList<ListContainerObject> lContainerObjects = jdc.deserialize(je, fooType);

        for (ListContainerObject curContainer : lContainerObjects) {
            try {
                Class lClass = Class.forName(curContainer.classname);
                lReturn.append(jdc.deserialize(new JsonParser().parse(curContainer.instance), lClass));
            } catch (Exception e) {
                throw new JsonParseException(e.getMessage());
            }
        }
        return lReturn;
    }

    private class ListContainerObject {

        private final String classname;
        private final String instance;

        private ListContainerObject(String pClassname, String pInstance) {
            this.classname = pClassname;
            this.instance = pInstance;
        }
    }
}
