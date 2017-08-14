package Calculator2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {
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
    private String[] name = {"编辑(E)", "帮助(H)", "历史记录"
            , "复制(C)", "粘贴(P)"
            , "查看帮助(V)", "关于计算器(A)"
            , "复制历史记录(I)", "编辑(E)", "取消编辑(N)", "清除(L)"};
    private String[] num = {
            "MC", "MR", "MS", "M+", "M-"
            , "←", "CE", "C", "±", "√"
            , "7", "8", "9", "/", "%"
            , "4", "5", "6", "*", "1/x"
            , "1", "2", "3", "-", "="
            , "0", ".", "+"};

    public Frame() {
        Font font = new Font("微软雅黑", Font.PLAIN, 14);
        UIManager.put("Button.font", font);

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

        jPanel = new JPanel();
        jPanel.setLayout(null);
        jTextField = new JTextField("0");
        jTextField.setMargin(new java.awt.Insets(0,0,0,0));
        jTextField.setHorizontalAlignment(JTextField.RIGHT);
        jTextField.setBounds(10, 10, 220, 30);
        jPanel.add(jTextField);
        //设置标准键位
        for (int i = 0; i < 24; i++) {
            setButton(num[i], i);
        }
        //设置特殊键位"=","0",".","+"
        setSingleButton(num[24], 190, 185, 40, 65);
        setSingleButton(num[25], 10, 220, 85, 30);
        setSingleButton(num[26], 100, 220, 40, 30);
        setSingleButton(num[27], 145, 220, 40, 30);
        this.add(bar, BorderLayout.NORTH);
        this.add(jPanel);
        setFrame();
    }

    private void setFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("img/calculate_32.png");
        this.setSize(245, 310);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("计算器");
        this.setIconImage(img);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setSingleButton(String content, int x, int y, int width, int height) {
        JButton singleButton = new JButton(content);
        singleButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        singleButton.setBounds(x, y, width, height);
        jPanel.add(singleButton);
    }

    private void setButton(String content, int i) {
        JButton button = new JButton(content);
        button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button.setBounds(10 + (i % 5) * 45, 45 + (i / 5) * 35, 40, 30);
        jPanel.add(button);
    }

    private void SetJRadioButton(String radioButton) {
        JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem(radioButton);
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
    }
}
