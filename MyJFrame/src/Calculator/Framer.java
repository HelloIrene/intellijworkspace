package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Framer extends JFrame {
    private static final long serialVersionUID = -1798822481105277917L;

    private JMenuBar bar;
    // 菜单
    private JMenu menuEdit;
    private JMenu subMenuEdit;
    private JMenu menuHelp;
    // 菜单项
    private JMenuItem copy;
    private JMenuItem paste;
    private JMenuItem help;
    private JMenuItem aboutCal;
    private JMenuItem copyHis;
    private JMenuItem edit;
    private JMenuItem delEdit;
    private JMenuItem del;
    private JPanel jPanel;
    private JTextField jTextField;
    private JButton btnMC;
    private JButton btnMR;
    private JButton btnMS;
    private JButton btnMPlus;
    private JButton btnMpp;
    private JButton btnesc;
    private JButton btnCE;
    private JButton btnC;
    private JButton btnRt;
    private JButton btnsprt;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn0;
    private JButton btndot;
    private JButton btnPlus;
    private JButton btnjian;
    private JButton btncheng;
    private JButton btnchu;
    private JButton btnbaifenhao;
    private JButton btnxfenzhiyi;
    private JButton btndenghao;

    public Framer() {
        menuEdit = new JMenu("编辑(E)");
        menuEdit.setMnemonic('E');
        menuHelp = new JMenu("帮助(H)");
        menuHelp.setMnemonic('H');
        subMenuEdit = new JMenu("历史记录");

        copy = new JMenuItem("复制(C)");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        paste = new JMenuItem("粘贴(P)");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        help = new JMenuItem("查看帮助(V)");
        help.setAccelerator(KeyStroke.getKeyStroke("F1"));
        aboutCal = new JMenuItem("关于计算器(A)");
        copyHis = new JMenuItem("复制历史记录(I)");
        edit = new JMenuItem("编辑(E)");
        edit.setAccelerator(KeyStroke.getKeyStroke("F2"));
        delEdit = new JMenuItem("取消编辑(N)");
        delEdit.setAccelerator(KeyStroke.getKeyStroke("ESCAPE"));
        del = new JMenuItem("清除(L)");
        del.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK));

        subMenuEdit.add(copyHis);
        subMenuEdit.add(edit);
        subMenuEdit.add(delEdit);
        subMenuEdit.add(del);

        menuEdit.add(copy);
        menuEdit.add(paste);
        menuEdit.addSeparator();
        menuEdit.add(subMenuEdit);

        menuHelp.add(help);
        menuHelp.addSeparator();
        menuHelp.add(aboutCal);

        bar = new JMenuBar();
        bar.add(menuEdit);
        bar.add(menuHelp);

        jTextField = new JTextField("0");
        jTextField.setHorizontalAlignment(JTextField.RIGHT);
        jTextField.setBounds(10, 10, 295, 30);

        btnMC = new JButton("MC");
        btnMC.setBounds(10, 45, 55, 30);
        btnMR = new JButton("MR");
        btnMR.setBounds(70, 45, 55, 30);
        btnMS = new JButton("MS");
        btnMS.setBounds(130, 45, 55, 30);
        btnMPlus = new JButton("M+");
        btnMPlus.setBounds(190, 45, 55, 30);
        btnMpp = new JButton("M-");
        btnMpp.setBounds(250, 45, 55, 30);

        btnesc = new JButton("←");
        btnesc.setBounds(10, 80, 55, 30);
        btnCE = new JButton("CE");
        btnCE.setBounds(70, 80, 55, 30);
        btnC = new JButton("C");
        btnC.setBounds(130, 80, 55, 30);
        btnRt = new JButton("±");
        btnRt.setBounds(190, 80, 55, 30);
        btnsprt = new JButton("√");
        btnsprt.setBounds(250, 80, 55, 30);

        btn7 = new JButton("7");
        btn7.setBounds(10, 115, 55, 30);
        btn8 = new JButton("8");
        btn8.setBounds(70, 115, 55, 30);
        btn9 = new JButton("9");
        btn9.setBounds(130, 115, 55, 30);
        btnchu = new JButton("/");
        btnchu.setBounds(190, 115, 55, 30);
        btnbaifenhao = new JButton("%");
        btnbaifenhao.setBounds(250, 115, 55, 30);

        btn4 = new JButton("4");
        btn4.setBounds(10, 150, 55, 30);
        btn5 = new JButton("5");
        btn5.setBounds(70, 150, 55, 30);
        btn6 = new JButton("6");
        btn6.setBounds(130, 150, 55, 30);
        btncheng = new JButton("*");
        btncheng.setBounds(190, 150, 55, 30);
        btnxfenzhiyi = new JButton("1/x");
        btnxfenzhiyi.setBounds(250, 150, 55, 30);

        btn1 = new JButton("1");
        btn1.setBounds(10, 185, 55, 30);
        btn2 = new JButton("2");
        btn2.setBounds(70, 185, 55, 30);
        btn3 = new JButton("3");
        btn3.setBounds(130, 185, 55, 30);
        btnjian = new JButton("-");
        btnjian.setBounds(190, 185, 55, 30);
        btndenghao = new JButton("=");
        btndenghao.setBounds(250, 185, 55, 65);

        btn0 = new JButton("0");
        btn0.setBounds(10, 220, 115, 30);
        btndot = new JButton(".");
        btndot.setBounds(130, 220, 55, 30);
        btnPlus = new JButton("+");
        btnPlus.setBounds(190, 220, 55, 30);

        jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.add(jTextField);
        jPanel.add(btnMC);
        jPanel.add(btnMR);
        jPanel.add(btnMS);
        jPanel.add(btnMPlus);
        jPanel.add(btnMpp);
        jPanel.add(btnesc);
        jPanel.add(btnCE);
        jPanel.add(btnC);
        jPanel.add(btnRt);
        jPanel.add(btnsprt);
        jPanel.add(btn7);
        jPanel.add(btn8);
        jPanel.add(btn9);
        jPanel.add(btnchu);
        jPanel.add(btnbaifenhao);
        jPanel.add(btn4);
        jPanel.add(btn5);
        jPanel.add(btn6);
        jPanel.add(btncheng);
        jPanel.add(btnxfenzhiyi);
        jPanel.add(btn1);
        jPanel.add(btn2);
        jPanel.add(btn3);
        jPanel.add(btnjian);
        jPanel.add(btndenghao);
        jPanel.add(btn0);
        jPanel.add(btndot);
        jPanel.add(btnPlus);

        this.add(bar, BorderLayout.NORTH);
        this.add(jPanel, BorderLayout.CENTER);

        initFrame();
    }
    private void initFrame() {
        this.setSize(320, 310);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("计算器");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("img/calculate_32.png");
        this.setIconImage(img);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
