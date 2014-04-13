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
    
    /**
     *
     * @param posX
     * @param posY
     */
    public CaseImplementee(int posX, int posY) 
    {
        this.posX=posX;
        this.posY=posY;
    }

    /**
     *
     * @return
     */
    @Override
    public int getPositionX() {
        return posX;
    }

    /**
     *
     * @return
     */
    @Override
    public int getPositionY() {
        return posY;
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean canMoveToCase() {
        return vasy;
    }
    
}
