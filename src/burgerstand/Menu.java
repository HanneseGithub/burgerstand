package burgerstand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Menu {
    private Map<Burger, AdditionSelection> burgerMenu;
    private List<Burger> burgers;

    public Menu() {
	burgerMenu = new TreeMap<Burger, AdditionSelection>();
	burgers = new ArrayList<Burger>();
    }
    
    public void addToMenu(Burger burger, AdditionSelection additions) {
	burgerMenu.put(burger, additions);
	burgers.add(burger);
    }
    
    public Map<Burger, AdditionSelection> getBurgerMenu() {
	return burgerMenu;
    }
    
    public List<Burger> getBurgers() {
	Collections.sort(burgers);
	return burgers;
    }
    
    @Override
    public String toString() {
	String menu = "";
	int counter = 1;
	
	System.out.println("0 - Finish the order");
	
	for (Burger key : this.burgerMenu.keySet()) {
	    menu += counter + " - " + key + "\n";
	    counter++;
	}
	
	return menu;
    }
}
