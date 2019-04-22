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
import dao.PacketSelfDao;
import dao.PassageDao;
import dao.TagDao;
import entity.Company;
import entity.Log;
import entity.PacketOriginal;
import entity.PacketSelf;
import entity.Passage;
import entity.Tag;

public class packetSelflServlet extends HttpServlet {

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

		PacketSelfDao packet_selfdao = new PacketSelfDao();
		ArrayList<PacketSelf> packet_self_list = packet_selfdao.getArrayList_packet_self();
		
		request.setAttribute("packet_self_list", packet_self_list);
		
		String operatorString = request.getParameter("operator");

		request.getRequestDispatcher("/manager/packetSelf.jsp").forward(request,response);//请求重定

		return;
         	
	}

}
