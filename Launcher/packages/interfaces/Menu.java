package packages.interfaces;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import packages.decisionnaires.Decisiveness;
import packages.outils.fichiers.file.Files;

/**
 * Creation Windows Menu 
 * @author Theo gerfaux && Johan Turquin
 * version 3.0
 */

public class Menu extends javax.swing.JPanel {

    /*##########################################################################
    #                                ATTRIBUS                                  #
    ##########################################################################*/
    
    private javax.swing.JFrame parent;
    private Decisiveness joueur1;
    private Decisiveness joueur2;
    private String[] chaine = new String[3];
    private JButton[] button = new JButton[3];
    private Files file = new Files();
    
    byte langue;

    /*##########################################################################
    #                            END ATTRIBUS                                  #
    ##########################################################################*/
    
    /*##########################################################################
    #                                BUILDER                                   #
    ##########################################################################*/
    
    /**
     * Creates new form Menu
     */
    
    public Menu(javax.swing.JFrame f) throws IOException {
        initComponents();
        byte comparaison;
        parent=f;
        
        button[0] = jButton1;
        button[1] = jButton2;
        button[2] = jButton3;
        
        langue = file.read("src/packages/outils/fichiers/gestion_langues/initialisation.init");
        chaine = file.lecture("src/packages/outils/fichiers/gestion_sauvegardes/name.txt");
        
        if(langue == 0) {
            Français();
        } else {
            Anglais();
        }
    }
    
    public Menu() throws IOException {
        
         button[0] = jButton1;
        button[1] = jButton2;
        button[2] = jButton3;
        initComponents();
        byte comparaison;
        langue = file.read("src/packages/outils/fichiers/gestion_langues/initialisation.init");
        chaine = file.lecture("src/packages/outils/fichiers/gestion_sauvegardes/name.txt");
        
        if(langue == 0) {
            Français();
        } else {
            Anglais();
        }
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packages/images/settings.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packages/images/open-exit-door.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("p");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("P");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("P");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            name(jButton3,3);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            load("init.ini","Partie_1/");
            parent.setResizable(true);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.removeAll();
        this.setLayout(new java.awt.BorderLayout());
        try {
            this.add(new Options(parent));
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        parent.repaint();
        parent.validate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            name(jButton1,1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            load("init.ini","Partie_2/");
            parent.setResizable(true);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("Partie2");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            name(jButton2,2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
      /*  try {
            load("init.ini","Partie_3/");
            parent.setResizable(true);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("Partie3");*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        if(jButton3.getText() != "Joueur 3" || jButton3.getText() != "Player 3"){
        chaine[2] = "none";
        
        if(langue == 0) {
            
            Français();
        } else {
            Anglais();
        }
        
        file.save("src/packages/outils/fichiers/gestion_sauvegardes/Partie_1/init.ini", (byte)0);
        file.save("src/packages/outils/fichiers/gestion_sauvegardes/name.txt",chaine);
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       if(jButton1.getText() != "Joueur 1" || jButton1.getText() != "Player 1"){
        chaine[0] = "none";
        
        if(langue == 0) {
            
            Français();
        } else {
            Anglais();
        }
        
        file.save("src/packages/outils/fichiers/gestion_sauvegardes/Partie_2/init.ini", (byte)0);
        file.save("src/packages/outils/fichiers/gestion_sauvegardes/name.txt",chaine);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(jButton1.getText() != "Joueur 2" || jButton1.getText() != "Player 2"){
        chaine[1] = "none";
        
        if(langue == 0) {
            
            Français();
        } else {
            Anglais();
        }
        
        file.save("src/packages/outils/fichiers/gestion_sauvegardes/Partie_3/init.ini", (byte)0);
        file.save("src/packages/outils/fichiers/gestion_sauvegardes/name.txt",chaine);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * load the data 
     * @param init path of the init
     * @param partie num of the fame
     * @throws IOException 
     */
    
    public void load(String init, String partie) throws IOException, InterruptedException {
        
        Files file = new Files();
        byte lecture = -1;
        
        try {
            lecture = file.read("src/packages/outils/fichiers/gestion_sauvegardes/" + partie + init);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //on lis par defaut
        switch (lecture) {
            case 0:
                this.removeAll();
                this.setLayout(new java.awt.BorderLayout());
                GameLauncher g0 = new GameLauncher(this);
                if(parent!=null){
                    g0.genererMenu(parent);
                }
                this.repaint();
                this.validate();
            file.save("src/packages/outils/fichiers/gestion_sauvegardes/" + partie + init, (byte)1);
            break;
            case 1:
                
                this.removeAll();
                this.setLayout(new java.awt.BorderLayout());
                try {
                    GameLauncher g1 = new GameLauncher(this, partie);
                    if(parent!=null){
                        g1.genererMenu(parent);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }   this.repaint();
                this.validate();
                break;
            default:
                System.err.println("Problème de lecture");
                break;
        }
    }
    
    /**
     * Change the text for the english
     */
    
    public void Anglais(){
                for (int i = 0; i < chaine.length; i++) {
            
             if(chaine[i].equals("none")) {
                
                 button[i].setText("Player " + (i+1));
            // On ecris dans le fichier le nom
        } else {
                 button[i].setText(chaine[i]);
             }
        }
    }
    
    /**
     * Change the text for the french
     */
    
    public void Français() {
        
      
        for (int i = 0; i < chaine.length; i++) {
            
             if(chaine[i].equals("none")) {
                
                 button[i].setText("Joueur " + (i+1));
            // On ecris dans le fichier le nom
        } else {
                 button[i].setText(chaine[i]);
             }
        }
    }

    public void paintComponent(Graphics g)
    {
        File fichier1 = new File("src/packages/images/fond.png");

                BufferedImage image1;
                try {
                    image1 = ImageIO.read(fichier1);

                    g.drawImage(image1, -35, 0, null);
                } catch (IOException ex) {System.out.println(ex.getMessage()); }
    }
    
    public void name(JButton button,int x) throws InterruptedException {
        System.err.println(x);
        System.err.println("Joueur " + x);
        if(button.getText().equals("Joueur " + x) || button.getText().equals("Player " +x)) {
            JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
            String nom = jop.showInputDialog(null, "Veuillez décliner votre identité !", "", JOptionPane.QUESTION_MESSAGE);
            
            chaine[x-1] = nom;
            file.save("src/packages/outils/fichiers/gestion_sauvegardes/name.txt",chaine);
            button.setText(nom);   
        }
  }
    /*##########################################################################
    #                             END METHODE                                  #
    ##########################################################################*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    // End of variables declaration//GEN-END:variables
}
