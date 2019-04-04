package packages.etat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Short.parseShort;

/**
 * Cree un Etat
 * @author TTurq
 * @version 1.0
 */

public class Etats {

    private short posX;
    private short posY;
    private final Etat etat;

    /**
     * Construction de l'etat
     * @param posX position x
     * @param posY position y
     * @param etat etat de la case
     */

    public Etats(final short posX, final short posY, Etat etat) {

        this.posX = posX;
        this.posY = posY;
        this.etat = etat;
    }
    
    public Etats(Etat etat) throws IOException {
        lecture("src/packages/outils/fichiers/gestion_sauvegardes/objectif.txt");
        this.etat = etat;
    }

    /**
     * retourne la postion x
     * @return x
     */

    public short getX() {
        return posX;
    }

    /**
     * retourne la position y
     * @return y
     */

    public short getY() {
        return posY;
    }
    
    public void sauvegarder(final String nameFile) {
            
        try{
            
            try (PrintWriter pWriter = new PrintWriter(new FileWriter(nameFile, false))) {
                pWriter.print(posX);
                pWriter.print(" ");
                pWriter.print(posY);
            }
      
        }catch (IOException e) {
            System.out.println("Probleme de fichier : " + e.getMessage());
        }
    }
    
    
    public void lecture(final String nameFile) throws IOException {
        
        String ligne;
        String mot[];

        try {
            try (BufferedReader in = new BufferedReader(new FileReader(nameFile))) {
                ligne = in.readLine();
                
                mot = ligne.split(" ");
                posX = parseShort(mot[0]);
                posY = parseShort(mot[1]);
            }
	}catch (FileNotFoundException e) {
	    System.out.println("Probleme de fichier avec " + nameFile);
	}catch (IOException e) {
	    System.out.println("Probleme de lecture : " + e.getMessage());
	}
    }
}
