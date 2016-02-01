package de.matchbox.server.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MatchUtility {

    public static String getWrongEquasion(String pCorrectEquasion) {
        int lMaxChanges = 2;
        int lChangesCount = 0;
        int lMatchesCount = 0;
        HashMap<Character, MatchInfoContainer[]> lMatchHelperHashMap = getMatchHelperHashMap();
        ArrayList<Integer> lChangedIndexes = new ArrayList<>();

        char[] lCharArray = pCorrectEquasion.toCharArray();
        int lLoopCount = 0;
        do {
            for (int i = 0; i < lCharArray.length && lChangesCount < lMaxChanges && !(lChangesCount > 0 && lMatchesCount == 0); i++) {
                if (!lChangedIndexes.contains(i) && lMatchHelperHashMap.containsKey(lCharArray[i]) && new Random().nextBoolean()) {
                    MatchInfoContainer[] lPossibleChanges = lMatchHelperHashMap.get(lCharArray[i]);
                    if (lMatchesCount == 0) {
                        MatchInfoContainer lChange = lPossibleChanges[new Random().nextInt(lPossibleChanges.length)];
                        lMatchesCount += lChange.getMatchCount();
                        lCharArray[i] = lChange.getResult();
                        lChangedIndexes.add(i);
                        lChangesCount++;
                    } else {
                        ArrayList<MatchInfoContainer> lNewPossibleChanges = new ArrayList<>();
                        for (MatchInfoContainer lCurInfoContainer : lPossibleChanges) {
                            if (lMatchesCount + lCurInfoContainer.getMatchCount() == 0) {
                                lNewPossibleChanges.add(lCurInfoContainer);
                            }
                        }

                        if (lNewPossibleChanges.size() > 0) {
                            MatchInfoContainer lChange = lNewPossibleChanges.get(new Random().nextInt(lNewPossibleChanges.size()));
                            lMatchesCount += lChange.getMatchCount();
                            lCharArray[i] = lChange.getResult();
                            lChangedIndexes.add(i);
                            lChangesCount++;
                        } else {
                            for (MatchInfoContainer lCurInfoContainer : lPossibleChanges) {
                                if (lMatchesCount + lCurInfoContainer.getMatchCount() > 0) {
                                    lNewPossibleChanges.add(lCurInfoContainer);
                                }
                            }
                            if (lNewPossibleChanges.size() > 0) {
                                MatchInfoContainer lChange = lNewPossibleChanges.get(new Random().nextInt(lNewPossibleChanges.size()));
                                lMatchesCount += lChange.getMatchCount();
                                lCharArray[i] = lChange.getResult();
                                lChangedIndexes.add(i);
                                lChangesCount++;
                            }
                        }
                    }
                }
            }
            if (lLoopCount > 5) {
                return "";
            }
            lLoopCount++;
        } while (lChangesCount < lMaxChanges && !(lChangesCount > 0 && lMatchesCount == 0));

        return CharUtility.getStringFromCharArray(lCharArray);
    }

    static HashMap<Character, MatchInfoContainer[]> getMatchHelperHashMap() {
        HashMap<Character, MatchInfoContainer[]> lReturn = new HashMap<>();
        lReturn.put('1', new MatchInfoContainer[]{new MatchInfoContainer('7', -1)});
        lReturn.put('2', new MatchInfoContainer[]{new MatchInfoContainer('3', 0), new MatchInfoContainer('5', 0), new MatchInfoContainer('6', -1), new MatchInfoContainer('9', -1), new MatchInfoContainer('0', -1)});
        lReturn.put('3', new MatchInfoContainer[]{new MatchInfoContainer('2', 0), new MatchInfoContainer('4', 1), new MatchInfoContainer('5', 0), new MatchInfoContainer('6', -1), new MatchInfoContainer('9', -1), new MatchInfoContainer('0', -1)});
        lReturn.put('4', new MatchInfoContainer[]{new MatchInfoContainer('3', -1), new MatchInfoContainer('5', -1), new MatchInfoContainer('7', 1)});
        lReturn.put('5', new MatchInfoContainer[]{new MatchInfoContainer('2', 0), new MatchInfoContainer('3', 0), new MatchInfoContainer('4', 1), new MatchInfoContainer('6', -1), new MatchInfoContainer('9', -1), new MatchInfoContainer('0', -1)});
        lReturn.put('6', new MatchInfoContainer[]{new MatchInfoContainer('2', 1), new MatchInfoContainer('3', 1), new MatchInfoContainer('5', 1), new MatchInfoContainer('8', -1), new MatchInfoContainer('9', 0), new MatchInfoContainer('0', 0)});
        lReturn.put('7', new MatchInfoContainer[]{new MatchInfoContainer('1', 1), new MatchInfoContainer('4', -1)});
        lReturn.put('8', new MatchInfoContainer[]{new MatchInfoContainer('6', 1), new MatchInfoContainer('9', 1), new MatchInfoContainer('0', 1)});
        lReturn.put('9', new MatchInfoContainer[]{new MatchInfoContainer('2', 1), new MatchInfoContainer('3', 1), new MatchInfoContainer('5', 1), new MatchInfoContainer('6', 0), new MatchInfoContainer('8', -1), new MatchInfoContainer('0', 0)});
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
