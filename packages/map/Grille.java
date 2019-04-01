package packages.map;

import packages.etat.Etat;


/**
 * Création de la grille de jeu
 * @author TTurq
 * @version 1.0
 */

public class Grille {


    private final Etat[][] grille;

    public final byte COLONNE = 18;
    public final byte LIGNE = 9;

    /**
     * Construction de la grille par defaut
     */

    public Grille() {

        this.grille = new Etat[LIGNE][COLONNE];
        for(byte i = 0; i < LIGNE; i++) {
            for(byte j = 0; j < COLONNE; j++){
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

    public void changementPosition(final short x,final short y,final Etat etat) {
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
     * donne le nombre de colonne
     * @return COLONNE
     */

    public short colonne() {
        return COLONNE;
    }

    /**
     * donne le nombre de ligne
     * @return LIGNE
     */

    public short ligne() {
        return LIGNE;
    }

    /**
     *
     * @return chaine (return la grille)
     */

    @Override
    public String toString() {

        String chaine = "";

        for(byte i = 0; i < LIGNE; i++) {
            for(byte j = 0; j < COLONNE; j++){
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
     * Affiche la grille avec leurs etats
     */

    public void afficher() {
        System.out.println(toString());
    }

}
