package servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import dao.BlogDao;
import factory.BlogDaoFactory;
import model.Blog;
/**
 * Servlet implementation class WriteBlog
 */
@WebServlet("/WriteBlog")
public class WriteBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteBlog() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("lalala");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Blog blog = new Blog();
		BlogDao blogdao = BlogDaoFactory.getBlogDaoInstance();
		String blog_name = request.getParameter("blog_name");         blog.setBname(blog_name);
		String blog_tags = request.getParameter("blog_tags");         blog.setBtags(blog_tags);
		String str_blog_text = request.getParameter("blog_text"); 
		System.out.println(blog_name);
		System.out.println(blog_tags);
		System.out.println(str_blog_text);
		HttpSession session = request.getSession();
		int userid = Integer.parseInt((String) session.getAttribute("userid"));
		blog.setUid(userid);
		SerialBlob blog_text=null;
		System.out.println("微博内容"+blog_text);
		blog.setBtext(str_blog_text);
		/*try {
			blog_text =  new SerialBlob(str_blog_text.getBytes("utf-8"));
			blog.setBtext(blog_text);
			System.out.println("微博内容"+blog_text);
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} */
		blog.setBdate(new Date());//设置发布日期
		int j=0;
		if (request.getParameterValues("vehicle") != null) {
			String[] favorites = request.getParameterValues("vehicle");
			for (int i = 0; i < favorites.length; i++) {
				j += Integer.parseInt(favorites[i]);
			}
		}
		blog.setBgroup(j);
		System.out.println(j);
		blogdao.addBlog(blog);
		request.getRequestDispatcher("showHouse").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
