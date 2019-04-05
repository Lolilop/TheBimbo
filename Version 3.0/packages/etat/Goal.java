package packages.etat;

import java.io.IOException;
import static packages.etat.Etat.Goal;

/**
 * Creating Goal
 * @author Theo gerfaux && Johan Turquin
 * version 3.0
 */

public class Goal extends State {

    /*##########################################################################
    #                                BUILDER                                   #
    ##########################################################################*/
    
    /**
     * Build the Goal
     * @param x position x
     * @param y position y
     */

    public Goal(final short x, final short y) {

        super((short)x,(short)y,Goal);

    }
    
    /**
     * Build the Goal withe the save
     * @throws IOException 
     */
    
    public Goal() throws IOException {
        super(Goal);
    }

    /*##########################################################################
    #                             END BUILDER                                  #
    ##########################################################################*/
}
