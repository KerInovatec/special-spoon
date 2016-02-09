package de.matchbox.client.forms;

import de.matchbox.client.Control;
import de.matchbox.client.Zahl;
import de.matchbox.client.forms.models.RoomFormModel;
import de.matchbox.client.utility.MatchUtility;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.contentobjects.RoomCommandContentObject;
import de.matchbox.communication.contentobjects.roomcommands.EquasionContentObject;
import de.matchbox.communication.contentobjects.roomcommands.IRoomCommandContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.CheckEquasionResultContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.ListPlayerContentObject;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.communication.enumeration.RoomCommand;
import de.matchbox.communication.shared.abiturklassen.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class FrmRoom extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel jMatchArr[][];
    private JLabel jSpaceArr[][];
    private final RoomFormModel roomFormModel;
    private boolean hasMatch;
    private DefaultListModel playerListModel;
    private String gleichung;
    private Timer timer;
    private int secondsPassed;

    public FrmRoom(RoomFormModel pRoomFormModel) {
        this.roomFormModel = pRoomFormModel;
        this.initComponents();
        this.playerListModel = new DefaultListModel();
        this.jPlayerListIngame.setModel(this.playerListModel);
        this.jMatchArr = new JLabel[8][10];
        this.jSpaceArr = new JLabel[8][10];
        this.createArr();
        this.resetView();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.initEvents();
        this.initEvents2();
        this.hasMatch = false;
        this.gleichung = "";
        this.jProgressBar1.setMinimum(0);
        this.jProgressBar1.setMaximum(100);
        this.secondsPassed = 0;
        this.timer = new Timer(1000, (ActionEvent e)
                -> {
            this.jProgressBar1.setValue(this.jProgressBar1.getMaximum() - this.secondsPassed);
            this.secondsPassed++;
            if (this.secondsPassed == this.jProgressBar1.getMaximum()) {
                this.timer.stop();
                JOptionPane.showMessageDialog(null, "Du hast versagt.", "titel", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPlayerListIngame = new javax.swing.JList();
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
        jLabelInfo = new javax.swing.JLabel();
        jButtonCheck = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jScrollPane1.setViewportView(jPlayerListIngame);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(1270, 340, 230, 270);

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

        jTextFieldTest.setText("123+456=789");
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

        jLabelInfo.setText("HasMatch");
        jPanel1.add(jLabelInfo);
        jLabelInfo.setBounds(620, 370, 290, 70);

        jButtonCheck.setText("Check");
        jButtonCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCheck);
        jButtonCheck.setBounds(460, 450, 61, 23);

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(340, 460, 61, 23);
        jPanel1.add(jProgressBar1);
        jProgressBar1.setBounds(0, 584, 1270, 30);

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
//        this.setMatches(jTextFieldTest.getText());
        roomFormModel.send(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.REQUEST_EQUASION)));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonCheckActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCheckActionPerformed
    {//GEN-HEADEREND:event_jButtonCheckActionPerformed
        if (this.areNummbers()) {
            roomFormModel.send(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.CHECK_EQUASION, new EquasionContentObject(MatchUtility.matchToEquation(this.convertToList())))));
        } else {
            jLabelInfo.setText("Nicht alle Zeichen sind Zahlen");
        }

    }//GEN-LAST:event_jButtonCheckActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setMatches(gleichung);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void verarbeite(RoomCommandContentObject pCommandObject) {
        switch (pCommandObject.getCommand()) {
            case LIST_PLAYER:
                this.setPlayerList(pCommandObject.getContentObject());
                break;
            case REQUEST_EQUASION:
                this.hasMatch = false;
                gleichung = ((EquasionContentObject) (pCommandObject.getContentObject())).getEquasion();
                this.setMatches(gleichung);
                break;
            case CHECK_EQUASION:
                if (((CheckEquasionResultContentObject) pCommandObject.getContentObject()).isEquasionCorrect()) {
                    jLabelInfo.setText("Gut Gemacht ist Richtig!");
                } else {
                    jLabelInfo.setText("Schlecht gemacht ist Falsch");
                }
                timer.stop();
                break;

        }

    }

    private List convertToList() {
        List ausgabe = new List();
        boolean[] zahlCode;
        Zahl pZahl = new Zahl();
        for (int i = 1; i < 10; i++) {

            zahlCode = new boolean[]{
                !jSpaceArr[1][i].isVisible(), !jSpaceArr[2][i].isVisible(), !jSpaceArr[3][i].isVisible(), !jSpaceArr[4][i].isVisible(), !jSpaceArr[5][i].isVisible(), !jSpaceArr[6][i].isVisible(), !jSpaceArr[7][i].isVisible()
            };

            pZahl = new Zahl();
            pZahl.setZahlCode(zahlCode);

            if (this.isBlank(i)) {
                ausgabe.append('*');
            } else {
                ausgabe.append(pZahl);
            }
            if (i == 3) {
                if (jPlus.isVisible()) {
                    ausgabe.append('+');
                } else {
                    ausgabe.append('-');
                }
            } else if (i == 6) {
                ausgabe.append('=');
            }

        }
        return ausgabe;
    }

    private boolean isBlank(int index) {
        for (int i = 1; i < 8; i++) {
            if (!jSpaceArr[i][index].isVisible()) {
                return false;
            }
        }
        return true;
    }

    private boolean areNummbers() {
        boolean[] zahlCode;

        Zahl pZahl = new Zahl();
        for (int i = 1; i < 10; i++) {

            zahlCode = new boolean[]{
                !jSpaceArr[1][i].isVisible(), !jSpaceArr[2][i].isVisible(), !jSpaceArr[3][i].isVisible(), !jSpaceArr[4][i].isVisible(), !jSpaceArr[5][i].isVisible(), !jSpaceArr[6][i].isVisible(), !jSpaceArr[7][i].isVisible()
            };
            pZahl = new Zahl();
            pZahl.setZahlCode(zahlCode);

            if (!pZahl.isNumber()) {
                if (!isBlank(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setPlayerList(IRoomCommandContentObject pRoomCommandContentObject) {
        if (!(pRoomCommandContentObject instanceof ListPlayerContentObject)) {
            return;
        }

        this.playerListModel.clear();
        List lList = ((ListPlayerContentObject) pRoomCommandContentObject).getPlayer();
        lList.toFirst();
        while (lList.hasAccess()) {
            this.playerListModel.addElement(lList.getObject());
            lList.next();
        }
    }

    public void setEquasion(RoomCommandContentObject pCommandObject) {
        this.hasMatch = false;
        this.gleichung = ((EquasionContentObject) (pCommandObject.getContentObject())).getEquasion();
        this.setMatches(gleichung);
    }

    public void onCheckedEquasion(RoomCommandContentObject pCommandObject) {
        if (((CheckEquasionResultContentObject) pCommandObject.getContentObject()).isEquasionCorrect()) {
            jLabelInfo.setText("Gut Gemacht ist Richtig!");
        } else {
            jLabelInfo.setText("Schlecht gemacht ist Falsch");
        }
        timer.stop();
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
                jSpaceArr[y][i].setVisible(true); //jMatchArr[y][i].setVisible(true);
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
        timer.stop();
        secondsPassed = 0;
        jProgressBar1.setValue(jProgressBar1.getMaximum());
        timer.restart();
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

            jLabelInfo.setText("HasMatch true");
        }
    }

    private void spaceClicked(java.awt.event.MouseEvent evt, int x, int y) {
        if (hasMatch) {
            jSpaceArr[y][x].setVisible(false);

            hasMatch = false;

            jLabelInfo.setText("HasMatch false");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonCheck;
    private javax.swing.JLabel jEaquals;
    private javax.swing.JLabel jLabelInfo;
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
    private javax.swing.JList jPlayerListIngame;
    private javax.swing.JLabel jPlus;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
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