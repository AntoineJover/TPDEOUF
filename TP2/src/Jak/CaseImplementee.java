/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jak;

/**
 *
 *  * @author Ashvin SIlvestro And Antoine Jover
 */
public class CaseImplementee implements Case {

    protected int posX, posY;
    protected boolean vasy;
    
    public CaseImplementee(int posX, int posY) 
    {
        this.posX=posX;
        this.posY=posY;
    }

    @Override
    public int getPositionX() {
        return posX;
    }

    @Override
    public int getPositionY() {
        return posY;
    }
    
    @Override
    public boolean canMoveToCase() {
        return vasy;
    }
    
}
