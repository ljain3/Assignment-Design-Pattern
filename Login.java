import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.*;
public class Login extends JDialog {
    private boolean m_bExit = false;
    private JLabel usernameUI = new JLabel();
    private JLabel passwordUI = new JLabel();
    private JTextField UsernameField = new JTextField();
    private JPasswordField PasswordField = new JPasswordField();
    private JButton loginButton = new JButton();
    private JButton buttonCancel = new JButton();
    private ButtonGroup buttonGroup1 = new ButtonGroup();
    private String UserBox = null;
    private UserInfoItem.USER_TYPE UserType;
    Login(){
        try {
            jbInit();
            setSize(300, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(Main.buyersDict.get("tutu"));
    }

    private void jbInit() {
        this.getContentPane().setLayout(null);
        usernameUI.setText("UserName");
        usernameUI.setBounds(new Rectangle(26, 52, 100, 20));
        this.getContentPane().add(usernameUI, null);

        passwordUI.setText("Password");
        passwordUI.setBounds(new Rectangle(23, 119, 100, 20));
        this.getContentPane().add(passwordUI, null);

        loginButton.setText("Login");
        loginButton.setBounds(new Rectangle(31, 212, 85, 28));
        loginButton.addActionListener(this::loginButton_actionPerformed);
        this.getContentPane().add(loginButton, null);

        buttonCancel.setText("Cancel");
        buttonCancel.setBounds(new Rectangle(180, 211, 97, 28));
        buttonCancel.addActionListener(e -> buttonCancel_actionPerformed());
        this.getContentPane().add(buttonCancel, null);

        UsernameField.setBounds(new Rectangle(119, 52, 144, 22));
        this.getContentPane().add(UsernameField, null);

        PasswordField.setBounds(new Rectangle(118, 119, 147, 22));
        this.getContentPane().add(PasswordField, null);
    }

    private void buttonCancel_actionPerformed() {
        m_bExit = true;
        dispose();
    }

    private void loginButton_actionPerformed(ActionEvent e) {
        UserBox = UsernameField.getText();
        String PasswordBox = new String(PasswordField.getPassword());
        String LoginName = null;


        if(findInBuyers(UserBox,PasswordBox)){
            UserType = UserInfoItem.USER_TYPE.Buyer;
            LoginName = UserBox;
        }else if (findInSellers(UserBox,PasswordBox)) {
            LoginName = UserBox;
            UserType = UserInfoItem.USER_TYPE.Seller;
        } else {
            System.out.println("Incorrect User Name or Password, Try again!");
            jbInit();
            setSize(300, 300);
        }
        if (LoginName != null) {
            this.dispose();
        }
    }
    private String GetPassword(String aline) {
        int Sep = aline.lastIndexOf(':');
        return aline.substring(Sep + 1);
    }
    String GetUserName() {
        return UserBox;
    }

    public boolean findInSellers(String uname, String pass) {
        if (Main.sellersDict.get(uname)!=null){
            if(Main.sellersDict.get(uname).equals(pass)){return true;}
            else {return false;}
        }
        else {return false;}
    }

    public boolean findInBuyers(String uname, String pass) {
        if (Main.buyersDict.get(uname)!=null){
            if(Main.buyersDict.get(uname).equals(pass)){return true;}
            else {return false;}
        }
        else {return false;}
    }


    public UserInfoItem.USER_TYPE GetUserType() {
        return UserType;
    }
}
