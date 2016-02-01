package de.matchbox.server.utility;

import de.matchbox.communication.shared.abiturklassen.List;

public class ListUtility {

    public static List copyList(List pListToCopy) {
        List pReturn = new List();
        pListToCopy.toFirst();
        while (pListToCopy.hasAccess()) {
            pReturn.append(pListToCopy.getObject());
            pListToCopy.next();
        }
        return pReturn;
    }
}
