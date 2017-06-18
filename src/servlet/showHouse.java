package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BlogDao;
import dao.UserDao;
import dao.ValidationDao;
import factory.BlogDaoFactory;
import factory.UserDaoFactory;
import factory.ValidationDaoFactory;
import model.Blog;
import model.User;
import model.Validation;
import util.Page;
import util.PageUtil;

/**
 * Servlet implementation class showHouse
 */
@WebServlet("/showHouse")
public class showHouse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showHouse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId=0;
		HttpSession session = request.getSession();
		if(request.getParameter("userId") != null) 
			userId = Integer.parseInt(request.getParameter("userId"));
		else if(session.getAttribute("userid") != null){
			userId = Integer.parseInt((String) session.getAttribute("userid"));
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr == null || "".equals(currentPageStr)){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		BlogDao blogDao = BlogDaoFactory.getBlogDaoInstance();
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		List<Blog> blogs = null;
		User user = null;
		int blogCount = blogDao.findAllCount(userId);
		Page page = PageUtil.createPage(8, blogCount,currentPage);//设置分页信息
		blogs = blogDao.findAllBlog(page,userId);
		System.out.println("在我的空间输出 :  "+userId);
		user = userDao.findUserById(userId);
		System.out.println("用户"+user);
		System.out.println("博客条数"+blogs.size());
		request.setAttribute("blogList", blogs);//保存消息回复列表
		request.setAttribute("page", page);//保存分页信息
		request.setAttribute("user", user);
		ValidationDao validationDao = ValidationDaoFactory.getValidationDaoInstance();
		List<Validation> validatio = validationDao.findUntendVaList(userId);
		List<Validation> validation = validationDao.findAgreeVaList(userId);
		List<Validation> validations = validationDao.findEndedVaList(userId);
		List<Validation> validations1 = validationDao.findtendedVaList(userId);
		request.setAttribute("validationsLi", validatio);
		request.setAttribute("validationsLis", validation);
		request.setAttribute("validationsList", validations);
		request.setAttribute("validationsList1", validations1);
		System.out.println("list0 的大小"+validatio.size());
		System.out.println("list2 的大小"+validation.size());
		System.out.println("list3 的大小"+validations.size());
		request.getRequestDispatcher("myHouse.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
