package classes;
public class laundary extends Commodity {

    public laundary(String name, double unitprice) {
        super(name, unitprice);
    }

    
    @Override
    public String getinfo() {
        return "laundary type " + super.getinfo(); 
    }
    
    @Override
    public Commodity copy() {
        return new laundary(getName(), getUnitprice());
    }
    
    
}
