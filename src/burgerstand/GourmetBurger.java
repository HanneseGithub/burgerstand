package burgerstand;

public class GourmetBurger extends Burger {
    public GourmetBurger(){
	super("The Burger", "Beef", "Homemade Bun", 10);
    }
    
    @Override
    public String toString() {
        return  "*CHEF'S SPECIAL!* " + super.toString();
    }
}
