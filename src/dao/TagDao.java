package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Tag;
import util.DBHelper;

public class TagDao {
	
	public ArrayList<Tag> getArrayList_tag() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Tag> tag_list = new ArrayList<Tag>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM tag";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				Tag tag = new Tag();
				tag.setNameString(rs.getString("name"));
				tag.setTypeInteger(rs.getInt("type"));
				tag.setPermissionInteger(rs.getInt("type"));

				tag_list.add(tag);
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
		return tag_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TagDao tagdao = new TagDao();
		ArrayList<Tag> tag_list = tagdao.getArrayList_tag();
		System.out.print(tag_list.size());
		for(int i = 0; i < tag_list.size(); i++) {
			System.out.print(tag_list.get(i).getNameString());
		}
 
	}

}
