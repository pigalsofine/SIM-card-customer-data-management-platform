package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Company;
import entity.ManagerRole;
import util.DBHelper;

public class CompanyDao {
	
	public ArrayList<Company> getArrayList_company() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;//数据集
		int flag = 0;
		ArrayList<Company> company_list = new ArrayList<Company>();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "SELECT * FROM role";
			stmt = conn.createStatement();
			rs = (ResultSet) stmt.executeQuery("select * from company");
			while(rs.next()){
				Company company = new Company();
				company.setAccountString(rs.getString("account"));
				company.setPhoneString(rs.getString("phone"));
				company.setAlipay_accountString(rs.getString("alipay_account"));
				company.setAlipy_nameString(rs.getString("alipay_name"));
				company.setRateFloat(rs.getFloat("rate"));
				company.setSalesman_nameString(rs.getString("salesman_name"));
				company.setEmailString(rs.getString("email"));
				company.setRoleString(rs.getString("role"));
				company.setNameString(rs.getString("name"));
				company.setNameString(rs.getString("status"));
				company_list.add(company);
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
		return company_list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompanyDao companyDao = new CompanyDao();
		ArrayList<Company> company_list = companyDao.getArrayList_company();

		for(int i = 0; i < company_list.size(); i++) {
			System.out.print(company_list.get(i).getNameString());
			System.out.print(company_list.get(i).getSalesman_nameString());
		}
 
	}

}
