package login;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class MyFrame extends JFrame {

    private static final long serialVersionUID = -2122161377842820073L;

    private JButton buttonOk;
    private JButton buttonExit;
    private JTextField textFieldUserName;
    private JPasswordField textFieldPass;

    private JLabel jLabel;
    private JLabel jLabel1;

    public MyFrame() {
        buttonOk = new JButton("sign in!");
        buttonOk.setSize(80, 30);
        buttonOk.setLocation(50, 140);

        buttonExit = new JButton("sign up!");
        buttonExit.setSize(80, 30);
        buttonExit.setLocation(170, 140);

        textFieldUserName = new JTextField("UserName");
        textFieldUserName.setSize(165, 30);
        textFieldUserName.setLocation(120, 40);

        textFieldPass = new JPasswordField("PassWord");
        textFieldPass.setSize(165, 30);
        textFieldPass.setLocation(120, 90);

        jLabel = new JLabel("UserName:");
        jLabel.setSize(70,30);
        jLabel.setLocation(30,40);

        jLabel1=new JLabel("PassWord:");
        jLabel1.setSize(70,30);
        jLabel1.setLocation(30,90);


        this.setSize(340, 240);
        this.setLocationRelativeTo(null);
        this.setTitle("My JFrame");
        this.setLayout(null);
        this.add(buttonExit);
        this.add(buttonOk);
        this.add(textFieldUserName);
        this.add(textFieldPass);
        this.add(jLabel);
        this.add(jLabel1);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("img/acfun_52.png");
        this.setIconImage(img);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
