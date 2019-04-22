package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {
	
	public static Connection getConnection() throws Exception{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String  user="root";
			String  pwd="123456~asd";
			String url="jdbc:mysql://localhost:3306/sim-manager?serverTimezone=GMT";
			con=DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = DBHelper.getConnection();
			if (conn!=null) {
				System.out.println("���ݿ���������");
				Statement stmt = conn.createStatement();
				ResultSet rs = (ResultSet) stmt.executeQuery("select * from sim-manager");
				                                                   //table_1 Ϊ����MySQL���ݿ��д�����-�������
				while(rs.next()){
					System.out.println(rs.getString("iduser_name"));        //ȡMySQL���ݿ���table_1���е�ID
				}
			}else {
				System.out.println("���ݿ������쳣");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
