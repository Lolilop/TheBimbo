package packages.outils.fichiers.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Short.parseShort;
import packages.IDecisionMaker;
import packages.decisionnaires.Decisiveness;
import packages.etat.Goal;


/**
 * Creation File 
 * @author Theo gerfaux && Johan Turquin
 * version 3.0
 */

public class Files {
    
    /*##########################################################################
    #                                ATTRIBUS                                  #
    ##########################################################################*/
    
    BufferedReader in;
    
    /*##########################################################################
    #                            END ATTRIBUS                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                BUILDER                                   #
    ##########################################################################*/
     
    /**
     * Build the file
     */
    
    public Files() {
        in = null;
    }
    
    /*##########################################################################
    #                             END BUILDER                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                 METHODE                                  #
    ##########################################################################*/
    
    public String[] lecture(final String nameFile) {
        

         String[] chaine = new String[3];
         String ligne;
         byte x = 0;
         
       try {
            BufferedReader in = new BufferedReader(new FileReader(nameFile));
	    	while ((ligne = in.readLine()) != null) {
                    chaine[x] = ligne;
                    x++;
	    	}
	    	in.close();
		}catch (FileNotFoundException e) {
	    	System.out.println("Probleme de fichier avec " + nameFile);
		}catch (IOException e) {
	    	System.out.println("Probleme de lecture : " + e.getMessage());
		}
         
         return chaine;
    }
    
    /**
     * Read the File
     * @param nameFile¨Path
     * @return byte 0 or 1
     * @throws IOException 
     */
    public byte read(final String nameFile) throws IOException {
        
        String ligne;
        byte x = -1;

        try {
	    in = new BufferedReader(new FileReader(nameFile));
	    ligne = in.readLine();
            x = Byte.parseByte(ligne);
	    in.close();
	}catch (FileNotFoundException e) {
	    System.out.println("Probleme de fichier avec " + nameFile);
	}catch (IOException e) {
	    System.out.println("Probleme de lecture : " + e.getMessage());
	}
        return x;
    }
    
    /**
     * Read the File
     * @param nameFile path
     * @param obj object
     * @throws IOException 
     */
    
    public void read(final String nameFile, final IDecisionMaker obj) throws IOException {
        
        String ligne;
        String mot[];

        try {
	    BufferedReader in = new BufferedReader(new FileReader(nameFile));           
	    ligne = in.readLine();
            mot = ligne.split(" ");
            
            //System.err.println(mot[1]);
            obj.setY(parseShort(mot[1]));
            obj.setX(parseShort(mot[0]));
            
	    in.close();
	}catch (FileNotFoundException e) {
	    System.out.println("Probleme de fichier avec " + nameFile);
	}catch (IOException e) {
	    System.out.println("Probleme de lecture : " + e.getMessage());
	}
    }
    
    /**
     * Save the data  
     * @param nameFile path
     * @param x data
     */
    
    public void save(final String nameFile, byte x) {
            
        try{     
            PrintWriter pWriter = new PrintWriter(new FileWriter(nameFile, false)); 
            pWriter.print(x);
            pWriter.close() ;
        }catch (IOException e) {
            System.out.println("Probleme de fichier : " + e.getMessage());
        }
    }
    
    /**
     * Save the position
     * @param nameFile path
     * @param obj object
     */
        
     public void save(final String nameFile, IDecisionMaker obj) {
            
        try{
            PrintWriter pWriter = new PrintWriter(new FileWriter(nameFile, false));
            pWriter.print(obj.getX());
            pWriter.print(" ");
            pWriter.print(obj.getY());
            pWriter.close() ;
        }catch (IOException e) {
            System.out.println("Probleme de fichier : " + e.getMessage());
        }
    }
     
     public void save(final String nameFile, String[] obj) {
            
       
        try{
            PrintWriter pWriter = new PrintWriter(new FileWriter(nameFile, false));
            
            for(int i = 0 ; i < obj.length; i++) {
                pWriter.print(obj[i]);
                pWriter.print("\n");
            }

            pWriter.close() ;
        }catch (IOException e) {
            System.out.println("Probleme de fichier : " + e.getMessage());
        }
    }
     
     
    /*##########################################################################
    #                             END METHODE                                  #
    ##########################################################################*/

    
}
