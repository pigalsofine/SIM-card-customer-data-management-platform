package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Customer;
import entity.Tag;
import entity.User;
import util.DBHelper;

public class CustomerDao {
	
	public ArrayList<Customer> getArrayList_customer() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Customer> customer_list = new ArrayList<Customer>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM customer";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				Customer customer = new Customer();
				customer.setIdInteger(rs.getInt("id"));
				customer.setNameString(rs.getString("name"));
				customer.setAccountString(rs.getString("account"));
				customer.setPhoneString(rs.getString("phone"));
				customer_list.add(customer);
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
		return customer_list;
	}

	public Customer get_customer_by_id(String idString) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		Integer integer = Integer.parseInt(idString);
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "select * from customer where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, integer);
			rs = stmt.executeQuery();
			while(rs.next()){
				Customer customer = new Customer();
				customer.setIdInteger(rs.getInt("id"));
				customer.setNameString(rs.getString("name"));
				customer.setAccountString(rs.getString("account"));
				customer.setPhoneString(rs.getString("phone"));
				return customer;
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
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustomerDao();
//		ArrayList<Customer> customer_list = customerDao.getArrayList_customer();
//		for(int i = 0; i < customer_list.size(); i++) {
//			System.out.print(customer_list.get(i).getNameString());
//		}
		System.out.print(customerDao.get_customer_by_id("1").getNameString()); 
 
	}

}
