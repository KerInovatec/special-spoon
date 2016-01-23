/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.contentobjects.client;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pascal
 */
public class ListRoomsContentObject extends HashMap<String, String> {

    public ListRoomsContentObject(Map<Integer, String> pRoomList) {
        this.put("rooms", new Gson().toJson(pRoomList));
    }
}
