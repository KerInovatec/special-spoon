package de.matchbox.client.utility;

import java.util.Map;
import java.util.TreeMap;

public class Konami {

    private static final int[] code
            = {38, 38, 40, 40, 37, 39, 37, 39, 66, 65};
    static private Map<Integer, Integer>[] graph;
    static private int currentNode = 0;
    
    static public boolean isActivated = false;

    static public void checkKonami(int keyPressed) {
        Integer nextNode = graph[currentNode].get(keyPressed);
        currentNode = (nextNode == null ? 0 : nextNode);
        isActivated = currentNode == code.length - 1;
    }

    static public void generateSequenceMap() {
        graph = generateSequenceMap(code);
    }

    static private Map<Integer, Integer>[] generateSequenceMap(int[] sequence) {
        Map<Integer, Integer>[] lGraph = new Map[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            lGraph[i] = new TreeMap<>();
        }

        for (int i = 0; i < sequence.length; i++) {
            loop:
            for (int j = i; j < sequence.length - 1; j++) {
                if (sequence[j - i] == sequence[j]) {
                    Integer value = lGraph[j].get(sequence[j - i + 1]);
                    if (value == null || value < j - i + 1) {
                        lGraph[j].put(sequence[j - i + 1], j - i + 1);
                    }
                } else {
                    break;
                }
            }
        }
        return lGraph;
    }
}
