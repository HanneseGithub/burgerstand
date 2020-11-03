package burgerstand;

import java.util.Scanner;

public class BurgerStand {
    
    // Create static methods for printing
    public static void printText(Object text) {
	System.out.print(text);
    }
    
    public static void printTextLine(Object text) {
	System.out.println(text);
    }

    public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	
	// Create 2 different selections of additions to choose between
	AdditionSelection firstChoiceAdditions = new AdditionSelection(new Addition("Cheese", 0.5), new Addition("Tomato", 1), new Addition("Salad", 0.5), new Addition("Salsa", 1));
	AdditionSelection secondChoiceAdditions = new AdditionSelection(new Addition("Bacon", 1), new Addition("Cucumber", 0.5), new Addition("Onion", 0.5), new Addition("Salad", 0.5));
	
	// Create burgers to add to the menu
	Burger ChickenBurger = new Burger("Chicken Burger", "Chicken", "White bread", 2.50);
	Burger OldFashionedCheeseburger = new Burger("Old Fashioned Cheeseburger", "Pork", "White bread", 4);
	Burger NewYorkBurger = new Burger("New York Burger", "Beef", "Wholegrain bread", 5);
	Burger TheBurger = new GourmetBurger();
	
	// Create a menu with burgers and assign selections to burgers
	Menu burgerMenu = new Menu();

	burgerMenu.addToMenu(ChickenBurger, firstChoiceAdditions);
	burgerMenu.addToMenu(OldFashionedCheeseburger, secondChoiceAdditions);
	burgerMenu.addToMenu(NewYorkBurger, secondChoiceAdditions);
	burgerMenu.addToMenu(TheBurger, firstChoiceAdditions);

	// Print out the menu for the customer
	printTextLine("Welcome to Hannes's Burger Stand! \n");
	printTextLine("Today's menu:");
	
	
	// Initialize the check
	Cheque cheque = new Cheque();
	
	// Start the loop of creating the burger
	while (true) {
	    printTextLine(burgerMenu);
	    
	    printText("Which burger would you like to choose?: ");
	    int selectionNumber = 1;
	    
	    // Validate user input if it's a valid burger or 0 - all the other times keep displaying error and ask again
	    try {
		selectionNumber = Integer.parseInt(userInput.nextLine());
		
		if(selectionNumber > burgerMenu.getBurgers().size()) {
		    throw new BurgerException();
		} else if (selectionNumber == 0) {
		    break;
		}
	    } catch (Exception e) {
		printTextLine("This number of burger is not on the menu, please enter a valid number! \n");
		continue;
	    }
	    
	    // Burger that the client has selected and its additions
	    Burger selectedBurger = burgerMenu.getBurgers().get(selectionNumber - 1);
	    AdditionSelection selectedBurgerAdditions = burgerMenu.getBurgerMenu().get(selectedBurger);
	    
	    printTextLine("\nAdditions available for this burger: " + selectedBurgerAdditions);
	    

	    // Start the loop of choosing additions
	    while (true) {
		printText("Which addition would you like to add to your burger?: ");
		String pickedAddition = userInput.nextLine();
		
		// If user enters nothing go to finishing the burger
		if (pickedAddition.isEmpty()) {
		    break;
		}
		
		// Check if entered addition is in the addition selection
		for (Addition addition : selectedBurgerAdditions.getAdditions()) {
		    // If it's found, add it to the burger
		    if (addition.getName().toLowerCase().equals(pickedAddition.toLowerCase())) {
			selectedBurger.addAddition(addition);
			break;
		    } 
		}
	    }
	    
	    // Add the completed burger to the cheque
	    cheque.addToCheque(selectedBurger);
	    printTextLine("Current total value: " + cheque.calculateFinalPrice() + "€\n");   
	}
	
	// Print out the cheque after order is made
	printTextLine("\nYour order is as follows:");
	printTextLine(cheque);
	printTextLine("That will be a total of: " + cheque.calculateFinalPrice() + "€");
    }

}
