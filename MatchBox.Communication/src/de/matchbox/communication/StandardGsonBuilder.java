/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.contentobjects.IMessageContentObject;
import de.matchbox.communication.instancecreators.ErrorContentObjectInstanceCreator;
import de.matchbox.communication.jsonadapter.IMessageContentObjectAdapter;
import de.matchbox.communication.jsonadapter.ListAdapter;
import de.matchbox.communication.shared.abiturklassen.List;

/**
 *
 * @author Pascal
 */
public final class StandardGsonBuilder {
    private final GsonBuilder gsonBuilder;
    
    public StandardGsonBuilder(){
        this.gsonBuilder = new GsonBuilder();
        this.gsonBuilder.registerTypeAdapter(IMessageContentObject.class, new IMessageContentObjectAdapter());
        this.gsonBuilder.registerTypeAdapter(ErrorContentObject.class, new ErrorContentObjectInstanceCreator());
        this.gsonBuilder.registerTypeAdapter(List.class, new ListAdapter());
    }
    
    public GsonBuilder createBuilder(){
        return this.gsonBuilder;
    }
    
    public Gson create(){
        return this.gsonBuilder.create();
    }
}