package de.matchbox.client.forms;

import de.matchbox.client.Zahl;
import de.matchbox.client.forms.models.RoomFormModel;
import de.matchbox.client.forms.usercontrols.PlayerControl;
import de.matchbox.client.utility.Konami;
import de.matchbox.client.utility.MatchUtility;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.classmodels.PlayerModel;
import de.matchbox.communication.contentobjects.RoomCommandContentObject;
import de.matchbox.communication.contentobjects.roomcommands.EquasionContentObject;
import de.matchbox.communication.contentobjects.roomcommands.IRoomCommandContentObject;
import de.matchbox.communication.contentobjects.roomcommands.MessageContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.CheckEquasionResultContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.EquasionSolvedContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.ListPlayerContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.PlayerWonContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.ServerMessageContentObject;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.communication.enumeration.RoomCommand;
import de.matchbox.communication.shared.abiturklassen.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class FrmRoom extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel jMatchArr[][];
    private JLabel jSpaceArr[][];
    private final RoomFormModel roomFormModel;
    private int hasMatch;
    private String gleichung;
    private Timer timer;
    private StyledDocument ChatStyledDocument;

    public FrmRoom(RoomFormModel pRoomFormModel) {
        this.roomFormModel = pRoomFormModel;
        this.initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/de/matchbox/client/Resources/icon.png")));
        this.jMatchArr = new JLabel[8][10];
        this.jSpaceArr = new JLabel[8][10];
        this.createArr();
        this.resetView();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.initEvents();
        this.initEvents2();
        this.Rekt.setVisible(false);
        this.jLabelScope.setVisible(false);
        this.hasMatch = 0;
        this.gleichung = "";
        this.newEquasion();
        this.timer = new Timer(1420, taskPerformer);
        this.jButtonCheck.setOpaque(false);
        this.jButtonReset.setOpaque(false);
        this.jButtonSend.setOpaque(false);
        this.jLabelMatchStatus.setText("You have " + hasMatch + " matches");
        this.ChatStyledDocument = (StyledDocument) jTextPaneChat.getDocument();
        this.jTextPaneChat.setEditable(false);

    }
    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            jLabelBackground.setIcon(null);
            jLabelScope.setVisible(false);
            Rekt.setVisible(false);
            timer.stop();
        }
    };

    public void initMLG() {
        if (this.roomFormModel.konamiisak()) {

            this.jLabelScope.setVisible(this.roomFormModel.konamiisak());
            this.Rekt.setVisible(this.roomFormModel.konamiisak());
            jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/MLGBackground.jpg")));
            timer.start();
        }

    }

    public void newEquasion() {
        this.hasMatch = 0;
        jLabelInfo.setText("Solve it!");
        this.jLabelMatchStatus.setText("You have " + hasMatch + " matches");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
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
        jLabelScope = new javax.swing.JLabel();
        jButtonCheck = new javax.swing.JButton();
        jLabelInfo = new javax.swing.JLabel();
        Rekt = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jPanelPlayer = new javax.swing.JPanel();
        jLabelBackground = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextFieldSend = new javax.swing.JTextField();
        jButtonSend = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneChat = new javax.swing.JTextPane();
        jLabelMatchStatus = new javax.swing.JLabel();
        mnuMain = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuQuit = new javax.swing.JMenuItem();
        mnuCon = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MatchBox");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1413, 620));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
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

        jLabelScope.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/photo.jpg.gif"))); // NOI18N
        jPanel1.add(jLabelScope);
        jLabelScope.setBounds(360, 280, 282, 281);

        jButtonCheck.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCheck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCheck.setText("Check");
        jButtonCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCheck);
        jButtonCheck.setBounds(420, 390, 80, 60);

        jLabelInfo.setFont(new java.awt.Font("Meiryo", 0, 18)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInfo.setText("HasMatch");
        jPanel1.add(jLabelInfo);
        jLabelInfo.setBounds(60, 330, 430, 70);

        Rekt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/matchbox/client/Resources/R3KT.gif"))); // NOI18N
        jPanel1.add(Rekt);
        Rekt.setBounds(580, 360, 500, 200);

        jButtonReset.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonReset);
        jButtonReset.setBounds(330, 390, 80, 60);
        jPanel1.add(jPanelPlayer);
        jPanelPlayer.setBounds(1110, 290, 270, 280);

        jLabelBackground.setBackground(new java.awt.Color(204, 204, 204));
        jLabelBackground.setMinimumSize(new java.awt.Dimension(1500, 610));
        jPanel1.add(jLabelBackground);
        jLabelBackground.setBounds(0, 0, 1410, 610);

        jTextFieldSend.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSendKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTextFieldSend);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(550, 520, 490, 40);

        jButtonSend.setText("Send");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSend);
        jButtonSend.setBounds(1040, 520, 60, 40);

        jScrollPane3.setViewportView(jTextPaneChat);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(550, 290, 550, 230);

        jLabelMatchStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMatchStatus.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelMatchStatus);
        jLabelMatchStatus.setBounds(40, 440, 500, 80);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1500, 620);

        mnuFile.setText("File");

        mnuQuit.setText("Exit");
        mnuQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuQuitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuQuit);

        mnuMain.add(mnuFile);

        mnuCon.setText("Conection");

        jMenuItem1.setText("Leave the Room");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuCon.add(jMenuItem1);

        mnuMain.add(mnuCon);

        setJMenuBar(mnuMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuQuitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mnuQuitActionPerformed
    {//GEN-HEADEREND:event_mnuQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuQuitActionPerformed

    private void jButtonCheckActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCheckActionPerformed
    {//GEN-HEADEREND:event_jButtonCheckActionPerformed
        if (hasMatch == 1) {
            jLabelInfo.setText("Place you Match before Checking");
        } else if (this.areNummbers()) {
            roomFormModel.send(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.CHECK_EQUASION, new EquasionContentObject(MatchUtility.matchToEquation(this.convertToList())))));
        } else {
            jLabelInfo.setText("Some matches are not Nummbers");
        }

    }//GEN-LAST:event_jButtonCheckActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        this.setMatches(gleichung);
        hasMatch = 0;
        jLabelInfo.setText("Solve it!");
        jLabelMatchStatus.setText("You have " + hasMatch + " matches");


    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        roomFormModel.send(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.LEAVE_ROOM)));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        //sende Nachricht an den server
        roomFormModel.send(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.MESSAGE, new MessageContentObject(this.jTextFieldSend.getText()))));
        jTextFieldSend.setText("");
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jTextFieldSendKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSendKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            roomFormModel.send(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.MESSAGE, new MessageContentObject(this.jTextFieldSend.getText()))));
            jTextFieldSend.setText("");
        }
    }//GEN-LAST:event_jTextFieldSendKeyPressed

    public void reciveMassage(IRoomCommandContentObject pCommandObject) {
        StyleContext context = new StyleContext();
        Style style = context.addStyle("test", null);
        try {
            if (!(pCommandObject instanceof ServerMessageContentObject)) {
                return;
            }

            String chatVerlauf = ChatStyledDocument.getText(0, ChatStyledDocument.getLength());
            if (chatVerlauf.indexOf(':') != -1) {

                if (((chatVerlauf.substring(chatVerlauf.lastIndexOf(">") + 1, chatVerlauf.lastIndexOf(":"))).equals(((ServerMessageContentObject) pCommandObject).getUsername()))) {

                    StyleConstants.setForeground(style, Color.BLACK);
                    this.ChatStyledDocument.insertString(ChatStyledDocument.getLength(), "\t" + ((ServerMessageContentObject) pCommandObject).getMessage() + "\n", style);

                } else {
                    StyleConstants.setForeground(style, Color.BLACK);
                    this.ChatStyledDocument.insertString(ChatStyledDocument.getLength(), ">", style);
                    StyleConstants.setForeground(style, Color.ORANGE);
                    this.ChatStyledDocument.insertString(ChatStyledDocument.getLength(), ((ServerMessageContentObject) pCommandObject).getUsername(), style);
                    StyleConstants.setForeground(style, Color.BLACK);
                    this.ChatStyledDocument.insertString(ChatStyledDocument.getLength(), ":\t" + ((ServerMessageContentObject) pCommandObject).getMessage() + "\n", style);
                }
            } else {
                StyleConstants.setForeground(style, Color.BLACK);
                this.ChatStyledDocument.insertString(ChatStyledDocument.getLength(), ">", style);
                StyleConstants.setForeground(style, Color.ORANGE);
                this.ChatStyledDocument.insertString(ChatStyledDocument.getLength(), ((ServerMessageContentObject) pCommandObject).getUsername(), style);
                StyleConstants.setForeground(style, Color.BLACK);
                this.ChatStyledDocument.insertString(ChatStyledDocument.getLength(), ":\t" + ((ServerMessageContentObject) pCommandObject).getMessage() + "\n", style);
            }
        } catch (BadLocationException ex) {
            StyleConstants.setForeground(style, Color.RED);
            jTextPaneChat.setText("An Error Occurred while inserting Message");

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

            if (this.isEmpty(i)) {
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

    private boolean isEmpty(int index) {
        for (int i = 1; i < 8; i++) {
            if (jMatchArr[i][index].isVisible()) {
                return false;
            }
        }
        return true;
    }

    private boolean isBlank(int index) {
        for (int i = 1; i < 8; i++) {
            if (jSpaceArr[i][index].isVisible()) {
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

    private void setPlayerList(List pList) {
        Box lPlayerBox = Box.createVerticalBox();

        pList.toFirst();
        while (pList.hasAccess()) {
            PlayerControl lPlayerControl = new PlayerControl((PlayerModel) pList.getObject());
            lPlayerControl.setAlignmentX(0.5F);
            lPlayerControl.setMaximumSize(new Dimension(210, 35));
            lPlayerBox.add(lPlayerControl);
            pList.next();
        }

        this.jPanelPlayer.removeAll();
        this.jPanelPlayer.setLayout(new GridLayout(1, 1));
        this.jPanelPlayer.add(lPlayerBox);
        this.jPanelPlayer.updateUI();
    }

    public void setPlayerList(IRoomCommandContentObject pCommandObject) {
        if (!(pCommandObject instanceof ListPlayerContentObject)) {
            return;
        }

        this.setPlayerList(((ListPlayerContentObject) pCommandObject).getPlayer());
    }

    public void onEquasionSolved(IRoomCommandContentObject pCommandObject, String pMyUsername) {
        if (!(pCommandObject instanceof EquasionSolvedContentObject)) {
            return;
        }

        EquasionSolvedContentObject lContentObject = (EquasionSolvedContentObject) pCommandObject;
        if (lContentObject.getUsername().equals(pMyUsername)) {
            JOptionPane.showMessageDialog(null, "Well done, You Solved it!", "Good Job!", JOptionPane.INFORMATION_MESSAGE);
            jLabelInfo.setText("Solve It!");
        } else if (!lContentObject.getUsername().equals(pMyUsername)) {
            JOptionPane.showMessageDialog(null, "Equasion solved by " + lContentObject.getUsername() + ". Try the next one", "Too Slow", JOptionPane.INFORMATION_MESSAGE);
        }

        this.setPlayerList(lContentObject.getPlayerList());
    }

    public void setEquasion(RoomCommandContentObject pCommandObject) {

        this.gleichung = ((EquasionContentObject) (pCommandObject.getContentObject())).getEquasion();
        this.setMatches(gleichung);
    }

    public void onCheckedEquasion(RoomCommandContentObject pCommandObject) {
        if (((CheckEquasionResultContentObject) pCommandObject.getContentObject()).isEquasionCorrect()) {
            jLabelInfo.setText("Well Done! Correct");
            this.initMLG();
        } else {
            jLabelInfo.setText("Equasion is Wrong, try again");
        }
    }

    public void onPlayerWon(IRoomCommandContentObject pCommandObject) {
        if (!(pCommandObject instanceof PlayerWonContentObject)) {
            return;
        }
        JOptionPane.showMessageDialog(null, "Player " + ((PlayerWonContentObject) pCommandObject).getUsername() + " Won the Game", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
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
                jMatchArr[y][i].setVisible(true);
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
                for (int i = 1; i <= 7; i++) {
                    jSpaceArr[i][ZahlIndex].setVisible(false);
                    jMatchArr[i][ZahlIndex].setVisible(false);
                }
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
        if (hasMatch == 0) {
            jSpaceArr[y][x].setVisible(true);

            hasMatch = 1;

            jLabelMatchStatus.setText("You have " + hasMatch + " matches");
        } else if (hasMatch == 2) {

            jLabelMatchStatus.setText("<html>You have already moved your match.<br>Press \"reset\" to be able to make changes</html>");
        } else {
            jLabelInfo.setText("You are only allowed to move 1 Match. Click reset to restart");
        }
    }

    private void spaceClicked(java.awt.event.MouseEvent evt, int x, int y) {
        if (hasMatch == 1) {
            jSpaceArr[y][x].setVisible(false);

            hasMatch = 2;

            jLabelMatchStatus.setText("You moved the Match");
        } else {
            jLabelInfo.setText("You have no Matches");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Rekt;
    private javax.swing.JButton jButtonCheck;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jEaquals;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelMatchStatus;
    private javax.swing.JLabel jLabelScope;
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel jMinus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelPlayer;
    private javax.swing.JLabel jPlus;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTextField jTextFieldSend;
    private javax.swing.JTextPane jTextPaneChat;
    private javax.swing.JMenu mnuCon;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JMenuItem mnuQuit;
    // End of variables declaration//GEN-END:variables

}
