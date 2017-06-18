package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import factory.UserDaoFactory;
import model.User;
import util.Encrypter;

/**
 * Servlet implementation class changeziliao
 */
@WebServlet("/changeziliao")
public class changeziliao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeziliao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User user = new User();
		UserDao userdao = UserDaoFactory.getUserDaoInstance();
		String user_name = request.getParameter("user_name");  user.setUname(user_name);
		String user_passwd = request.getParameter("user_passwd"); 
		String passwordMD5 = null;
		try {
			passwordMD5 = Encrypter.md5Encrypt(user_passwd);
		} catch (Exception e1) {
			e1.printStackTrace();
		}user.setUpasswd(passwordMD5);
		String user_tell = request.getParameter("user_tell"); user.setUtell(user_tell);
		String str_user_age = request.getParameter("user_age"); 
		String str_user_birthday = request.getParameter("user_birthday");
		String str_user_sex = request.getParameter("user_sex");
		String str_profile = request.getParameter("user_profile");user.setUprofile(str_profile);
		int user_sex = Integer.parseInt(str_user_sex);
		int user_age = Integer.parseInt(str_user_age);user.setUage(user_age);
		if(user_sex == 1) user.setUsex(true);
		else              user.setUsex(false);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date user_birthday = null;
		try {
			user_birthday = sdf.parse(str_user_birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setUbirthday(user_birthday);
		int j=0;
		if (request.getParameterValues("user_group") != null) {
			String[] favorites = request.getParameterValues("user_group");
			for (int i = 0; i < favorites.length; i++) {
				j += Integer.parseInt(favorites[i]);
			}
		}
		user.setUgroup(j);
		String user_id = request.getParameter("userId");
		user.setUid(Integer.parseInt(user_id));
		userdao.updateUser(user);
		request.setAttribute("user", user);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
