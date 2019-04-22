package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CompanyDao;
import dao.CustomerDao;
import dao.ManagerDao;
import entity.Company;



public class companyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设置编码格式防止乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8"); 

		CompanyDao companyDao = new CompanyDao();
		ArrayList<Company> company_list = companyDao.getArrayList_company();
		
		request.setAttribute("company_list", company_list);
		
		request.getRequestDispatcher("/manager/manager_seconduser.jsp").forward(request,response);//请求重定
		//判断是否有登陆表单post进来
		return;
         
	}

}
