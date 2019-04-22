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

import dao.CardDao;
import dao.CompanyDao;
import dao.CustomerDao;
import dao.ManagerDao;
import dao.PassageDao;
import dao.TagDao;
import entity.Card;
import entity.Company;
import entity.Passage;
import entity.Tag;



public class cardServlet extends HttpServlet {

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

		CardDao carddao = new CardDao();
		ArrayList<Card> card_list = carddao.getArrayList_card();
		
		request.setAttribute("card_list", card_list);

		String operatorString = request.getParameter("operator");

		if ( operatorString.equals("tele") ) {
			request.getRequestDispatcher("/manager/cardTele.jsp").forward(request,response);//请求重定
		} else if ( operatorString.equals("mobile") ) {
			request.getRequestDispatcher("/manager/cardMobile.jsp").forward(request,response);//请求重定
		}

		return;
         	
	}

}
