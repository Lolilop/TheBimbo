package packages.decisionnaires;

import java.io.IOException;

import packages.etat.Etat;
import packages.map.Map;
import packages.outils.fichiers.file.Files;
import packages.IDecisionMaker;


/**
 * Constructed of different decision makers (player and AI)
 * @author Theo gerfaux && Johan Turquin
 * version 3.0
 */

public abstract class Decisiveness implements IDecisionMaker{

    /*##########################################################################
    #                                ATTRIBUS                                  #
    ##########################################################################*/
    
    private short posX;
    private short posY;
    
    public final byte ZERO = 0;
    public final byte UN = 1;
    
    private final Files file = new Files();
    
    /*##########################################################################
    #                            END ATTRIBUS                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                BUILDER                                   #
    ##########################################################################*/

    /**
     * Build decision makers
     * @param x position x
     * @param y position y
     * @param map Copy of the Map 
     * @param state state
     */

    public Decisiveness(final short x, final short y, final Map map, final Etat state) {
        this.posX = x;
        this.posY = y;
        map.setState(posX, posY, state);
    }
    
    /**
     * Build decisions makers
     * @param partie
     * @throws IOException 
     */
    
    public Decisiveness(String partie, String file , Map map, Etat state) throws IOException {
        this.file.read("src/packages/outils/fichiers/gestion_sauvegardes/" + partie + "/" + file,this);
        System.err.println(posY);
        map.setState(posX,posY,state);
    }
    
    /*##########################################################################
    #                             END BUILDER                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                             ASCENSEURS                                   #
    ##########################################################################*/

    /**
     * @return position x
     */

    @Override
    public short getX(){
        return this.posX;
    }

    /**
     * @return position y
     */

    @Override
    public short getY(){
        return this.posY;
    }
    
    /**
     * Change the position x
     * @param x position x
     */
    
    @Override
    public void setX(final short x) {
        posX = x;
    }
    
    /**
     * Change the position y
     * @param y position y
     */
    @Override
    public void setY(final short y) {
        posY = y;
    }
    
    /*##########################################################################
    #                             END ASCENSEURS                               #
    ##########################################################################*/
    
    /*##########################################################################
    #                                 METHODE                                  #
    ##########################################################################*/

    /**
     * add the position x
     * @param x position x
     */

    public void addX(final short x){
        this.posX += x;
    }

    /**
     * add the position y
     * @param y position y
     */

    public void addY(final short y){
        this.posY += y;
    }
    
    /**
     * verify the possibility of going to the North
     * @return if the possibility is ok
     */

    public boolean carryOnNorth() {
        return((getY() - 1) > -1);
    }

    /**
     * verify the possibility of going to the South
     * @param map Copy of the Map
     * @return if the possibility is ok
     */

    public boolean carryOnSouth(final Map map) {
        return((getY() + 1) < map.getLINE());
    }
    
    /**
     * verify the possibility of going to the East
     * @param map Copy of the Map
     * @return if the possibility is ok
     */

    public boolean carryOnEast(final Map map) {
        return((getX() + 1 < map.getCOLUMN()));
    }

    /**
     * verify the possibility of going to the West
     * @return if the possibility is ok
     */
    
    public boolean carryOnWest() {
        return((getX() - 1) > -1);
    }
       
    /*##########################################################################
    #                             END METHODE                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                             METHODE ABSTRACT                             #
    ##########################################################################*/

    /**
     * Direction Nord
     * @param map
     */

    public abstract void directionNorth(final Map map);

    /**
     * Direction South
     * @param grille
     */

    public abstract void directionSouth(final Map grille);

    /**
     * Direction East
     * @param grille
     */

    public abstract void directionEast(final Map grille);

    /**
     * Direction West
     * @param grille
     */

    public abstract void directionWest(final Map grille);

    /**
     * check if the Decisiveness they won
     * @param grille map
     * @param y position y
     * @param x position x
     * @return vrai si l'un des deux a gagner
     */

    public abstract boolean win(short x,short y);
    
    public abstract boolean move(final Map map, String direction);
    
    /*##########################################################################
    #                         END METHODE ABSTRACT                             #
    ##########################################################################*/    
}
