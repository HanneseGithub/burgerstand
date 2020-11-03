package burgerstand;

public class Addition {
    private String name;
    private double price;

    public Addition(String name, double price) {
	this.name = name;
	this.price = price;
    }
    
    public String getName() {
	return name;
    }
    
    public void setName(String name) {
	this.name = name;
    }
    
    public double getPrice() {
	return price;
    }
    
    public void setPrice(double price) throws BurgerException {
	if (price >= 0) {
	    this.price = price;
	} else {
	    throw new BurgerException("The price cannot be negative!");
	}
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if(!this.name.equals(obj)) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
