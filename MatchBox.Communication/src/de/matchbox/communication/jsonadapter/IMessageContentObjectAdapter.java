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
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import de.matchbox.communication.contentobjects.IMessageContentObject;
import java.lang.reflect.Type;

/**
 *
 * @author Pascal
 */
public class IMessageContentObjectAdapter implements JsonSerializer<IMessageContentObject>, JsonDeserializer<IMessageContentObject> {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE = "INSTANCE";

    @Override
    public JsonElement serialize(IMessageContentObject t, Type type, JsonSerializationContext jsc) {
        JsonObject lReturn = new JsonObject();
        String lClassName = t.getClass().getCanonicalName();
        lReturn.addProperty(CLASSNAME, lClassName);
        JsonElement lJsonElement = jsc.serialize(t);
        lReturn.add(INSTANCE, lJsonElement);
        return lReturn;
    }

    @Override
    public IMessageContentObject deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject lJsonObject = je.getAsJsonObject();
        JsonPrimitive lPrimitive = (JsonPrimitive) lJsonObject.get(CLASSNAME);
        String className = lPrimitive.getAsString();

        Class<?> lClass = null;
        try {
            lClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }
        return jdc.deserialize(lJsonObject.get(INSTANCE), lClass);
    }

}
