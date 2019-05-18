package servlet;

import java.awt.print.Printable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CardDao;
import dao.CompanyDao;
import dao.CustomerDao;
import dao.LogDao;
import dao.ManagerDao;
import dao.PassageDao;
import dao.RateDao;
import dao.TagDao;
import dao.UserDao;
import entity.Card;
import entity.Company;
import entity.Customer;
import entity.Log;
import entity.Passage;
import entity.Rate;
import entity.Tag;
import entity.User;



public class customerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//…Ë÷√±‡¬Î∏Ò Ω∑¿÷π¬“¬Î
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		HttpSession session = request.getSession(true);
		
		CustomerDao customerDao = new CustomerDao();
		ArrayList<Customer> customer_list = customerDao.getArrayList_customer();

		String form = request.getParameter("form");
		if (form != null ) {
			if (form.equals("change_password")) {
				String idString = request.getParameter("customer_id");
				String passwordString = request.getParameter("password");
				
				UserDao userdao = new UserDao();
				String nameString = customerDao.get_customer_by_id(idString).getNameString();
				Boolean ret = userdao.set_user_password(nameString, passwordString);
				
			}
		}
		
		CardDao carddao = new CardDao();
		ArrayList<Card> card_list = carddao.getArrayList_card();
		
		Map<Customer, Card> map_C_C = new HashMap<>();
		for ( int i = 0; i < card_list.size(); i++ ) {
			String customer_name = card_list.get(i).getCustomerString();
			for ( int j = 0; j < customer_list.size(); j++ ) {
				if ( customer_name.equals( customer_list.get(j).getNameString()) ) {
					map_C_C.put(customer_list.get(j),  card_list.get(i));
					break;
				}
			}
		}

		session.setAttribute("map_C_C", map_C_C);
		response.sendRedirect("/SIM-card-customer-data-management-platform/customer.jsp");
		return;
         	
	}

}
