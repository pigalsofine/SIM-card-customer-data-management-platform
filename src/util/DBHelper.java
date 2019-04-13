package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
   
	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //���ݿ�����
	//�������ݿ��URL��ַ
	private static final String url="jdbc:sqlserver://localhost:1433;database=EDUC"; 
	private static final String username="sa";//���ݿ���û���
	private static final String password="1";//���ݿ������
    
	private static Connection conn = null;
	//��̬������������
	static{
		try {
			//������������
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		if (conn==null) {
			//������ݿ������
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = DBHelper.getConnection();
			if (conn!=null) {
				System.out.println("���ݿ���������");
			}else {
				System.out.println("���ݿ������쳣");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
