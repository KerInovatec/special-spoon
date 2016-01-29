/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.classmodels;

/**
 *
 * @author Pascal
 */
public class RoomModel {
    private final int id;
    private final String name;

    public RoomModel(int pId, String pName) {
        this.id = pId;
        this.name = pName;
    }

    public RoomModel() {
        this(Integer.MAX_VALUE, "");
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString()
    {
        return this.getName();
    }
}
