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
import dao.PassageDao;
import dao.RateDao;
import dao.TagDao;
import entity.Company;
import entity.Log;
import entity.Passage;
import entity.Rate;
import entity.Tag;



public class rateServlet extends HttpServlet {

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

		RateDao ratedao = new RateDao();
		ArrayList<Rate> rate_list = ratedao.getArrayList_rate();
		for(int i = 0; i < rate_list.size(); i++) {
			System.out.print(rate_list.get(i).getUsernameString());
		}
		request.setAttribute("rate_list", rate_list);

		request.getRequestDispatcher("/manager/rate.jsp").forward(request,response);//请求重定

		return;
         	
	}

}
