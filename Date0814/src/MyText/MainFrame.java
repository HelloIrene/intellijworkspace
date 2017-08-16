package MyText;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import java.util.Properties;
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
    private JPopupMenu jPopupMenu;
    private String path;

    private Clipboard clipboard;
    private UndoManager undomg = new UndoManager();

    public MainFrame() {
        jTextArea = new JTextArea();
        this.iniFrame();
        this.iniJMenuBar();
        showTime = new JPanel(new BorderLayout());
        this.setJMenuBar(bar);
        this.iniJPopUpMenu();
        this.iniJTextArea();
        iniStatusBar();
        this.add(showTime, BorderLayout.SOUTH);
        this.iniJPopUpMenu();
    }

    private void iniStatusBar() {
        timeStatusBar = new JLabel();
        Timer t = new Timer(true);
        MyTask task = new MyTask();
        t.schedule(task, 1000, 1000);
        showTime.add(timeStatusBar, BorderLayout.SOUTH);
    }

    private void iniJTextArea() {
        jTextArea.getDocument().addUndoableEditListener(undomg);
        jTextArea.setLineWrap(false);
        scrollPane = new JScrollPane(jTextArea);
        this.add(scrollPane);
    }

    private void iniJPopUpMenu() {
        jPopupMenu = new JPopupMenu();
        jPopupMenu.add(this.setJMenuItem("����", 'U', KeyEvent.VK_Z));
        jPopupMenu.addSeparator();
        jPopupMenu.add(this.setJMenuItem("����", 'T', KeyEvent.VK_X));
        jPopupMenu.add(this.setJMenuItem("����", 'C', KeyEvent.VK_C));
        jPopupMenu.add(this.setJMenuItem("ճ��", 'P', KeyEvent.VK_V));
        jPopupMenu.add(this.setJMenuItem("ɾ��", 'L', "DELETE"));
        jPopupMenu.addSeparator();
        jPopupMenu.add(this.setJMenuItem("ȫѡ", 'A', KeyEvent.VK_A));
        this.settingRightClick();
    }

    private void settingRightClick() {
        jTextArea.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger())// ���ش�����¼��Ƿ�Ϊ��ƽ̨�ĵ����˵������¼�
                {
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());// ����������ߵ�����ռ��е�λ��
                    // X��Y
                    // ��ʾ�����˵�
                }
                jPopupMenu.requestFocus();// �༭����ȡ����
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger())// ���ش�����¼��Ƿ�Ϊ��ƽ̨�ĵ����˵������¼�
                {
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());// ����������ߵ�����ռ��е�λ��
                    // X��Y
                    // ��ʾ�����˵�
                }
                jPopupMenu.requestFocus();// �༭����ȡ����
            }
        });// ��
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
        menuFormat.add(this.setJMenuItem("�޸ı���", 'C'));
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
        switch (jMenuItemName) {
            case "���ڼ��±�":
                this.iniCopyRightInf(menuItem);
                return;
            case "��":
                this.iniOpenMenuItem(menuItem);
                return;
            case "���Ϊ":
                this.iniSaveAsMenuItem(menuItem);
                return;
            case "ճ��":
                this.iniPasteMenuItem(menuItem);
                return;
            case "����":
                this.iniCopyMenuItem(menuItem);
                return;
            case "����":
                this.iniCutMenuItem(menuItem);
                return;
            case "ɾ��":
                this.iniDelMenuItem(menuItem);
                return;
            case "ȫѡ":
                this.iniSelAllMenuItem(menuItem);
                return;
            case "����/ʱ��":
                this.soutTime(menuItem);
                return;
            case "����":
                this.settingUndomg(menuItem);
                return;
            case "����":
                this.settingFont(menuItem);
                return;
            case "�޸ı���":
                this.changeBGC(menuItem);
                return;
            case "����":
                this.saveFile(menuItem);
                return;
            case "�½�":
                this.create(menuItem);
                return;
            default:
                return;
        }
    }

    private void saveFile(JMenuItem jMenuItem) {
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (path == null) {
                    MainFrame.this.saveFileBody();
                } else {//���Ѿ��и��½��ļ�������£����������Ϊ�������ǣ������൱�ڸ�����֮ǰ���е��ļ�
                    File file = new File(path);
                    String str = jTextArea.getText();
                    try {
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(str);
                        bw.flush();
                        bw.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        });
    }

    private void create(JMenuItem jMenuItem) {
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextArea.getText().equals("")) {
                    jTextArea.setText("");
                    return;
                }
                int result = JOptionPane.showConfirmDialog(MainFrame.this, "�ļ�δ���棬�Ƿ����");
                if (result == JOptionPane.YES_OPTION) {
                    jTextArea.setText("");
                }
            }
        });
    }

    private void changeBGC(JMenuItem jMenuItem) {
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(MainFrame.this, "ѡ����ɫ", Color.BLACK);
                jTextArea.setBackground(c);
            }
        });
    }

    private void settingFont(JMenuItem jMenuItem) {
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFontChooser fontChooser = new MyFontChooser(jTextArea.getFont());
                // ��һ������ѡ�������ڣ�����Ϊ���������ߴ��塣����һ�����ͣ�������������ʱ������ȷ������ȡ�����ɲο�MQFontChooser.APPROVE_OPTION��MQFontChooser.CANCEL_OPTION
                int returnValue = fontChooser.showFontDialog(MainFrame.this);
                // ������µ���ȷ����ť
                if (returnValue == MyFontChooser.APPROVE_OPTION) {
                    Font font = fontChooser.getSelectFont(); // ��ȡѡ�������
                    // ���������õ�JTextArea��
                    jTextArea.setFont(font);
                }
            }
        });
    }

    private void settingUndomg(JMenuItem jMenuItem) {
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undomg.canUndo()) {
                    undomg.undo();
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "�޷�����", "����", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        });
    }

    private void soutTime(JMenuItem jMenuItem) {
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = jTextArea.getCaretPosition();
                jTextArea.insert(new Date().toString(), n);
                return;
            }
        });
    }

    private void iniSelAllMenuItem(JMenuItem menuItem) {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.selectAll();
            }
        });
    }

    private void iniDelMenuItem(JMenuItem jMenuItem) {
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.replaceSelection("");
            }
        });
    }

    private void iniCutMenuItem(JMenuItem menuItem) {
        clipboard = getToolkit().getSystemClipboard();
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(jTextArea.getSelectedText());
                clipboard.setContents(stringSelection, null);
                jTextArea.replaceSelection("");
            }
        });
    }

    private void iniCopyMenuItem(JMenuItem jMenuItem) {
        clipboard = getToolkit().getSystemClipboard();
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(jTextArea.getSelectedText());
                clipboard.setContents(stringSelection, null);
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
                        String title = file.getName();
                        MainFrame.this.setTitle(title);
                        path = file.getAbsolutePath();
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
                MainFrame.this.saveFileBody();
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

    private void saveFileBody(){
        String str = jTextArea.getText();
        JFileChooser jfc = new JFileChooser();
        jfc.showSaveDialog(MainFrame.this);
        try {
            File file = jfc.getSelectedFile();
            String title = file.getName();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.flush();
            bw.close();
            MainFrame.this.setTitle(title);
            path = file.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    //���洰���С��Ϣ
    private void saveFrameSize() {
        Properties properties = new Properties();
        properties.setProperty("JFrameX", String.valueOf(this.getX()));
        properties.setProperty("JFrameY", String.valueOf(this.getY()));
        properties.setProperty("JFrameWidth", String.valueOf(this.getWidth()));
        properties.setProperty("JFrameHeight", String.valueOf(this.getHeight()));
        try {
            FileWriter fw = new FileWriter("src/JFrameY.properties");
            properties.store(fw, "JFrame Info");
            fw.close();
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    private void setFrameSize(File file) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
            int x = Integer.parseInt(String.valueOf(properties.get("JFrameX")));
            int y = Integer.parseInt(String.valueOf(properties.get("JFrameY")));
            int w = Integer.parseInt(String.valueOf(properties.get("JFrameWidth")));
            int h = Integer.parseInt(String.valueOf(properties.get("JFrameHeight")));
            this.setBounds(x, y, w, h);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    //��ʼ������
    private void iniFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("img/Notepad_48px.png");
        this.setTitle("���±�");
        this.setIconImage(img);
        //);this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE
        this.addWindowListener(new ExitClick());
        File file = new File("src/JFrameY.properties");
        if (file.exists()) {
            this.setFrameSize(file);
            return;
        }
        this.setSize(390, 520);
        this.setLocationRelativeTo(null);
    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {
            timeStatusBar.setText(new Date().toString());
            System.gc();
        }
    }

    private class ExitClick extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            int result = JOptionPane.showConfirmDialog(MainFrame.this, "����δ���棬Ҫ��������˳�?", "Confirm",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                MainFrame.this.saveFileBody();
                MainFrame.this.saveFrameSize();
                MainFrame.this.dispose();// �رմ���
                System.exit(0) ;
            } else if (result == JOptionPane.NO_OPTION) {
                MainFrame.this.saveFrameSize();
                MainFrame.this.dispose();
                System.exit(0) ;
            }
        }
    }
}


