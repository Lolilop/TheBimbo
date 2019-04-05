package thebimbo;


import java.io.IOException;

import java.net.MalformedURLException;

import packages.decisionnaires.Player;
import packages.decisionnaires.ia.Proba;
import packages.map.Map;
import java.util.Scanner;
import packages.etat.Goal;

import packages.interfaces.Interface;


/**
 *
 * @author TTurq
 */

public class main {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        
        Scanner clavier = new Scanner(System.in);
        
        Map grille = new Map();
        
        
        
        Player joueur = new Player(grille) {};
         Proba ia = new Proba(grille,joueur);
         Goal objectif = new Goal((short)6,(short)6);
         grille.print();
         
         Interface ihm = new Interface();
         ihm.setVisible(true);
         
        
        while(joueur.win((short)0,(short)0) != true && ia.win((short)0,(short)0) != true ){
            
     
        System.err.print("choisir une position : ");
        int a = clavier.nextInt();
        //ia.deplacer(grille);
        grille.print();
        
        switch(a){
            case 1:
                   joueur.directionNorth(grille);
                   break;
            case 2:
                   joueur.directionSouth(grille);
                   break;
            case 3:
                   joueur.directionEast(grille);
                   break;
            case 4:
                   joueur.directionWest(grille);
                   break;
        }

        grille.print();

        
        }
    }
    
   
    
}
