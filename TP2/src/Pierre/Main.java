/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pierre;

import java.io.File;
import java.util.*;
import Paul.*;
import Jak.*;

/**
 *
 * @author Antoine Jover And Ashvin Silvestro
 */
public class Main {

    public static void main(String[] args) throws FileFormatException, ImpossibleMoveException {
        boolean jeu = true;
        String clav;
        int nextX;
        int nextY;
        
        
        
        
        System.out.println("Bienvenue dans le jeu du labyrynthe ! taper le nom du niveau a charger !");
        Scanner ent = new Scanner(System.in);

        File fic = new File(ent.next());

        Labyrinthe laby = new Labyrinthe();
        try {
            laby.InitFromFile(fic);
        } catch (FileFormatException err) {
            throw err;
        }
        System.out.println("Taper a pour lancer le jeu an auto, et s pour jouer");
        clav = ent.next();

        while (!"a".equals(clav) || !"s".equals(clav)) {
            System.out.println("Taper a pour lancer le jeu an auto, et s pour jouer");
            clav = ent.next();
        }

        while (jeu) {
            
            if ("a".equals(clav)) 
            {
                laby.automove();
            } 
            else 
            {
                System.out.println("taper la position X voulue");
                nextX = Integer.parseInt(ent.next());
                System.out.println("taper la position Y voulue");
                nextY = Integer.parseInt(ent.next());
                laby.move(nextY, nextY);
            }
            if(laby.getCurrentPositionX() == laby.arriveeX && laby.getCurrentPositionX() == laby.arriveeX)
            {
                jeu = false;
            }
        }
        System.out.println("jeu terminé.");
        
    }
}
