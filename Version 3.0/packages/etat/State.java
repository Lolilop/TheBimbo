package packages.etat;


import java.io.IOException;

import packages.IDecisionMaker;
import packages.outils.fichiers.file.Files;

/**
 * Build state
 * @author Theo gerfaux && Johan Turquin
 * version 3.0
 */

public class State implements IDecisionMaker{

    /*##########################################################################
    #                                ATTRIBUS                                  #
    ##########################################################################*/
    
    private short posX;
    private short posY;
    private final Etat state;
    
    Files file = new Files();
    
    /*##########################################################################
    #                            END ATTRIBUS                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                BUILDER                                   #
    ##########################################################################*/

    /**
     * Build the State
     * @param posX position x
     * @param posY position y
     * @param state etat de la case
     */

    public State(final short posX, final short posY, Etat state) {

        this.posX = posX;
        this.posY = posY;
        this.state = state;
    }
    
    /**
     * Buile the state withe the save
     * @param etat
     * @throws IOException 
     */
    
    public State(Etat etat) throws IOException {
        file.read("src/packages/outils/fichiers/gestion_sauvegardes/objectif.txt",this);
        this.state = etat;
    }
    
    /*##########################################################################
    #                             END BUILDER                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                             ASCENSEURS                                   #
    ##########################################################################*/
    
     /**
     * get the position x
     * @return psoition x
     */

    @Override
    public short getX() {
        return posX;
    }

    /**
     * get the position y
     * @return  y
     */

    @Override
    public short getY() {
        return posY;
    }

    /**
     * set the position x
     * @param x position x 
     */
    
    @Override
    public void setX(short x) {
        this.posX = x;
    }

    /**
     * set the position y
     * @param y position y 
     */
    
    @Override
    public void setY(short y) {
        this.posY = y;
    }
    
    /*##########################################################################
    #                             END ASCENSEURS                               #
    ##########################################################################*/
}
