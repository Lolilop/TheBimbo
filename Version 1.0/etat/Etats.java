package etat;

/**
 * Cree un Etat
 * @author TTurq
 * @version 1.0
 */

public class Etats {

    private final short posX;
    private final short posY;
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
}
