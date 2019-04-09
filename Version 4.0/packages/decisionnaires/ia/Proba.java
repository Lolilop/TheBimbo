package packages.decisionnaires.ia;

import java.io.IOException;
import packages.decisionnaires.Decisiveness;
import packages.etat.Etat;
import packages.map.Map;

import packages.decisionnaires.Player;
import static packages.etat.Etat.Ennemi;

/**
 * Constructed the IA with the proba
 * @author Theo gerfaux && Johan Turquin
 * version 3.0
 */

public class Proba extends Decisiveness{

    /*##########################################################################
    #                                ATTRIBUS                                  #
    ##########################################################################*/

    private Etat etatPrecedent;
    private final Player player;

    public final double UN_PAR_DEUX = 1.0/2.0;
    public final double UN_PAR_TROIS = 1.0 / 3.0;
    public final double UN_PAR_QUATRE = 1.0 / 4.0;

    /*##########################################################################
    #                            END ATTRIBUS                                  #
    ##########################################################################*/

    /*##########################################################################
    #                                BUILDER                                   #
    ##########################################################################*/

    /**
     * Builded the ia
     * @param map copy the map
     * @param player copy the player
     */
    
    public Proba(final Map map,final Player player) {
        super((short)2, (short)7, map, Etat.Ennemi);
        this.player = player;
        etatPrecedent = Etat.FreeBox;
    }
    
    /**
     * Builds the ia whih the save
     * @param player copy the player
     * @throws IOException 
     */

    public Proba(final Player player, String partie, Map map) throws IOException {
        super(partie,"ia.txt" ,map,Ennemi);
        this.player = player;
        etatPrecedent = Etat.FreeBox;
    }

    /*##########################################################################
    #                             END BUILDER                                  #
    ##########################################################################*/

    /*##########################################################################
    #                                 METHODE                                  #
    ##########################################################################*/
    
    /**
     * management of probabilistic movement
     * @param map copy the map 
     * @param direction 
     */

    @Override
    public boolean move(final Map map, final String direction) {

        double probaNorth, probaSouth, probaEast, probaWest;
        boolean continuer = true;
        
        probaNorth = probaSouth = probaEast = probaWest = UN_PAR_QUATRE;


        if(!carryOnNorth()) {
            probaSouth = probaEast = probaWest = UN_PAR_TROIS;
            probaNorth = (double)ZERO;
        }

        if(!carryOnSouth(map)) {

            if(carryOnNorth()) {
                probaNorth = probaEast = probaWest = UN_PAR_TROIS;
            }else {
                probaEast = probaWest = UN_PAR_DEUX;
                probaNorth = (double)ZERO;
            }
            probaSouth=0;
        }

        if(!carryOnEast(map)) {
            if(!carryOnNorth() && !carryOnSouth(map)) {
                probaWest = (double)UN;
                probaNorth = probaSouth = ZERO;
            }else if(!carryOnNorth()) {
                probaWest = probaSouth = UN_PAR_DEUX;
                probaNorth = ZERO;
            }else if(!carryOnSouth(map)) {
                probaWest = probaNorth = UN_PAR_DEUX;
                probaSouth = ZERO;
            }else{
                probaSouth = probaNorth = probaWest = UN_PAR_TROIS;
            }
            probaEast = ZERO;
        }

        if(!carryOnWest()) {

            if(!carryOnNorth() && !carryOnSouth(map) && !carryOnEast(map)) {
                probaSouth = probaNorth = probaEast = ZERO;
            }else if(!carryOnNorth() && !carryOnSouth(map)) {
                probaEast = UN;
                probaNorth = probaSouth = ZERO;
            }else if(!carryOnNorth() && !carryOnEast(map)) {
                probaSouth = UN;
                probaNorth = probaEast = ZERO;
            }else if(!carryOnSouth(map) && !carryOnEast(map)) {
                probaNorth = UN;
                probaEast = probaSouth = ZERO;
            }else if(!carryOnNorth()) {
                probaEast = probaSouth = UN_PAR_DEUX;
                probaNorth = ZERO;
            }else if(!carryOnSouth(map)){
                probaNorth = probaEast = UN_PAR_DEUX;
                probaSouth = ZERO;
            }else if(!carryOnEast(map)) {
                probaNorth = probaSouth = UN_PAR_DEUX;
                probaEast = ZERO;
            }else{
                probaEast = probaSouth = probaNorth = UN_PAR_TROIS;
            }
            probaWest = ZERO;
        }

        
        if(!carryOnNorth()&& !carryOnSouth(map) && !carryOnEast(map) && !carryOnWest()){
            probaWest = probaEast = probaNorth = probaSouth = ZERO;
            continuer = false;
        }


        double rdm = Math.random();

        if(rdm < probaWest) {
            directionWest(map);
        }else if(rdm < probaWest + probaEast){
            directionEast(map);
        }else if(rdm < probaWest + probaEast + probaNorth){
            directionNorth(map);
        }else{
            directionSouth(map);
        }
        return false;
    }

    /**
     * Move in the North
     * @param map copy of the map
     */
    
    @Override
    public void directionNorth(final Map map) {
        map.setState(getX(),getY(),etatPrecedent);
        addY((short)-UN);
        etatPrecedent = map.getPosition(getX(),getY());
        map.setState(getX(),getY(),Etat.Ennemi);
    }
    
     /**
     * Move in the South
     * @param map copy of the map
     */

    @Override
    public void directionSouth(final Map map) {
        if(carryOnSouth(map)){
            map.setState(getX(),getY(),etatPrecedent);
            addY((short)UN);
            etatPrecedent = map.getPosition(getX(),getY());
            map.setState(getX(),getY(),Etat.Ennemi);
        }
    }
    
    /**
     * Move in the East
     * @param map copy of the map
     */

    @Override
    public void directionEast(final Map map) {
        map.setState(getX(),getY(),etatPrecedent);
        addX((short)UN);
        etatPrecedent = map.getPosition(getX(),getY());
        map.setState(getX(),getY(),Etat.Ennemi);
    }
    
    /**
     * Move in the West
     * @param map copy of the map
     */

    @Override
    public void directionWest(final Map map) {
        map.setState(getX(),getY(),etatPrecedent);
        addX((short)-UN);
        etatPrecedent = map.getPosition(getX(),getY());
        map.setState(getX(),getY(),Etat.Ennemi);
    }

    /**
     * checked if the IA have won
     * @param y position y
     * @param x position x
     * @return true if the IA have win
     */
    
    public boolean win(short x,short y){

        boolean gagner = false;

        if((x += getX()) == player.getY() && (y += getY())== player.getX()){
            gagner = true;
        }

        return gagner;
    }

    /*##########################################################################
    #                             END METHODE                                  #
    ##########################################################################*/
 }
