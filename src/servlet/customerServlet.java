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
import entity.Card;
import entity.Company;
import entity.Customer;
import entity.Log;
import entity.Passage;
import entity.Rate;
import entity.Tag;



public class customerServlet extends HttpServlet {

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

		CustomerDao customerDao = new CustomerDao();
		ArrayList<Customer> customer_list = customerDao.getArrayList_customer();
		
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

		request.setAttribute("map_C_C", map_C_C);

		request.getRequestDispatcher("/manager/customer.jsp").forward(request,response);//请求重定

		return;
         	
	}

}
