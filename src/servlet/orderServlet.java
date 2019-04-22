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
import dao.LogDao;
import dao.ManagerDao;
import dao.OrderDao;
import dao.PassageDao;
import dao.RateDao;
import dao.TagDao;
import entity.Company;
import entity.Log;
import entity.Order;
import entity.Passage;
import entity.Rate;
import entity.Tag;



public class orderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//���ñ����ʽ��ֹ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8"); 

		OrderDao orderdao = new OrderDao();
		ArrayList<Order> order_list_packet = orderdao.getArrayList_order_package();
		ArrayList<Order> order_list_recharge = orderdao.getArrayList_order_recharge();

		request.setAttribute("order_list_packet", order_list_packet);
		request.setAttribute("order_list_recharge", order_list_recharge);

		request.getRequestDispatcher("/manager/order.jsp").forward(request,response);//�����ض�

		return;
         	
	}

}
