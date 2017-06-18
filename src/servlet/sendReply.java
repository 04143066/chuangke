package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import dao.ReplyDao;
import factory.ReplyDaoFactory;
import model.Blog;
import model.Reply;

/**
 * Servlet implementation class sendReply
 */
@WebServlet("/sendReply")
public class sendReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String rtext = request.getParameter("rtext");
		System.out.println("评论内容:"+rtext);
		HttpSession session = request.getSession();
		int uid = 3;
		if(session.getAttribute("userid")!=null)
			uid = Integer.parseInt((String) session.getAttribute("userid"));	
		int blogId = Integer.parseInt(request.getParameter("blogId"));
		Reply reply = new Reply();
		ReplyDao replyDao = ReplyDaoFactory.getReplyDaoInstance();
		reply.setBid(blogId);
		reply.setRdate(new Date());
		reply.setRtext(rtext);
		reply.setUid(uid);
		replyDao.addReplay(reply);
		request.getRequestDispatcher("showBlog").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
