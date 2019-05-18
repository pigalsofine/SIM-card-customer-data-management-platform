package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Card;
import entity.Log;
import util.DBHelper;

public class CardDao {
	
	public ArrayList<Card> getArrayList_card() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Card> card_list = new ArrayList<Card>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM card";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				Card card = new Card();
				card.setIdInteger(rs.getInt("id"));
				card.setNumberString(rs.getString("number"));
				card.setCard_idString(rs.getString("card_id"));
				card.setICCID(rs.getString("ICCID"));
				card.setIMSI(rs.getString("IMSI"));
				card.setStatusInteger(rs.getInt("status"));
				card.setTagString(rs.getString("tag"));
				card.setStart_timeString(rs.getString("start_time"));
				card.setBilling_timeString(rs.getString("billing_time"));
				card.setBilling_cycleInteger(rs.getInt("billing_cycle"));
				card.setPacket_nameString(rs.getString("packet_name"));
				card.setFlow_usedFloat(rs.getFloat("flow_used"));
				card.setFlow_totalFloat(rs.getFloat("flow_total"));
				card.setRechargeFloat(rs.getFloat("recharge"));
				card.setOverangeFloat(rs.getFloat("overange"));
				card.setIpString(rs.getString("ip"));
				card.setDomainString(rs.getString("domain"));
				card.setCustomerString(rs.getString("customer"));
				card.setOwnerString(rs.getString("owner"));
				card.setOperatorString(rs.getString("operator"));

				card_list.add(card);
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
		return card_list;
	}
	
	public boolean change_ip(String ipString, String idString) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		int id = Integer.parseInt(idString);
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "update card set ip=? where id=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ipString.toUpperCase());
			stmt.setInt(2, id);
			
			stmt.execute();
			
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
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardDao carddao = new CardDao();
		carddao.change_ip("2224423","1");
		ArrayList<Card> card_list = carddao.getArrayList_card();
		System.out.print(card_list.size());
		for(int i = 0; i < card_list.size(); i++) {
			System.out.println(card_list.get(i).getIpString());
		}
 
	}

}
