package packages.decisionnaires;

import static packages.etat.Etat.CaseLibre;
import static packages.etat.Etat.Joueur;
import static packages.etat.Etat.Objectif;
import static packages.etat.Etat.Ennemi;
import packages.etat.Objectif;
import packages.map.Grille;

/**
 * Crée un joeur
 * @author TTurq
 * @version 1.0
 */
public class Joueur extends Decisionnaires {

    private final String name;
    private final Objectif objectif;

    /**
     * Construction d'un joueur
     * @param grille
     */

    public Joueur(final Grille grille) {
        super((short)6, (short)6, grille, Joueur);
        this.name = "Joueur_Test";
        objectif = new Objectif((short)1, (short)1);
        grille.setPosition((short)objectif.getX(), (short)objectif.getY(), Objectif);
    }
    
    public boolean deplacer(Grille grille, String direction){
        boolean ok = false;
        if(direction.equals("Haut")){
            ok=continuerNord();
            if(ok) directionNord(grille);
        }else if(direction.equals("Bas")){
            ok=continuerSud();
            if(ok) directionSud(grille);
        }else if(direction.equals("Gauche")){
            ok=continuerOuest();
            if(ok) directionOuest(grille);
        }else if(direction.equals("Droite")){
            ok=continuerEst();
            if(ok) directionEst(grille);
        }
        return ok;
    }

    /**
     * Permet de se dirigier au Nord
     * @param grille
     */
    @Override
    public void directionNord(final Grille grille) {

        if(continuerNord()) {
          
            grille.setPosition((short)(getX()), (short)(getY()-1), Joueur);
            grille.setPosition((short)(getX()), (short)getY(), CaseLibre);
            setY((short)-1);
        }

    }

    /**
     * Permet de se dirigier au Sud
     * @param grille
     */

    @Override
    public void directionSud(final Grille grille) {


            grille.setPosition((short)getX(), (short)(getY()+1), Joueur);
            grille.setPosition((short)getX(), (short)getY(), CaseLibre);
            setY((short)1);
       
    }

    /**
     * Permet de se dirigier a l'Est
     * @param grille
     */

    @Override
    public void directionEst(final Grille grille) {

        if(continuerEst()) {

            grille.setPosition((short)(getX()+1), (short)(getY()), Joueur);
            grille.setPosition((short)(getX()), (short)getY(), CaseLibre);
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

            grille.setPosition((short)(getX()-1), (short)(getY()), Joueur);
            grille.setPosition((short)(getX()), (short)getY(), CaseLibre);
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

    public boolean joueurGagne(final Grille grille) {

        boolean gagner = false;


        if(getX() == objectif.getX() && getY() == objectif.getY()){
            gagner = true;
            System.err.println("Vous avez gagne");
        }

        return gagner;
    }
    
    public boolean joueurPerd(final Grille grille){
        boolean perdu = false;
        
        if(getX()>1 && grille.getPosition((short)(getX()-1),(short)(getY()))==Ennemi){
            perdu=true;
        }
        
        if(getY()>1 && grille.getPosition((short)(getX()),(short)(getY()-1))==Ennemi){
            perdu=true;
        }
        
        if(getX()<grille.getTailleX()-1 && grille.getPosition((short)(getX()+1),(short)(getY()))==Ennemi){
            perdu=true;
        }
        
        if(getY()<grille.getTailleY()-1 && grille.getPosition((short)(getX()),(short)(getY()+1))==Ennemi){
            perdu=true;
        }
        
        return perdu;
    }

    @Override
    public String toString() {
       String chaine = "";

       return (chaine = "Position en X = " + getX() + " Position en Y = " + getY());
    }

    public void afficher() {
        System.err.println(toString());
    }

}
