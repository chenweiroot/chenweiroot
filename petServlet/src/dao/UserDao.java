package dao;

import java.util.List;

import entity.User;


public interface UserDao {
	 int save(User  user);//��������
	 int del(User  user);//ɾ������
	 int updata(User user);//�޸�����
	 List<User>  getAll(User user);//��ѯ����
}
