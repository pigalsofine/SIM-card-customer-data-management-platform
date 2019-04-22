package servlet;

import java.awt.print.Printable;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManagerRoleDao;
import entity.ManagerRole;

public class manager_roleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
		
		ManagerRoleDao manager = new ManagerRoleDao();
		ArrayList<ManagerRole> managerRole_list = manager.getArrayList_managerrole();
		
		request.setAttribute("managerRole_list", managerRole_list);
		
		request.getRequestDispatcher("/manager/users_manager.jsp").forward(request,response);//请求重定向
		return;         
	}

}
