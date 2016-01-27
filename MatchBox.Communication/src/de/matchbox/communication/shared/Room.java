package de.matchbox.communication.shared;

import com.google.gson.annotations.Expose;

public class Room {
    @Expose
    private final int id;
    @Expose
    private final String name;
    
    public Room(){
        this.id = Integer.MAX_VALUE;
        this.name = "";
    }
    
    public Room(int pId, String pName){
        this.id = pId;
        this.name = pName;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
