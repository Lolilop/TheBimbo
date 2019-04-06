/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packages.manager;

import packages.etat.Etat;
import packages.map.Map;
import packages.decisionnaires.Decisiveness;
import packages.decisionnaires.Player;
import packages.decisionnaires.ia.Proba;
import packages.etat.Goal;


/**
 * Manager, devra contenir un objet Grille (pour connaître l'état des cases) ainsi que deux Decisionnaire (le Joueur et l'Ennemi)
 * Il fera avancer le Joueur/l'Ennemi sur la Grille quand l'Interface Graphique lui demandera et fournira à l'Interface Graphique l'état des cases
 * @author Théo Gerfaux
 */
public class Manager {
    
    /*##########################################################################
    #                                ATTRIBUS                                  #
    ##########################################################################*/
    
    private Map map;
    private Decisiveness joueur1;
    private Decisiveness joueur2;
    
    /*##########################################################################
    #                            END ATTRIBUS                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                BUILDER                                   #
    ##########################################################################*/
    
    /**
     * Build the manager
     * @param map copy the grille
     * @param j1 give the j1
     * @param j2 give the j2
     */
    
    public Manager(Map map, Decisiveness j1, Decisiveness j2){
        
        this.map = map;
        this.joueur1 = j1;
        this.joueur2 = j2;
    }
    
    /**
     * Build the manager
     * @param g copy of the grille
     */
    
    public Manager(Map g){
        this.joueur1 = new Player(g) {};
        this.joueur2 = new Proba(g, (Player) joueur1);
    }
    
    /*##########################################################################
    #                             END BUILDER                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                             ASCENSEURS                                   #
    ##########################################################################*/
    
    /**
     * get the state
     * @param i position x
     * @param j position y
     * @return the state of the box
     */
    
    public Etat getEtat(short i, short j){
        return map.getPosition(i,j);
    }
    
    /**
     * get the Player 1
     * @return the player
     */
    
    public Player getPlayer1(){
        return (Player)joueur1;
    }
    
    /**
     * get the grille
     * @return the grille
     */
    
    public Map getGrille(){
        return map;
    }
    
    /*##########################################################################
    #                             END ASCENSEURS                               #
    ##########################################################################*/
    
    /*##########################################################################
    #                                 METHODE                                  #
    ##########################################################################*/
    
    /**
     * move the player 1
     * @param direction
     * @return true if the player move
     */
    
    public boolean movePlayer1(String direction){
        return joueur1.move(map,direction);
    }
       
    /**
     * move the player 2
     */
    
    public void movePlayer2(){
        joueur2.move(map,"");
    }
    
    /**
     * reset the game
     */

    public void reset(){
        
        map = new Map();
        joueur1 = new Player(map) {};
        joueur2 = new Proba(map, (Player) joueur1);
    }
    
    /*##########################################################################
    #                             END METHODE                                  #
    ##########################################################################*/
}
