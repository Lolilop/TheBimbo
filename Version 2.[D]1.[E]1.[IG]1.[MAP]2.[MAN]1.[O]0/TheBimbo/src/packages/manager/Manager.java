/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packages.manager;

import packages.etat.Etat;
import packages.map.Grille;
import packages.decisionnaires.*;
import packages.decisionnaires.ia.*;

/**
 * Manager, devra contenir un objet Grille (pour connaître l'état des cases) ainsi que deux Decisionnaire (le Joueur et l'Ennemi)
 * Il fera avancer le Joueur/l'Ennemi sur la Grille quand l'Interface Graphique lui demandera et fournira à l'Interface Graphique l'état des cases
 * @author Théo Gerfaux
 */
public class Manager {
    private Grille grille;
    private Decisionnaires joueur1;
    private Decisionnaires joueur2;
    
    public Manager(Grille g, Decisionnaires j1, Decisionnaires j2){
        grille=g;
        joueur1=j1;
        joueur2=j2;
    }
    
    public Manager(Grille g){
        joueur1=new Joueur(g);
        joueur2=new Random(g);
    }
    
    public boolean deplacerJoueur1(String direction){
        return joueur1.deplacer(grille,direction);
    }
    
    public void deplacerJoueur2(){
        joueur2.deplacer(grille,"");
    }
    
    public Etat getEtat(short i, short j){
        return grille.getPosition(i,j);
    }
    
    public Joueur getJoueur1(){return (Joueur)joueur1;}
    
    public Grille getGrille(){return grille;}
    
    public void reset(){
        grille=new Grille();
        joueur1=new Joueur(grille);
        joueur2=new Random(grille);
    }
    
    
}
