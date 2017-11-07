package dao;

import java.util.List;

import entity.User;


public interface UserDao {
	 int save(User  user);//保存数据
	 int del(User  user);//删除数据
	 int updata(User user);//修改数据
	 List<User>  getAll(User user);//查询数据
}
