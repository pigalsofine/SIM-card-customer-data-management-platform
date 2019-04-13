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
		System.out.println("dopost");

		CustomerDao customerdao = new CustomerDao();
		ManagerDao managerdao = new ManagerDao();
		
		//设置编码格式防止乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		//System.out.println(req.getParameter("username")+" "+req.getParameter("password"));
		HttpSession session = null;
		//判断是否有登陆表单post进来
		if (request.getParameter("username")!=null 
				&& request.getParameter("password")!=null) {
			//判断是否有此用户
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if (managerdao.is_manager(username, password)) {
				
				session = request.getSession();
	            session.setAttribute("username","admin");
	            
				System.out.println("admid");
				
	            response.sendRedirect("/SIM-card-customer-data-management-platform/manager_start.jsp");//请求重定向
	            
	            return;
	            
			} else if (customerdao.is_customer(username, password)) {
				
				session = request.getSession();
	            session.setAttribute("username",request.getParameter("username"));
				
	            response.sendRedirect("/SIM-card-customer-data-management-platform/customerdao_start.jsp");//请求重定向
	           
	            return;
			} else {
				//如果用户名或密码错误，则返回错误session
				session = request.getSession();
	            session.setAttribute("loginError", "请检查用户名或密码");
	            
	            response.sendRedirect("/SIM-card-customer-data-management-platform/login.jsp");//请求重定向
				return  ;
			}
			
		}	          
	}

}
