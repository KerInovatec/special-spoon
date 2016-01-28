package de.matchbox.client.forms;

import de.matchbox.client.Control;
import de.matchbox.client.utility.MatchUtility;
import de.matchbox.client.Zahl;
import de.matchbox.communication.classmodels.RoomModel;
import de.matchbox.communication.shared.abiturklassen.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class FrmMain extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel jMatchArr[][];
    private JLabel jSpaceArr[][];
    private final Control control;
    private boolean hasMatch;
    private DefaultListModel lobby;
    private RoomModel[] rm;

    public FrmMain() {
        this.control = new Control(this);
        new FrmLogin(this).setVisible(true);
        initComponents();
        jMatchArr = new JLabel[8][10];
        jSpaceArr = new JLabel[8][10];
        this.createArr();
        this.resetView();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.initEvents();
        this.initEvents2();
        hasMatch = false;
        lobby = new DefaultListModel();

    }

    public void doLogin(String ip, int port, String username) {
        this.control.connect(ip, port);
        this.control.login(username);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanelIntro = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jRoomList = new javax.swing.JList();
        jConnectRoom = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSpace1_1 = new javax.swing.JLabel();
        jSpace2_1 = new javax.swing.JLabel();
        jSpace3_1 = new javax.swing.JLabel();
        jSpace4_1 = new javax.swing.JLabel();
        jSpace5_1 = new javax.swing.JLabel();
        jSpace6_1 = new javax.swing.JLabel();
        jSpace7_1 = new javax.swing.JLabel();
        jMatch1_1 = new javax.swing.JLabel();
        jMatch2_1 = new javax.swing.JLabel();
        jMatch3_1 = new javax.swing.JLabel();
        jMatch4_1 = new javax.swing.JLabel();
        jMatch5_1 = new javax.swing.JLabel();
        jMatch6_1 = new javax.swing.JLabel();
        jMatch7_1 = new javax.swing.JLabel();
        jSpace1_2 = new javax.swing.JLabel();
        jSpace2_2 = new javax.swing.JLabel();
        jSpace3_2 = new javax.swing.JLabel();
        jSpace4_2 = new javax.swing.JLabel();
        jSpace5_2 = new javax.swing.JLabel();
        jSpace6_2 = new javax.swing.JLabel();
        jSpace7_2 = new javax.swing.JLabel();
        jMatch1_2 = new javax.swing.JLabel();
        jMatch2_2 = new javax.swing.JLabel();
        jMatch3_2 = new javax.swing.JLabel();
        jMatch4_2 = new javax.swing.JLabel();
        jMatch5_2 = new javax.swing.JLabel();
        jMatch6_2 = new javax.swing.JLabel();
        jMatch7_2 = new javax.swing.JLabel();
        jSpace1_3 = new javax.swing.JLabel();
        jSpace2_3 = new javax.swing.JLabel();
        jSpace3_3 = new javax.swing.JLabel();
        jSpace4_3 = new javax.swing.JLabel();
        jSpace5_3 = new javax.swing.JLabel();
        jSpace6_3 = new javax.swing.JLabel();
        jSpace7_3 = new javax.swing.JLabel();
        jMatch1_3 = new javax.swing.JLabel();
        jMatch2_3 = new javax.swing.JLabel();
        jMatch3_3 = new javax.swing.JLabel();
        jMatch4_3 = new javax.swing.JLabel();
        jMatch5_3 = new javax.swing.JLabel();
        jMatch6_3 = new javax.swing.JLabel();
        jMatch7_3 = new javax.swing.JLabel();
        jSpace1_4 = new javax.swing.JLabel();
        jSpace2_4 = new javax.swing.JLabel();
        jSpace3_4 = new javax.swing.JLabel();
        jSpace4_4 = new javax.swing.JLabel();
        jSpace5_4 = new javax.swing.JLabel();
        jSpace6_4 = new javax.swing.JLabel();
        jSpace7_4 = new javax.swing.JLabel();
        jMatch1_4 = new javax.swing.JLabel();
        jMatch2_4 = new javax.swing.JLabel();
        jMatch3_4 = new javax.swing.JLabel();
        jMatch4_4 = new javax.swing.JLabel();
        jMatch5_4 = new javax.swing.JLabel();
        jMatch6_4 = new javax.swing.JLabel();
        jMatch7_4 = new javax.swing.JLabel();
        jSpace1_5 = new javax.swing.JLabel();
        jSpace2_5 = new javax.swing.JLabel();
        jSpace3_5 = new javax.swing.JLabel();
        jSpace4_5 = new javax.swing.JLabel();
        jSpace5_5 = new javax.swing.JLabel();
        jSpace6_5 = new javax.swing.JLabel();
        jSpace7_5 = new javax.swing.JLabel();
        jMatch1_5 = new javax.swing.JLabel();
        jMatch2_5 = new javax.swing.JLabel();
        jMatch3_5 = new javax.swing.JLabel();
        jMatch4_5 = new javax.swing.JLabel();
        jMatch5_5 = new javax.swing.JLabel();
        jMatch6_5 = new javax.swing.JLabel();
        jMatch7_5 = new javax.swing.JLabel();
        jSpace1_6 = new javax.swing.JLabel();
        jSpace2_6 = new javax.swing.JLabel();
        jSpace3_6 = new javax.swing.JLabel();
        jSpace4_6 = new javax.swing.JLabel();
        jSpace5_6 = new javax.swing.JLabel();
        jSpace6_6 = new javax.swing.JLabel();
        jSpace7_6 = new javax.swing.JLabel();
        jMatch1_6 = new javax.swing.JLabel();
        jMatch2_6 = new javax.swing.JLabel();
        jMatch3_6 = new javax.swing.JLabel();
        jMatch4_6 = new javax.swing.JLabel();
        jMatch5_6 = new javax.swing.JLabel();
        jMatch6_6 = new javax.swing.JLabel();
        jMatch7_6 = new javax.swing.JLabel();
        jSpace1_7 = new javax.swing.JLabel();
        jSpace2_7 = new javax.swing.JLabel();
        jSpace3_7 = new javax.swing.JLabel();
        jSpace4_7 = new javax.swing.JLabel();
        jSpace5_7 = new javax.swing.JLabel();
        jSpace6_7 = new javax.swing.JLabel();
        jSpace7_7 = new javax.swing.JLabel();
        jMatch1_7 = new javax.swing.JLabel();
        jMatch2_7 = new javax.swing.JLabel();
        jMatch3_7 = new javax.swing.JLabel();
        jMatch4_7 = new javax.swing.JLabel();
        jMatch5_7 = new javax.swing.JLabel();
        jMatch6_7 = new javax.swing.JLabel();
        jMatch7_7 = new javax.swing.JLabel();
        jSpace1_8 = new javax.swing.JLabel();
        jSpace2_8 = new javax.swing.JLabel();
        jSpace3_8 = new javax.swing.JLabel();
        jSpace4_8 = new javax.swing.JLabel();
        jSpace5_8 = new javax.swing.JLabel();
        jSpace6_8 = new javax.swing.JLabel();
        jSpace7_8 = new javax.swing.JLabel();
        jMatch1_8 = new javax.swing.JLabel();
        jMatch2_8 = new javax.swing.JLabel();
        jMatch3_8 = new javax.swing.JLabel();
        jMatch4_8 = new javax.swing.JLabel();
        jMatch5_8 = new javax.swing.JLabel();
        jMatch6_8 = new javax.swing.JLabel();
        jMatch7_8 = new javax.swing.JLabel();
        jSpace1_9 = new javax.swing.JLabel();
        jSpace2_9 = new javax.swing.JLabel();
        jSpace3_9 = new javax.swing.JLabel();
        jSpace4_9 = new javax.swing.JLabel();
        jSpace5_9 = new javax.swing.JLabel();
        jSpace6_9 = new javax.swing.JLabel();
        jSpace7_9 = new javax.swing.JLabel();
        jMatch1_9 = new javax.swing.JLabel();
        jMatch2_9 = new javax.swing.JLabel();
        jMatch3_9 = new javax.swing.JLabel();
        jMatch4_9 = new javax.swing.JLabel();
        jMatch5_9 = new javax.swing.JLabel();
        jMatch6_9 = new javax.swing.JLabel();
        jMatch7_9 = new javax.swing.JLabel();
        jEaquals = new javax.swing.JLabel();
        jPlus = new javax.swing.JLabel();
        jMinus = new javax.swing.JLabel();
        jTextFieldTest = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mnuMain = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuQuit = new javax.swing.JMenuItem();
        mnuCon = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MatchBox");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1500, 650));
        getContentPane().setLayout(null);

        jScrollPane3.setViewportView(jRoomList);

        jConnectRoom.setText("Connect");
        jConnectRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConnectRoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIntroLayout = new javax.swing.GroupLayout(jPanelIntro);
        jPanelIntro.setLayout(jPanelIntroLayout);
        jPanelIntroLayout.setHorizontalGroup(
            jPanelIntroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIntroLayout.createSequentialGroup()
                .addContainerGap(1227, Short.MAX_VALUE)
                .addGroup(jPanelIntroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jConnectRoom)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelIntroLayout.setVerticalGroup(
            jPanelIntroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIntroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jConnectRoom)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelIntro);
        jPanelIntro.setBounds(0, 0, 1500, 620);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jSpace1_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace1_1);
        jSpace1_1.setBounds(20, 50, 100, 12);

        jSpace2_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace2_1);
        jSpace2_1.setBounds(10, 60, 12, 100);

        jSpace3_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace3_1);
        jSpace3_1.setBounds(120, 60, 12, 100);

        jSpace4_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace4_1);
        jSpace4_1.setBounds(20, 160, 100, 12);

        jSpace5_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace5_1);
        jSpace5_1.setBounds(10, 170, 12, 100);

        jSpace6_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace6_1);
        jSpace6_1.setBounds(120, 170, 12, 100);

        jSpace7_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace7_1);
        jSpace7_1.setBounds(20, 270, 100, 12);

        jMatch1_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch1_1);
        jMatch1_1.setBounds(20, 50, 100, 12);

        jMatch2_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch2_1);
        jMatch2_1.setBounds(10, 60, 12, 100);

        jMatch3_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch3_1);
        jMatch3_1.setBounds(120, 60, 12, 100);

        jMatch4_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch4_1);
        jMatch4_1.setBounds(20, 160, 100, 12);

        jMatch5_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch5_1);
        jMatch5_1.setBounds(10, 170, 12, 100);

        jMatch6_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch6_1);
        jMatch6_1.setBounds(120, 170, 12, 100);

        jMatch7_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch7_1);
        jMatch7_1.setBounds(20, 270, 100, 12);

        jSpace1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace1_2);
        jSpace1_2.setBounds(150, 50, 100, 12);

        jSpace2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace2_2);
        jSpace2_2.setBounds(140, 60, 12, 100);

        jSpace3_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace3_2);
        jSpace3_2.setBounds(250, 60, 12, 100);

        jSpace4_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace4_2);
        jSpace4_2.setBounds(150, 160, 100, 12);

        jSpace5_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace5_2);
        jSpace5_2.setBounds(140, 170, 12, 100);

        jSpace6_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace6_2);
        jSpace6_2.setBounds(250, 170, 12, 100);

        jSpace7_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace7_2);
        jSpace7_2.setBounds(150, 270, 100, 12);

        jMatch1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch1_2);
        jMatch1_2.setBounds(150, 50, 100, 12);

        jMatch2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch2_2);
        jMatch2_2.setBounds(140, 60, 12, 100);

        jMatch3_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch3_2);
        jMatch3_2.setBounds(250, 60, 12, 100);

        jMatch4_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch4_2);
        jMatch4_2.setBounds(150, 160, 100, 12);

        jMatch5_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch5_2);
        jMatch5_2.setBounds(140, 170, 12, 100);

        jMatch6_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch6_2);
        jMatch6_2.setBounds(250, 170, 12, 100);

        jMatch7_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch7_2);
        jMatch7_2.setBounds(150, 270, 100, 12);

        jSpace1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace1_3);
        jSpace1_3.setBounds(280, 50, 100, 12);

        jSpace2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace2_3);
        jSpace2_3.setBounds(270, 60, 12, 100);

        jSpace3_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace3_3);
        jSpace3_3.setBounds(380, 60, 12, 100);

        jSpace4_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace4_3);
        jSpace4_3.setBounds(280, 160, 100, 12);

        jSpace5_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace5_3);
        jSpace5_3.setBounds(270, 170, 12, 100);

        jSpace6_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace6_3);
        jSpace6_3.setBounds(380, 170, 12, 100);

        jSpace7_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace7_3);
        jSpace7_3.setBounds(280, 270, 100, 12);

        jMatch1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch1_3);
        jMatch1_3.setBounds(280, 50, 100, 12);

        jMatch2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch2_3);
        jMatch2_3.setBounds(270, 60, 12, 100);

        jMatch3_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch3_3);
        jMatch3_3.setBounds(380, 60, 12, 100);

        jMatch4_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch4_3);
        jMatch4_3.setBounds(280, 160, 100, 12);

        jMatch5_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch5_3);
        jMatch5_3.setBounds(270, 170, 12, 100);

        jMatch6_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch6_3);
        jMatch6_3.setBounds(380, 170, 12, 100);

        jMatch7_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch7_3);
        jMatch7_3.setBounds(280, 270, 100, 12);

        jSpace1_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace1_4);
        jSpace1_4.setBounds(520, 50, 100, 12);

        jSpace2_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace2_4);
        jSpace2_4.setBounds(510, 60, 12, 100);

        jSpace3_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace3_4);
        jSpace3_4.setBounds(620, 60, 12, 100);

        jSpace4_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace4_4);
        jSpace4_4.setBounds(520, 160, 100, 12);

        jSpace5_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace5_4);
        jSpace5_4.setBounds(510, 170, 12, 100);

        jSpace6_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace6_4);
        jSpace6_4.setBounds(620, 170, 12, 100);

        jSpace7_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace7_4);
        jSpace7_4.setBounds(520, 270, 100, 12);

        jMatch1_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch1_4);
        jMatch1_4.setBounds(520, 50, 100, 12);

        jMatch2_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch2_4);
        jMatch2_4.setBounds(510, 60, 12, 100);

        jMatch3_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch3_4);
        jMatch3_4.setBounds(620, 60, 12, 100);

        jMatch4_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch4_4);
        jMatch4_4.setBounds(520, 160, 100, 12);

        jMatch5_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch5_4);
        jMatch5_4.setBounds(510, 170, 12, 100);

        jMatch6_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch6_4);
        jMatch6_4.setBounds(620, 170, 12, 100);

        jMatch7_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch7_4);
        jMatch7_4.setBounds(520, 270, 100, 12);

        jSpace1_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace1_5);
        jSpace1_5.setBounds(650, 50, 100, 12);

        jSpace2_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace2_5);
        jSpace2_5.setBounds(640, 60, 12, 100);

        jSpace3_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace3_5);
        jSpace3_5.setBounds(750, 60, 12, 100);

        jSpace4_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace4_5);
        jSpace4_5.setBounds(650, 160, 100, 12);

        jSpace5_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace5_5);
        jSpace5_5.setBounds(640, 170, 12, 100);

        jSpace6_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace6_5);
        jSpace6_5.setBounds(750, 170, 12, 100);

        jSpace7_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace7_5);
        jSpace7_5.setBounds(650, 270, 100, 12);

        jMatch1_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch1_5);
        jMatch1_5.setBounds(650, 50, 100, 12);

        jMatch2_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch2_5);
        jMatch2_5.setBounds(640, 60, 12, 100);

        jMatch3_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch3_5);
        jMatch3_5.setBounds(750, 60, 12, 100);

        jMatch4_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch4_5);
        jMatch4_5.setBounds(650, 160, 100, 12);

        jMatch5_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch5_5);
        jMatch5_5.setBounds(640, 170, 12, 100);

        jMatch6_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch6_5);
        jMatch6_5.setBounds(750, 170, 12, 100);

        jMatch7_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch7_5);
        jMatch7_5.setBounds(650, 270, 100, 12);

        jSpace1_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace1_6);
        jSpace1_6.setBounds(780, 50, 100, 12);

        jSpace2_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace2_6);
        jSpace2_6.setBounds(770, 60, 12, 100);

        jSpace3_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace3_6);
        jSpace3_6.setBounds(880, 60, 12, 100);

        jSpace4_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace4_6);
        jSpace4_6.setBounds(780, 160, 100, 12);

        jSpace5_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace5_6);
        jSpace5_6.setBounds(770, 170, 12, 100);

        jSpace6_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace6_6);
        jSpace6_6.setBounds(880, 170, 12, 100);

        jSpace7_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace7_6);
        jSpace7_6.setBounds(780, 270, 100, 12);

        jMatch1_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch1_6);
        jMatch1_6.setBounds(780, 50, 100, 12);

        jMatch2_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch2_6);
        jMatch2_6.setBounds(770, 60, 12, 100);

        jMatch3_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch3_6);
        jMatch3_6.setBounds(880, 60, 12, 100);

        jMatch4_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch4_6);
        jMatch4_6.setBounds(780, 160, 100, 12);

        jMatch5_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch5_6);
        jMatch5_6.setBounds(770, 170, 12, 100);

        jMatch6_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch6_6);
        jMatch6_6.setBounds(880, 170, 12, 100);

        jMatch7_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch7_6);
        jMatch7_6.setBounds(780, 270, 100, 12);

        jSpace1_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace1_7);
        jSpace1_7.setBounds(1020, 50, 100, 12);

        jSpace2_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace2_7);
        jSpace2_7.setBounds(1010, 60, 12, 100);

        jSpace3_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace3_7);
        jSpace3_7.setBounds(1120, 60, 12, 100);

        jSpace4_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace4_7);
        jSpace4_7.setBounds(1020, 160, 100, 12);

        jSpace5_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace5_7);
        jSpace5_7.setBounds(1010, 170, 12, 100);

        jSpace6_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace6_7);
        jSpace6_7.setBounds(1120, 170, 12, 100);

        jSpace7_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace7_7);
        jSpace7_7.setBounds(1020, 270, 100, 12);

        jMatch1_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch1_7);
        jMatch1_7.setBounds(1020, 50, 100, 12);

        jMatch2_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch2_7);
        jMatch2_7.setBounds(1010, 60, 12, 100);

        jMatch3_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch3_7);
        jMatch3_7.setBounds(1120, 60, 12, 100);

        jMatch4_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch4_7);
        jMatch4_7.setBounds(1020, 160, 100, 12);

        jMatch5_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch5_7);
        jMatch5_7.setBounds(1010, 170, 12, 100);

        jMatch6_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch6_7);
        jMatch6_7.setBounds(1120, 170, 12, 100);

        jMatch7_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch7_7);
        jMatch7_7.setBounds(1020, 270, 100, 12);

        jSpace1_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace1_8);
        jSpace1_8.setBounds(1150, 50, 100, 12);

        jSpace2_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace2_8);
        jSpace2_8.setBounds(1140, 60, 12, 100);

        jSpace3_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace3_8);
        jSpace3_8.setBounds(1250, 60, 12, 100);

        jSpace4_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace4_8);
        jSpace4_8.setBounds(1150, 160, 100, 12);

        jSpace5_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace5_8);
        jSpace5_8.setBounds(1140, 170, 12, 100);

        jSpace6_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace6_8);
        jSpace6_8.setBounds(1250, 170, 12, 100);

        jSpace7_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace7_8);
        jSpace7_8.setBounds(1150, 270, 100, 12);

        jMatch1_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch1_8);
        jMatch1_8.setBounds(1150, 50, 100, 12);

        jMatch2_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch2_8);
        jMatch2_8.setBounds(1140, 60, 12, 100);

        jMatch3_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch3_8);
        jMatch3_8.setBounds(1250, 60, 12, 100);

        jMatch4_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch4_8);
        jMatch4_8.setBounds(1150, 160, 100, 12);

        jMatch5_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch5_8);
        jMatch5_8.setBounds(1140, 170, 12, 100);

        jMatch6_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch6_8);
        jMatch6_8.setBounds(1250, 170, 12, 100);

        jMatch7_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch7_8);
        jMatch7_8.setBounds(1150, 270, 100, 12);

        jSpace1_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace1_9);
        jSpace1_9.setBounds(1280, 50, 100, 12);

        jSpace2_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace2_9);
        jSpace2_9.setBounds(1270, 60, 12, 100);

        jSpace3_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace3_9);
        jSpace3_9.setBounds(1380, 60, 12, 100);

        jSpace4_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace4_9);
        jSpace4_9.setBounds(1280, 160, 100, 12);

        jSpace5_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace5_9);
        jSpace5_9.setBounds(1270, 170, 12, 100);

        jSpace6_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_V.png"))); // NOI18N
        jPanel1.add(jSpace6_9);
        jSpace6_9.setBounds(1380, 170, 12, 100);

        jSpace7_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Empty_H.png"))); // NOI18N
        jPanel1.add(jSpace7_9);
        jSpace7_9.setBounds(1280, 270, 100, 12);

        jMatch1_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch1_9);
        jMatch1_9.setBounds(1280, 50, 100, 12);

        jMatch2_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch2_9);
        jMatch2_9.setBounds(1270, 60, 12, 100);

        jMatch3_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch3_9);
        jMatch3_9.setBounds(1380, 60, 12, 100);

        jMatch4_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch4_9);
        jMatch4_9.setBounds(1280, 160, 100, 12);

        jMatch5_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch5_9);
        jMatch5_9.setBounds(1270, 170, 12, 100);

        jMatch6_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Vertical.png"))); // NOI18N
        jPanel1.add(jMatch6_9);
        jMatch6_9.setBounds(1380, 170, 12, 100);

        jMatch7_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMatch7_9);
        jMatch7_9.setBounds(1280, 270, 100, 12);

        jEaquals.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Equals.png"))); // NOI18N
        jPanel1.add(jEaquals);
        jEaquals.setBounds(900, 120, 100, 90);

        jPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Plus.png"))); // NOI18N
        jPanel1.add(jPlus);
        jPlus.setBounds(400, 110, 100, 110);

        jMinus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/Horizontal.png"))); // NOI18N
        jPanel1.add(jMinus);
        jMinus.setBounds(400, 150, 100, 30);
        jPanel1.add(jTextFieldTest);
        jTextFieldTest.setBounds(160, 380, 240, 40);

        jButton3.setText("Test");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(240, 450, 53, 23);

        jLabel1.setText("HasMatch");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(620, 370, 130, 14);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1500, 620);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuQuitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mnuQuitActionPerformed
    {//GEN-HEADEREND:event_mnuQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuQuitActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setMatches(jTextFieldTest.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jConnectRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConnectRoomActionPerformed
       if(!jRoomList.isSelectionEmpty())
       {
           //conect.rm[jRoomList.getSelectedIndex()].getIP; ka auf jeden fall sollte er hier connecten
       }
       
    }//GEN-LAST:event_jConnectRoomActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    public void setRooms(List rooms) {
        //List voller Raeume. Muss hier noch geaendert werden
        //jList1.setListData(rooms.entrySet().toArray());
        rooms.toFirst();
        while (rooms.hasAccess()) {
            lobby.addElement(((RoomModel) rooms.getObject()).getName());
            rooms.next();
        }
        rm = (RoomModel[])lobby.toArray();
        jRoomList.setModel(lobby);
       

    }

    private void createArr() {
        //Spaces
        int x = 1;
        jSpaceArr[1][x] = jSpace1_1;
        jSpaceArr[2][x] = jSpace2_1;
        jSpaceArr[3][x] = jSpace3_1;
        jSpaceArr[4][x] = jSpace4_1;
        jSpaceArr[5][x] = jSpace5_1;
        jSpaceArr[6][x] = jSpace6_1;
        jSpaceArr[7][x] = jSpace7_1;
        //**************************
        x = 2;
        jSpaceArr[1][x] = jSpace1_2;
        jSpaceArr[2][x] = jSpace2_2;
        jSpaceArr[3][x] = jSpace3_2;
        jSpaceArr[4][x] = jSpace4_2;
        jSpaceArr[5][x] = jSpace5_2;
        jSpaceArr[6][x] = jSpace6_2;
        jSpaceArr[7][x] = jSpace7_2;
        //**************************
        x = 3;
        jSpaceArr[1][x] = jSpace1_3;
        jSpaceArr[2][x] = jSpace2_3;
        jSpaceArr[3][x] = jSpace3_3;
        jSpaceArr[4][x] = jSpace4_3;
        jSpaceArr[5][x] = jSpace5_3;
        jSpaceArr[6][x] = jSpace6_3;
        jSpaceArr[7][x] = jSpace7_3;
        //**************************
        x = 4;
        jSpaceArr[1][x] = jSpace1_4;
        jSpaceArr[2][x] = jSpace2_4;
        jSpaceArr[3][x] = jSpace3_4;
        jSpaceArr[4][x] = jSpace4_4;
        jSpaceArr[5][x] = jSpace5_4;
        jSpaceArr[6][x] = jSpace6_4;
        jSpaceArr[7][x] = jSpace7_4;
        //**************************
        x = 5;
        jSpaceArr[1][x] = jSpace1_5;
        jSpaceArr[2][x] = jSpace2_5;
        jSpaceArr[3][x] = jSpace3_5;
        jSpaceArr[4][x] = jSpace4_5;
        jSpaceArr[5][x] = jSpace5_5;
        jSpaceArr[6][x] = jSpace6_5;
        jSpaceArr[7][x] = jSpace7_5;
        //**************************
        x = 6;
        jSpaceArr[1][x] = jSpace1_6;
        jSpaceArr[2][x] = jSpace2_6;
        jSpaceArr[3][x] = jSpace3_6;
        jSpaceArr[4][x] = jSpace4_6;
        jSpaceArr[5][x] = jSpace5_6;
        jSpaceArr[6][x] = jSpace6_6;
        jSpaceArr[7][x] = jSpace7_6;
        //**************************
        x = 7;
        jSpaceArr[1][x] = jSpace1_7;
        jSpaceArr[2][x] = jSpace2_7;
        jSpaceArr[3][x] = jSpace3_7;
        jSpaceArr[4][x] = jSpace4_7;
        jSpaceArr[5][x] = jSpace5_7;
        jSpaceArr[6][x] = jSpace6_7;
        jSpaceArr[7][x] = jSpace7_7;
        //**************************
        x = 8;
        jSpaceArr[1][x] = jSpace1_8;
        jSpaceArr[2][x] = jSpace2_8;
        jSpaceArr[3][x] = jSpace3_8;
        jSpaceArr[4][x] = jSpace4_8;
        jSpaceArr[5][x] = jSpace5_8;
        jSpaceArr[6][x] = jSpace6_8;
        jSpaceArr[7][x] = jSpace7_8;
        //**************************
        x = 9;
        jSpaceArr[1][x] = jSpace1_9;
        jSpaceArr[2][x] = jSpace2_9;
        jSpaceArr[3][x] = jSpace3_9;
        jSpaceArr[4][x] = jSpace4_9;
        jSpaceArr[5][x] = jSpace5_9;
        jSpaceArr[6][x] = jSpace6_9;
        jSpaceArr[7][x] = jSpace7_9;
        //**************************

        //Matches
        x = 1;
        jMatchArr[1][x] = jMatch1_1;
        jMatchArr[2][x] = jMatch2_1;
        jMatchArr[3][x] = jMatch3_1;
        jMatchArr[4][x] = jMatch4_1;
        jMatchArr[5][x] = jMatch5_1;
        jMatchArr[6][x] = jMatch6_1;
        jMatchArr[7][x] = jMatch7_1;
        //**************************
        x = 2;
        jMatchArr[1][x] = jMatch1_2;
        jMatchArr[2][x] = jMatch2_2;
        jMatchArr[3][x] = jMatch3_2;
        jMatchArr[4][x] = jMatch4_2;
        jMatchArr[5][x] = jMatch5_2;
        jMatchArr[6][x] = jMatch6_2;
        jMatchArr[7][x] = jMatch7_2;
        //**************************
        x = 3;
        jMatchArr[1][x] = jMatch1_3;
        jMatchArr[2][x] = jMatch2_3;
        jMatchArr[3][x] = jMatch3_3;
        jMatchArr[4][x] = jMatch4_3;
        jMatchArr[5][x] = jMatch5_3;
        jMatchArr[6][x] = jMatch6_3;
        jMatchArr[7][x] = jMatch7_3;
        //**************************
        x = 4;
        jMatchArr[1][x] = jMatch1_4;
        jMatchArr[2][x] = jMatch2_4;
        jMatchArr[3][x] = jMatch3_4;
        jMatchArr[4][x] = jMatch4_4;
        jMatchArr[5][x] = jMatch5_4;
        jMatchArr[6][x] = jMatch6_4;
        jMatchArr[7][x] = jMatch7_4;
        //**************************
        x = 5;
        jMatchArr[1][x] = jMatch1_5;
        jMatchArr[2][x] = jMatch2_5;
        jMatchArr[3][x] = jMatch3_5;
        jMatchArr[4][x] = jMatch4_5;
        jMatchArr[5][x] = jMatch5_5;
        jMatchArr[6][x] = jMatch6_5;
        jMatchArr[7][x] = jMatch7_5;
        //**************************
        x = 6;
        jMatchArr[1][x] = jMatch1_6;
        jMatchArr[2][x] = jMatch2_6;
        jMatchArr[3][x] = jMatch3_6;
        jMatchArr[4][x] = jMatch4_6;
        jMatchArr[5][x] = jMatch5_6;
        jMatchArr[6][x] = jMatch6_6;
        jMatchArr[7][x] = jMatch7_6;
        //**************************
        x = 7;
        jMatchArr[1][x] = jMatch1_7;
        jMatchArr[2][x] = jMatch2_7;
        jMatchArr[3][x] = jMatch3_7;
        jMatchArr[4][x] = jMatch4_7;
        jMatchArr[5][x] = jMatch5_7;
        jMatchArr[6][x] = jMatch6_7;
        jMatchArr[7][x] = jMatch7_7;
        //**************************
        x = 8;
        jMatchArr[1][x] = jMatch1_8;
        jMatchArr[2][x] = jMatch2_8;
        jMatchArr[3][x] = jMatch3_8;
        jMatchArr[4][x] = jMatch4_8;
        jMatchArr[5][x] = jMatch5_8;
        jMatchArr[6][x] = jMatch6_8;
        jMatchArr[7][x] = jMatch7_8;
        //**************************
        x = 9;
        jMatchArr[1][x] = jMatch1_9;
        jMatchArr[2][x] = jMatch2_9;
        jMatchArr[3][x] = jMatch3_9;
        jMatchArr[4][x] = jMatch4_9;
        jMatchArr[5][x] = jMatch5_9;
        jMatchArr[6][x] = jMatch6_9;
        jMatchArr[7][x] = jMatch7_9;
        //**************************

    }

    private void resetView() {
        jPlus.setVisible(false);
        jMinus.setVisible(false);
        jEaquals.setVisible(false);
        for (int i = 1; i < 10; i++) {
            for (int y = 1; y < 8; y++) {
                jSpaceArr[y][i].setVisible(true);
                //jMatchArr[y][i].setVisible(true); 
            }
        }

    }

    private void setMatches(String pEaquasion) {
        resetView();
        List lGleichung = MatchUtility.equationToMatch(pEaquasion);
        boolean[] lCode;
        int ZahlIndex = 1;
        lGleichung.toFirst();
        while (lGleichung.hasAccess()) {

            if ((lGleichung.getObject() instanceof Zahl)) {
                lCode = ((Zahl) lGleichung.getObject()).getZahlCode();
                for (int i = 1; i <= 7; i++) {
                    jSpaceArr[i][ZahlIndex].setVisible(!lCode[i - 1]);
                }
                ZahlIndex++;
            } else if ((char) lGleichung.getObject() == '*') {
                ZahlIndex++;

            } else if ((char) lGleichung.getObject() == '-') {
                jMinus.setVisible(true);
            } else if ((char) lGleichung.getObject() == '+') {
                jPlus.setVisible(true);
            }
            lGleichung.next();
        }
        jEaquals.setVisible(true);
    }

    private void initEvents() {
        for (int i = 1; i < 10; i++) {
            for (int y = 1; y < 8; y++) {
                JLabel curLabel = this.jMatchArr[y][i];
                int x = i;
                int z = y;
                if (curLabel != null) {
                    curLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            matchClicked(evt, x, z);
                        }
                    });
                }
            }
        }
    }

    private void initEvents2() {
        for (int i = 1; i < 10; i++) {
            for (int y = 1; y < 8; y++) {
                JLabel curLabel = this.jSpaceArr[y][i];
                int x = i;
                int z = y;
                if (curLabel != null) {
                    curLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            spaceClicked(evt, x, z);
                        }
                    });
                }
            }
        }
    }

    private void matchClicked(java.awt.event.MouseEvent evt, int x, int y) {
        if (!hasMatch) {
            jSpaceArr[y][x].setVisible(true);

            hasMatch = true;

            jLabel1.setText("HasMatch true");
        }
    }

    private void spaceClicked(java.awt.event.MouseEvent evt, int x, int y) {
        if (hasMatch) {
            jSpaceArr[y][x].setVisible(false);

            hasMatch = false;

            jLabel1.setText("HasMatch false");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jConnectRoom;
    private javax.swing.JLabel jEaquals;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jMatch1_1;
    private javax.swing.JLabel jMatch1_2;
    private javax.swing.JLabel jMatch1_3;
    private javax.swing.JLabel jMatch1_4;
    private javax.swing.JLabel jMatch1_5;
    private javax.swing.JLabel jMatch1_6;
    private javax.swing.JLabel jMatch1_7;
    private javax.swing.JLabel jMatch1_8;
    private javax.swing.JLabel jMatch1_9;
    private javax.swing.JLabel jMatch2_1;
    private javax.swing.JLabel jMatch2_2;
    private javax.swing.JLabel jMatch2_3;
    private javax.swing.JLabel jMatch2_4;
    private javax.swing.JLabel jMatch2_5;
    private javax.swing.JLabel jMatch2_6;
    private javax.swing.JLabel jMatch2_7;
    private javax.swing.JLabel jMatch2_8;
    private javax.swing.JLabel jMatch2_9;
    private javax.swing.JLabel jMatch3_1;
    private javax.swing.JLabel jMatch3_2;
    private javax.swing.JLabel jMatch3_3;
    private javax.swing.JLabel jMatch3_4;
    private javax.swing.JLabel jMatch3_5;
    private javax.swing.JLabel jMatch3_6;
    private javax.swing.JLabel jMatch3_7;
    private javax.swing.JLabel jMatch3_8;
    private javax.swing.JLabel jMatch3_9;
    private javax.swing.JLabel jMatch4_1;
    private javax.swing.JLabel jMatch4_2;
    private javax.swing.JLabel jMatch4_3;
    private javax.swing.JLabel jMatch4_4;
    private javax.swing.JLabel jMatch4_5;
    private javax.swing.JLabel jMatch4_6;
    private javax.swing.JLabel jMatch4_7;
    private javax.swing.JLabel jMatch4_8;
    private javax.swing.JLabel jMatch4_9;
    private javax.swing.JLabel jMatch5_1;
    private javax.swing.JLabel jMatch5_2;
    private javax.swing.JLabel jMatch5_3;
    private javax.swing.JLabel jMatch5_4;
    private javax.swing.JLabel jMatch5_5;
    private javax.swing.JLabel jMatch5_6;
    private javax.swing.JLabel jMatch5_7;
    private javax.swing.JLabel jMatch5_8;
    private javax.swing.JLabel jMatch5_9;
    private javax.swing.JLabel jMatch6_1;
    private javax.swing.JLabel jMatch6_2;
    private javax.swing.JLabel jMatch6_3;
    private javax.swing.JLabel jMatch6_4;
    private javax.swing.JLabel jMatch6_5;
    private javax.swing.JLabel jMatch6_6;
    private javax.swing.JLabel jMatch6_7;
    private javax.swing.JLabel jMatch6_8;
    private javax.swing.JLabel jMatch6_9;
    private javax.swing.JLabel jMatch7_1;
    private javax.swing.JLabel jMatch7_2;
    private javax.swing.JLabel jMatch7_3;
    private javax.swing.JLabel jMatch7_4;
    private javax.swing.JLabel jMatch7_5;
    private javax.swing.JLabel jMatch7_6;
    private javax.swing.JLabel jMatch7_7;
    private javax.swing.JLabel jMatch7_8;
    private javax.swing.JLabel jMatch7_9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel jMinus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelIntro;
    private javax.swing.JLabel jPlus;
    private javax.swing.JList jRoomList;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jSpace1_1;
    private javax.swing.JLabel jSpace1_2;
    private javax.swing.JLabel jSpace1_3;
    private javax.swing.JLabel jSpace1_4;
    private javax.swing.JLabel jSpace1_5;
    private javax.swing.JLabel jSpace1_6;
    private javax.swing.JLabel jSpace1_7;
    private javax.swing.JLabel jSpace1_8;
    private javax.swing.JLabel jSpace1_9;
    private javax.swing.JLabel jSpace2_1;
    private javax.swing.JLabel jSpace2_2;
    private javax.swing.JLabel jSpace2_3;
    private javax.swing.JLabel jSpace2_4;
    private javax.swing.JLabel jSpace2_5;
    private javax.swing.JLabel jSpace2_6;
    private javax.swing.JLabel jSpace2_7;
    private javax.swing.JLabel jSpace2_8;
    private javax.swing.JLabel jSpace2_9;
    private javax.swing.JLabel jSpace3_1;
    private javax.swing.JLabel jSpace3_2;
    private javax.swing.JLabel jSpace3_3;
    private javax.swing.JLabel jSpace3_4;
    private javax.swing.JLabel jSpace3_5;
    private javax.swing.JLabel jSpace3_6;
    private javax.swing.JLabel jSpace3_7;
    private javax.swing.JLabel jSpace3_8;
    private javax.swing.JLabel jSpace3_9;
    private javax.swing.JLabel jSpace4_1;
    private javax.swing.JLabel jSpace4_2;
    private javax.swing.JLabel jSpace4_3;
    private javax.swing.JLabel jSpace4_4;
    private javax.swing.JLabel jSpace4_5;
    private javax.swing.JLabel jSpace4_6;
    private javax.swing.JLabel jSpace4_7;
    private javax.swing.JLabel jSpace4_8;
    private javax.swing.JLabel jSpace4_9;
    private javax.swing.JLabel jSpace5_1;
    private javax.swing.JLabel jSpace5_2;
    private javax.swing.JLabel jSpace5_3;
    private javax.swing.JLabel jSpace5_4;
    private javax.swing.JLabel jSpace5_5;
    private javax.swing.JLabel jSpace5_6;
    private javax.swing.JLabel jSpace5_7;
    private javax.swing.JLabel jSpace5_8;
    private javax.swing.JLabel jSpace5_9;
    private javax.swing.JLabel jSpace6_1;
    private javax.swing.JLabel jSpace6_2;
    private javax.swing.JLabel jSpace6_3;
    private javax.swing.JLabel jSpace6_4;
    private javax.swing.JLabel jSpace6_5;
    private javax.swing.JLabel jSpace6_6;
    private javax.swing.JLabel jSpace6_7;
    private javax.swing.JLabel jSpace6_8;
    private javax.swing.JLabel jSpace6_9;
    private javax.swing.JLabel jSpace7_1;
    private javax.swing.JLabel jSpace7_2;
    private javax.swing.JLabel jSpace7_3;
    private javax.swing.JLabel jSpace7_4;
    private javax.swing.JLabel jSpace7_5;
    private javax.swing.JLabel jSpace7_6;
    private javax.swing.JLabel jSpace7_7;
    private javax.swing.JLabel jSpace7_8;
    private javax.swing.JLabel jSpace7_9;
    private javax.swing.JTextField jTextFieldTest;
    private javax.swing.JMenu mnuCon;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JMenuItem mnuQuit;
    // End of variables declaration//GEN-END:variables

}
