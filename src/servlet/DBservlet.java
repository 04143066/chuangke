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
 * Servlet implementation class DBservlet
 */
@WebServlet("/DBservlet")
public class DBservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String validationCode = request.getParameter("validationCode");
		System.out.println(validationCode);
		if(!checkValidationCode(request, validationCode)){
			request.getRequestDispatcher("register.jsp").forward(request,response);
			System.out.println("验证码错误");
			return;
			
		}
		User user = new User();
		UserDao userdao = UserDaoFactory.getUserDaoInstance();
		System.out.println("验证码正确");
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
		userdao.addUser(user);
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public boolean checkValidationCode(HttpServletRequest request, String validationCode){
		String validationCodeSession = (String) request.getSession().getAttribute("validation_code");
		
		System.out.println("验证码： "+validationCodeSession);
		System.out.println("jjj"+validationCode);
		if(validationCodeSession == null){
			request.setAttribute("info", "info");
			request.setAttribute("codeError", "重新获取验证码");
			return false;
		}
		else if(!validationCode.equalsIgnoreCase(validationCodeSession)){
			request.setAttribute("info", "info");
			request.setAttribute("codeError", "验证码错误");
			System.out.println("输入的验证码： "+validationCode);
			return false;
		}
		else
			return true;
	}

}
