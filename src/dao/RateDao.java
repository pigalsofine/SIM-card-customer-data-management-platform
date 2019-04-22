package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Log;
import entity.Rate;
import util.DBHelper;

public class RateDao {
	
	public ArrayList<Rate> getArrayList_rate() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Rate> rate_list = new ArrayList<Rate>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM rate";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				Rate rate = new Rate();
				rate.setUsernameString(rs.getString("name"));
				rate.setRateFloat(rs.getFloat("rate"));
				rate.setDescriptionString(rs.getString("description"));
				rate_list.add(rate);
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
		return rate_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RateDao ratedao = new RateDao();
		ArrayList<Rate> rate_list = ratedao.getArrayList_rate();
		System.out.print(rate_list.size());
		for(int i = 0; i < rate_list.size(); i++) {
			System.out.print(rate_list.get(i).getUsernameString());
		}
 
	}

}
