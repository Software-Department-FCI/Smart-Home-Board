import java.sql.*;
public class UserActions {
	private AdminActions admin;
	UserActions(User user){
		
	}
	public boolean sign_in(User user) throws SQLException{
		if (searchUser(user) == null)
			return false;
		else
			return true;		
	}
	public boolean sign_up(User user) throws SQLException{
        admin.addUser(user);
		return true;
	}
	public User searchUser(User user) throws SQLException{
		Connection con = DriverManager.getConnection(null);
		CallableStatement cs = con.prepareCall("{call sp_searchUser}");
		ResultSet rs;
		cs.setString(1, user.getUserName());
		cs.executeQuery();
		rs = cs.getResultSet();
		User tmp = null;
		tmp.setUserName(rs.getString(0));
		tmp.setPassword(rs.getString(1));
		return tmp;
	}
	public boolean deleteUser(User user) throws SQLException{
        admin.removeUser(user);
		return true;
				
	}
	public Board[] getMyBoards(){
		Connection con = DriverManager.getConnection(null);
		CallableStatement cs = con.prepareCall("{call sp_getMyBoards}");
		cs.executeQuery();
		ResultSet rs = cs.getResultSet();
		Board[50] b;
		for(int i = 0; i < rs.getFetchSize(); rs.next()){
			b[i].setName(rs.getString(0));
		}
		return b;
	}
}
