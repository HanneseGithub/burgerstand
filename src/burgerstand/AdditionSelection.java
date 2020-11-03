package burgerstand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Addition selection creates a bundle of available additions to add to a burger.
public class AdditionSelection {
    private List<Addition> additions;
    
    public AdditionSelection(Addition addition1, Addition addition2, Addition addition3, Addition addition4) {
	additions = new ArrayList<Addition>();
	Collections.addAll(additions, addition1, addition2, addition3, addition4);
    }
    
    public List<Addition> getAdditions() {
	return additions;
    }
    
    @Override
    public String toString() {
	String additionString = "";
	int counter = 0;
	
	for (Addition addition : additions) {
	    if (counter < additions.size() - 1) {
		additionString += addition.getName() + " - " + addition.getPrice() + "€ / ";
	    } else {
		additionString += addition.getName() + " - " + addition.getPrice() + "€";
	    }
	    
	    counter++;
	}
        return additionString;
    }
}
