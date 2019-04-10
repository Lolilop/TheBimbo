package packages.interfaces;

import java.awt.AWTException;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import packages.manager.Manager;
import packages.decisionnaires.Player;
import packages.decisionnaires.ia.Proba;
import packages.map.Map;
import packages.outils.chrono.Chrono;
import packages.outils.fichiers.file.Files;

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
    private JMenuItem pause;
    private JMenuItem play;
   
    private Manager manager;
    
    private String game;
    private Files files = new Files();
    private Player player;
    private Proba prob;
    
    Chrono chrono = new Chrono();
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
    
    public GameLauncher(String partie) throws IOException { //chargement de partie + nouvelle fenêtre
        
        initComponents();
        
        player = new Player(partie,g);
        prob = new Proba(player,partie,g);
        manager=new Manager(g,player ,prob);
        generationMap();
        JFrame f = new JFrame("TheBimbo");
        this.game = partie;
        
        
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
    
    public GameLauncher() throws IOException { //nouvelle fenêtre
        
        initComponents();
      
        player = new Player(g) {};
        prob = new Proba(g,player);
        manager=new Manager(g,player,prob);
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
     * @throws IOException
     * @param parent 
     */
    
    public GameLauncher(javax.swing.JPanel parent, String partie) throws IOException, InterruptedException{ //inclusion dans un JPanel + chargement de partie
        initComponents();
        chrono.start();
        player = new Player(partie,g);
        prob = new Proba(player,partie,g);
        manager=new Manager(g,player ,prob);
        
        generationMap();
        this.game = partie;
        
        parent.add(this);
        System.err.println("hello");
        chronoToString();
        
       
    }
    
    /**
     * Creates new form GameLauncher
     * @param parent 
     */
    
    public GameLauncher(javax.swing.JPanel parent){ //inclusion dans un JPanel
        initComponents();
        chrono.start();
        Player player=new Player(g);
        manager=new Manager(g,player,new Proba(g,player));
        generationMap();
        parent.add(this);
        
        System.err.println("Temps : " + chrono.getDureeMs());
        
        
        
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

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

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

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packages/images/fleche-haut.jpg.png"))); // NOI18N
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packages/images/left-pointing-arrow.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packages/images/fleche-bas.jpg.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packages/images/right-arrow.png"))); // NOI18N
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
    chrono.resume();
        gauche();
        chronoToString();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    chrono.resume();
        haut();
        chronoToString();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        chrono.resume();
        bas();
        chronoToString();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        chrono.resume();
        System.err.println(chrono.getDureeMs());
        droite();
       chronoToString();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        System.err.println(evt.getKeyChar());
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_KP_UP:
                haut();
                break;
            case KeyEvent.VK_ENTER:
                bas();
                break;
            case KeyEvent.VK_KP_RIGHT:
                droite();
                break;
            case KeyEvent.VK_KP_LEFT:
                gauche();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jPanel1KeyPressed


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
    
    public void genererMenu(JFrame f){
        barre=new JMenuBar();
        fichier=new JMenu("Fichier");
        quitter=new JMenuItem("Quitter");
        recommencer=new JMenuItem("Recommencer");
        pause=new JMenuItem("Pause");
        play=new JMenuItem("Play");
        
        

        recommencer.addActionListener(new java.awt.event.ActionListener(){;
            public void actionPerformed(java.awt.event.ActionEvent e){
                newGame();
            }
        });
        
        quitter.addActionListener(new java.awt.event.ActionListener(){;
            public void actionPerformed(java.awt.event.ActionEvent e){
                 saveQuit();
                System.exit(0);
            }
        });
        
        pause.addActionListener(new java.awt.event.ActionListener(){;
            public void actionPerformed(java.awt.event.ActionEvent e){
                pause();
            }
        });
        
        play.addActionListener(new java.awt.event.ActionListener(){;
            public void actionPerformed(java.awt.event.ActionEvent e){
                play();
            }
        });
        
        fichier.add(pause);
        fichier.add(play);      
        
        fichier.add(recommencer);
        fichier.add(quitter);
        barre.add(fichier);
        f.setJMenuBar(barre);
    }
    
    /**
     * Generate the map
     */
    private void generationMap(){
        jPanel1.setLayout(new java.awt.GridLayout(g.getLINE(),getBaseline(g.getLINE(), g.getCOLUMN())));
        for(short y=0 ; y < g.getLINE();y++){
            for(short x=0;x<g.getCOLUMN();x++){
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
    
    private void saveQuit() {
        
        JOptionPane jop = new JOptionPane();			
        int option = jop.showConfirmDialog(null, "Voulez-vous sauvegarder?", "Lancement de la sauvegarde", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
        if(option == JOptionPane.OK_OPTION){
            
           files.save("src/packages/outils/fichiers/gestion_sauvegardes/" + game + "/joueur.txt", player);
           files.save("src/packages/outils/fichiers/gestion_sauvegardes/" + game + "/ia.txt", prob);
        }
    }
    
    public void haut(){
                        
        if(manager.movePlayer1("Haut")){
            manager.movePlayer2();
        }
        updateGrille();
        if(manager.getPlayer1().win(manager.getGrille())){
             victoire();
         }else if(manager.getPlayer1().joueurPerd(manager.getGrille())){
             defaite();
         }
        System.out.println(manager.getPlayer1().getX());
        System.out.println(manager.getPlayer1().getY());
        System.out.println("---------------");
        System.out.println(manager.getPlayer2().getX());
        System.out.println(manager.getPlayer2().getY());
       
    }
    
    public void bas(){
                        
       if(manager.movePlayer1("Bas")){
            manager.movePlayer2();
        }
        updateGrille();
        if(manager.getPlayer1().win(manager.getGrille())){
            victoire();
        }else if(manager.getPlayer1().joueurPerd(manager.getGrille())){
            defaite();
        }
        System.out.println(manager.getPlayer1().getX());
        System.out.println(manager.getPlayer1().getY());
        System.out.println("---------------");
        System.out.println(manager.getPlayer2().getX());
        System.out.println(manager.getPlayer2().getY());
       
    }
    
    public void droite(){
                        
        if(manager.movePlayer1("Droite")){
            manager.movePlayer2();
        }
        updateGrille();
        if(manager.getPlayer1().win(manager.getGrille())){
            victoire();
        }else if(manager.getPlayer1().joueurPerd(manager.getGrille())){
            defaite();
        }
        System.out.println(manager.getPlayer1().getX());
        System.out.println(manager.getPlayer1().getY());
        System.out.println("---------------");
        System.out.println(manager.getPlayer2().getX());
        System.out.println(manager.getPlayer2().getY());
        
    }
    
    public void gauche(){
                        
        if(manager.movePlayer1("Gauche")){
            manager.movePlayer2();
        }
        updateGrille();
        if(manager.getPlayer1().win(manager.getGrille())){
            victoire();
        }else if(manager.getPlayer1().joueurPerd(manager.getGrille())){
            defaite();
        }
        System.out.println(manager.getPlayer1().getX());
        System.out.println(manager.getPlayer1().getY());
        System.out.println("---------------");
        System.out.println(manager.getPlayer2().getX());
        System.out.println(manager.getPlayer2().getY());
       
    }
    
    public void chronoToString() {
        
        chrono.pause();

        if(chrono.getDureeSec() > 20) {
            files.save(game, prob);
            files.save(game, player);
            chrono.start();
            
        }

    }
    
    
    
    
    /*##########################################################################
    #                             END METHODE                                  #
    ##########################################################################*/
    
}
