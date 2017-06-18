package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ValidationDao;
import factory.ValidationDaoFactory;
import model.Validation;

/**
 * Servlet implementation class agreeValidation
 */
@WebServlet("/agreeValidation")
public class agreeValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agreeValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int validationId = Integer.parseInt(request.getParameter("validationId"));
		ValidationDao validao = ValidationDaoFactory.getValidationDaoInstance();
		Validation vali = validao.findByVid(validationId);
		System.out.println("1招标的id号"+validationId);
		System.out.println("1招标的状态:"+vali.getVstate());
		validao.agreeValidation(vali);
		vali = validao.findByVid(validationId);
		System.out.println("2招标的id号"+validationId);
		System.out.println("2招标的状态:"+vali.getVstate());
		request.setAttribute("validation", vali);
		request.getRequestDispatcher("ShowValidation?validationId="+vali.getVid()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
