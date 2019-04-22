package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Main {
 

	public static Connection getMySQLCon()
	{
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String  user="root";
			String  pwd="123456~asd";
			String url="jdbc:mysql://localhost:3306/users?serverTimezone=GMT";
			con=DriverManager.getConnection(url,user,pwd);
			Statement stmt = con.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery("select * from user_name");
			                                                   //table_1 Ϊ����MySQL���ݿ��д�����-�������
	 
			while(rs.next()){
				System.out.println(rs.getString("iduser_name"));        //ȡMySQL���ݿ���table_1���е�ID
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn=Main.getMySQLCon();
		if(conn!=null)
		{
			System.out.println("MySQL���ݿ����ӳɹ���Connection="+conn.toString());


		}
 
	}
 } 