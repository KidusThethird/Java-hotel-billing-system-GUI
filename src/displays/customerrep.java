
 
package displays;

import classes.Commodity;
import classes.Customer;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


 

 
class customerrep extends JFrame implements ActionListener {

    private JPanel centerpanel,rightpanel;
    public Commodity[] commodities;
    public Customer customer;
    
    private JTextField firstnamein,lastnamein,phonenumin,tinnumin;
    private JButton addOrder,finish;
    
    public customerrep(Commodity[] commodities) {
        super("Hotel Billing System");
        
        this.commodities = commodities;
        addOrder = new JButton("add order");
        finish = new JButton("finish");
        addOrder.addActionListener(this);
        finish.addActionListener(this);
        firstnamein = new JTextField();
        lastnamein = new JTextField();
        phonenumin = new JTextField();
        tinnumin = new JTextField();
        centerpanel = new JPanel(new GridLayout(0,1));
        rightpanel = new JPanel(new GridLayout(0,1));

        rightpanel.setVisible(false);
        
        centerpanel.add(new JLabel("enter customer informations"));
        centerpanel.add(new JLabel("first name"));
        centerpanel.add(firstnamein);
        centerpanel.add(new JLabel("last name"));
        centerpanel.add(lastnamein);
        centerpanel.add(new JLabel("phone number"));
        centerpanel.add(phonenumin);
        centerpanel.add(new JLabel("tin number"));
        centerpanel.add(tinnumin);
        JButton contbutton = new JButton("continue");
        contbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String firstname = firstnamein.getText();
                String lastname = lastnamein.getText();
                String phonenumber = phonenumin.getText();
                long tinnum = Long.parseLong(tinnumin.getText());
                customer = new Customer(firstname, lastname, phonenumber, tinnum);
                rightpanel.setVisible(true);
                refreshcenter();
            }
        });
        
        centerpanel.add(contbutton);
        
        rightpanel.add(addOrder);
        rightpanel.add(finish);
        
        add(centerpanel,BorderLayout.CENTER);
        add(rightpanel,BorderLayout.EAST);

        setSize(800,600);
        setVisible(true);
    }
    
    public void refreshcenter() {
        centerpanel.removeAll();

        String[] report = customer.getPurcheseReport();
        for (int i = 0; i < report.length; i++) {
            centerpanel.add(new JLabel(report[i]));
        }
    
        validate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton b = (JButton) ae.getSource();
        if(b == addOrder) {
            new makeorder(this);
        } else {
            dispose();
            setVisible(false);
        }
    }
    
}
