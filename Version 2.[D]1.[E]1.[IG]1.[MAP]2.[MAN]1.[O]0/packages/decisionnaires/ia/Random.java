package packages.decisionnaires.ia;

import packages.decisionnaires.Decisionnaires;
import packages.etat.Etat;
import packages.map.Grille;

import java.lang.Math;

/**
 *
 * @author TTurq
 */
public class Random extends Decisionnaires{
    
    private Etat etatPrecedent;
    
    public Random(final Grille grille) {
        super((short)3, (short)4, grille, Etat.Ennemi);
        etatPrecedent=Etat.CaseLibre;
    }
    
    public boolean deplacer(final Grille grille, String direction){ // deplacement aleatoire de l'IA
        
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
        
        if(!continuerSud()){
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
        
        if(!continuerEst()){
            if(!continuerNord() && !continuerSud()){
                probaOuest=1;
                probaNord=0;
                probaSud=0;
            }else if(!continuerNord()){
                probaOuest=1.0/2.0;
                probaSud=1.0/2.0;
                probaNord=0;
            }else if(!continuerSud()){
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
            if(!continuerNord() && !continuerSud() && !continuerEst()){
                probaSud=0;
                probaNord=0;
                probaEst=0;
            }else if(!continuerNord() && !continuerSud()){
                probaEst=1;
                probaNord=0;
                probaSud=0;
            }else if(!continuerNord() && !continuerEst()){
                probaSud=1;
                probaNord=0;
                probaEst=0;
            }else if(!continuerSud() && !continuerEst()){
                probaNord=1;
                probaEst=0;
                probaSud=0;
            }else if(!continuerNord()){
                probaEst=1.0/2.0;
                probaSud=1.0/2.0;
                probaNord=0;
            }else if(!continuerSud()){
                probaNord=1.0/2.0;
                probaEst=1.0/2.0;
                probaSud=0;
            }else if(!continuerEst()){
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
        
        boolean ok=true;
        if(!continuerNord() && !continuerSud() && !continuerEst() && !continuerOuest()){
            probaOuest=0;
            probaEst=0;
            probaNord=0;
            probaSud=0;
            ok=false;
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
        
        return ok; 
    }
    
    @Override
    public void directionNord(final Grille grille) {
        grille.setPosition(getX(),getY(),etatPrecedent);
        setY((short)-1);
        etatPrecedent=grille.getPosition(getX(),getY());
        grille.setPosition(getX(),getY(),Etat.Ennemi);
    }
    
    @Override
    public void directionSud(final Grille grille) {
        if(continuerSud()){
            grille.setPosition(getX(),getY(),etatPrecedent);
            setY((short)1);
            etatPrecedent=grille.getPosition(getX(),getY());
            grille.setPosition(getX(),getY(),Etat.Ennemi);
        }
    }
    
    @Override
    public void directionEst(final Grille grille) {
        if(continuerEst()){
            grille.setPosition(getX(),getY(),etatPrecedent);
            setX((short)1);
            etatPrecedent=grille.getPosition(getX(),getY());
            grille.setPosition(getX(),getY(),Etat.Ennemi);
        }
    }
    
    @Override
    public void directionOuest(final Grille grille) {
        grille.setPosition(getX(),getY(),etatPrecedent);
        setX((short)-1);
        etatPrecedent=grille.getPosition(getX(),getY());
        grille.setPosition(getX(),getY(),Etat.Ennemi);
    }
    
    public boolean gagner(Grille grille, short x, short y){return false;}


}
