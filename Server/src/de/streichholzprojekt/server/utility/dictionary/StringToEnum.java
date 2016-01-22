package de.streichholzprojekt.server.utility.dictionary;

import de.streichholzprojekt.server.enumeration.MessageType;
import java.util.HashMap;

public class StringToEnum
{
    public final static HashMap<String, MessageType> MessageTypeDictionary = getMessageTypeDictionary();

    private static HashMap<String, MessageType> getMessageTypeDictionary()
    {
        HashMap<String, MessageType> lReturn = new HashMap<>();
        lReturn.put("LOGIN", MessageType.LOGIN);
        lReturn.put("LOGOUT", MessageType.LOGOUT);
        lReturn.put("CREATE_ROOM", MessageType.CREATE_ROOM);
        lReturn.put("JOIN_ROOM", MessageType.JOIN_ROOM);
        lReturn.put("LEAVE_ROOM", MessageType.LEAVE_ROOM);
        lReturn.put("LIST", MessageType.LIST_ROOMS);

        return lReturn;
    }
}
