package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.ValidationDao;
import factory.UserDaoFactory;
import factory.ValidationDaoFactory;
import model.User;
import model.Validation;
import util.Page;
import util.PageUtil;

/**
 * Servlet implementation class showPersonList
 */
@WebServlet("/showPersonList")
public class showPersonList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showPersonList() {
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
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		User user = new User();
		int countuser = userDao.countUser();
		Page page = PageUtil.createPage(12, countuser,currentPage);//设置分页信息
		List<User> users = userDao.findUserByGroup(page);
		request.setAttribute("page", page);
		request.setAttribute("userList", users);
		request.getRequestDispatcher("personMarkt.jsp").forward(request,response);
		System.out.println("查询到人数的记录："+countuser);
		System.out.println("list人数的大小："+users.size());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
