import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminActions {
	AdminActions(User user){
		
	}
	public void addUser(User user) throws SQLException{
		Connection con = DriverManager.getConnection(null);
		CallableStatement cs = con.prepareCall("{call sp_signUp}");
		cs.setString(1, user.getUserName());
		cs.setString(2, user.getPassword());
		cs.executeQuery();
	}
	public void removeUser(User user) throws SQLException{
		Connection con = DriverManager.getConnection(null);
		CallableStatement cs = con.prepareCall("{call sp_deleteUser}");
		cs.setString(1, user.getUserName());
		cs.executeQuery();
	}
	public void updateUser(User tmpUser) throws SQLException{
		Connection con = DriverManager.getConnection(null);
		CallableStatement cs = con.prepareCall("{call sp_updateUser}");
		cs.setString(1, tmpUser.getUserName());
		cs.setString(2, tmpUser.getPassword());
		cs.setLong(3, tmpUser.userID);
		cs.executeQuery();
		
	}
	public void addBoard(Board board) throws SQLException{
		Connection con = DriverManager.getConnection(null);
		CallableStatement cs = con.prepareCall("{call sp_addBoard}");
		cs.setString(1, board.getName());
		cs.executeQuery();
	}
	public void removeBoard(Board board) throws SQLException{
		Connection con = DriverManager.getConnection(null);
		CallableStatement cs = con.prepareCall("{call sp_removeBoard}");
		cs.setString(1, board.getName());
		cs.executeQuery();
	}
	public void addDevice(Device device) throws SQLException{
		Connection con = DriverManager.getConnection(null);
		CallableStatement cs = con.prepareCall("{call sp_addDevice}");
		cs.setString(1, device.getName());
		cs.executeQuery();
	}
	public boolean removeDevice(Device device) throws SQLException{
		Connection con = DriverManager.getConnection(null);
		CallableStatement cs = null;
		try {
			cs = con.prepareCall("{call sp_removeDevice}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cs.setString(1, device.getName());
		cs.executeQuery();
		return true;
	}
}
