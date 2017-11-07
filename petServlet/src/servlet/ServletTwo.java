package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.imple.UserDaoImple;

import entity.User;

public class ServletTwo extends HttpServlet{

	/**
	 * µÇÂ¼
	 */
	private static final long serialVersionUID = -3656630649933857229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String  uName=req.getParameter("uName");
		String  uPassword=req.getParameter("uPassword");
		UserDao  user=new UserDaoImple();
		User   u=new  User();
		u.setName(uName);
		u.setPassword(uPassword);
		List<User> list= user.getAll(u);
		if (list.isEmpty()) {
			
			req.getRequestDispatcher("shibai.jsp").forward(req, resp);
		}else{
			req.setAttribute("name",u.getName());
			req.setAttribute("password",u.getPassword());
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
