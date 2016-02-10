/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.client.forms;

import de.matchbox.client.Control;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.enumeration.MessageType;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
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
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        this.setResizable(false);
        this.setLocationRelativeTo(null);

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
        jButton1 = new javax.swing.JButton();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        MLG = new javax.swing.JLabel();
        jLabelBackGround = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MatchBox");
        setMinimumSize(new java.awt.Dimension(360, 267));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(72, 56, 9, 15);

        jLabel3.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Port");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(182, 56, 19, 15);

        jTextFieldIp.setText("localhost");
        jTextFieldIp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldIpKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldIp);
        jTextFieldIp.setBounds(92, 53, 80, 20);

        jTextFieldPort.setText("1234");
        jTextFieldPort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPortKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldPort);
        jTextFieldPort.setBounds(206, 53, 30, 20);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(93, 138, 57, 23);

        jTextFieldUsername.setText("Hans3");
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldUsername);
        jTextFieldUsername.setBounds(93, 79, 225, 20);

        jLabel4.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(35, 82, 47, 15);

        MLG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/MLG.gif"))); // NOI18N
        getContentPane().add(MLG);
        MLG.setBounds(168, 117, 150, 150);

        jLabelBackGround.setBackground(new java.awt.Color(255, 0, 0));
        jLabelBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/BurningMatch.gif"))); // NOI18N
        getContentPane().add(jLabelBackGround);
        jLabelBackGround.setBounds(0, -6, 360, 280);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ip = this.jTextFieldIp.getText();
        int port = Integer.parseInt(this.jTextFieldPort.getText());
        String username = this.jTextFieldUsername.getText();
        this.control.connect(ip, port);
        this.control.login(username);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldIpKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextFieldIpKeyPressed
    {//GEN-HEADEREND:event_jTextFieldIpKeyPressed
        if (!jTextFieldIp.getText().isEmpty() && !jTextFieldPort.getText().isEmpty()
                && !jTextFieldUsername.getText().isEmpty() && evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            this.jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldIpKeyPressed

    private void jTextFieldUsernameKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextFieldUsernameKeyPressed
    {//GEN-HEADEREND:event_jTextFieldUsernameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameKeyPressed

    private void jTextFieldPortKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextFieldPortKeyPressed
    {//GEN-HEADEREND:event_jTextFieldPortKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPortKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MLG;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelBackGround;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextFieldIp;
    private javax.swing.JTextField jTextFieldPort;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
