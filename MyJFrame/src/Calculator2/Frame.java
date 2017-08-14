package Calculator2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {
    private JMenuBar bar;
    // �˵�
    private JMenu menuEdit;
    private JMenu subMenuEdit;
    private JMenu menuHelp;
    // �˵���
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
    private String[] name = {"�༭(E)", "����(H)", "��ʷ��¼"
            , "����(C)", "ճ��(P)"
            , "�鿴����(V)", "���ڼ�����(A)"
            , "������ʷ��¼(I)", "�༭(E)", "ȡ���༭(N)", "���(L)"};
    private String[] num = {
            "MC", "MR", "MS", "M+", "M-"
            , "��", "CE", "C", "��", "��"
            , "7", "8", "9", "/", "%"
            , "4", "5", "6", "*", "1/x"
            , "1", "2", "3", "-", "="
            , "0", ".", "+"};

    public Frame() {
        Font font = new Font("΢���ź�", Font.PLAIN, 14);
        UIManager.put("Button.font", font);

        menuEdit = new JMenu("�༭(E)");
        menuEdit.setMnemonic('E');
        menuHelp = new JMenu("����(H)");
        menuHelp.setMnemonic('H');
        subMenuEdit = new JMenu("��ʷ��¼");

        copy = new JMenuItem("����(C)");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        paste = new JMenuItem("ճ��(P)");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        help = new JMenuItem("�鿴����(V)");
        help.setAccelerator(KeyStroke.getKeyStroke("F1"));
        aboutCal = new JMenuItem("���ڼ�����(A)");
        copyHis = new JMenuItem("������ʷ��¼(I)");
        edit = new JMenuItem("�༭(E)");
        edit.setAccelerator(KeyStroke.getKeyStroke("F2"));
        delEdit = new JMenuItem("ȡ���༭(N)");
        delEdit.setAccelerator(KeyStroke.getKeyStroke("ESCAPE"));
        del = new JMenuItem("���(L)");
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
        //���ñ�׼��λ
        for (int i = 0; i < 24; i++) {
            setButton(num[i], i);
        }
        //���������λ"=","0",".","+"
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
        this.setTitle("������");
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
