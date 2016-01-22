/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.abi;

public class BinaryTree
{
    private Object lContent;
    private BinaryTree lLeftTree, lRightTree;

    /**
     * Nach dem Aufruf des Konstruktors existiert ein leerer Binaerbaum.
     */
    public BinaryTree()
    {
        lContent = null;
        lLeftTree = null;
        lRightTree = null;
    }

    /**
     * Wenn der Parameter pContent ungleich null ist, existiert nach dem Aufruf des Konstruktors der Binaerbaum und hat pContent als Inhaltsobjekt
     * und zwei leere Teilbaeume. Falls der Parameter null ist, wird ein leerer Binaerbaum erzeugt.
     *
     * @param pContent Inhaltsobjekt
     */
    public BinaryTree(Object pObject)
    {
        if(pObject != null)
        {
            lContent = pObject;
            lLeftTree = new BinaryTree();
            lRightTree = new BinaryTree();
        } else
        {
            lContent = null;
            lLeftTree = null;
            lRightTree = null;
        }
    }

    /**
     * Wenn der Parameter pContent ungleich null ist, wird ein Binaerbaum mit pContent als Objekt
     * und den beiden Teilbaeume pLeftTree und pRightTree erzeugt. Sind pLeftTree oder pRightTree gleich null, wird der entsprechende Teilbaum
     * als leerer Binaerbaum eingefuegt. Wenn der Parameter pContent gleich null ist, wird ein leerer Binaerbaum erzeugt.
     *
     * @param pContent     Inhaltsobjekt
     * @param pLinkerBaum  linker Binaerbaum
     * @param pRechterBaum rechter Binaerbaum
     */
    public BinaryTree(Object pContent, BinaryTree pLinkerBaum, BinaryTree pRechterBaum)
    {
        if(pContent != null)
        {
            lContent = pContent;
            if(pLinkerBaum != null)
                lLeftTree = pLinkerBaum;
            else
                lLeftTree = new BinaryTree();
            if(pRechterBaum != null)
                lRightTree = pRechterBaum;
            else
                lRightTree = new BinaryTree();
        } else
        {    // da der Inhalt null ist, wird ein leerer Baum erzeugt
            lContent = null;
            lLeftTree = null;
            lRightTree = null;
        }

    }

    /**
     * Diese Anfrage liefert den Wahrheitswert true, wenn der Binaerbaum leer ist, sonst liefert sie den Wert false.
     *
     * @return true, wenn der Binaerbaum leer ist, sonst false
     */
    public boolean isEmpty()
    {
        return (lContent == null);
    }

    /**
     * Wenn der Binaerbaum leer ist, wird der Parameter pObject als Inhaltsobjekt sowie ein leerer linker und rechter Teilbaum eingefuegt.
     * Ist der Binaerbaum nicht leer, wird das Inhaltsobjekt durch pObject ersetzt. Die Teilbaeume werden nicht geaendert.
     * Wenn pObject null ist, bleibt der Binaerbaum unveraendert.
     *
     * @param pObject neues Inhaltsobjekt
     */
    public void setObject(Object pObject)
    {
        if(pObject != null)
        {
            if(this.isEmpty())
            {
                lLeftTree = new BinaryTree();
                lRightTree = new BinaryTree();
            }
            lContent = pObject;
        }
    }

    /**
     * Diese Anfrage liefert das Inhaltsobjekt des Binaerbaums. Wenn der Binaerbaum leer ist, wird null zurueckgegeben.
     *
     * @return Inhaltsobjekt (bzw. null, wenn der Baum leer ist)
     */
    public Object getObject()
    {
        return lContent;
    }

    /**
     * Wenn der Binaerbaum leer ist, wird pTree nicht angehaengt.
     * Andernfalls erhaelt der Binaerbaum den uebergebenen Baum als linken Teilbaum. Falls der Parameter null ist, aendert sich nichts.
     *
     * @param pTree neuer linker Teilbaum
     */
    public void setLeftTree(BinaryTree pTree)
    {
        if(!this.isEmpty() && pTree != null)
            lLeftTree = pTree;
    }

    /**
     * Wenn der Binaerbaum leer ist, wird pTree nicht angehaengt.
     * Andernfalls erhaelt der Binaerbaum den uebergebenen Baum als rechten Teilbaum. Falls der Parameter null ist, aendert sich nichts.
     *
     * @param pTree neuer rechter Teilbaum
     */
    public void setRightTree(BinaryTree pTree)
    {
        if(!this.isEmpty() && pTree != null)
            lRightTree = pTree;
    }

    /**
     * Diese Anfrage liefert den linken Teilbaum des Binaerbaumes.
     * Der Binaerbaum aendert sich nicht. Wenn der Binaerbaum leer ist, wird null zurueckgegeben.
     *
     * @return linker Teilbaum
     */
    public BinaryTree getLeftTree()
    {
        if(!this.isEmpty())
            return lLeftTree;
        else
            return null;
    }

    /**
     * Diese Anfrage liefert den rechten Teilbaum des Binaerbaumes.
     * Der Binaerbaum aendert sich nicht. Wenn der Binaerbaum leer ist, wird null zurueckgegeben.
     *
     * @return rechter Teilbaum
     */
    public BinaryTree getRightTree()
    {
        if(!this.isEmpty())
            return lRightTree;
        else
            return null;
    }

    /**
     * Der Baum wird durch diesen Auftrag geleert.
     * Die Anfrage isEmpty liefert danach true zurueck und auf die beiden urspruenglichen Teilbaeume kann nicht mehr zugegriffen werden.
     */
    public void setEmpty()
    {
        lContent = null;
        lLeftTree = null;
        lRightTree = null;
    }
}
