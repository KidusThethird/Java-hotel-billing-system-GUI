/*
NAME...............................ID NUMBER
1,ESHETIE GILET..................549/07
2, MULU   FEKADU...................1123/07
3,TEGEGN ABERA....................1370/07
4,GELTU DEGFU ....................641/07
5,DANIAL MULYE....................427/07
6,GENTE LEMA......................651/07
*/
package displays;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class checkuser extends JFrame  implements ActionListener {

    private JTextField usernameinput;
    private JPasswordField passwordinput;
    private JButton enter,cancel;
    private String systemusername = "manager", systempassword = "password";
    
    public checkuser(){
        super("Hotel Billing System");
        usernameinput = new JTextField();
        passwordinput = new JPasswordField();
        enter = new JButton("enter");
        cancel = new JButton("cancel");
        setLayout(new GridLayout(0, 1));
        
        add(new JLabel("username"));
        add(usernameinput);
        add(new JLabel("password"));
        add(passwordinput);
        add(enter);
        add(cancel);
        
        enter.addActionListener(this);
        cancel.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = (JButton) ae.getSource();
        
        if(button == enter) {
            String username = usernameinput.getText();
            String password = passwordinput.getText();
            if(username.equals(systemusername) && password.equals(systempassword)) {
                new firstwindow();
                setVisible(false);
            }
        } else {
            System.exit(0);
        }
        
    }
    
    public static void main(String[] args) {
        new checkuser();
    }
    
}
