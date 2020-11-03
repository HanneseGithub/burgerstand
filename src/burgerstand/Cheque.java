package burgerstand;

import java.util.ArrayList;
import java.util.List;

public class Cheque {
    private List<Burger> burgersBought;
    
    public Cheque() {
	this.burgersBought = new ArrayList<Burger>();
    }
    
    public void addToCheque(Burger burger) {
	burgersBought.add(burger);
    }
    
    public double calculateFinalPrice() {
	double finalPrice = 0.0;
	for (Burger burger : burgersBought) {
	    finalPrice += burger.burgerPrice();
	}
	
	return finalPrice;
    }
    
    @Override
    public String toString() {
        String finalCheque = "";
        for (Burger burger : burgersBought) {
            finalCheque +=  burger.getName() + " - " + burger.getPrice() + "€\n"; 
            for(Addition boughtAddition : burger.getBurgerAdditions()) {
        	finalCheque += "  +" + boughtAddition.getName() + " - " + boughtAddition.getPrice() + "€\n";
            }
        }
        
        return finalCheque;
    }

}
