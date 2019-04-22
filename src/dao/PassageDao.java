package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.ManagerRole;
import entity.Passage;
import util.DBHelper;

public class PassageDao {
	
	public ArrayList<Passage> getArrayList_passage() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Passage> passage_list = new ArrayList<Passage>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM passage";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery("select * from passage");
			while(rs.next()){
				Passage passage = new Passage();
				passage.setNameString(rs.getString("name"));
				passage.setOperatorString(rs.getString("operator"));
				passage.setAttrString(rs.getString("attr"));
				passage.setChinese_nameString(rs.getString("chinese_name"));
				passage.setUser_nameString(rs.getString("user_name"));
				passage.setUser_passwordString(rs.getString("user_password"));
				passage.setKeyString(rs.getString("key"));
				passage.setAddressString(rs.getString("address"));
				passage.setPollingBoolean(rs.getBoolean("polling"));
				passage.setOverageFloat(rs.getFloat("overage"));

				passage_list.add(passage);
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
		return passage_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PassageDao passagedao = new PassageDao();
		ArrayList<Passage> passage_list = passagedao.getArrayList_passage();
		System.out.print(passage_list.size());
		for(int i = 0; i < passage_list.size(); i++) {
			System.out.print(passage_list.get(i).getNameString());
		}
 
	}

}
