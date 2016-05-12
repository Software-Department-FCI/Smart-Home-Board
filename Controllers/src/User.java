
public class User {
	private String userName;
	private String password;
	public static int userID = 0;
	private boolean isAdmin;
	User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		userID++;
		isAdmin = false;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getUserName(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	public void makeAdmin(){
		isAdmin = true;
	}
	public boolean isAdmin(){
		return isAdmin;
	}
}
