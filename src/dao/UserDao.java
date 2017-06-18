package dao;

import java.util.List;

import model.User;
import util.Page;

public interface UserDao {
	
	public void addUser(User user);		//定义添加员工信息的方法
	public void updateUser(User user);	//定义修改员工信息的方法
	public void deleteUser(int userId);		//定义删除员工信息的方法
	public List<User> findUserByGroup(Page page);		//定义查询所有员工信息的方法
	public User findUserById(int userId);//定义按ID查询员工信息的方法
	public int findUserByNa(User user);
	public int countUser();//统计人数
}
