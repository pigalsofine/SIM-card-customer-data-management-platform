package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.ManagerRole;
import util.DBHelper;

public class ManagerRoleDao {
	
	public ArrayList<ManagerRole> getArrayList_managerrole() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<ManagerRole> managerrole_list = new ArrayList<ManagerRole>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM role";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery("select * from role");
			while(rs.next()){
				ManagerRole managerrole = new ManagerRole();
				managerrole.setName(rs.getString("name"));
				managerrole.setAdd_time(rs.getString("add_time"));
				managerrole.setPermission(rs.getString("permission"));
				managerrole.setDesprition(rs.getString("desprition"));
				managerrole_list.add(managerrole);
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
		return managerrole_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagerRoleDao manager = new ManagerRoleDao();
		ArrayList<ManagerRole> managerrole_list = manager.getArrayList_managerrole();
		System.out.print(managerrole_list.size());
		for(int i = 0; i < managerrole_list.size(); i++) {
			System.out.print(managerrole_list.get(i).getName());
		}
 
	}

}
