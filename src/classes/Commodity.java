package classes;

public abstract class Commodity {
    
    private String name;
    private double unitprice;
    private int count;

    public Commodity(String name, double unitprice) {
        this.name = name;
        this.unitprice = unitprice;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public double getTotalPrice() {
        return count*unitprice;
    }

    public String getinfo() {
        return name + " " + unitprice + " x" + count;
    }

    public abstract Commodity copy();
    
}
