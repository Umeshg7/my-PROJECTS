package exception;

public class InvalidMarks extends RuntimeException {
	 private static final long serialVersionUID = 1L;
    public InvalidMarks() {
        super("Invalid marks");
    }
}
