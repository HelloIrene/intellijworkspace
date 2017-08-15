package MyText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * start 2017年8月14日
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

    //设定菜单栏
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

    //设置帮助菜单
    private void setJMenuHelp() {
        menuHelp = new JMenu("帮助(H)");
        menuHelp.setMnemonic('H');
        menuHelp.add(this.setJMenuItem("查看帮助", 'H'));
        menuHelp.addSeparator();
        menuHelp.add(this.setJMenuItem("关于记事本", 'A'));
    }

    //设置查看菜单
    private void setJMenuCheck() {
        menuCheck = new JMenu("查看(V)");
        menuCheck.setMnemonic('V');
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem("状态栏(S)");
        jCheckBoxMenuItem.setMnemonic('s');
        jCheckBoxMenuItem.setSelected(true);
        this.iniStatuInf(jCheckBoxMenuItem);
        menuCheck.add(jCheckBoxMenuItem);
    }

    //设置格式菜单
    private void setJMenuFormat() {
        menuFormat = new JMenu("格式(O)");
        menuFormat.setMnemonic('O');
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem("自动换行(W)");
        jCheckBoxMenuItem.setMnemonic('W');
        this.iniAutoWrap(jCheckBoxMenuItem);
        menuFormat.add(jCheckBoxMenuItem);
        menuFormat.add(this.setJMenuItem("字体", 'F'));
    }

    //设置编辑菜单
    private void setJMenuEdit() {
        menuEdit = new JMenu("编辑(E)");
        menuEdit.setMnemonic('E');
        menuEdit.add(this.setJMenuItem("撤销", 'U', KeyEvent.VK_Z));
        menuEdit.addSeparator();
        menuEdit.add(this.setJMenuItem("剪切", 'T', KeyEvent.VK_X));
        menuEdit.add(this.setJMenuItem("复制", 'C', KeyEvent.VK_C));
        menuEdit.add(this.setJMenuItem("粘贴", 'P', KeyEvent.VK_V));
        menuEdit.add(this.setJMenuItem("删除", 'L', "DELETE"));
        menuEdit.addSeparator();
        menuEdit.add(this.setJMenuItem("查找", 'F', KeyEvent.VK_F));
        menuEdit.add(this.setJMenuItem("查找下一个", 'N', "F3"));
        menuEdit.add(this.setJMenuItem("替换", 'R', KeyEvent.VK_H));
        menuEdit.add(this.setJMenuItem("转到", 'G', KeyEvent.VK_G));
        menuEdit.addSeparator();
        menuEdit.add(this.setJMenuItem("全选", 'A', KeyEvent.VK_A));
        menuEdit.add(this.setJMenuItem("日期/时间", 'D', "F5"));
    }

    //设置文件菜单
    private void setJMenuFile() {
        menuFile = new JMenu("文件(F)");
        menuFile.setMnemonic('F');
        menuFile.add(this.setJMenuItem("新建", 'N', KeyEvent.VK_N));
        menuFile.add(this.setJMenuItem("打开", 'O', KeyEvent.VK_O));
        menuFile.add(this.setJMenuItem("保存", 'S', KeyEvent.VK_S));
        menuFile.add(this.setJMenuItem("另存为", 'A'));
        menuFile.addSeparator();
        menuFile.add(this.setJMenuItem("退出", 'X'));
    }

    //用重载定义三种设定菜单栏的方法
    //只设定一组Alt快捷键
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

    //设定一组Alt快捷键和一组Ctrl组合键
    private JMenuItem setJMenuItem(String name, char shortcuts, int ctrlLetter) {
        JMenuItem jMenuItem = this.setJMenuItem(name, shortcuts);
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(ctrlLetter, KeyEvent.CTRL_MASK));
        return jMenuItem;
    }

    //设定一组Alt快捷键和单个快捷键
    private JMenuItem setJMenuItem(String name, char shortcuts, String singleKey) {
        JMenuItem jMenuItem = this.setJMenuItem(name, shortcuts);
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(singleKey));
        return jMenuItem;
    }

    private void setAction(JMenuItem menuItem, String jMenuItemName) {
        if (jMenuItemName.equals("关于记事本")) {
            this.iniCopyRightInf(menuItem);
        }
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

    //初始化窗口
    private void iniFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("img/notepad_32px.png");
        this.setSize(390, 520);
        this.setLocationRelativeTo(null);
        this.setTitle("记事本");
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


