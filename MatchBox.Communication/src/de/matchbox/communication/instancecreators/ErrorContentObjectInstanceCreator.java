package de.matchbox.communication.instancecreators;

import com.google.gson.InstanceCreator;
import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import java.lang.reflect.Type;

public class ErrorContentObjectInstanceCreator implements InstanceCreator<ErrorContentObject> {

    @Override
    public ErrorContentObject createInstance(Type type) {
        return new ErrorContentObject(ErrorType.UNKOWN);
    }

}
