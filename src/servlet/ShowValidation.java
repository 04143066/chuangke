package servlet;

import java.io.IOException;
import java.sql.Blob;
import java.util.Date;

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
import model.User;
import model.Validation;

/**
 * Servlet implementation class ShowValidation
 */
@WebServlet("/ShowValidation")
public class ShowValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowValidation() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int userId = 3;
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null)
			userId = Integer.parseInt((String) session.getAttribute("userid"));
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		User user = userDao.findUserById(userId);
		int validationId = 12;
		if(request.getParameter("validationId") != null)
			validationId = Integer.parseInt(request.getParameter("validationId"));
		Validation vali = new Validation();
		ValidationDao validao = ValidationDaoFactory.getValidationDaoInstance();
		vali = validao.findByVid(validationId);
		System.out.println("333招标信息的id号"+vali.getVid());
		request.setAttribute("validation", vali);
		request.setAttribute("user", user);
		request.getRequestDispatcher("showValidation.jsp").forward(request, response);
	}
}
