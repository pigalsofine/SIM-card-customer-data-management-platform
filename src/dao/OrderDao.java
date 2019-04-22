package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Order;
import util.DBHelper;

public class OrderDao {
	
	public ArrayList<Order> getArrayList_order_package() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Order> order_list = new ArrayList<Order>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM orderpacket";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				Order order = new Order();
				order.setAmountFloat(rs.getFloat("amount"));
				order.setCard_idString(rs.getString("card_id"));
				order.setCustomerString(rs.getString("customer"));
				order.setDeal_timeString(rs.getString("deal_time"));
				order.setPackageString(rs.getString("package"));
				order.setSubmit_timeString(rs.getString("submit_time"));
				
				order_list.add(order);
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
		return order_list;
	}
	
	public ArrayList<Order> getArrayList_order_recharge() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Order> order_list = new ArrayList<Order>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM orderrecharge";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				Order order = new Order();
				order.setAmountFloat(rs.getFloat("amount"));
				order.setCard_idString(rs.getString("card_id"));
				order.setCustomerString(rs.getString("customer"));
				order.setDeal_timeString(rs.getString("deal_time"));
				order.setPackageString(rs.getString("package"));
				order.setSubmit_timeString(rs.getString("submit_time"));
				
				order_list.add(order);
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
		return order_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderDao orderdao = new OrderDao();
		ArrayList<Order> order_list = orderdao.getArrayList_order_package();
		System.out.println(order_list.size());
		for(int i = 0; i < order_list.size(); i++) {
			System.out.println(order_list.get(i).getCard_idString());
		}
		
		ArrayList<Order> order_list_recharge = orderdao.getArrayList_order_recharge();
		System.out.println(order_list_recharge.size());
		for(int i = 0; i < order_list_recharge.size(); i++) {
			System.out.println(order_list_recharge.get(i).getCard_idString());
		}
 
	}

}
