import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Test extends JFrame {
    public static void main(String[] args) {
        Test cf=new Test();
        cf.setVisible(true);
    }
    private static final long serialVersionUID = -6664327445834781605L;
    //����������
    //�����˵������˵����˵���
    private JMenuBar menuBar=new JMenuBar();
    private JMenu viewmenu=new JMenu("�鿴(V)");
    private JMenu editmenu=new JMenu("�༭(E)");
    private JMenu helpmenu=new JMenu("����(H)");
    private JMenuItem menuCopy =new JMenuItem("����");
    private JMenuItem menuPaste =new JMenuItem("ճ��");
    private JRadioButtonMenuItem general = new JRadioButtonMenuItem("��׼��");
    private JRadioButtonMenuItem science = new JRadioButtonMenuItem("��ѧ��");
    private JMenu hi = new JMenu("��ʷ��¼");
    private JMenuItem copy = new JMenuItem("������ʷ��¼");
    //����һ������Ϊ30���ַ����ı���
    private JTextField textField=new JTextField(30);
    //����JLabel
    private JLabel label=new JLabel();
    //�����������ĸ��ְ�ť
    private JButton[] button=new JButton[28];
    private String[] buttonstr={"MC", "MR", "MS", "M+", "M-", "��","CE","C","+/-","sqrt","7","8", "9", "/",
            "%", "4", "5", "6", "*", "1/x",  "1", "2", "3", "-",
            "0", ".", "+", "=" };
    //�����������
    private JPanel panel=new JPanel();
    private JPanel childPanel2=new JPanel();
    private JPanel childPanel6=new JPanel();
    private JPanel childPanel7=new JPanel();

    private GridLayout gridLayout1=new GridLayout(1,5,5,5);
    private GridLayout gridLayout2=new GridLayout(4,5,5,5);
    public Test(){
        viewmenu.setMnemonic('V');
        editmenu.setMnemonic('E');
        helpmenu.setMnemonic('H');
        viewmenu.add(general);
        viewmenu.add(science);
        ButtonGroup bg = new ButtonGroup();
        bg.add(general);
        bg.add(science);
        editmenu.add(menuCopy);
        editmenu.add(menuPaste);
        editmenu.add(hi);
        hi.add(copy);

        menuCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        menuPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        menuBar.add(viewmenu);
        menuBar.add(editmenu);
        menuBar.add(helpmenu);

        for(int i=0;i<28;i++){
            button[i]=new JButton(buttonstr[i]);
        }

        panel.setLayout(null);

        textField.setText("0");
        textField.setBounds(10,10,380,60);
        textField.setBackground(Color.WHITE);
        textField.setHorizontalAlignment(JTextField.RIGHT);//�������ִ��ұ߿�ʼ��ʾ

        childPanel2.setLayout(gridLayout2);
        childPanel2.setBounds(10,75,380,160);
        for(int i=0;i<=19;i++){
            childPanel2.add(button[i]);
        }

        childPanel6.setLayout(gridLayout1);
        childPanel6.setBounds(10,240,380,35);
        for(int i=20;i<=23;i++){
            childPanel6.add(button[i]);
        }

        childPanel7.setLayout(gridLayout1);
        childPanel7.setBounds(10,280,380,35);
        for(int i=24;i<=27;i++){
            childPanel7.add(button[i]);
        }

        panel.add(textField);
        panel.add(childPanel2);
        panel.add(childPanel6);
        panel.add(childPanel7);

        this.add(menuBar,BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 300, 400, 375);
        this.setTitle("������");
        this.setVisible(true);
    }
}
