package de.matchbox.server.utility;

public class CharUtility {

    public static String getStringFromCharArray(char[] pCharArray) {
        String lReturnString = "";
        for (char lCurChar : pCharArray) {
            lReturnString += lCurChar;
        }
        return lReturnString;
    }
}
