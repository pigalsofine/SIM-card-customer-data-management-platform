package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Diagnosis;
import entity.Tag;
import util.DBHelper;

public class DiagnosisDao {
	
	public ArrayList<Diagnosis> getArrayList_diagnosis() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Diagnosis> diagnosis_list = new ArrayList<Diagnosis>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM diagnosis";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				Diagnosis diagnosis = new Diagnosis();
				diagnosis.setNameString(rs.getString("name"));
				diagnosis.setResultString(rs.getString("result"));
				diagnosis.setDeal_suggeString(rs.getString("deal_suggest"));

				diagnosis_list.add(diagnosis);
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
		return diagnosis_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiagnosisDao diagnosisdao = new DiagnosisDao();
		ArrayList<Diagnosis> diagnosis_list = diagnosisdao.getArrayList_diagnosis();
		System.out.print(diagnosis_list.size());
		for(int i = 0; i < diagnosis_list.size(); i++) {
			System.out.print(diagnosis_list.get(i).getDeal_suggeString());
		}
 
	}

}
