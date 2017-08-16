package MyTest2;

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
 * start 2017年8月14日
 * initially complete 2017年8月16日
 *
 * @author student Ross
 */

public class MyTextFrame extends JFrame {
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
    private String content = "";

    private Clipboard clipboard;
    private UndoManager undomg = new UndoManager();

    public MyTextFrame() {
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
        jPopupMenu.add(this.setJMenuItem("撤销", 'U', KeyEvent.VK_Z));
        jPopupMenu.addSeparator();
        jPopupMenu.add(this.setJMenuItem("剪切", 'T', KeyEvent.VK_X));
        jPopupMenu.add(this.setJMenuItem("复制", 'C', KeyEvent.VK_C));
        jPopupMenu.add(this.setJMenuItem("粘贴", 'P', KeyEvent.VK_V));
        jPopupMenu.add(this.setJMenuItem("删除", 'L', "DELETE"));
        jPopupMenu.addSeparator();
        jPopupMenu.add(this.setJMenuItem("全选", 'A', KeyEvent.VK_A));
        this.settingRightClick();
    }

    private void settingRightClick() {
        jTextArea.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger())// 返回此鼠标事件是否为该平台的弹出菜单触发事件
                {
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());// 在组件调用者的坐标空间中的位置
                    // X、Y
                    // 显示弹出菜单
                }
                jPopupMenu.requestFocus();// 编辑区获取焦点
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger())// 返回此鼠标事件是否为该平台的弹出菜单触发事件
                {
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());// 在组件调用者的坐标空间中的位置
                    // X、Y
                    // 显示弹出菜单
                }
                jPopupMenu.requestFocus();// 编辑区获取焦点
            }
        });// 文
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
        menuFormat.add(this.setJMenuItem("修改背景", 'C'));
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
        addWindowListener(new ExitClick());
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
        this.settingActionListener(jMenuItem, name);
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

    private void settingActionListener(JMenuItem menuItem, String jMenuItemName) {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (jMenuItemName) {
                    case "关于记事本":
                        JOptionPane.showMessageDialog(MyTextFrame.this,
                                "<html><br></br><p><font size=\"4\">Copyright&copy; 2017 Ross .All rights reserved.&emsp;&emsp;</font></p><br></br><html>");
                        return;
                    case "打开":
                        MyTextFrame.this.iniOpenMenuItem();
                        return;
                    case "另存为":
                        MyTextFrame.this.saveFileBody();
                        return;
                    case "粘贴":
                        MyTextFrame.this.iniPasteMenuItem();
                        return;
                    case "复制":
                        MyTextFrame.this.iniCopyMenuItem();
                        return;
                    case "剪切":
                        MyTextFrame.this.iniCutMenuItem();
                        return;
                    case "删除":
                        jTextArea.replaceSelection("");
                        return;
                    case "全选":
                        jTextArea.selectAll();
                        return;
                    case "日期/时间":
                        MyTextFrame.this.soutTime();
                        return;
                    case "撤销":
                        MyTextFrame.this.settingUndomg();
                        return;
                    case "字体":
                        MyTextFrame.this.settingFont();
                        return;
                    case "修改背景":
                        MyTextFrame.this.changeBGC();
                        return;
                    case "保存":
                        MyTextFrame.this.saveFile();
                        return;
                    case "新建":
                        MyTextFrame.this.create();
                        return;
                    case "退出":
                        MyTextFrame.this.exitWaring();
                        return;
                    default:
                        MyTextFrame.this.warning();
                        return;
                }
            }
        });
    }

    private void saveFile() {
        if (path == null) {
            MyTextFrame.this.saveFileBody();
        } else {//在已经有个新建文件的情况下，保存与另存为的区别是：保存相当于覆盖了之前已有的文件
            File file = new File(path);
            String str = jTextArea.getText();
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(str);
                bw.flush();
                bw.close();
                content = str;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void create() {
        if (jTextArea.getText().equals(content)) {
            jTextArea.setText("");
            return;
        }
        int result = JOptionPane.showConfirmDialog(MyTextFrame.this, "文件未保存，是否继续", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            jTextArea.setText("");
            return;
        } else if (result == JOptionPane.NO_OPTION) {
            MyTextFrame.this.saveFileBody();
            jTextArea.setText("");
            MyTextFrame.this.setTitle("记事本");
            return;
        }
    }

    private void changeBGC() {
        Color c = JColorChooser.showDialog(MyTextFrame.this, "选择颜色", Color.BLACK);
        jTextArea.setBackground(c);
    }

    private void settingFont() {
        MyFontChooser fontChooser = new MyFontChooser(jTextArea.getFont());
        // 打开一个字体选择器窗口，参数为父级所有者窗体。返回一个整型，代表设置字体时按下了确定或是取消，可参考MQFontChooser.APPROVE_OPTION和MQFontChooser.CANCEL_OPTION
        int returnValue = fontChooser.showFontDialog(MyTextFrame.this);
        // 如果按下的是确定按钮
        if (returnValue == MyFontChooser.APPROVE_OPTION) {
            Font font = fontChooser.getSelectFont(); // 获取选择的字体
            // 将字体设置到JTextArea中
            jTextArea.setFont(font);
        }
    }

    private void settingUndomg() {
        if (undomg.canUndo()) {
            undomg.undo();
            return;
        } else {
            JOptionPane.showMessageDialog(null, "无法撤销", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

    }

    private void soutTime() {
        int n = jTextArea.getCaretPosition();
        jTextArea.insert(new Date().toString(), n);
        return;
    }

    private void iniCutMenuItem() {
        MyTextFrame.this.iniCopyMenuItem();
        jTextArea.replaceSelection("");
    }

    private void iniCopyMenuItem() {
        clipboard = getToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(jTextArea.getSelectedText());
        clipboard.setContents(stringSelection, null);
    }

    private void iniPasteMenuItem() {
        clipboard = getToolkit().getSystemClipboard();
        Transferable clipT = clipboard.getContents(this);
        if (clipT != null) {
            // 检查内容是否是文本类型
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

    private void iniOpenMenuItem() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int rst = jFileChooser.showOpenDialog(MyTextFrame.this);
        File file = jFileChooser.getSelectedFile();
        if (rst == JFileChooser.APPROVE_OPTION) {
            try {
                String title = file.getName();
                MyTextFrame.this.setTitle(title);
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
                content = sb.toString();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
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

    private void saveFileBody() {
        String str = jTextArea.getText();
        JFileChooser jfc = new JFileChooser();
        jfc.showSaveDialog(MyTextFrame.this);
        try {
            File file = jfc.getSelectedFile();
            String title = file.getName();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.flush();
            bw.close();
            MyTextFrame.this.setTitle(title);
            path = file.getAbsolutePath();
            content = str;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void warning() {
        JOptionPane.showMessageDialog(MyTextFrame.this, "Waiting for Versions 2.0 !", "Versions 1.0", JOptionPane.WARNING_MESSAGE);
    }

    //保存窗体大小信息
    private void saveFrameSize() {
        Properties properties = new Properties();
        properties.setProperty("JFrameX", String.valueOf(this.getX()));
        properties.setProperty("JFrameY", String.valueOf(this.getY()));
        properties.setProperty("JFrameWidth", String.valueOf(this.getWidth()));
        properties.setProperty("JFrameHeight", String.valueOf(this.getHeight()));
        try {
            FileWriter fw = new FileWriter("src/JFrameInf.properties");
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
            int width = Integer.parseInt(String.valueOf(properties.get("JFrameWidth")));
            int height = Integer.parseInt(String.valueOf(properties.get("JFrameHeight")));
            this.setBounds(x, y, width, height);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    //初始化窗口
    private void iniFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("img/Notepad_48px.png");
        this.setTitle("记事本");
        this.setIconImage(img);
        this.addWindowListener(new ExitClick());
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        File file = new File("src/JFrameInf.properties");
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

    private void exitWaring() {
        if (jTextArea.getText().equals(content)) {
            System.exit(0);
            return;
        }
        int result = JOptionPane.showConfirmDialog(MyTextFrame.this, "内容未保存，是否保存后再退出?", "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            MyTextFrame.this.saveFileBody();
            MyTextFrame.this.saveFrameSize();
            System.exit(0);
            return;
        } else if (result == JOptionPane.NO_OPTION) {
            MyTextFrame.this.saveFrameSize();
            System.exit(0);
            return;
        }
    }
    private class ExitClick extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            MyTextFrame.this.exitWaring();
        }
    }
}


