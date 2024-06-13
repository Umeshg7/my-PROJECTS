package exception;

public class InvalidFormat extends RuntimeException{
	 private static final long serialVersionUID = 1L;
    public InvalidFormat() {
        super("Invalid format!");
    }  
}
