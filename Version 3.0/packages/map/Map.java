package packages.map;

import packages.etat.Etat;



/**
 * Création de la grille de jeu
 * @author TTurq
 * @version 1.0
 */

public class Map {

    /*##########################################################################
    #                                ATTRIBUS                                  #
    ##########################################################################*/
    
    private final Etat[][] Map;

    public final byte COLUMN = 18;
    public final byte LINE = 9;

    /*##########################################################################
    #                            END ATTRIBUS                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                BUILDER                                   #
    ##########################################################################*/ 
    
    /**
     * Build the map
    */

    public Map() {
        this.Map = new Etat[LINE][COLUMN];
        BuildMap(LINE, COLUMN);
    }

    /*##########################################################################
    #                             END BUILDER                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                             ASCENSEURS                                   #
    ##########################################################################*/
    
    /**
     * change the state of the box
     * @param x position x
     * @param y position y
     * @param etat state of the box
     */

    public void setState(final short x,final short y,final Etat etat) {
        Map[x][y] = etat;
    }

    /**
     * get the state of the box
     * @param x position x
     * @param y position y
     * @return l'etat de la case
     */

    public Etat getPosition(final short x,final short y) {
        return Map[x][y];
    }

    /**
     * get the column
     * @return COLONNE
     */

    public short getCOLUMN() {
        return COLUMN;
    }

    /**
     * get the line
     * @return LINE
     */

    public short getLINE() {
        return LINE;
    }
    
    /*##########################################################################
    #                             END ASCENSEURS                               #
    ##########################################################################*/
    
    /*##########################################################################
    #                                 METHODE                                  #
    ##########################################################################*/
    
    /**
     * Build the map
     * @param x position x
     * @param y position y
     */
    
    private void BuildMap(short x, short y) {
       
        for(byte i = 0; i < x; i++) {
            for(byte j = 0; j < y; j++){
                this.Map[i][j] = Etat.FreeBox;
            }
        }
    }

    /**
     * Convert the map
     * @return chaine (return la grille)
     */

    @Override
    public String toString() {

        String chaine = "";

        for(byte i = 0; i < LINE; i++) {
            for(byte j = 0; j < COLUMN; j++){
                if(null != this.Map[i][j]) switch (this.Map[i][j]) {
                    case FreeBox:
                        chaine += "*";
                        break;
                    case Ennemi:
                        chaine += "E";
                        break;
                    case Player:
                        chaine += "J";
                        break;
                    case Goal:
                        chaine += "O";
                        break;
                    default:
                        break;
                }

            }
             chaine += "\n";
        }

        return chaine;
    }

    /**
     * print the map
     */

    public void print() {
        System.out.println(toString());
    }
    
    /*##########################################################################
    #                             END METHODE                                  #
    ##########################################################################*/

}
