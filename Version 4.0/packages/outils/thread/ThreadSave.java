/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packages.outils.thread;

import packages.decisionnaires.Decisiveness;
import packages.etat.Goal;


public class ThreadSave implements Runnable {

    private Decisiveness joueur1;
    private Decisiveness joueur2;
    private Goal obj;
    private String partie;
    
    public ThreadSave() {

    }
    
     public ThreadSave(Decisiveness j1, Decisiveness j2) {
        this.joueur1 = j1;
        this.joueur2 = j2;
    }
    
    public void run() {
            System.err.println("hello");
    }
    
}
