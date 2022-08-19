package classes;

public class room extends Commodity {
    
    public room(String name, double unitprice) {
        super(name, unitprice);
    }

    @Override
    public String getinfo() {
        return "bed type " + super.getinfo(); 
    }
    
    
    
    @Override
    public Commodity copy() {
        return new room(getName(), getUnitprice());
    }
    
}
