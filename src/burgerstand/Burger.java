package burgerstand;

import java.util.ArrayList;
import java.util.List;

public class Burger implements Comparable<Burger> {
    private String name;
    private String meatType;
    private String breadType;
    private double price;
    
    private List<Addition> burgerAdditions;

    public Burger(String name, String meatType, String breadType, double price) {
	this.name = name;
	this.meatType = meatType;
	this.breadType = breadType;
	this.price = price;
	
	this.burgerAdditions = new ArrayList<Addition>();
    }
    
    public void addAddition(Addition addition) {
	burgerAdditions.add(addition);
    }
    
    public List<Addition> getBurgerAdditions() {
	return burgerAdditions;
    }
    
    public double burgerPrice() {
	double totalPrice = 0;
	totalPrice += this.price;
	
	for(Addition addition : burgerAdditions) {
	    totalPrice += addition.getPrice();
	}
	
	return totalPrice;
    }
    
    public String getName() {
	return this.name;
    }
    
    public double getPrice() {
	return this.price;
    }

    @Override
    public int compareTo(Burger o) {
	if (this.name.compareTo(o.getName()) < 0) {
	    return -1;
	} else if (this.name.compareTo(o.getName()) > 0) {
	    return 1;
	} else {
	    return 0;
	}
    }
    
    @Override
    public String toString() {
        return this.name + " - " + this.meatType + ", " + this.breadType + " ("+ this.price +"€)";
    }
}
