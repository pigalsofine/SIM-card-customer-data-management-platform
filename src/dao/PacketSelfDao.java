package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.PacketSelf;
import util.DBHelper;

public class PacketSelfDao {
	
	public ArrayList<PacketSelf> getArrayList_packet_self() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<PacketSelf> packet_self_list = new ArrayList<PacketSelf>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM packetself";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				PacketSelf packet_self = new PacketSelf();
				packet_self.setNameString(rs.getString("name"));
				packet_self.setCodeString(rs.getNString("code"));
				packet_self.setCostFloat(rs.getFloat("cost"));
				packet_self.setAisleString(rs.getString("aisle"));
				packet_self.setValidity_periodInteger(rs.getInt("validity_period"));
				packet_self.setValidity_flowInteger(rs.getInt("validity_flow"));
				packet_self.setKindString(rs.getString("kind"));
				packet_self.setFormatString(rs.getString("format"));
				packet_self.setEffective_wayString(rs.getString("effective_way"));
				packet_self.setRange_idInteger(rs.getInt("range_id"));
				packet_self.setTagString(rs.getString("tag"));
				packet_self.setDescriptionString(rs.getString("description"));
				packet_self_list.add(packet_self);
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
		return packet_self_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacketSelfDao packet_selfdao = new PacketSelfDao();
		ArrayList<PacketSelf> packet_self_list = packet_selfdao.getArrayList_packet_self();
		System.out.print(packet_self_list.size());
		for(int i = 0; i < packet_self_list.size(); i++) {
			System.out.print(packet_self_list.get(i).getNameString());
		}
 
	}

}
