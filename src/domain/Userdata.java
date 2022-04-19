package domain;

public class Userdata {
	String Username;
	String Password;
	public String Get_Username() {
		return this.Username;
	}
	public String Get_Password() {
		return this.Password;
	}
	public void Set_Username(String m) {
		this.Username=m;
	}
	public void Set_Password(String m) {
		this.Password=m;
	}
}
