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
 * @author Kreax
 */
public class Labyrinthe {

    public int tailleX, tailleY;
    public int departX, departY;
    public int arriveeX, arriveeY;
    private int posX, posY;
    CaseImplementee labyrinthe[][];

    public void InitFromFile(File lab) throws FileFormatException {

        Scanner laby = new Scanner(lab);

        this.tailleX = laby.nextInt(); // la premiere ligne sert a initialiser les attributs du labyrinthe
        this.tailleY = laby.nextInt();
        this.departX = laby.nextInt();
        this.departY = laby.nextInt();
        this.arriveeX = laby.nextInt();
        this.arriveeY = laby.nextInt();

        this.posX = this.departX;
        this.posY = this.departY;

        this.labyrinthe = new CaseImplementee[this.tailleY][this.tailleX]; // on crée un tableau de la taille du terrain

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

}
