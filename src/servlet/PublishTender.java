package servlet;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.ValidationDao;
import factory.UserDaoFactory;
import factory.ValidationDaoFactory;
import model.Validation;
import java.util.Date;

/**
 * Servlet implementation class PublishTender
 */
@WebServlet("/PublishTender")
public class PublishTender extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishTender() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳转成功");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		int tenderee = 3;
		if(session.getAttribute("userid")!=null)
			tenderee = Integer.parseInt((String) session.getAttribute("userid"));		
		Validation validation = new Validation();
		validation.setVtenderee(tenderee);
		ValidationDao validationDao =  ValidationDaoFactory.getValidationDaoInstance(); 
		String validation_money = request.getParameter("vmoney"); 
		System.out.println("1111"+validation_money);
		int vmoney = Integer.parseInt(validation_money); 
		System.out.println("2222"+vmoney);
		validation.setVmoney(vmoney);
		String validation_name= request.getParameter("vname");
		System.out.println("3333"+validation_name);
		validation.setVname(validation_name);
		String valiation_text = request.getParameter("vtext");
		String valiation_profile = request.getParameter("vprofile");
		validation.setVprofile(valiation_profile);
		System.out.println(valiation_text);
		validation.setVdate(new Date());
		validation.setVtext(valiation_text);
		int j=0;
		if (request.getParameterValues("user_group") != null) {
			String[] favorites = request.getParameterValues("user_group");
			for (int i = 0; i < favorites.length; i++) {
				j += Integer.parseInt(favorites[i]);
			}
		}
		validation.setVgroup(j);
		validationDao.addValidation(validation);
		request.getRequestDispatcher("showZhaobiaoList").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
