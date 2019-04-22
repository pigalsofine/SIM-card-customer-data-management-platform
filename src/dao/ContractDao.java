package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Contract;
import entity.Log;
import util.DBHelper;

public class ContractDao {
	
	public ArrayList<Contract> getArrayList_contract() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Contract> contract_list = new ArrayList<Contract>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM contract";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				Contract contract = new Contract();
				contract.setContextString(rs.getString("context"));
				contract.setNameString(rs.getString("name"));
				contract.setPart_aString(rs.getString("part_a"));
				contract.setPart_bString(rs.getString("part_b"));
				contract.setTimeString(rs.getString("time"));
				contract_list.add(contract);
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
		return contract_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContractDao contractdao = new ContractDao();
		ArrayList<Contract> contract_list = contractdao.getArrayList_contract();
		System.out.print(contract_list.size());
		for(int i = 0; i < contract_list.size(); i++) {
			System.out.print(contract_list.get(i).getNameString());
		}
 
	}

}
