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
		ResultSet rs = null;//���ݼ�
		int flag = 0;
		ArrayList<Rate> rate_list = new ArrayList<Rate>();
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
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
			//�ͷ����ݼ�����
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//�ͷ�������
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
