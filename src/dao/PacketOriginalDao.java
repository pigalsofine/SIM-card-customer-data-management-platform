package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.PacketOriginal;
import entity.Tag;
import util.DBHelper;

public class PacketOriginalDao {
	
	public ArrayList<PacketOriginal> getArrayList_packet_original() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<PacketOriginal> packet_original_list = new ArrayList<PacketOriginal>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM packetOriginal";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				PacketOriginal packet_original = new PacketOriginal();
				packet_original.setNameString(rs.getString("name"));
				packet_original.setCodeString(rs.getNString("code"));
				packet_original.setCostFloat(rs.getFloat("cost"));
				packet_original.setAisleString(rs.getString("aisle"));
				packet_original.setValidity_periodInteger(rs.getInt("validity_period"));
				packet_original.setValidity_flowInteger(rs.getInt("validity_flow"));
				packet_original.setKindString(rs.getString("kind"));
				packet_original.setFormatString(rs.getString("format"));
				packet_original.setEffective_wayString(rs.getString("effective_way"));
				packet_original.setRange_idInteger(rs.getInt("range_id"));
				packet_original.setOperatorString(rs.getString("operator"));
				packet_original_list.add(packet_original);
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
		return packet_original_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacketOriginalDao packet_originaldao = new PacketOriginalDao();
		ArrayList<PacketOriginal> packet_original_list = packet_originaldao.getArrayList_packet_original();
		System.out.print(packet_original_list.size());
		for(int i = 0; i < packet_original_list.size(); i++) {
			System.out.print(packet_original_list.get(i).getNameString());
		}
 
	}

}
