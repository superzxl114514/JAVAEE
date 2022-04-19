package biz;

import java.sql.SQLException;

import dao.DataBaseOperator;

public class Userbiz {
	public static boolean login(String usern, String passw) throws SQLException {
		if(DataBaseOperator.getInstance().search(usern,passw)!=null) {
			return true;
		}
		else {
			return false;
		}
	}
}
