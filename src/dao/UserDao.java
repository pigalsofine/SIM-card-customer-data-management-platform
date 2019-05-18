package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.User;
import util.DBHelper;

public class UserDao {
	
	public ArrayList<User> getArrayList_user() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<User> user_list = new ArrayList<User>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM User";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setPassword(rs.getString("user_password"));
				user.setUsername(rs.getString("user_name"));
				user_list.add(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			//释放数据集对象
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//释放语句对象
			if (stmt!=null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
		}
		return user_list;
	}
		
	public User get_user_by_name(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<User> user_list = new ArrayList<User>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "select * from User where user_name=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name.toUpperCase());
			rs = stmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setPassword(rs.getString("user_password"));
				user.setUsername(rs.getString("user_name"));
				return user;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			//释放数据集对象
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//释放语句对象
			if (stmt!=null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
		}
		return null;
	}
	
	public boolean set_user_password(String nameString, String passwordString) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "update user set user_password=? where user_name=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(2, nameString.toUpperCase());
			stmt.setString(1, passwordString.toUpperCase());
			
			stmt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			//释放数据集对象
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//释放语句对象
			if (stmt!=null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userdao = new UserDao();
		ArrayList<User> user_list = userdao.getArrayList_user();
		System.out.print(user_list.size());
		for(int i = 0; i < user_list.size(); i++) {
			System.out.println(user_list.get(i).getUsername());
		}
		System.out.println(userdao.get_user_by_name("wanghai").getPassword());
		userdao.set_user_password("wanghai","122");
		System.out.println(userdao.get_user_by_name("wanghai").getPassword());
	}

}
