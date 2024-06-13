import java.awt.EventQueue;
import database.DatabaseMGMT;
import gui.Login;
public class Main {
	 public static void main(String[] args) {
		 DatabaseMGMT db = new DatabaseMGMT();
		 db.setUrl("jdbc:mysql://localhost:3306/cms");
		 db.setUsername("root");
		 db.setPassword("");
		 EventQueue.invokeLater(new Runnable() {
		 public void run() {
		 try {
		 Login window = new Login();
		 window.frame.setVisible(true);
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		 }
});
		 }
}
