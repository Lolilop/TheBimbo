package packages.outils.fichiers.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Short.parseShort;
import packages.IDecisionMaker;


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
            obj.setX(parseShort(mot[0]));
            obj.setY(parseShort(mot[1]));
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
            pWriter.print(obj.getX());
            pWriter.close() ;
        }catch (IOException e) {
            System.out.println("Probleme de fichier : " + e.getMessage());
        }
    }
     
    /*##########################################################################
    #                             END METHODE                                  #
    ##########################################################################*/

    public short save(String srcpackagesoutilsfichiersgestion_languesi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
