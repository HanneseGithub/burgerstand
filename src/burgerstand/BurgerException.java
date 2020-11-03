package burgerstand;

public class BurgerException extends Exception{

    public BurgerException() {
	super();
    }
    
    public BurgerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public BurgerException(String message, Throwable cause) {
	super(message, cause);
    }
    
    public BurgerException(String message) {
	super(message);
    }
    
    public BurgerException(Throwable cause) {
	super(cause);
    }
}

