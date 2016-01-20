package Abiturklassen.main;

import Abiturklassen.List;
import Abiturklassen.BinaryTree;

public class Control {
    
    BinaryTree zahlenBaum;
    public Control() {
        
        zahlenBaum =  new BinaryTree();
        
    }
    private void erstelleBaum(BinaryTree pBaum,boolean pBol,int pInt)
    {      
        
    }
    

    public boolean isNumber(boolean[] pZahlcode) {
        
       return true;
    }


    public void moveMatch(List pEquasion, int pZahlIndex1, int pZahlIndex2, int pIndex1, int pIndex2) {

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
                    zahl1[pIndex1] = false;
                    zahl2[pIndex2] = true;
                    if (this.isNumber(zahl1) && isNumber(zahl2)) {
                        Zahl1.setZahlCode(zahl1);
                        Zahl2.setZahlCode(zahl2);
                    }

                }
            }

        }
    }

    public String matchToEquation(List pEquation) {
        String ausgabe = null;
        pEquation.toFirst();
        while (pEquation.hasAccess()) {
            if (!(pEquation.getObject() instanceof Zahl)) {
                ausgabe += (char) pEquation.getObject();
            } else {

                ausgabe += ((Zahl) pEquation.getObject()).getZahl();
            }
            pEquation.next();
        }
        return ausgabe;
    }

    public List equationToMatch(String pEquation) {
        List ausgabe = new List();
        for (int i = 0; i < pEquation.length(); i++) {
            if (!(pEquation.charAt(i) == '+' || pEquation.charAt(i) == '-' || pEquation.charAt(i) == '=')) {
                ausgabe.append(new Zahl(Integer.parseInt(pEquation.charAt(i) + "")));
            } else {

                ausgabe.append(pEquation.charAt(i));
            }
        }
        return ausgabe;
    }
}
