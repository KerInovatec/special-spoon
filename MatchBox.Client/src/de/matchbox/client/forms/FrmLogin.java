/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.client.forms;

import de.matchbox.client.Control;
import de.matchbox.client.utility.Konami;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Jakob
 * @bearbeitet Andrej
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form login
     *
     * @param pMainForm
     */
    private final Control control;

    public FrmLogin(Control pControl) {
        this.control = pControl;
        initComponents();
        MLG.setVisible(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/de/matchbox/client/Resources/Icon.png")));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.initEvent();
        jButtonLogIn.setOpaque(false);
        jLabelUsernamecheck.setForeground(Color.green);
        jLabelUsernamecheck.setText("OK");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldIp = new javax.swing.JTextField();
        jTextFieldPort = new javax.swing.JTextField();
        jButtonLogIn = new javax.swing.JButton();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        MLG = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelUsernamecheck = new javax.swing.JLabel();
        jLabelBackGround = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MatchBox");
        setMinimumSize(new java.awt.Dimension(450, 300));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 110, 9, 15);

        jLabel3.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Port");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(290, 110, 19, 15);

        jTextFieldIp.setText("localhost");
        jTextFieldIp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldIpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIpKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldIp);
        jTextFieldIp.setBounds(150, 110, 130, 20);

        jTextFieldPort.setText("1234");
        jTextFieldPort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPortKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldPort);
        jTextFieldPort.setBounds(320, 110, 30, 20);

        jButtonLogIn.setBackground(new java.awt.Color(0, 102, 51));
        jButtonLogIn.setText("Log In");
        jButtonLogIn.setBorder(null);
        jButtonLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogInActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogIn);
        jButtonLogIn.setBounds(290, 210, 100, 30);

        jTextFieldUsername.setText("Player");
        getContentPane().add(jTextFieldUsername);
        jTextFieldUsername.setBounds(150, 140, 130, 20);

        jLabel4.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 140, 47, 15);

        MLG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/MLG.gif"))); // NOI18N
        getContentPane().add(MLG);
        MLG.setBounds(60, 180, 150, 80);

        jLabel5.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Welcome to Matchbox !");
        jLabel5.setToolTipText("");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 30, 220, 30);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Please Log in to start The Game");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 50, 250, 40);

        jLabelUsernamecheck.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(jLabelUsernamecheck);
        jLabelUsernamecheck.setBounds(290, 140, 150, 20);

        jLabelBackGround.setBackground(new java.awt.Color(255, 0, 0));
        jLabelBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/BurningMatch.gif"))); // NOI18N
        getContentPane().add(jLabelBackGround);
        jLabelBackGround.setBounds(0, -6, 450, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogInActionPerformed
        // TODO add your handling code here:
        String ip = this.jTextFieldIp.getText();
        int port = Integer.parseInt(this.jTextFieldPort.getText());
        String username = this.jTextFieldUsername.getText();

        try {
            this.control.connect(ip, port);
            this.control.login(username);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Can not connect o the server", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLogInActionPerformed

    private void jTextFieldIpKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextFieldIpKeyPressed
    {//GEN-HEADEREND:event_jTextFieldIpKeyPressed
        Konami.checkKonami(evt.getKeyCode());
        if (Konami.isActivated) {
            JOptionPane.showMessageDialog(this, "MLG mode Activated!");
            MLG.setVisible(true);
            control.setKonamiisAk(Konami.isActivated);
        }

        if (!jTextFieldIp.getText().isEmpty() && !jTextFieldPort.getText().isEmpty()
                && !jTextFieldUsername.getText().isEmpty() && evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            this.jButtonLogInActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldIpKeyPressed
    // Listen for changes in the text

    private void initEvent() {
        jTextFieldUsername.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                checkUsername();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkUsername();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkUsername();
            }
        });
    }

    public void checkUsername() {
        if (!jTextFieldUsername.getText().equals("")) {
            if (jTextFieldUsername.getText().length() >= 16) {
                jLabelUsernamecheck.setForeground(Color.red);
                jLabelUsernamecheck.setText("Too Long. max: 15");
            } else if (jTextFieldUsername.getText().indexOf(" ") != -1) {
                jLabelUsernamecheck.setForeground(Color.red);
                jLabelUsernamecheck.setText("No Spacing allowed");

            } else {

                jLabelUsernamecheck.setForeground(Color.green);
                jLabelUsernamecheck.setText("OK");

            }
        } else {
            jLabelUsernamecheck.setText("");
        }
    }
    private void jTextFieldPortKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextFieldPortKeyPressed
    {//GEN-HEADEREND:event_jTextFieldPortKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPortKeyPressed

    private void jTextFieldIpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIpKeyTyped

    }//GEN-LAST:event_jTextFieldIpKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MLG;
    private javax.swing.JButton jButtonLogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelBackGround;
    private javax.swing.JLabel jLabelUsernamecheck;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextFieldIp;
    private javax.swing.JTextField jTextFieldPort;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
