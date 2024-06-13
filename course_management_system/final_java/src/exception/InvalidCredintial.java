package exception;

import java.sql.SQLException;

public class InvalidCredintial extends SQLException{
	 private static final long serialVersionUID = 1L;
		public InvalidCredintial() {
			super("Invalid Credintial");
		}
}
