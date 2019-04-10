package packages.interfaces;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
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
    private Files file = new Files();

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
        
        comparaison = file.read("src/packages/outils/fichiers/gestion_langues/initialisation.init");
        
        if(comparaison == 0) {
            Français();
        } else {
            Anglais();
        }
    }
    
    public Menu() throws IOException {
        initComponents();
        byte comparaison;
        comparaison = file.read("src/packages/outils/fichiers/gestion_langues/initialisation.init");
        
        if(comparaison == 0) {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)
                        .addGap(0, 323, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(81, 81, 81)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            name("partie_1/",jButton3);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            load("init.ini","Partie_1/");
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
            this.add(new Options());
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.repaint();
        this.validate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            name("partie_2/",jButton1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            load("init.ini","Partie_2/");
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("Partie2");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            name("partie_2/",jButton3);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            load("init.ini","Partie_3/");
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("Partie3");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

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
        jButton1.setText("Player 2");
        jButton2.setText("Player 3");
        jButton3.setText("Player 1");
    }
    
    /**
     * Change the text for the french
     */
    
    public void Français() {
        jButton1.setText("Joueur 2");
        jButton2.setText("Joueur 3");
        jButton3.setText("Joueur 1");
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
    
    public void name(String partie, JButton button) throws InterruptedException {
        
        if(button.getText() == "Joueur 1" || button.getText() == "Player 1") {
            JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
            String nom = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Gendarmerie nationale !", JOptionPane.QUESTION_MESSAGE);
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
    // End of variables declaration//GEN-END:variables
}
