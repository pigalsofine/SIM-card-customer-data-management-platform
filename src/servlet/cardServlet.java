package servlet;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer.Form;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 设置编码格式防止乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession(true);
		CardDao carddao = new CardDao();
		
		String form = request.getParameter("form");
		if (form != null ) {
			if (form.equals("change_ip")) {
				String ipString = request.getParameter("ip");
				String idString = request.getParameter("card_id");
				System.out.println("llalalalalla");
				System.out.println(ipString);
				System.out.println(idString);
				carddao.change_ip(ipString, idString);
			}
		}

		
		ArrayList<Card> card_list = carddao.getArrayList_card();
		for (int i = 0; i < card_list.size(); i++){
			System.out.println(card_list.get(i).getIpString());
		}

		session.setAttribute("card_list", card_list);

		String operatorString = request.getParameter("operator");

		if (operatorString.equals("tele")) {
			response.sendRedirect("/SIM-card-customer-data-management-platform/cardTele.jsp");
			// request.getRequestDispatcher("/manager/cardTele.jsp").forward(request,response);//请求重定
		} else if (operatorString.equals("mobile")) {
			response.sendRedirect("/SIM-card-customer-data-management-platform/cardMobile.jsp");
			// request.getRequestDispatcher("/manager/cardMobile.jsp").forward(request,response);//请求重定
		}

		return;

	}

}
