/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.instancecreators;

import com.google.gson.InstanceCreator;
import de.matchbox.communication.contentobjects.ErrorContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import java.lang.reflect.Type;

/**
 *
 * @author Pascal
 */
public class ErrorContentObjectInstanceCreator implements InstanceCreator<ErrorContentObject> {

    @Override
    public ErrorContentObject createInstance(Type type) {
        return new ErrorContentObject(ErrorType.UNKOWN);
    }

}
