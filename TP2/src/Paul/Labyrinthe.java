/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paul;

import Jak.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Ashvin SIlvestro And Antoine Jover
 */
public class Labyrinthe {

    public int tailleX, tailleY;
    public int departX, departY;
    public int arriveeX, arriveeY;
    private int posX, posY;
    CaseImplementee labyrinthe[][];

    public void InitFromFile(File lab) throws FileFormatException {

        Scanner laby;

        try {
            laby = new Scanner(lab);
        } catch (FileNotFoundException ex) {
            throw new FileFormatException();
        }
        if (lab.length() == 0) {
            throw new FileFormatException();
        }

        this.tailleX = laby.nextInt();
        this.tailleY = laby.nextInt();
        this.departX = laby.nextInt();
        this.departY = laby.nextInt();
        this.arriveeX = laby.nextInt();
        this.arriveeY = laby.nextInt();
        this.posX = this.departX;
        this.posY = this.departY;
        this.labyrinthe = new CaseImplementee[this.tailleY][this.tailleX];
        String ligne = laby.nextLine();
        for (int i = 0; i < this.tailleY; i++) {
            for (int j = 0; j < this.tailleX; j++) {
                if (ligne.charAt(j) == 'X') {
                    labyrinthe[i][j] = new CaseMur(i, j);
                } else {
                    labyrinthe[i][j] = new CaseTrou(i, j);
                }
            }
            ligne = laby.nextLine();
        }
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

    public void automove(int x, int y) {
        int nextX = this.posX;
        int nextY = this.posY;

        do {

            int test = (int) (Math.random() * 4);
            switch (test) {
                case 0:
                    nextX++;
                    break;
                case 1:
                    nextX--;
                    break;
                case 2:
                    nextY++;
                    break;
                case 3:
                    nextY--;
                    break;

            }
        } while ((nextX >= tailleX) || (nextX < 0) || (nextY >= tailleY) || (nextY < 0) && !(labyrinthe[nextX][nextY].canMoveToCase()));

    }
    
    public int getCurrentPositionX(){
        return this.posX;
    }

    public int getCurrentPositionY(){
        return this.posY;
}
}