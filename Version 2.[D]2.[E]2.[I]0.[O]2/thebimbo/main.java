package thebimbo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import packages.decisionnaires.Joueur;
import packages.decisionnaires.ia.Proba;
import packages.map.Grille;
import java.util.Scanner;
import packages.etat.Objectif;
import packages.interfaces.Interface;
import packages.musiques.Musique;

/**
 *
 * @author TTurq
 */

public class main {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    
    private Musique SON = new Musique(getClass().getResource("/packages/musiques/son/undertale-megalovania.wav"));
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        
        Scanner clavier = new Scanner(System.in);
        
        Grille grille = new Grille();
        
        
        
        Joueur joueur = new Joueur(grille);
         Proba ia = new Proba(grille,joueur);
         Objectif objectif = new Objectif((short)6,(short)6);
         grille.afficher();
         
         Interface ihm = new Interface();
         ihm.setVisible(true);
         
        joueur.lecture("src/packages/outils/fichiers/gestion_sauvegardes/joueur.txt");
        joueur.sauvegarder("src/packages/outils/fichiers/gestion_sauvegardes/joueur.txt");
        ia.sauvegarder("src/packages/outils/fichiers/gestion_sauvegardes/ia.txt");
        objectif.sauvegarder("src/packages/outils/fichiers/gestion_sauvegardes/objectif.txt");
        grille.sauvegarder("src/packages/outils/fichiers/gestion_sauvegardes/grille.txt");
        
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
