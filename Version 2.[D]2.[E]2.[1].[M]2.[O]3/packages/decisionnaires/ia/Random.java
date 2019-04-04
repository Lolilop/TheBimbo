package packages.decisionnaires.ia;

import packages.decisionnaires.Decisionnaires;
import packages.etat.Etat;
import packages.map.Grille;

import packages.decisionnaires.Joueur;

/**
 *
 * @author TTurq
 */
public class Random extends Decisionnaires{
    
    private Etat etatPrecedent;
    private final Joueur joueur;
    
    public Random(final Grille grille, Joueur joueur) {
        super((short)2, (short)7, grille, Etat.Ennemi);
        this.joueur = joueur;
        etatPrecedent=Etat.CaseLibre;
    }
    
    public void deplacer(final Grille grille){ // deplacement aleatoire de l'IA
        
        //Je pars de proba égales pour le nord, le sud, l'est et l'ouest et je mets à 0 les probas des directions impossibles puis j'augmente
        // les autres probas pour que ça fasse 1
        
        double probaNord=1.0/4.0;
        double probaSud=1.0/4.0;
        double probaEst=1.0/4.0;
        double probaOuest=1.0/4.0;
        
        if(!continuerNord()){
            probaSud=1.0/3.0;
            probaEst=1.0/3.0;
            probaOuest=1.0/3.0;
            probaNord=0;
        }
        
        if(!continuerSud(grille)){
            if(continuerNord()){
                probaNord=1.0/3.0;
                probaEst=1.0/3.0;
                probaOuest=1.0/3.0;
            }else{
                probaEst=1.0/2.0;
                probaOuest=1.0/2.0;
                probaNord=0;
            }
            probaSud=0;
        }
        
        if(!continuerEst(grille)){
            if(!continuerNord() && !continuerSud(grille)){
                probaOuest=1;
                probaNord=0;
                probaSud=0;
            }else if(!continuerNord()){
                probaOuest=1.0/2.0;
                probaSud=1.0/2.0;
                probaNord=0;
            }else if(!continuerSud(grille)){
                probaOuest=1.0/2.0;
                probaNord=1.0/2.0;
                probaSud=0;
            }else{
                probaSud=1.0/3.0;
                probaNord=1.0/3.0;
                probaOuest=1.0/3.0;
            }
            probaEst=0;
        }
        
        if(!continuerOuest()){
            if(!continuerNord() && !continuerSud(grille) && !continuerEst(grille)){
                probaSud=0;
                probaNord=0;
                probaEst=0;
            }else if(!continuerNord() && !continuerSud(grille)){
                probaEst=1;
                probaNord=0;
                probaSud=0;
            }else if(!continuerNord() && !continuerEst(grille)){
                probaSud=1;
                probaNord=0;
                probaEst=0;
            }else if(!continuerSud(grille) && !continuerEst(grille)){
                probaNord=1;
                probaEst=0;
                probaSud=0;
            }else if(!continuerNord()){
                probaEst=1.0/2.0;
                probaSud=1.0/2.0;
                probaNord=0;
            }else if(!continuerSud(grille)){
                probaNord=1.0/2.0;
                probaEst=1.0/2.0;
                probaSud=0;
            }else if(!continuerEst(grille)){
                probaNord=1.0/2.0;
                probaSud=1.0/2.0;
                probaEst=0;
            }else{
                probaEst=1.0/3.0;
                probaSud=1.0/3.0;
                probaNord=1.0/3.0;
            }
            probaOuest=0;
        }
        
        if(!continuerNord() && !continuerSud(grille) && !continuerEst(grille) && !continuerOuest()){
            probaOuest=0;
            probaEst=0;
            probaNord=0;
            probaSud=0;
        }
        
        
        double rdm = Math.random();
        System.out.println(Double.toString(probaEst)+" "+Double.toString(probaOuest)+" "+Double.toString(probaNord)+" "+Double.toString(probaSud)+" "+Double.toString(rdm));
        
        if(rdm<probaOuest){
            directionOuest(grille);
        }else if(rdm<probaOuest+probaEst){
            directionEst(grille);
        }else if(rdm<probaOuest+probaEst+probaNord){
            directionNord(grille);
        }else{
            directionSud(grille);
        }
    }
    
    @Override
    public void directionNord(final Grille grille) {
        grille.changementPosition(getX(),getY(),etatPrecedent);
        setY((short)-1);
        etatPrecedent=grille.getPosition(getX(),getY());
        grille.changementPosition(getX(),getY(),Etat.Ennemi);
    }
    
    @Override
    public void directionSud(final Grille grille) {
        if(continuerSud(grille)){
            grille.changementPosition(getX(),getY(),etatPrecedent);
            setY((short)1);
            etatPrecedent=grille.getPosition(getX(),getY());
            grille.changementPosition(getX(),getY(),Etat.Ennemi);
        }
    }
    
    @Override
    public void directionEst(final Grille grille) {
        grille.changementPosition(getX(),getY(),etatPrecedent);
        setX((short)-1);
        etatPrecedent=grille.getPosition(getX(),getY());
        grille.changementPosition(getX(),getY(),Etat.Ennemi);
    }
    
    @Override
    public void directionOuest(final Grille grille) {
        grille.changementPosition(getX(),getY(),etatPrecedent);
        setX((short)1);
        etatPrecedent=grille.getPosition(getX(),getY());
        grille.changementPosition(getX(),getY(),Etat.Ennemi);
    }
    
    public boolean gagner(Grille grille, short x, short y){
        
        boolean gagner = false;
        x += getX();
        y += getY();

        if(x == joueur.getY() && y == joueur.getX()){
            gagner = true;
            System.err.println("Vous avez gagner");
        }
        
        return gagner;
    }
    
        public String toString() {
       String chaine = "";

       return (chaine = "Random : Position en X = " + getX() + " Position en Y = " + getY());
    }

    public void afficher() {
        System.err.println(toString());
    }


}

