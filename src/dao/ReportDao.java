package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import entity.Report;
import util.DBHelper;

public class ReportDao {
	
	public ArrayList<Report> getArrayList_report() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//���ݼ�
		int flag = 0;
		ArrayList<Report> report_list = new ArrayList<Report>();
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "SELECT * FROM report";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				Report report = new Report();
				report.setNameString(rs.getString("name"));
				report.setTypeInteger(rs.getInt("type"));
				report.setTime(rs.getString("time"));
				report.setContextString(rs.getString("context"));
				report.setContactString(rs.getString("contact"));

				report_list.add(report);
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
		return report_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReportDao reportDao = new ReportDao();
		ArrayList<Report> report_list = reportDao.getArrayList_report();
		System.out.print(report_list.size());
		for(int i = 0; i < report_list.size(); i++) {
			System.out.print(report_list.get(i).getNameString());
		}
 
	}

}
