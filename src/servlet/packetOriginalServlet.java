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
import dao.PacketOriginalDao;
import dao.PassageDao;
import dao.TagDao;
import entity.Company;
import entity.Log;
import entity.PacketOriginal;
import entity.Passage;
import entity.Tag;

public class packetOriginalServlet extends HttpServlet {

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

		PacketOriginalDao packet_originaldao = new PacketOriginalDao();
		ArrayList<PacketOriginal> packet_original_list = packet_originaldao.getArrayList_packet_original();
		System.out.println(packet_original_list.size());
		request.setAttribute("packet_original_list", packet_original_list);
		
		String operatorString = request.getParameter("operator");

		if ( operatorString.equals("tele") ) {
			request.getRequestDispatcher("/manager/packetOriginalTele.jsp").forward(request,response);//�����ض�
		} else if ( operatorString.equals("mobile") ) {
			request.getRequestDispatcher("/manager/packetOriginalMobile.jsp").forward(request,response);//�����ض�
		}

		return;
         	
	}

}
