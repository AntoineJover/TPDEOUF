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
            throw new FileFormatException("Le fichier" + lab.getName() + " n'existe pas");
        }
        if (lab.length() == 0) {
            throw new FileFormatException("fichier vide");
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
}
