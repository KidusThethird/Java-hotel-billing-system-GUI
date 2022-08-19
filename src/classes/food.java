package classes;

public class food extends Commodity {
    
    public food(String name, double unitprice) {
        super(name, unitprice);
    }
    
    @Override
    public String getinfo() {
        return "food type " + super.getinfo(); 
    }

    @Override
    public Commodity copy() {
        return new food(getName(), getUnitprice());
    }
    
}
