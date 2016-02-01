package de.matchbox.server.utility;

import java.util.HashMap;

public class MatchUtility {

    static HashMap<Character, MatchInfoContainer[]> getMatchHelperHashMap() {
        HashMap<Character, MatchInfoContainer[]> lReturn = new HashMap<>();
        lReturn.put('1', new MatchInfoContainer[]{new MatchInfoContainer('4', -2), new MatchInfoContainer('7', -1)});
        lReturn.put('2', new MatchInfoContainer[]{new MatchInfoContainer('3', 0), new MatchInfoContainer('5', 0), new MatchInfoContainer('6', -1), new MatchInfoContainer('8', -2), new MatchInfoContainer('9', -1), new MatchInfoContainer('0', -1)});
        lReturn.put('3', new MatchInfoContainer[]{new MatchInfoContainer('2', 0), new MatchInfoContainer('4', 1), new MatchInfoContainer('5', 0), new MatchInfoContainer('6', -1), new MatchInfoContainer('8', -2), new MatchInfoContainer('9', -1), new MatchInfoContainer('0', -1)});
        lReturn.put('4', new MatchInfoContainer[]{new MatchInfoContainer('1', 2), new MatchInfoContainer('3', -1), new MatchInfoContainer('5', -1), new MatchInfoContainer('7', 1), new MatchInfoContainer('9', -2)});
        lReturn.put('5', new MatchInfoContainer[]{new MatchInfoContainer('2', 0), new MatchInfoContainer('3', 0), new MatchInfoContainer('4', 1), new MatchInfoContainer('6', -1), new MatchInfoContainer('8', -2), new MatchInfoContainer('9', -1), new MatchInfoContainer('0', -1)});
        lReturn.put('6', new MatchInfoContainer[]{new MatchInfoContainer('2', 1), new MatchInfoContainer('3', 1), new MatchInfoContainer('5', 1), new MatchInfoContainer('8', -1), new MatchInfoContainer('9', 0), new MatchInfoContainer('0', 0)});
        lReturn.put('7', new MatchInfoContainer[]{new MatchInfoContainer('1', 1), new MatchInfoContainer('4', -1)});
        lReturn.put('8', new MatchInfoContainer[]{new MatchInfoContainer('2', 2), new MatchInfoContainer('3', 2), new MatchInfoContainer('5', 2), new MatchInfoContainer('6', 1), new MatchInfoContainer('9', 1), new MatchInfoContainer('0', 1)});
        lReturn.put('9', new MatchInfoContainer[]{new MatchInfoContainer('2', 1), new MatchInfoContainer('3', 1), new MatchInfoContainer('4', 2), new MatchInfoContainer('5', 1), new MatchInfoContainer('6', 0), new MatchInfoContainer('8', -1), new MatchInfoContainer('0', 0)});
        lReturn.put('0', new MatchInfoContainer[]{new MatchInfoContainer('2', 1), new MatchInfoContainer('3', 1), new MatchInfoContainer('5', 1), new MatchInfoContainer('6', 0), new MatchInfoContainer('8', -1), new MatchInfoContainer('9', 0)});
        return lReturn;
    }

}

class MatchInfoContainer {

    private final char result;
    private final int matchCount;

    public MatchInfoContainer(char pResult, int pMatchCount) {
        this.result = pResult;
        this.matchCount = pMatchCount;
    }

    public char getResult() {
        return result;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
