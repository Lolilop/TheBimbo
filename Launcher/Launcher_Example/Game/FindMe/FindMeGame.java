/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launcher_Example.Game.FindMe;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Launcher_Example.Game.Game;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author JC
 */
public final class FindMeGame extends Game 
{

    private final MyButton[][] clickZone = new MyButton[4][4];
    private Manager manager;
    private final Container parent;
    
    /**
     * Creates new form FindMeGame
     * @param parent The container to add the game to
     */
    public FindMeGame(Container parent) {
        super("FindMe !!!");
        this.parent=parent;
        this.manager = new Manager();
        initComponents();
        startGame();
        
    }

    private void showFinalMessage(boolean win)
    {
        String message="";
        
        if(win) message+=  "You win !!!";
        else    message+=  "You lose ..."; 
            
        javax.swing.JOptionPane.showMessageDialog(parent, message,                       
                                           "The game is over",
                                           javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Not used due to problem of stability ...
    /*private void showMessage(String message)
    {
       javax.swing.JOptionPane.showMessageDialog(parent, message,                       
                                           "Information",
                                           javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }*/
    
    private void initiate()
    {
      for(int i=0;i<clickZone.length;i++)
       {
           for (int j=0;j<clickZone[i].length;j++)
           {
               clickZone[i][j]=new MyButton(i,j);
               clickZone[i][j].setFont(new java.awt.Font("Liberation Sans", 0, 24));
               clickZone[i][j].addActionListener(new showButton());    
               jPanel1.add(clickZone[i][j]);
           }
       }
    }
             
    private void disableAll()
    {
        for( var line : clickZone)
        {
            for ( var button : line)
            {
                button.setEnabled(false);
            }
        }
    }
    
    private void restoreAll()
    {
        for( var line : clickZone)
        {
            for ( var button : line)
            {
                if(! manager.isClicked(button.getLine(),button.getColumn() ))
                {
                    button.setEnabled(true);
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.GridLayout(4, 4));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Find Me");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Launcher_Example/Game/FindMe/SmallSPD.jpg"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Number of tries");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(parent);
        parent.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

       
    }// </editor-fold>                        

    //Only useful if game is used as a standalone game
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        startGame();
    }                                    

    class showButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(currentState != State.STARTED)
            {
                return;
            }
            MyButton button=(MyButton)e.getSource();
                       
            if(manager.isHere(button.getLine(),button.getColumn() ))
               {
                    button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Launcher_Example/Game/FindMe/SmallSPD.jpg")));
                    showFinalMessage(true);
                    disableAll();
               }
            else
               {
                    button.setEnabled(false);
                    jLabel4.setText(Integer.toString(manager.getRemainingTries()));
                    if(manager.getRemainingTries()==0)
                       {
                           showFinalMessage(false);
                           disableAll();
                       }
               }
                    
        }
                   
    }
    
    @Override
    public void saveGame(java.io.File file)
    {
        if(currentState != State.STARTED)
        {
            return;
        }

        System.out.println("Saving into "+file);
        
        java.io.ObjectOutputStream out=null;
        try {
            out = new java.io.ObjectOutputStream( new java.io.FileOutputStream(file));
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFound Exception ...");
        } catch (IOException ex) {
            System.out.println("Generic I/O Exception");
        }
        
        if(out!=null)
        {
            try {
                   out.writeObject(manager);
                   out.flush();
                   out.close();
            } catch (IOException ex) {
                System.out.println("Generic I/O Exception");
            }
        }
    }
    
    @Override
    public void loadGame(java.io.File file)
    {
        System.out.println("Loading from "+file);
        
        java.io.ObjectInputStream in=null;
        try {
            in = new java.io.ObjectInputStream( new java.io.FileInputStream(file));
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFound Exception ...");
        } catch (IOException ex) {
            System.out.println("Generic I/O Exception");
        }
        
        if(in!=null)
        {
            try {
                   manager=(Manager)in.readObject();
                   in.close();
            } catch (IOException ex) {
                System.out.println("Generic I/O Exception");
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException for Manager");
            }
            
            
            jLabel4.setText(Integer.toString(manager.getRemainingTries()));
        
            for( var line : clickZone)
            {
                for ( var button : line)
                {
                   button.setEnabled(! manager.isClicked(button.getLine(),button.getColumn() ));
                }
            }
        }
    }
        
    
    @Override
    public void startGame()
    {
        jPanel1.removeAll();
        initiate();
        jPanel1.revalidate();
        jPanel1.repaint();
        manager.restart();
        jLabel4.setText(Integer.toString(manager.getRemainingTries()));
        
        currentState=State.STARTED;
        //showMessage("Restart");
        System.out.println("Restart");
    }
    
    @Override
    public void stopGame()
    {
       if(currentState != State.STOPPED && currentState != State.INITIALIZED)
        {
           disableAll();
           //showMessage("The game is stopped");
           System.out.println("The game is stopped");
           currentState=State.STOPPED;
        }
       //currentState=State.STOPPED;
     
    }
       
    @Override
    public void pauseGame()
    {
           
        if(currentState==State.PAUSED)
        {
            currentState=State.STARTED;
            //showMessage("The game continues");
            System.out.println("The game continues");
            restoreAll();
            
        }
        else
        {
            if(currentState==State.STARTED)
            {
                currentState=State.PAUSED;
                //showMessage("The game is paused");
                System.out.println("The game is paused");
                
                disableAll();
                
            }
            else
            {
                //showMessage("The game is not started or already stopped, pause not possible");    
                System.out.println("The game is not started or already stopped, pause not possible");    
            }
            
        }
    }
    

//Declarations made by Netbeans    
// Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration        
}
