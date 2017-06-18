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
import javax.servlet.http.HttpSession;

import servlet.DBservlet;
import dao.UserDao;
import factory.UserDaoFactory;
import model.User;
import util.Encrypter;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("挑战成功");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String validationCode = request.getParameter("validation_code");
		System.out.println(validationCode);
		if(!checkValidationCode(request, validationCode)){
			request.getRequestDispatcher("login.jsp").forward(request,response);
			System.out.println("验证码错误");
			return;
			
		}
		User user = new User();
		UserDao userdao = UserDaoFactory.getUserDaoInstance();
		System.out.println("验证码正确");
		String user_name = request.getParameter("user_name");  user.setUname(user_name);
		String user_passwd = request.getParameter("user_passwd"); 
		String passwordMD5 = null;
		System.out.println("用户名:"+user_name);
		System.out.println("密码："+user_passwd);
		try {
			passwordMD5 = Encrypter.md5Encrypt(user_passwd);
		} catch (Exception e1) {
			e1.printStackTrace();
		}user.setUpasswd(passwordMD5);
		int i =userdao.findUserByNa(user);
		
		if(i ==-1){
			request.setAttribute("userError", user_name+"不存在");
			System.out.println("查无此人");
			request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		else if(i==0){
			request.setAttribute("passwordError", "密码有误");
			System.out.println("密码有误");
			request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("username", user_name);
			session.setAttribute("userid", i+"");
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
			
	}

	private boolean checkValidationCode(HttpServletRequest request, String validationCode) {
	String validationCodeSession = (String) request.getSession().getAttribute("validation_code");
		
		//System.out.println("验证码： "+validationCodeSession);
		//System.out.println("jjj"+validationCode);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
