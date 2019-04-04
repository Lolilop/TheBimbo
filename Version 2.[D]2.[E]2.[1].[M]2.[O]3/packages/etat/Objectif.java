package packages.etat;

import java.io.IOException;
import static packages.etat.Etat.Objectif;

/**
 * Cree un Objectif
 * @author TTurq
 * @version 1.0
 */
public class Objectif extends Etats {

    /**
     * Construction de l'Objectif
     * @param x position x
     * @param y position y
     */

    public Objectif(final short x, final short y) {

        super((short)x,(short)y,Objectif);

    }
    
    public Objectif() throws IOException {
        super(Objectif);
    }





}
