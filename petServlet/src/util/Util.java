package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.User;

public class Util {
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/jsptest", "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 查询
	public List<User> getAll(String sql,Object[] obj) {
		// 创建集合来存放对象
		List<User> list = new ArrayList<User>();
		User user = new User();
		try {
			ptmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ptmt.setObject(i+1, obj[i]);
			}
			rs = ptmt.executeQuery();
			while (rs.next()) {
				// 将查询的结果存放到user中
				user.setName(rs.getString(1));
				user.setPassword(rs.getString(2));
				// 将user对象存放集合中
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, ptmt, conn);
		}
		return list;
	}

	// 增删改
	public int exeupdate(String sql, Object[] obj) {
		int index = 0;
		try {
			ptmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ptmt.setObject(i + 1, obj[i]);
			}
			index = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(null, ptmt, conn);
		}

		return index;
	}

	//关闭资源
	public void closeAll(ResultSet rs, PreparedStatement ptmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ptmt!=null) {
			try {
				ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
