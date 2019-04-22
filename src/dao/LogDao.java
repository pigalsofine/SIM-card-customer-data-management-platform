package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Log;
import util.DBHelper;

public class LogDao {
	
	public ArrayList<Log> getArrayList_log() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Log> log_list = new ArrayList<Log>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM Log";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				Log log = new Log();
				log.setUsernameString(rs.getString("user_name"));
				log.setOperateString(rs.getString("operate"));
				log.setTimeString(rs.getString("time"));
				log_list.add(log);
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
		return log_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogDao logdao = new LogDao();
		ArrayList<Log> log_list = logdao.getArrayList_log();
		System.out.print(log_list.size());
		for(int i = 0; i < log_list.size(); i++) {
			System.out.print(log_list.get(i).getUsernameString());
		}
 
	}

}
