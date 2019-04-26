package bimbo;


import java.io.IOException;
import static java.lang.Thread.sleep;
import packages.decisionnaires.Player;
import packages.decisionnaires.ia.Proba;
import packages.etat.Goal;




import packages.interfaces.Interface;
import packages.map.Map;
import packages.outils.chrono.Chrono;
import packages.outils.fichiers.file.Document;


/**
 *
 * @author TTurq
 */

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {
     
        Document doc = new Document();
        doc.lecture("src/packages/outils/fichiers/file/TheBimbo.html");
        Goal goal = new Goal((short)10,(short)5);
        Map map = new Map();
        Player j1 = new Player(map);
        Proba j2 = new Proba(map,j1);
        
        doc.writeGoal(goal);
        doc.writeJoueur1(j1);
        doc.writeJoueur2(j2);
        doc.afficher();
        doc.writeHtml("src/packages/outils/fichiers/file/TheBimbo.html");
        Interface ihm = new Interface();
        ihm.setVisible(true);

    }
    
   
    
}
