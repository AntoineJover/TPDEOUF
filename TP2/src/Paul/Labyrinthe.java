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
    CaseImplementee[][] labyr;

    /**
     * Initialise le labyrinthe à partir d'un fichier
     * @param lab
     * @throws Paul.FileFormatException
     */
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
        this.labyr = new CaseImplementee[this.tailleY][this.tailleX];
        String ligne = laby.nextLine();
        for (int i = 0; i < this.tailleY; i++) {
            for (int j = 0; j < this.tailleX; j++) {
                if (ligne.charAt(j) == 'X') {
                    labyr[i][j] = new CaseMur(i, j);
                } else {
                    labyr[i][j] = new CaseTrou(i, j);
                }
            }
            ligne = laby.nextLine();
        }
    }

    /**
     * Vérifie le déplacement souhaité par le joueur et l'effectue
     *
     * @param x
     * @param y
     * @throws Paul.ImpossibleMoveException
     */
    public void move(int x, int y) throws ImpossibleMoveException {
        if ((x >= tailleX) || (x < 0) || (y >= tailleY) || (y < 0)) {
            throw new ImpossibleMoveException("Cette case n'existe pas");

        } else if (labyr[x][y].canMoveToCase() && ((x == posX + 1) || (x == posX - 1)) && ((y == posY + 1) || (y == posY - 1))) {
            this.posX = x;
            this.posY = y;

        } else {
            throw new ImpossibleMoveException("Un mur est présent sur cette case !");
        }
    }

    /**
     * Méthode qui génère aléatoirement le déplacement du joueur
     */
    public void automove() {
        int nextX;
        int nextY;

        do {

            nextY = this.posY;
            nextX = this.posX;

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
        } while ((nextX >= tailleX) || (nextX < 0) || (nextY >= tailleY) || (nextY < 0) && !(labyr[nextX][nextY].canMoveToCase()));

    }

    /**
     * Accesseur de la position actuelle de la case en x
     *
     * @return
     */
    public int getCurrentPositionX() {
        return this.posX;
    }

    /**
     * Accesseur de la position actuelle de la case en y
     *
     * @return
     */
    public int getCurrentPositionY() {
        return this.posY;
    }

    /**
     *
     * Affichage le labyrinthe
     */
    public void afficher() {

        for (int i = 0; i < this.tailleY; i++) {
            for (int j = 0; j < this.tailleX; j++) {
                if (labyr[i][j].canMoveToCase() == true && i == this.posX && j == this.posY) {
                    System.out.print("O");
                } else if (labyr[i][j].canMoveToCase() == true) {
                    System.out.print(" ");
                } else {
                    System.out.print("X");
                }
            }

        }
    }
}
