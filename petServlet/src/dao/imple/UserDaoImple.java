package dao.imple;

import java.util.List;

import util.Util;

import dao.UserDao;
import entity.User;

public class UserDaoImple extends  Util implements UserDao{
	@Override
	public int save(User user) {
         String  sql="insert  into  user (name,password)values(?,?)";
         Object  []obj={user.getName(),user.getPassword()};
		return exeupdate(sql, obj);
	}

	@Override
	public List<User> getAll(User user) {
		String  sql="select *  from  user where name=? and password=?";
		Object []obj={user.getName(),user.getPassword()};
		return getAll(sql,obj);
	}

	@Override
	public int del(User user) {
		String sql="delete   from  user  where name=? and  password=?";
		Object obj[]={user.getName(),user.getPassword()};
		return exeupdate(sql, obj);
	}

	@Override
	public int updata(User user) {
		String sql="UPDATE USER  SET PASSWORD=?  WHERE NAME=?";
		Object obj[]={user.getPassword(),user.getName()};
		return exeupdate(sql, obj);
	}
}
