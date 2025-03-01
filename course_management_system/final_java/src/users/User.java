package users;

import java.sql.Connection;
import database.ConnectionDB;

public  class User {
	public int id;
	public String name;
	public String email;
	public String phone;
	protected Connection connect;
	static ConnectionDB db = new ConnectionDB();

	public User() {
		try {
			connect = db.load();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public User(int id, String name, String email, String phone) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.phone = phone;
		try {
			connect = db.load();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
