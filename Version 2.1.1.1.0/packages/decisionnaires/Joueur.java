package packages.decisionnaires;

import static packages.etat.Etat.CaseLibre;
import static packages.etat.Etat.Joueur;
import static packages.etat.Etat.Objectif;
import packages.etat.Objectif;
import packages.map.Grille;

/**
 * Crée un joeur
 * @author TTurq
 * @version 1.0
 */
public class Joueur extends Decisionnaires {

    
    private final Objectif objectif;

    /**
     * Construction d'un joueur
     * @param grille
     */

    public Joueur(final Grille grille) {
        super((short)6, (short)6, grille, Joueur);
        objectif = new Objectif((short)1, (short)1);
        grille.changementPosition((short)objectif.getX(), (short)objectif.getY(), Objectif);
    }

    /**
     * Permet de se dirigier au Nord
     * @param grille
     */

    @Override
    public void directionNord(final Grille grille) {

        if(continuerNord()) {
            gagner(grille,(short)-1,(short)0);
            grille.changementPosition((short)(getY() - 1), (short)getX(), Joueur);
            grille.changementPosition((short)(getY()), (short)getX(), CaseLibre);
            setY((short)-1);
        }

    }

    /**
     * Permet de se dirigier au Sud
     * @param grille
     */

    @Override
    public void directionSud(final Grille grille) {

        if(continuerSud(grille)) {
            gagner(grille,(short)1,(short)0);
            grille.changementPosition((short)(getY() + 1), (short)getX(), Joueur);
            grille.changementPosition((short)(getY()), (short)getX(), CaseLibre);
            setY((short)1);
       }
    }

    /**
     * Permet de se dirigier a l'Est
     * @param grille
     */

    @Override
    public void directionEst(final Grille grille) {

        if(continuerEst(grille)) {
            gagner(grille,(short)0,(short)1);
            grille.changementPosition((short)(getY()), (short)(getX() + 1), Joueur);
            grille.changementPosition((short)(getY()), (short)getX(), CaseLibre);
            setX((short)1);
        }
    }

    /**
     * Permet de se dirigier a l'Ouest
     * @param grille
     */

    @Override
    public void directionOuest(final Grille grille) {

        if(continuerOuest()) {

            gagner(grille,(short)0,(short)-1);
            grille.changementPosition((short)(getY()), (short)(getX() - 1), Joueur);
            grille.changementPosition((short)(getY()), (short)getX(), CaseLibre);
            setX((short)-1);
        }

    }

    /**
     * Verifie si le joueur a gagner
     * @param grille
     * @param y position y
     * @param x position x
     * @return true si le joueur a gagner
     */

    public boolean gagner(final Grille grille, short y, short x) {

        boolean gagner = false;

        x += getX();
        y += getY();

        if(x == objectif.getX() && y == objectif.getY()){
            gagner = true;
            System.err.println("Vous avez gagner");
        }

        return gagner;
    }

    @Override
    public String toString() {
       String chaine = "";

       return (chaine = "Joueur : Position en X = " + getX() + " Position en Y = " + getY());
    }

    public void afficher() {
        System.err.println(toString());
    }
    
    

}
