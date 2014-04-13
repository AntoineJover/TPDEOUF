/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paul;

/**
 *
 * @author Kreax
 */
public class ImpossibleMoveException extends Exception {

    /**
     * Gestion des exceptions de déplacement
     *
     * @param exception
     */
    public ImpossibleMoveException(String exception) {
        System.out.println(exception);
    }
}
