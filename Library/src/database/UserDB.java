package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import business.User;
import utility.DBUtility;


public class UserDB {

	public int loginUser(User user) {
        int x = 0;
        Connection conn = DBUtility.getConnection();
        PreparedStatement ps = null;

        try {
            String query = "select email from accounts where email=? and password=? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtility.closeConnection(conn);
        }
        return x;
    }

    public String getType(User user) {
        // TODO Auto-generated method stub
        String x = null;
        Connection conn = DBUtility.getConnection();
        PreparedStatement ps = null;

        try {
            String query = "select TypeName from AccountType, accounts where TypeID=TypeofAccount and Email=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                x = rs.getString(1);
            }
            return x;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtility.closeConnection(conn);
        }
    }

    public String getUser(User user) {
        Connection con = DBUtility.getConnection();
        PreparedStatement ps = null;
        String name = null;
        String query = "SELECT name FROM accounts WHERE Email = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user.getEmail());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtility.closeConnection(con);
        }
    }

    public User getUserDetails(String email) {
        Connection con = DBUtility.getConnection();
        PreparedStatement ps = null;
        User user = new User();
        String query = "SELECT name, email FROM login WHERE email = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString(1));
                user.setEmail(rs.getString(2));
                return user;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtility.closeConnection(con);
        }
    }

    public void updateUser(User user, String email) {
        Connection con = DBUtility.getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE login SET name = ?, email = ?, password = ?, cpassword = ? WHERE email = ?;";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(5, email);
            int x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DBUtility.closeConnection(con);
        }
    }
    
    public int checkUser(User user) {
        Connection con = DBUtility.getConnection();
        PreparedStatement ps = null;
        int x = 0;
        String query = "SELECT name FROM login WHERE email = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user.getEmail());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                x = 1;
                return x;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtility.closeConnection(con);
        }
        return 0;
    }

    public int createUser(User user) {
        // TODO Auto-generated method stub
        Connection conn = DBUtility.getConnection();
        PreparedStatement ps = null;

        try {
            String query = "insert into login values(?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(5, user.getType());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtility.closeConnection(conn);
        }
    }
}
