package de.matchbox.client.forms;

import de.matchbox.client.Control;
import java.util.Map;

public class FrmMain extends javax.swing.JFrame
{

    private static final long serialVersionUID = 1L;
    private Control control;

    public FrmMain()
    {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jMatch1_1 = new javax.swing.JLabel();
        jMatch1_2 = new javax.swing.JLabel();
        jMatch1_3 = new javax.swing.JLabel();
        jMatch1_4 = new javax.swing.JLabel();
        jMatch1_5 = new javax.swing.JLabel();
        jMatch1_6 = new javax.swing.JLabel();
        jMatch1_7 = new javax.swing.JLabel();
        jMatch2_1 = new javax.swing.JLabel();
        jMatch2_2 = new javax.swing.JLabel();
        jMatch2_3 = new javax.swing.JLabel();
        jMatch2_4 = new javax.swing.JLabel();
        jMatch2_5 = new javax.swing.JLabel();
        jMatch2_6 = new javax.swing.JLabel();
        jMatch2_7 = new javax.swing.JLabel();
        mnuMain = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuQuit = new javax.swing.JMenuItem();
        mnuCon = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("DoStuff!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Beenden");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jMatch1_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Horizontal.png"))); // NOI18N

        jMatch1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Vertical.png"))); // NOI18N

        jMatch1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Vertical.png"))); // NOI18N

        jMatch1_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Horizontal.png"))); // NOI18N

        jMatch1_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Vertical.png"))); // NOI18N

        jMatch1_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Vertical.png"))); // NOI18N

        jMatch1_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Horizontal.png"))); // NOI18N

        jMatch2_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Horizontal.png"))); // NOI18N

        jMatch2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Vertical.png"))); // NOI18N

        jMatch2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Vertical.png"))); // NOI18N

        jMatch2_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Horizontal.png"))); // NOI18N

        jMatch2_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Vertical.png"))); // NOI18N

        jMatch2_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Vertical.png"))); // NOI18N

        jMatch2_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resorses/Horizontal.png"))); // NOI18N

        mnuFile.setText("Datei");

        mnuQuit.setText("Beenden");
        mnuQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuQuitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuQuit);

        mnuMain.add(mnuFile);

        mnuCon.setText("Verbindung");
        mnuMain.add(mnuCon);

        setJMenuBar(mnuMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(1232, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jMatch1_1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jMatch1_5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jMatch1_6))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jMatch1_2)
                                            .addGap(98, 98, 98)
                                            .addComponent(jMatch1_3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jMatch1_4)
                                            .addComponent(jMatch1_7))))))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jMatch2_1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jMatch2_5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jMatch2_6))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jMatch2_2)
                                    .addGap(98, 98, 98)
                                    .addComponent(jMatch2_3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMatch2_4)
                                    .addComponent(jMatch2_7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jMatch1_1)
                                        .addGap(2, 2, 2)
                                        .addComponent(jMatch1_2))
                                    .addComponent(jMatch1_3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMatch1_4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMatch1_5)
                                    .addComponent(jMatch1_6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMatch1_7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jMatch2_1)
                                        .addGap(2, 2, 2)
                                        .addComponent(jMatch2_2))
                                    .addComponent(jMatch2_3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMatch2_4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMatch2_5)
                                    .addComponent(jMatch2_6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMatch2_7)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.control = new Control(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void mnuQuitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mnuQuitActionPerformed
    {//GEN-HEADEREND:event_mnuQuitActionPerformed
        jButton2ActionPerformed(null);
    }//GEN-LAST:event_mnuQuitActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList jList1;
    private javax.swing.JLabel jMatch1_1;
    private javax.swing.JLabel jMatch1_2;
    private javax.swing.JLabel jMatch1_3;
    private javax.swing.JLabel jMatch1_4;
    private javax.swing.JLabel jMatch1_5;
    private javax.swing.JLabel jMatch1_6;
    private javax.swing.JLabel jMatch1_7;
    private javax.swing.JLabel jMatch2_1;
    private javax.swing.JLabel jMatch2_2;
    private javax.swing.JLabel jMatch2_3;
    private javax.swing.JLabel jMatch2_4;
    private javax.swing.JLabel jMatch2_5;
    private javax.swing.JLabel jMatch2_6;
    private javax.swing.JLabel jMatch2_7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnuCon;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JMenuItem mnuQuit;
    // End of variables declaration//GEN-END:variables

    public void setRooms(Map<String, String> rooms)
    {
        jList1.setListData(rooms.entrySet().toArray());
    }
}
