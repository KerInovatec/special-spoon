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
                    if (lMatchesCount == 0 && lPossibleChanges.length > 0) {
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
                        }
                    }
                }
            }
            if (lLoopCount > 3) {
                return "";
            }
            lLoopCount++;
        } while (lChangesCount < lMaxChanges && !(lChangesCount > 0 && lMatchesCount == 0));

        String lWrongEquasion = CharUtility.getStringFromCharArray(lCharArray);
        if (lWrongEquasion.isEmpty() || isEquasionCorrect(lWrongEquasion)) {
            return getWrongEquasion(pCorrectEquasion);
        }

        return CharUtility.getStringFromCharArray(lCharArray);
    }

    static HashMap<Character, MatchInfoContainer[]> getMatchHelperHashMap() {
        HashMap<Character, MatchInfoContainer[]> lReturn = new HashMap<>();
        lReturn.put('1', new MatchInfoContainer[]{new MatchInfoContainer('7', -1)});
        lReturn.put('2', new MatchInfoContainer[]{new MatchInfoContainer('3', 0)});
        lReturn.put('3', new MatchInfoContainer[]{new MatchInfoContainer('2', 0), new MatchInfoContainer('5', 0), new MatchInfoContainer('9', -1)});
        lReturn.put('4', new MatchInfoContainer[]{});
        lReturn.put('5', new MatchInfoContainer[]{new MatchInfoContainer('3', 0), new MatchInfoContainer('6', -1), new MatchInfoContainer('9', -1)});
        lReturn.put('6', new MatchInfoContainer[]{new MatchInfoContainer('5', 1), new MatchInfoContainer('8', -1), new MatchInfoContainer('0', 0)});
        lReturn.put('7', new MatchInfoContainer[]{new MatchInfoContainer('1', 1)});
        lReturn.put('8', new MatchInfoContainer[]{new MatchInfoContainer('6', 1), new MatchInfoContainer('9', 1), new MatchInfoContainer('0', 1)});
        lReturn.put('9', new MatchInfoContainer[]{new MatchInfoContainer('3', 1), new MatchInfoContainer('5', 1), new MatchInfoContainer('8', -1), new MatchInfoContainer('0', 0)});
        lReturn.put('0', new MatchInfoContainer[]{new MatchInfoContainer('6', 0), new MatchInfoContainer('8', -1), new MatchInfoContainer('9', 0)});
        return lReturn;
    }

    public static boolean isEquasionCorrect(String pEquasion) {
        pEquasion = pEquasion.replace("*", "");
        char lEquasionTypeChar;
        if (pEquasion.contains("+")) {
            lEquasionTypeChar = '+';
        } else if (pEquasion.contains("-")) {
            lEquasionTypeChar = '-';
        } else {
            return false;
        }
        try {
            int lNumber1 = Integer.parseInt(pEquasion.split("\\" + String.valueOf(lEquasionTypeChar))[0]);
            int lNumber2 = Integer.parseInt(pEquasion.split("\\" + String.valueOf(lEquasionTypeChar))[1].split("=")[0]);
            int lSum = Integer.parseInt(pEquasion.split("=")[1]);
            switch (lEquasionTypeChar) {
                case '+':
                    return lNumber1 + lNumber2 == lSum;
                case '-':
                    return lNumber1 - lNumber2 == lSum;
                default:
                    return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean canBeCreatedFromEquasion(String pEquasion, String pToBeChecked) {
        if (pEquasion.length() != pToBeChecked.length()) {
            return false;
        }

        HashMap<Character, MatchInfoContainer[]> lMatchHelperHashMap = getMatchHelperHashMap();
        char[] lEquasion = pEquasion.toCharArray();
        char[] lToBeChecked = pToBeChecked.toCharArray();
        for (int i = 0; i < lToBeChecked.length; i++) {
            if ((lToBeChecked[i] == '*' && lEquasion[i] != '*')
                    || (lToBeChecked[i] == '+' && lEquasion[i] != '+')
                    || (lToBeChecked[i] == '=' && lEquasion[i] != '=')) {
                return false;
            } else if (lToBeChecked[i] != '*' && lToBeChecked[i] != '+' && lToBeChecked[i] != '=' && lToBeChecked[i] != lEquasion[i]) {
                boolean lFoundChar = false;
                for (MatchInfoContainer lContainer : lMatchHelperHashMap.get(lEquasion[i])) {
                    if (lContainer.getResult() == lToBeChecked[i]) {
                        lFoundChar = true;
                    }
                }
                if (!lFoundChar) {
                    return false;
                }
            }
        }
        return true;
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
