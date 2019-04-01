package thebimbo;

import packages.decisionnaires.Joueur;
import packages.decisionnaires.ia.Proba;
import packages.map.Grille;
import java.util.Scanner;

/**
 *
 * @author TTurq
 */

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner clavier = new Scanner(System.in);
        
        Grille grille = new Grille();
        
      
        Joueur joueur = new Joueur(grille);
         Proba ia = new Proba(grille,joueur);
         grille.afficher();
        
        while(joueur.gagner(grille,(short)0,(short)0) != true && ia.gagner(grille,(short)0,(short)0) != true ){
            
        joueur.afficher();
        System.err.print("choisir une position : ");
        int a = clavier.nextInt();
        //ia.deplacer(grille);
        grille.afficher();
        
        switch(a){
            case 1:
                   joueur.directionNord(grille);
                   break;
            case 2:
                   joueur.directionSud(grille);
                   break;
            case 3:
                   joueur.directionEst(grille);
                   break;
            case 4:
                   joueur.directionOuest(grille);
                   break;
        }
        joueur.afficher();
        grille.afficher();
            System.err.println( ia.gagner(grille,(short)0,(short)0));
            ia.afficher();
            joueur.afficher();
        
        }
    }
    
}
