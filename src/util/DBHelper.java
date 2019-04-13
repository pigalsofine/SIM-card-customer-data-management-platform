package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
   
	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //数据库驱动
	//连接数据库的URL地址
	private static final String url="jdbc:sqlserver://localhost:1433;database=EDUC"; 
	private static final String username="sa";//数据库的用户名
	private static final String password="1";//数据库的密码
    
	private static Connection conn = null;
	//静态代码块加载驱动
	static{
		try {
			//加载驱动程序
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		if (conn==null) {
			//获得数据库的连接
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = DBHelper.getConnection();
			if (conn!=null) {
				System.out.println("数据库连接正常");
			}else {
				System.out.println("数据库连接异常");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
