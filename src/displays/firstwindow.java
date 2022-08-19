
package displays;


import classes.Commodity;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class firstwindow extends JFrame implements ActionListener {

    private JButton addcomodity, sacr;
    private Commodity[] commodities;
    
    public firstwindow(){
        super("Hotel Billing System");
        commodities = new Commodity[100];
        
        setLayout(new GridLayout(0,1));
        
        addcomodity = new JButton("add commodity");
        sacr = new JButton("start a customer report");
        addcomodity.addActionListener(this);
        sacr.addActionListener(this);
        
        JLabel welcomeinfo = new JLabel("Welcome to Hotel Billing System");
        welcomeinfo.setHorizontalAlignment(JLabel.CENTER);
        
        add(welcomeinfo);
        add(addcomodity);
        add(sacr);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton b = (JButton) ae.getSource();
        if(b == sacr) {
            new customerrep(commodities);
        } else if(b == addcomodity) {
            new comoadd(commodities);
        }
    }
    
    
}
