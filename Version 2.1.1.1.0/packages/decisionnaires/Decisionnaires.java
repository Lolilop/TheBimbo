package packages.decisionnaires;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import packages.etat.Etat;
import packages.map.Grille;

/**
 * Création des différents decisionnaires (joueur et IA)
 * @author TTurq
 * version 1.0
 */
public abstract class Decisionnaires {

    private short posX;
    private short posY;
    private String name;

    /**
     * Construction d'un decisionnaires
     * @param x position x
     * @param y position y
     * @param grille grille
     * @param etat etat
     */

    public Decisionnaires(final short x, final short y, final Grille grille, final Etat etat) {

        this.posX = x;
        this.posY = y;
        grille.changementPosition(posX, posY, etat);
    }

    /**
     * retourne la position x
     * @return position x
     */

    public short getX(){
        return this.posX;
    }

    /**
     * return la position y
     * @return position y
     */

    public short getY(){
        return this.posY;
    }

    /**
     * change la position x
     * @param x position x
     */

    public void setX(short x){
        this.posX += x;
    }

    /**
     * change la position y
     * @param y position y
     */

    public void setY(short y){
        this.posY += y;
    }

    /**
     * permet au joueur de se deplacer au Nord
     * @param grille
     */

    public abstract void directionNord(final Grille grille);

    /**
     * permet au joueur de se deplacer au Sud
     * @param grille
     */

    public abstract void directionSud(final Grille grille);

    /**
     * permet au joueur de se deplacer à l'Est
     * @param grille
     */

    public abstract void directionEst(final Grille grille);

    /**
     * permet au joueur de se deplacer à l'Ouest
     * @param grille
     */

    public abstract void directionOuest(final Grille grille);

    /**
     * verifie la possibilite d'aller au Nord
     * @return vrai si c'est bon
     */

    public boolean continuerNord() {
        return((getY() - 1) > -1);
    }

    /**
     * verifie la possibilite d'aller au Sud
     * @param grille
     * @return vrai si c'est bon
     */

    public boolean continuerSud(final Grille grille) {
        return((getY() + 1) < grille.ligne());
    }

    /**
     * verifie la possibilite d'aller a l'Est
     * @param grille
     * @return vrai si c'est bon
     */

    public boolean continuerEst(final Grille grille) {
        return((getX() + 1 < grille.colonne()));
    }

    /**
     * verifie la possibilite d'aller a l'Ouest
     * @return vrai si c'est bon
     */

    public boolean continuerOuest() {
        return((getX() - 1) > -1);
    }

    /**
     * Verifie si le joueur ou l'ia a gagner
     * @param grille
     * @param y
     * @param x
     * @return vrai si l'un des deux a gagner
     */

    public abstract boolean gagner(final Grille grille, short y, short x);
    
    public void sauvegarder(final String nameFile) {
            
        try{
            
            PrintWriter pWriter = new PrintWriter(new FileWriter(nameFile, false));
             
            pWriter.print(posX);
            pWriter.print("\n");
            pWriter.print(posY);
            
            pWriter.close() ;
      
        }catch (IOException e) {
            System.out.println("Probleme de fichier : " + e.getMessage());
        }
    }
}
