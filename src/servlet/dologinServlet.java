package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.CustomerDao;
import dao.ManagerDao;



public class dologinServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("bba");
		CustomerDao customerdao = new CustomerDao();
		ManagerDao managerdao = new ManagerDao();
		
		//设置编码格式防止乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		//System.out.println(req.getParameter("username")+" "+req.getParameter("password"));

		response.sendRedirect("/SIM-card-customer-data-management-platform/login.jsp");//请求重定向
		//判断是否有登陆表单post进来
		return;
         
	}

}
