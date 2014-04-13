/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paul;

import java.util.*;
import java.io.*;

/**
 *
 * @author Kreax
 */
public class Labyrinthe {

    public int tailleX, tailleY;
    public int departX, departY;
    public int arriveeX, arriveeY;
    private int posX, posY;

    // test de ouf
    public void InitFromFile(File lab) throws FileFormatException {
        Scanner laby = new Scanner(lab);
        String parametre = new String();
        parametre = laby.nextLine();

// test
    }

    public void move(int x, int y) throws ImpossibleMoveException {
        if ((x >= tailleX) || (x < 0) || (y >= tailleY) || (y < 0)) {
            throw new ImpossibleMoveException("Cette case n'existe pas");

        } else if (labyrinthe[x][y].canMoveToCase()) {

            this.posX = x;
            this.posY = y;

        } else {

            throw new ImpossibleMoveException("Un mur est présent sur cette case !");
        }
    }
}
