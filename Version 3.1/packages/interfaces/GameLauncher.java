package packages.interfaces;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import packages.manager.Manager;
import packages.etat.Etat;
import packages.decisionnaires.Player;
import packages.decisionnaires.ia.Proba;
import packages.map.Map;

/**
 * Constructed the manager
 * @author Theo gerfaux && Johan Turquin
 * version 3.0
 */

public class GameLauncher extends javax.swing.JPanel {

    /*##########################################################################
    #                                ATTRIBUS                                  #
    ##########################################################################*/
    
    private Map g = new Map();
    private JMenuBar barre;
    private JMenu fichier;
    private JMenuItem quitter;
    private JMenuItem recommencer;
   
    private Manager manager;
    
    /*##########################################################################
    #                            END ATTRIBUS                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                BUILDER                                   #
    ##########################################################################*/
    
    /**
     * Creates new form GameLauncher
     * @throws java.io.IOException
     */
    
    public GameLauncher(String partie) throws IOException {
        initComponents();
        
        Player player = new Player(partie,g) {};
        manager=new Manager(g,player ,new Proba(player,partie,g));
        generationMap();
        JFrame f = new JFrame("TheBimbo");
        
        
        
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension resolution = t.getScreenSize();
        
        f.setSize(new Dimension((int)(resolution.getWidth()/2), (int)(resolution.getHeight()/2)));
        this.setPreferredSize(new Dimension((int)(f.getSize().getWidth()/2),(int)f.getSize().getHeight()/2));
        this.setMaximumSize(new Dimension((int)(f.getSize().getWidth()),(int)f.getSize().getHeight()));
        this.setMinimumSize(new Dimension((int)(f.getSize().getWidth()),(int)f.getSize().getHeight()));
        
        genererMenu(f);
        f.getContentPane().add(this);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
        public GameLauncher() throws IOException {
        initComponents();
        
        Player player = new Player(g) {};
        manager=new Manager(g,new Player(g) {},new Proba(g,player));
        generationMap();
        JFrame f = new JFrame("TheBimbo");
        
        
        
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension resolution = t.getScreenSize();
        
        f.setSize(new Dimension((int)(resolution.getWidth()/2), (int)(resolution.getHeight()/2)));
        this.setPreferredSize(new Dimension((int)(f.getSize().getWidth()/2),(int)f.getSize().getHeight()/2));
        this.setMaximumSize(new Dimension((int)(f.getSize().getWidth()),(int)f.getSize().getHeight()));
        this.setMinimumSize(new Dimension((int)(f.getSize().getWidth()),(int)f.getSize().getHeight()));
        
        genererMenu(f);
        f.getContentPane().add(this);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    /**
     * Creates new form GameLauncher
     * @param parent 
     */
    
    public GameLauncher(javax.swing.JPanel parent){
        initComponents();
        generationMap();
        parent.add(this);
    }

    /*##########################################################################
    #                             END BUILDER                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                 METHODE                                  #
    ##########################################################################*/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.GridLayout(2, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1314, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(2, 3));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);

        jButton4.setText("Haut");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5);

        jButton1.setText("Gauche");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Bas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton5.setText("Droite");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(manager.movePlayer1("Gauche")){
            manager.movePlayer2();
        }
        updateGrille();
        if(manager.getPlayer1().win(manager.getGrille())){
            victoire();
        }else if(manager.getPlayer1().joueurPerd(manager.getGrille())){
            defaite();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(manager.movePlayer1("Haut")){
            manager.movePlayer2();
        }
        updateGrille();
        if(manager.getPlayer1().win(manager.getGrille())){
             victoire();
         }else if(manager.getPlayer1().joueurPerd(manager.getGrille())){
             defaite();
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(manager.movePlayer1("Bas")){
            manager.movePlayer2();
        }
        updateGrille();
        if(manager.getPlayer1().win(manager.getGrille())){
            victoire();
        }else if(manager.getPlayer1().joueurPerd(manager.getGrille())){
            defaite();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(manager.movePlayer1("Droite")){
            manager.movePlayer2();
        }
        updateGrille();
        if(manager.getPlayer1().win(manager.getGrille())){
            victoire();
        }else if(manager.getPlayer1().joueurPerd(manager.getGrille())){
            defaite();
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
    

    /**
     * generate the menu
     * @param f Jframe
     */
    
    private void genererMenu(JFrame f){
        barre=new JMenuBar();
        fichier=new JMenu("Fichier");
        quitter=new JMenuItem("Quitter");
        recommencer=new JMenuItem("Recommencer");

        recommencer.addActionListener(new java.awt.event.ActionListener(){;
            public void actionPerformed(java.awt.event.ActionEvent e){
                newGame();
            }
        });
        
        quitter.addActionListener(new java.awt.event.ActionListener(){;
            public void actionPerformed(java.awt.event.ActionEvent e){
                System.exit(0);
            }
        });
        
        
        fichier.add(recommencer);
        fichier.add(quitter);
        barre.add(fichier);
        f.setJMenuBar(barre);
    }
    
    /**
     * Generate the map
     */
    private void generationMap(){
        jPanel1.setLayout(new java.awt.GridLayout(g.getCOLUMN(),getBaseline(g.getCOLUMN(), g.getLINE())));
        for(short y=0 ; y < g.getCOLUMN();y++){
            for(short x=0;x<g.getLINE();x++){
                if(null!=manager.getEtat(x,y))switch (manager.getEtat(x,y)) {
                    case FreeBox:{
                        javax.swing.JPanel p = new javax.swing.JPanel();
                        p.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
                        jPanel1.add(p);
                            break;
                        }
                    case Ennemi:{
                        javax.swing.JPanel p = new javax.swing.JPanel();
                        p.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
                        p.setBackground(new java.awt.Color(255,46,0));
                        p.add(new javax.swing.JLabel("E"));
                        jPanel1.add(p);
                            break;
                        }
                    case Goal:{
                        javax.swing.JPanel p = new javax.swing.JPanel();
                        p.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
                        p.add(new javax.swing.JLabel("O"));
                        p.setBackground(new java.awt.Color(27, 155, 10));
                        jPanel1.add(p);
                            break;
                        }
                    case Player:{
                        javax.swing.JPanel p = new javax.swing.JPanel();
                        p.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
                        p.setBackground(new java.awt.Color(11, 120, 160));
                        p.add(new javax.swing.JLabel("J"));
                        jPanel1.add(p);
                            break;
                        }
                    default:
                        break;
                }
            }
        }
    }
    
    /**
     * Update the map
     */
    
    private void updateGrille(){
        jPanel1.removeAll();
        generationMap();
        repaint();
        revalidate();
    }
    
    /**
     * pause
     */
    
    private void pause(){
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
    }
    
    /**
     * play
     */
    
    private void play(){
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
    }
    
    /**
     * win
     */
    
    private void victoire(){
        pause();
        jPanel2.removeAll();
        jPanel2.setLayout(new java.awt.GridBagLayout());
        jPanel2.add(new javax.swing.JLabel("Vous avez gagné la partie !"));
        repaint();
        revalidate();
    }
    
    /**
     * loose
     */
    
    private void defaite(){
        pause();
        jPanel2.removeAll();
        jPanel2.setLayout(new java.awt.GridBagLayout());
        jPanel2.add(new javax.swing.JLabel("Vous avez perdu la partie !"));
        repaint();
        revalidate();
    }
    
    /**
     * new partie
     */
    
    private void newGame(){
        manager.reset();
        updateGrille();
        newBouton();
        play();
    }
    
    /**
     * new bouton
     */
    
    private void newBouton(){
        jPanel2.removeAll();
           
        jPanel2.setLayout(new java.awt.GridLayout(2, 3));
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        jPanel2.add(jPanel4);
        
        jPanel2.add(jButton4);
        
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5);

        jPanel2.add(jButton1);

        jPanel2.add(jButton2);

        jPanel2.add(jButton5);
        
        repaint();
        revalidate();
    }
    
    /*##########################################################################
    #                             END METHODE                                  #
    ##########################################################################*/
    
}
