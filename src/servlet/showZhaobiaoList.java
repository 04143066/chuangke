package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ValidationDao;
import factory.ValidationDaoFactory;
import model.Validation;
import util.Page;
import util.PageUtil;

/**
 * Servlet implementation class showZhaobiaoList
 */
@WebServlet("/showZhaobiaoList")
public class showZhaobiaoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showZhaobiaoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr == null || "".equals(currentPageStr)){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		ValidationDao validationDao = ValidationDaoFactory.getValidationDaoInstance();
		Validation validation = new Validation();
		int countValidation = validationDao.countUntendValidation();
		Page page = PageUtil.createPage(12, countValidation,currentPage);//设置分页信息
		List<Validation> validations = validationDao.findUntendVaList(page);
		request.setAttribute("page", page);
		request.setAttribute("validationList", validations);
		request.getRequestDispatcher("zhaobiaoMarket.jsp").forward(request,response);
		System.out.println("查询到的记录："+countValidation);
		System.out.println("list的大小："+validations.size());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
