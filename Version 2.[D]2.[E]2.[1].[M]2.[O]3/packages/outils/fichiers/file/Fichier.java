package packages.outils.fichiers.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author TTurq
 */
public class Fichier {
    
    BufferedReader in;
    
    public Fichier() {
        in = null;
    }
    
    public byte lecture(final String nameFile) throws IOException {
        
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
    
        public void sauvegarder(final String nameFile) {
            
        try{
            
            PrintWriter pWriter = new PrintWriter(new FileWriter(nameFile, false));
             
            pWriter.print(1);
            
            pWriter.close() ;
      
        }catch (IOException e) {
            System.out.println("Probleme de fichier : " + e.getMessage());
        }
    }
        
        public void sauvegarder(final String nameFile, byte x) {
            
        try{
            
            PrintWriter pWriter = new PrintWriter(new FileWriter(nameFile, false));
             
            pWriter.print(x);
            
            pWriter.close() ;
      
        }catch (IOException e) {
            System.out.println("Probleme de fichier : " + e.getMessage());
        }
    }
    
}
