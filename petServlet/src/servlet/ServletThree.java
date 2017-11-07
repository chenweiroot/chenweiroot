package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.imple.UserDaoImple;
import entity.User;

public class ServletThree extends HttpServlet{

	/**
	 * 修改数据(密码)
	 */
	private static final long serialVersionUID = -2883374542426109606L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String upName=req.getParameter("updateName");
		String newPassword=req.getParameter("newPassword");
		UserDao  user=new UserDaoImple();
		User u=new User();
		u.setName(upName);
		u.setPassword(newPassword);
		int i=user.updata(u);
		if (i>0) {
			req.setAttribute("upName",u.getName());
			req.setAttribute("upPassword",u.getPassword());
			req.getRequestDispatcher("xiugai.jsp").forward(req, resp);
		}else{
			System.out.println("密码修改失败！");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
