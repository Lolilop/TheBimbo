package packages.outils.fichiers.file;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import packages.decisionnaires.Decisiveness;
import packages.etat.Goal;
import packages.map.Map;

public class Document {
    
    private ArrayList listeCommandes = new ArrayList();
    
    public Document() {
        super();
    }
    
    public void writeHtml(String name) {
        
        try{     
            PrintWriter pWriter = new PrintWriter(new FileWriter(name, false)); 
            for (Object commande : listeCommandes) {
                    pWriter.print(commande + "\n");
                }
            pWriter.close() ;
        }catch (IOException e) {
            System.out.println("Probleme de fichier : " + e.getMessage());
        }
         
    }
    
    public void writeJoueur1(Decisiveness j1) {

        listeCommandes.set(38,"<td>"+j1.getX()+"</td>");
        listeCommandes.set(39,"<td>"+j1.getY()+"</td>");
    }
    
    public void writeJoueur2(Decisiveness j2) {

        listeCommandes.set(44,"<td>"+j2.getX()+"</td>");
        listeCommandes.set(45,"<td>"+j2.getY()+"</td>");
    }
    
    public void writeGoal(Goal goal) {

        listeCommandes.set(50,"<td>"+goal.getX()+"</td>");
        listeCommandes.set(51,"<td>"+goal.getY()+"</td>");
    }
    
    public void writeMap(Map map) {

        int indice = 57;
        for(short i = 0; i < map.COLUMN; i++, indice++){
            listeCommandes.set(indice,"<tr>");
            indice++;
            for(short j = 0; j < map.LINE; j++, indice++){
                listeCommandes.set(indice,"<td>"+ map.getPosition(i, j) + "td>");         
            }
            listeCommandes.set(indice,"</tr>");
        }
    }
    
    
     public ArrayList lecture(final String nameFile) {
        

        
        String ligne;
 
         
       try {
            BufferedReader in = new BufferedReader(new FileReader(nameFile));
	    	while ((ligne = in.readLine()) != null) {
                    listeCommandes.add(ligne);
                    
                    
	    	}
	    	in.close();
		}catch (FileNotFoundException e) {
	    	System.out.println("Probleme de fichier avec " + nameFile);
		}catch (IOException e) {
	    	System.out.println("Probleme de lecture : " + e.getMessage());
		}
       
                
                
                
         return listeCommandes;
    }
     
     public void afficher() {
         int i = 0;
         for (Object commande : listeCommandes) {
                    System.out.println(commande + " " + i);
                    i++;
                }
     }
    
}
