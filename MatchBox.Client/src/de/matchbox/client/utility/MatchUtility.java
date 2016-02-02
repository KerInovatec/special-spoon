/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.client.utility;

import de.matchbox.client.Zahl;
import de.matchbox.communication.shared.abiturklassen.List;

/**
 *
 * @author Pascal
 */
public class MatchUtility {

    public MatchUtility() {
    }

    public static void moveMatch(List pEquasion, int pZahlIndex1, int pZahlIndex2, int pIndex1, int pIndex2) {

        if (pIndex1 >= 0 && pIndex1 <= 9
                && pIndex2 >= 0 && pIndex2 <= 9) {
            pEquasion.toFirst();
            for (int i = 0; i < pZahlIndex1; i++) {
                pEquasion.next();
            }
            Zahl Zahl1 = (Zahl) pEquasion.getObject();
            pEquasion.toFirst();
            for (int i = 0; i < pZahlIndex2; i++) {
                pEquasion.next();
            }
            Zahl Zahl2 = (Zahl) pEquasion.getObject();

            boolean zahl1[] = Zahl1.getZahlCode();

            if (zahl1[pIndex1]) {
                boolean zahl2[] = Zahl2.getZahlCode();
                if (!zahl2[pIndex2]) {

                    if (Zahl1.isNumber() && Zahl2.isNumber()) {
                        Zahl1.setZahlCode(zahl1);
                        Zahl2.setZahlCode(zahl2);
                    }

                }
            }

        }
    }

    public static String matchToEquation(List pEquation) {
        String ausgabe = null;
        pEquation.toFirst();
        while (pEquation.hasAccess()) {
            if (!(pEquation.getObject() instanceof Zahl)) {
                ausgabe += (char) pEquation.getObject();
            } else {

                ausgabe += ((Zahl) pEquation.getObject()).toInt();
            }
            pEquation.next();
        }
        return ausgabe;
    }

    public static List equationToMatch(String pEquation) {
        List ausgabe = new List();
        for (int i = 0; i < pEquation.length(); i++) {
            if (!(pEquation.charAt(i) == '+' || pEquation.charAt(i) == '-' || pEquation.charAt(i) == '=' || pEquation.charAt(i) == '*')) {
                ausgabe.append(new Zahl(Integer.parseInt(pEquation.charAt(i) + "")));
            } else {

                ausgabe.append(pEquation.charAt(i));
            }
        }
        return ausgabe;
    }
}
