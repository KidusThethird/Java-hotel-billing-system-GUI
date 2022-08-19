

package displays;

import classes.Commodity;
import classes.food;
import classes.laundary;
import classes.room;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
class comoadd extends JFrame implements ActionListener {
    private Commodity[] commodities;
    private JTextField nameinput,unitpriceinput; 
    private JComboBox<String> typeselect;
    private JLabel errors = new JLabel();
    public comoadd(Commodity[] commodities) {
        super("Hotel Billing System");
        this.commodities = commodities;
        nameinput = new JTextField();
        unitpriceinput = new JTextField();
        String [] types = {"room","food","laundary"};
        typeselect = new JComboBox<>(types);
        
        setLayout(new GridLayout(0,1));
        
        add(new JLabel("register new commodity"));
        add(new JLabel("name"));
        add(nameinput);
        add(new JLabel("unit price"));
        add(unitpriceinput);
        add(new JLabel("type"));
        add(typeselect);
        
        JButton savebutton = new JButton("save");
        savebutton.addActionListener(this);
        add(savebutton);
        add(errors);
        
        setSize(700,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // rigister a new material in the commodities array
        try {
        String name = nameinput.getText();
        double unitprice = Double.parseDouble(unitpriceinput.getText());
        String type = (String) typeselect.getSelectedItem();
        if(!name.equals("") && unitprice>0) {
            Commodity c = null;
            if(type.equals("room")) {
                c = new room(name, unitprice);
            } else if(type.equals("food")) {
                c = new food(name, unitprice);
            } else if(type.equals("laundary")) {
                c = new laundary(name, unitprice);
            }
            commodities[getlastindex()] = c;
            setVisible(false);
        } else {
            errors.setText("error: fill all parameteres correctly");
        }
        } catch (NumberFormatException ax) {
            errors.setText("error: price must be a number");
        }
    }
    
    private int getlastindex() {
        for (int i = 0; i < commodities.length; i++) {
            if(commodities[i] == null) return i;
        } 
        return 0;
    }
    
}
