package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDao;
import dao.ReplyDao;
import dao.UserDao;
import factory.BlogDaoFactory;
import factory.ReplyDaoFactory;
import factory.UserDaoFactory;
import model.Blog;
import model.Reply;
import model.User;
import util.Page;
import util.PageUtil;

/**
 * Servlet implementation class showBlog
 */
@WebServlet("/showBlog")
public class showBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showBlog() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int blogId = 1;
		if(request.getParameter("blogId")!=null)
			blogId = Integer.parseInt(request.getParameter("blogId"));//取得消息编号
		BlogDao blogDao = BlogDaoFactory.getBlogDaoInstance();//获得MessageDAO实例
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		Blog blog = blogDao.findBlogById(blogId);//查询该编号对应的消息
		request.setAttribute("blog", blog); //将消息保存在request范围
		User user = userDao.findUserById(blog.getUid());
		request.setAttribute("user", user); //将消息保存在request范围
		System.out.println(blog.getBtext());
		//获得该消息对应的所有回复
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr == null || "".equals(currentPageStr)){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
			ReplyDao replyDao = ReplyDaoFactory.getReplyDaoInstance();
			Page page = PageUtil.createPage(5, replyDao.findCountByBlogID(blogId),currentPage);//设置分页信息
			List<Reply> replys = replyDao.findReplayByBlogID(blogId, page);//分页查询消息回复
			System.out.println("评论的条数:"+replys.size());
			request.setAttribute("replyList", replys);//保存消息回复列表
			request.setAttribute("page", page);//保存分页信息
			User user1 = null;
			for(Reply repl:replys){
				user1 = userDao.findUserById(repl.getUid());
				repl.setUname(user1.getUname());
			}
			
			//获得该消息对象的批复
			/*ServletContext servletContext = getServletContext();
			RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/showBlog.jsp");	//跳转到消息显示页
			dispatcher.forward(request, response);*/
			request.getRequestDispatcher("showBlog.jsp").forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
