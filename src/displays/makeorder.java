package displays;

import classes.Commodity;
import classes.Customer;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class makeorder extends JFrame implements ActionListener {

    private Customer customer;
    private Commodity[] commodities;
    private JComboBox<String> commodselect;
    private JTextField amountin;
    private JLabel error = new JLabel();
    private customerrep customerrep;
    
    public makeorder(customerrep cr) {
        super("Order?");
        this.customerrep = cr;
        this.customer = cr.customer;
        this.commodities = cr.commodities;
        amountin = new JTextField();
        
        int k = 0;
        for (int i = 0; i < commodities.length; i++) {
            if(commodities[i] == null) { k = i; break; }
        }
        String[] comos = new String[k];
        for (int i = 0; i < k; i++) {
            comos[i] = commodities[i].getName();
        }
        commodselect = new JComboBox<>(comos);
        setLayout(new GridLayout(0,1));
        
        add(new JLabel("Make an Order"));
        add(new JLabel("to make an order just select the comodity enter the amount"));
        add(new JLabel("Commodity"));
        add(commodselect);
        add(new JLabel("Amount"));
        add(amountin);
        JButton add = new JButton("add to order list");
        add.addActionListener(this);
        add(add);
        add(error);
        
        setSize(400,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            int amount = Integer.parseInt(amountin.getText());
            int index = commodselect.getSelectedIndex();
            Commodity c = commodities[index].copy();
            c.setCount(amount);
            customer.purchese(c);
            customerrep.refreshcenter();
            setVisible(false);
            dispose();
        } catch(NumberFormatException ex) {
            error.setText("amount must be an integer number value");
        }
    }
    
}
