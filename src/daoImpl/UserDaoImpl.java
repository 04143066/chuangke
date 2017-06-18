package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import dao.*;
import model.User;
import util.DBConnection;
import util.Page;
public class UserDaoImpl implements UserDao{

	@Override
	public void addUser(User user) {
		Connection con =  DBConnection.getConnection();	
		String addSQL = "insert into t_user(user_age,user_group,user_picture,user_sex,user_tell,user_name,user_passwd,user_birthday,user_profile) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;					
		try {
			pstmt = con.prepareStatement(addSQL);	
			pstmt.setInt(1, user.getUage());
			pstmt.setInt(2, user.getUgroup());
			pstmt.setBlob(3, user.getUpicture());
			pstmt.setBoolean(4, user.isUsex());
			pstmt.setString(5, user.getUtell());
			pstmt.setString(6, user.getUname());
			pstmt.setString(7, user.getUpasswd());
			pstmt.setTimestamp(8, new Timestamp(user.getUbirthday().getTime()));
			pstmt.setString(9, user.getUprofile());
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	@Override
	public void updateUser(User user) {
		Connection con =  DBConnection.getConnection();	
		String addSQL = "update t_user set user_age = ?, user_group=?,"
				+ "user_picture = ?,user_sex = ?,user_tell = ?,"
				+ "user_name = ?,user_passwd = ?,user_birthday = ?,user_profile = ?"
				+ "where user_id = ?";
		PreparedStatement pstmt = null;					
		try {
			pstmt = con.prepareStatement(addSQL);	
			pstmt.setInt(1, user.getUage());
			pstmt.setInt(2, user.getUgroup());
			pstmt.setBlob(3, user.getUpicture());
			pstmt.setBoolean(4, user.isUsex());
			pstmt.setString(5, user.getUtell());
			pstmt.setString(6, user.getUname());
			pstmt.setString(7, user.getUpasswd());
			pstmt.setTimestamp(8, new Timestamp(user.getUbirthday().getTime()));
			pstmt.setString(9, user.getUprofile());
			pstmt.setInt(10, user.getUid());
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	@Override
	public void deleteUser(int userId) {
		Connection con =  DBConnection.getConnection();	
		String deleteSQL = "delete from t_user where user_id = ?";
		PreparedStatement pstmt = null;					
		try {
			pstmt = con.prepareStatement(deleteSQL);	
			pstmt.setInt(1, userId);	
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	@Override
	public List<User> findUserByGroup(Page page){
		Connection con = DBConnection.getConnection();
		String findAll = " select * from t_user  order by user_id desc limit ?,?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		List<User> users = new ArrayList<User>();
		try {
			pstmt = con.prepareStatement(findAll);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUid(rs.getInt(1));		
				user.setUage(rs.getInt(2));
				user.setUgroup(rs.getInt(3));
				user.setUpicture(rs.getBlob(4));
				user.setUsex(rs.getBoolean(5));	
				user.setUtell(rs.getString(6));
				user.setUname(rs.getString(7));	
				user.setUpasswd(rs.getString(8));	
				user.setUbirthday(rs.getDate(9));		
				user.setUprofile(rs.getString(10));	
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);								//关闭结果集对象
			DBConnection.close(pstmt);							//关闭预处理对象
			DBConnection.close(con);							//关闭连接对象
		}
		return users;
	}

	@Override
	public User findUserById(int userId) {
		Connection conn = DBConnection.getConnection();		//获得连接对象
		String findByIDSQL = "select * from " +
						"t_user where user_id = ?";	//SQL语句
		PreparedStatement pstmt = null;	//声明预处理对象
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = conn.prepareStatement(findByIDSQL);		//获得预处理对象并赋值
			pstmt.setInt(1, userId);					//设置参数
			rs = pstmt.executeQuery();						//执行查询
			if(rs.next()) {
				user = new User();
				user.setUid(rs.getInt(1));		
				user.setUage(rs.getInt(2));
				user.setUgroup(rs.getInt(3));
				user.setUpicture(rs.getBlob(4));
				user.setUsex(rs.getBoolean(5));	
				user.setUtell(rs.getString(6));
				user.setUname(rs.getString(7));	
				user.setUpasswd(rs.getString(8));	
				user.setUbirthday(rs.getDate(9));		
				user.setUprofile(rs.getString(10));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);								//关闭结果集对象
			DBConnection.close(pstmt);							//关闭预处理对象
			DBConnection.close(conn);							//关闭连接对象
		}
		return user;
	}

	@Override
	public int findUserByNa(User user) {
		Connection conn = DBConnection.getConnection();		//获得连接对象
		String findByIDSQL = "select user_passwd ,user_id from " +
						"t_user where user_name = ?";	//SQL语句
		PreparedStatement pstmt = null;	//声明预处理对象
		ResultSet rs = null;
		String password = "";
		int id=0;int flag=0;
		try {
			pstmt = conn.prepareStatement(findByIDSQL);		//获得预处理对象并赋值
			pstmt.setString(1, user.getUname());					//设置参数
			rs = pstmt.executeQuery();						//执行查询
			while(rs.next()) {
				flag=1;
				password=rs.getString(1);
				if(password.equals(user.getUpasswd())){
					id=rs.getInt(2);
					System.out.println("id："+id);
					System.out.println("数据库存储的密码："+password);
					System.out.println("输入的密码："+user.getUpasswd());
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);								//关闭结果集对象
			DBConnection.close(pstmt);							//关闭预处理对象
			DBConnection.close(conn);							//关闭连接对象
		}
		if(flag==0) id =-1;
		return id;
	}

	@Override
	public int countUser() {
		Connection conn = DBConnection.getConnection();	//获得连接对象
		String findSQL = "select count(*) from t_user ";
		PreparedStatement pstmt = null;					//声明预处理对象
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(findSQL);		//获得预处理对象并赋值
			rs = pstmt.executeQuery();					//执行查询
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);						//关闭结果集对象
			DBConnection.close(pstmt);					//关闭预处理对象
			DBConnection.close(conn);					//关闭连接对象
		}
		return count;
	}	
	

}
