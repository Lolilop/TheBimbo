package packages.map;

import packages.etat.Etat;

/**
 * Création de la grille de jeu
 * @author TTurq
 * @version 1.0
 */

public class Grille {


    private final Etat[][] grille;

    public static final byte TAILLE_X = 18;
    public static final byte TAILLE_Y = 9;

    /**
     * Construction de la grille par defaut
     */

    public Grille() {

        this.grille = new Etat[TAILLE_X][TAILLE_Y];
        for(byte i = 0; i < TAILLE_X; i++) {
            for(byte j = 0; j < TAILLE_Y; j++){
                this.grille[i][j] = Etat.CaseLibre;
            }
        }
    }

    /**
     * Change l'etat de la case
     * @param x position x
     * @param y position y
     * @param etat etat de la case
     */

    public void setPosition(final short x,final short y,final Etat etat) {
        grille[x][y] = etat;
    }

    /**
     * recupere l'etat de la case
     * @param x position x
     * @param y position y
     * @return l'etat de la case
     */

    public Etat getPosition(final short x,final short y) {
        return grille[x][y];
    }

    /**
     * @return la taille de la grille sur X
     */

    public static short getTailleX() {
        return TAILLE_X;
    }

     /**
     * @return la taille de la grille sur Y
     */

    public static short getTailleY() {
        return TAILLE_Y;
    }

    /**
     * Permet d'obtenir un affichage de la grille
     * @return une chaîne de caractères
     */

    @Override
    public String toString() {

        String chaine = "";

        for(byte i = 0; i < TAILLE_X; i++) {
            for(byte j = 0; j < TAILLE_Y; j++){
                if(null != this.grille[i][j]) switch (this.grille[i][j]) {
                    case CaseLibre:
                        chaine += "*";
                        break;
                    case Ennemi:
                        chaine += "E";
                        break;
                    case Joueur:
                        chaine += "J";
                        break;
                    case Objectif:
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
     * Affiche la grille
     */

    public void afficher() {
        System.out.println(toString());
    }

}
