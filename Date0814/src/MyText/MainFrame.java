package MyText;


import javax.swing.*;
import javax.swing.text.StringContent;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * start 2017��8��14��
 *
 * @author student Ross
 */


public class MainFrame extends JFrame {
    public StringBuffer jMenuItemName = new StringBuffer();
    private JMenuBar bar;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu menuFormat;
    private JMenu menuCheck;
    private JMenu menuHelp;
    private JPanel showTime;
    private JLabel timeStatusBar;
    private JTextArea jTextArea;
    private JScrollPane scrollPane;

    private Clipboard clipboard;

    public MainFrame() {
        this.iniFrame();
        this.iniJMenuBar();
        showTime = new JPanel(new BorderLayout());
        this.setJMenuBar(bar);
        this.iniJTextArea();
        iniStatusBar();
        this.add(showTime, BorderLayout.SOUTH);
    }

    private void iniStatusBar() {
        timeStatusBar = new JLabel();
        Timer t = new Timer(true);
        MyTask task = new MyTask();
        t.schedule(task, 1000, 1000);
        showTime.add(timeStatusBar, BorderLayout.SOUTH);
    }

    private void iniJTextArea() {
        jTextArea = new JTextArea();
        jTextArea.setLineWrap(false);
        scrollPane = new JScrollPane(jTextArea);
        this.add(scrollPane);
    }

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
        menuHelp.add(this.setJMenuItem("���ڼ��±�", 'A'));
    }

    //���ò鿴�˵�
    private void setJMenuCheck() {
        menuCheck = new JMenu("�鿴(V)");
        menuCheck.setMnemonic('V');
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem("״̬��(S)");
        jCheckBoxMenuItem.setMnemonic('s');
        jCheckBoxMenuItem.setSelected(true);
        this.iniStatuInf(jCheckBoxMenuItem);
        menuCheck.add(jCheckBoxMenuItem);
    }

    //���ø�ʽ�˵�
    private void setJMenuFormat() {
        menuFormat = new JMenu("��ʽ(O)");
        menuFormat.setMnemonic('O');
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem("�Զ�����(W)");
        jCheckBoxMenuItem.setMnemonic('W');
        this.iniAutoWrap(jCheckBoxMenuItem);
        menuFormat.add(jCheckBoxMenuItem);
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
        this.setAction(jMenuItem, name);
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

    private void setAction(JMenuItem menuItem, String jMenuItemName) {
        if (jMenuItemName.equals("���ڼ��±�")) {
            this.iniCopyRightInf(menuItem);
            return;
        } else if (jMenuItemName.equals("��")) {
            this.iniOpenMenuItem(menuItem);
            return;
        } else if (jMenuItemName.equals("���Ϊ")) {
            this.iniSaveAsMenuItem(menuItem);
            return;
        } else if (jMenuItemName.equals("ճ��")) {
            this.iniPasteMenuItem(menuItem);
            return;
        }else if (jMenuItemName.equals("����")) {
            this.iniCopyMenuItem(menuItem);
            return;
        }else if (jMenuItemName.equals("����")) {
            this.iniCutMenuItem(menuItem);
            return;
        }else if (jMenuItemName.equals("ɾ��")) {
            this.iniDelMenuItem(menuItem);
            return;
        }else if (jMenuItemName.equals("ȫѡ")) {
            this.iniSelAllMenuItem(menuItem);
            return;
        }
    }

    private void iniSelAllMenuItem(JMenuItem menuItem){
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.selectAll();
            }
        });
    }
    private void iniDelMenuItem(JMenuItem jMenuItem){
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.replaceSelection("");
            }
        });
    }
    private void iniCutMenuItem(JMenuItem menuItem){
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection=new StringSelection(jTextArea.getSelectedText());
                clipboard.setContents(stringSelection,null);
                jTextArea.replaceSelection("");
            }
        });
    }

    private void iniCopyMenuItem(JMenuItem jMenuItem) {
        clipboard = getToolkit().getSystemClipboard();
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection=new StringSelection(jTextArea.getSelectedText());
                clipboard.setContents(stringSelection,null);
            }
        });
    }

    private void iniPasteMenuItem(JMenuItem MenuItem) {
        clipboard = getToolkit().getSystemClipboard();
        MenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transferable clipT = clipboard.getContents(this);
                if (clipT != null) {
                    // ��������Ƿ����ı�����
                    if (clipT.isDataFlavorSupported(DataFlavor.stringFlavor))
                        try {
                            int n = jTextArea.getCaretPosition();
                            String str = (String) clipT.getTransferData(DataFlavor.stringFlavor);
                            jTextArea.insert(str, n);
                            return;
                        } catch (UnsupportedFlavorException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                }
            }
        });
    }

    private void iniOpenMenuItem(JMenuItem MenuItem) {
        MenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int rst = jFileChooser.showOpenDialog(MainFrame.this);
                File file = jFileChooser.getSelectedFile();
                if (rst == JFileChooser.APPROVE_OPTION) {
                    try {
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        String s = br.readLine();
                        StringBuffer sb = new StringBuffer();
                        while (s != null) {
                            sb.append(s);
                            sb.append(System.getProperty("line.separator"));
                            s = br.readLine();
                        }
                        jTextArea.setText(sb.toString());
                        br.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    private void iniSaveAsMenuItem(JMenuItem jMenuItem) {
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jTextArea.getText();
                JFileChooser jfc = new JFileChooser();
                jfc.showSaveDialog(MainFrame.this);
                try {
                    File file = jfc.getSelectedFile();
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(str);
                    bw.flush();
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void iniCopyRightInf(JMenuItem menuItem) {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainFrame.this,
                        "<html><br></br><p><font size=\"4\">Copyright&copy; 2017 Ross .All rights reserved.&emsp;&emsp;</font></p><br></br><html>");
            }
        });
    }

    private void iniStatuInf(JCheckBoxMenuItem jCheckBoxMenuItem) {
        jCheckBoxMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jCheckBoxMenuItem.isSelected()) {
                    showTime.setVisible(true);
                    return;
                }
                showTime.setVisible(false);
                return;
            }
        });
    }

    private void iniAutoWrap(JCheckBoxMenuItem jCheckBoxMenuItem) {
        jCheckBoxMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jCheckBoxMenuItem.isSelected()) {
                    jTextArea.setLineWrap(true);
                    return;
                }
                jTextArea.setLineWrap(false);
                return;
            }
        });
    }

    //��ʼ������
    private void iniFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("img/Notepad_48px.png");
        this.setSize(390, 520);
        this.setLocationRelativeTo(null);
        this.setTitle("���±�");
        this.setIconImage(img);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class MyTask extends TimerTask {

        @Override
        public void run() {
            timeStatusBar.setText(new Date().toString());
            System.gc();
        }

    }
}


