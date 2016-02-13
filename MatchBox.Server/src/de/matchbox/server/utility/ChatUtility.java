package de.matchbox.server.utility;

public class ChatUtility {
    public static String KickUsageText = "!kick USERNAME [REASON]";
    public static String SetUsageText = "!set {winningPoints, roomName} [VALUE]";
    public static String InfoUsageText = "!info";
    
    public static String getHelpText(boolean isHost){
        if(isHost){
            return "Help:\n" + InfoUsageText + "\n" + KickUsageText + "\n" + SetUsageText;
        }else{
            return "Help:\n" + InfoUsageText;
        }
    }
}
