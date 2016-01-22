package main;

import main.abi.List;

public class Control
{

    MatchBoxClient client;
    private FrmMain main;

    public Control(FrmMain main)
    {

        Zahl hZahl = new Zahl();
        this.main = main;
        client = new MatchBoxClient(this, "10.16.12.1", 1234);

    }

    public boolean isNumber(boolean[] pBol)
    {
        boolean ausgabe = false;
        int match;
        Zahl pZahl = new Zahl();
        boolean hBol[];
        for(int i = 0; i <= 9; i++)
        {
            match = 0;
            if(ausgabe)
            {
                return ausgabe;
            }
            pZahl.setZahl(i);
            hBol = pZahl.getZahlCode();
            for(int y = 0; y < 7; y++)
            {
                if(hBol[y] == pBol[y])
                {
                    match = +1;
                }
                else
                {
                    match = - 1;
                }
            }
            if(match == 7)
            {
                ausgabe = true;
            }
        }
        return ausgabe;
    }

    public void moveMatch(List pEquasion, int pZahlIndex1, int pZahlIndex2, int pIndex1, int pIndex2)
    {

        if(pIndex1 >= 0 && pIndex1 <= 9
           && pIndex2 >= 0 && pIndex2 <= 9)
        {
            pEquasion.toFirst();
            for(int i = 0; i < pZahlIndex1; i++)
            {
                pEquasion.next();
            }
            Zahl Zahl1 = (Zahl)pEquasion.getObject();
            pEquasion.toFirst();
            for(int i = 0; i < pZahlIndex2; i++)
            {
                pEquasion.next();
            }
            Zahl Zahl2 = (Zahl)pEquasion.getObject();

            boolean zahl1[] = Zahl1.getZahlCode();

            if(zahl1[pIndex1])
            {
                boolean zahl2[] = Zahl2.getZahlCode();
                if(!zahl2[pIndex2])
                {
                    zahl1[pIndex1] = false;
                    zahl2[pIndex2] = true;
                    if(this.isNumber(zahl1) && isNumber(zahl2))
                    {
                        Zahl1.setZahlCode(zahl1);
                        Zahl2.setZahlCode(zahl2);
                    }

                }
            }

        }
    }

    public String matchToEquation(List pEquation)
    {
        String ausgabe = null;
        pEquation.toFirst();
        while(pEquation.hasAccess())
        {
            if(!(pEquation.getObject() instanceof Zahl))
            {
                ausgabe += (char)pEquation.getObject();
            }
            else
            {

                ausgabe += ((Zahl)pEquation.getObject()).getZahl();
            }
            pEquation.next();
        }
        return ausgabe;
    }

    public List equationToMatch(String pEquation)
    {
        List ausgabe = new List();
        for(int i = 0; i < pEquation.length(); i++)
        {
            if(!(pEquation.charAt(i) == '+' || pEquation.charAt(i) == '-' || pEquation.charAt(i) == '='))
            {
                ausgabe.append(new Zahl(Integer.parseInt(pEquation.charAt(i) + "")));
            }
            else
            {

                ausgabe.append(pEquation.charAt(i));
            }
        }
        return ausgabe;
    }
}
