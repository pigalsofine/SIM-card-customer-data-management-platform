package servlet;

import java.awt.print.Printable;
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
import dao.PassageDao;
import entity.Company;
import entity.Passage;



public class passageServlet extends HttpServlet {

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

		PassageDao passagedao = new PassageDao();
		ArrayList<Passage> passage_list = passagedao.getArrayList_passage();
		System.out.println(passage_list.size());
		
		request.setAttribute("passage_list", passage_list);
		
		String operatorString = request.getParameter("operator");
		System.out.println(operatorString);
		if ( operatorString.equals("tele") ) {
			request.getRequestDispatcher("/manager/passage-tele.jsp").forward(request,response);//请求重定
		} else if ( operatorString.equals("mobile") ) {
			request.getRequestDispatcher("/manager/passage-mobile.jsp").forward(request,response);//请求重定
		}
		
		//判断是否有登陆表单post进来
		return;
         	
	}

}
