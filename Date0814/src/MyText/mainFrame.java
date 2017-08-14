package MyText;

/**
 * 2017��8��14��
 *
 * @author student Ross
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainFrame extends JFrame {
    public StringBuffer jMenuItemName = new StringBuffer();
    private JMenuBar bar;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu menuFormat;
    private JMenu menuCheck;
    private JMenu menuHelp;
    private JPanel body;
    private JTextArea jTextArea;

    public mainFrame() {
        this.iniFrame();
        this.iniJMenuBar();
        jTextArea = new JTextArea();
        this.setJMenuBar(bar);
        this.add(jTextArea,BorderLayout.CENTER);
    }

//    private void iniJTextArea(){
//        JTextArea jTextArea = new JTextArea();
//    }
    //�趨�˵���
    private void iniJMenuBar() {
        bar = new JMenuBar();
        setJMenuFile();
        setJMenuEdit();
        setJMenuFormat();
        setJMenuCheck();
        setJMenuHelp();
        bar.add(menuFile);
        bar.add(menuEdit);
        bar.add(menuFormat);
        bar.add(menuCheck);
        bar.add(menuHelp);
    }

    //���ð����˵�
    private void setJMenuHelp() {
        menuHelp = new JMenu("����(H)");
        menuHelp.setMnemonic('H');
        menuHelp.add(this.setJMenuItem("�鿴����", 'H'));
        menuHelp.addSeparator();
        JMenuItem temp=this.setJMenuItem("���ڼ��±�", 'A');
        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame.this,
                        "<html><br></br><p><font size=\"4\">Copyright&copy; 2017 Ross .All rights reserved.&emsp;&emsp;</font></p><br></br><html>");
            }
        });
        menuHelp.add(temp);
    }

    //���ò鿴�˵�
    private void setJMenuCheck() {
        menuCheck = new JMenu("�鿴(V)");
        menuCheck.setMnemonic('V');
        menuCheck.add(this.setJMenuItem("״̬��", 'S'));
    }

    //���ø�ʽ�˵�
    private void setJMenuFormat() {
        menuFormat = new JMenu("��ʽ(O)");
        menuFormat.setMnemonic('O');
        menuFormat.add(this.setJMenuItem("�Զ�����", 'W'));
        menuFormat.add(this.setJMenuItem("����", 'F'));
    }

    //���ñ༭�˵�
    private void setJMenuEdit() {
        menuEdit = new JMenu("�༭(E)");
        menuEdit.setMnemonic('E');
        menuEdit.add(this.setJMenuItem("����", 'U', KeyEvent.VK_Z));
        menuEdit.addSeparator();
        menuEdit.add(this.setJMenuItem("����", 'T', KeyEvent.VK_X));
        menuEdit.add(this.setJMenuItem("����", 'C', KeyEvent.VK_C));
        menuEdit.add(this.setJMenuItem("ճ��", 'P', KeyEvent.VK_V));
        menuEdit.add(this.setJMenuItem("ɾ��", 'L', "DELETE"));
        menuEdit.addSeparator();
        menuEdit.add(this.setJMenuItem("����", 'F', KeyEvent.VK_F));
        menuEdit.add(this.setJMenuItem("������һ��", 'N', "F3"));
        menuEdit.add(this.setJMenuItem("�滻", 'R', KeyEvent.VK_H));
        menuEdit.add(this.setJMenuItem("ת��", 'G', KeyEvent.VK_G));
        menuEdit.addSeparator();
        menuEdit.add(this.setJMenuItem("ȫѡ", 'A', KeyEvent.VK_A));
        menuEdit.add(this.setJMenuItem("����/ʱ��", 'D', "F5"));
    }

    //�����ļ��˵�
    private void setJMenuFile() {
        menuFile = new JMenu("�ļ�(F)");
        menuFile.setMnemonic('F');
        menuFile.add(this.setJMenuItem("�½�", 'N', KeyEvent.VK_N));
        menuFile.add(this.setJMenuItem("��", 'O', KeyEvent.VK_O));
        menuFile.add(this.setJMenuItem("����", 'S', KeyEvent.VK_S));
        menuFile.add(this.setJMenuItem("���Ϊ", 'A'));
        menuFile.addSeparator();
        menuFile.add(this.setJMenuItem("�˳�", 'X'));
    }

    //�����ض��������趨�˵����ķ���
    //ֻ�趨һ��Alt��ݼ�
    private JMenuItem setJMenuItem(String name, char shortcuts) {
        jMenuItemName.append(name);
        jMenuItemName.append("(");
        jMenuItemName.append(shortcuts);
        jMenuItemName.append(")");
        JMenuItem jMenuItem = new JMenuItem(jMenuItemName.toString());
        jMenuItem.setMnemonic(shortcuts);
        jMenuItemName.setLength(0);
        return jMenuItem;
    }

    //�趨һ��Alt��ݼ���һ��Ctrl��ϼ�
    private JMenuItem setJMenuItem(String name, char shortcuts, int ctrlLetter) {
        JMenuItem jMenuItem = this.setJMenuItem(name, shortcuts);
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(ctrlLetter, KeyEvent.CTRL_MASK));
        return jMenuItem;
    }

    //�趨һ��Alt��ݼ��͵�����ݼ�
    private JMenuItem setJMenuItem(String name, char shortcuts, String singleKey) {
        JMenuItem jMenuItem = this.setJMenuItem(name, shortcuts);
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(singleKey));
        return jMenuItem;
    }

    //��ʼ������
    private void iniFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("img/notepad_32px.png");
        this.setSize(390, 520);
        this.setLocationRelativeTo(null);
        this.setTitle("���±�");
        this.setIconImage(img);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        mainFrame mFrame = new mainFrame();
        mFrame.setVisible(true);
    }
}
