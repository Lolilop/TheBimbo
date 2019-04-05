package packages.decisionnaires;

import java.io.IOException;

import static packages.etat.Etat.Ennemi;
import static packages.etat.Etat.FreeBox;
import static packages.etat.Etat.Player;
import static packages.etat.Etat.Goal;
import packages.etat.Goal;
import packages.map.Map;

/**
 * Constructed the player
 * @author Theo gerfaux && Johan Turquin
 * version 3.0
 */

public abstract class Player extends Decisiveness {

    /*##########################################################################
    #                                ATTRIBUS                                  #
    ##########################################################################*/
    
    private final Goal goal;
    
    
    /*##########################################################################
    #                            END ATTRIBUS                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                BUILDER                                   #
    ##########################################################################*/ 

    /**
     * Build the Player
     * @param map Copy the map
     */

    public Player(final Map map) {
        super((short)6, (short)6, map, Player);
        goal = new Goal((short)UN, (short)UN);
        map.setState((short)goal.getX(), (short)goal.getY(), Goal);
    }
    
    /**
     * Build the Player
     * @throws IOException 
     */
    
    public Player() throws IOException {
        super();
        goal = new Goal();
    }
    
    /*##########################################################################
    #                             END BUILDER                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                 METHODE                                  #
    ##########################################################################*/
    
    /**
     * 
     * @param map copy of the map
     * @param direction
     * @return 
     */
    @Override
    public boolean move(Map map, String direction) {
        
        boolean continuer = false;
        
        if(direction.equals("Haut")){
            continuer = carryOnNorth();
            if(continuer){directionNorth(map);
            }else if(direction.equals("Bas")){  
            continuer = carryOnSouth(map);
            if(continuer) directionSouth(map);
            }else if(direction.equals("Gauche")){
            continuer = carryOnWest();
            if(continuer) directionWest(map);
            }else if(direction.equals("Droite")){
            continuer=carryOnEast(map);
            if(continuer) directionEast(map);
            }
        }
        return continuer;
    }
    
        
    /**
     * Move in the North
     * @param map copy of the map
     */

    @Override
    public void directionNorth(final Map map) {

        if(carryOnNorth()) {
            win((short)-UN,(short)ZERO);
            map.setState((short)(getY() - UN), (short)getX(), Player);
            map.setState((short)(getY()), (short)getX(), FreeBox);
            addY((short)-UN);
        }

    }

    /**
     * Move in the South
     * @param map copy of the map
     */

    @Override
    public void directionSouth(final Map map) {

        if(carryOnSouth(map)) {
            win((short)UN,(short)ZERO);
            map.setState((short)(getY() + UN), (short)getX(), Player);
            map.setState((short)(getY()), (short)getX(), FreeBox);
            addY((short)UN);
       }
    }

    /**
     * Move in the Weast
     * @param map copy of the map
     */

    @Override
    public void directionEast(final Map map) {

        if(carryOnEast(map)) {
            win((short)ZERO,(short)UN);
            map.setState((short)(getY()), (short)(getX() + UN), Player);
            map.setState((short)(getY()), (short)getX(), FreeBox);
            addY((short)UN);
        }
    }

    /**
     * Move in the West
     * @param map copy the map
     */

    @Override
    public void directionWest(final Map map) {

        if(carryOnWest()) {
            win((short)ZERO,(short)-UN);
            map.setState((short)(getY()), (short)(getX() - UN), Player);
            map.setState((short)(getY()), (short)getX(), FreeBox);
            addY((short)-UN);
        }

    }

    /**
     * checked if the playeur have won
     * @param y position y
     * @param x position x
     * @return true if the player have win
     */

    public boolean win(short y, short x) {

        boolean gagner = false;

        if((x += getX()) == goal.getX() && (y += getY()) == goal.getY()){
            gagner = true;
        }

        return gagner;
    }
    
    /**
     * checked if the playeur have won
     * @param map copy the map
     * @return true if the player have win
     */
    
    public boolean win(final Map map) {

        boolean gagner = false;


        if(getX() == goal.getX() && getY() == goal.getY()){
            gagner = true;
            System.err.println("Vous avez gagne");
        }

        return gagner;
    }
    
    public boolean joueurPerd(final Map grille){
        boolean perdu = false;
        
        if(getX()>1 && grille.getPosition((short)(getX()-1),(short)(getY()))==Ennemi){
            perdu=true;
        }
        
        if(getY()>1 && grille.getPosition((short)(getX()),(short)(getY()-1))==Ennemi){
            perdu=true;
        }
        
        if(getX()<grille.getCOLUMN()-1 && grille.getPosition((short)(getX()+1),(short)(getY()))==Ennemi){
            perdu=true;
        }
        
        if(getY()<grille.getCOLUMN()-1 && grille.getPosition((short)(getX()),(short)(getY()+1))==Ennemi){
            perdu=true;
        }
        
        return perdu;
    }
    
    /*##########################################################################
    #                             END METHODE                                  #
    ##########################################################################*/
}
