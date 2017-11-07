package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.imple.UserDaoImple;
import entity.User;

public class ServletOne  extends HttpServlet {
	
	/**
	 * зЂВс
	 */
	private static final long serialVersionUID = -3656630649933857229L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String  name=request.getParameter("userName");
		String  password=request.getParameter("password");
	       UserDao  user=new UserDaoImple();
	       User   u=new  User();
	       u.setName(name);
	       u.setPassword(password);
	       request.setAttribute("user", u);
	      int  i= user.save(u);
	      if (i>0) {
	    	   request.getRequestDispatcher("admin.jsp").forward(request, response);
	    	
		} else {
				request.getRequestDispatcher("reger.jsp").forward(request, response);
		}
}
	
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	  doGet(req, resp);
}
}
