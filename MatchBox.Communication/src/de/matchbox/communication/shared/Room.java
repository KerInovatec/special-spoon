package de.matchbox.communication.shared;

import com.google.gson.annotations.Expose;

public class Room {
    @Expose
    private final int id;
    @Expose
    private final String name;
    
    
    public Room(int pId, String pName){
        this.id = pId;
        this.name = pName;
    }
    public Room(String pName){
        this(Integer.MAX_VALUE,pName);
    }
    public Room(){
        this(Integer.MAX_VALUE,"");
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
