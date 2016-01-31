package de.matchbox.communication.jsonadapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import de.matchbox.communication.contentobjects.roomcommands.IRoomCommandContentObject;
import java.lang.reflect.Type;

public class IRoomCommandContentObjectAdapter implements JsonSerializer<IRoomCommandContentObject>, JsonDeserializer<IRoomCommandContentObject> {

    private static final String CLASSNAME = "classname";
    private static final String INSTANCE = "instance";

    @Override
    public JsonElement serialize(IRoomCommandContentObject t, Type type, JsonSerializationContext jsc) {
        JsonObject lReturn = new JsonObject();
        String lClassName = t.getClass().getCanonicalName();
        lReturn.addProperty(CLASSNAME, lClassName);
        JsonElement lJsonElement = jsc.serialize(t);
        lReturn.add(INSTANCE, lJsonElement);
        return lReturn;
    }

    @Override
    public IRoomCommandContentObject deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
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
