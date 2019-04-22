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
import dao.DiagnosisDao;
import dao.ManagerDao;
import dao.PassageDao;
import dao.TagDao;
import entity.Company;
import entity.Diagnosis;
import entity.Passage;
import entity.Tag;



public class diagnosisServlet extends HttpServlet {

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

		DiagnosisDao diagnosisdao = new DiagnosisDao();
		ArrayList<Diagnosis> diagnosis_list = diagnosisdao.getArrayList_diagnosis();

		request.setAttribute("diagnosis_list", diagnosis_list);

		request.getRequestDispatcher("/manager/diagnosis.jsp").forward(request,response);//请求重定

		return;
         	
	}

}
