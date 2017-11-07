package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.imple.UserDaoImple;
import entity.User;

public class ServletFour extends HttpServlet{

	/**
	 * É¾³ýÊý¾Ý
	 */
	private static final long serialVersionUID = 4190058701662601011L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String  name=req.getParameter("delName");
		String  password=req.getParameter("delPassword");
		UserDao  user=new UserDaoImple();
		User u=new User();
		u.setName(name);
		u.setPassword(password);
		int i=user.del(u);
		if (i>0) {
			req.getRequestDispatcher("delAount.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("delShiBai.jsp").forward(req, resp);
			
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
