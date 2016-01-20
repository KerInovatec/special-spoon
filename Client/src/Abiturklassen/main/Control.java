package Abiturklassen.main;

import Abiturklassen.List;

public class Control {

    private List Gleichungen;

    public Control() {
        Gleichungen = new List();
    }

    public void moveMatch(Zahl pZahl1, Zahl pZahl2, int pIndex1, int pIndex2) { // Klasse Zeichen (+,-,=) erstellen. Matches in der liste bewegen
        if (pIndex1 >= 0 && pIndex1 <= 9
                && pIndex2 >= 0 && pIndex2 <= 9) {

            boolean zahl1[] = pZahl1.getZahlCode();

            if (zahl1[pIndex1]) {
                boolean zahl2[] = pZahl2.getZahlCode();
                if (!zahl2[pIndex2]) {
                    zahl1[pIndex1] = false;
                    zahl2[pIndex2] = true;
                    pZahl1.setZahlCode(zahl1);
                    pZahl2.setZahlCode(zahl2);
                }
            }

        }
    }
    public String matchToEquation(List pEquation)
    {
        //bynary serach tree?
    }
}
