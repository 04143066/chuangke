package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import dao.BlogDao;
import model.Blog;
import util.*;

public class BlogDaoImpl implements BlogDao{

	@Override
	public void addBlog(Blog blog) {
		Connection con =  DBConnection.getConnection();	
		String addSQL = "insert into t_blog(blog_uid,blog_group,blog_name,blog_tags,blog_text,blog_date) values(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;	
		try {
			pstmt = con.prepareStatement(addSQL);	
			pstmt.setInt(1, blog.getUid());
			pstmt.setInt(2, blog.getBgroup());
			pstmt.setString(3, blog.getBname());
			pstmt.setString(4, blog.getBtags());
			pstmt.setString(5, blog.getBtext());
			pstmt.setTimestamp(6, new Timestamp(blog.getBdate().getTime()));
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	@Override
	public void updateBlog(Blog blog) {
		
	}

	@Override
	public void deleteBlog(int BlogID) {
		Connection con =  DBConnection.getConnection();	
		String deleteSQL = "delete from t_blog where blog_id = ?";
		PreparedStatement pstmt = null;					
		try {
			pstmt = con.prepareStatement(deleteSQL);	
			pstmt.setInt(1, BlogID);	
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	

	@Override
	public Blog findBlogById(int BlogID) {
		Connection con = DBConnection.getConnection();
		String findById = "select * from t_blog where blog_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Blog blog = null; 
		try {
			pstmt = con.prepareStatement(findById);
			pstmt.setInt(1,BlogID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				blog = new Blog();
				blog.setBid(rs.getInt(1));	
				blog.setUid(rs.getInt(2));
				blog.setBgroup(rs.getInt(3));			
				blog.setBname(rs.getString(4));
				blog.setBtags(rs.getString(5));
				blog.setBtext(rs.getString(6));
				blog.setBdate(rs.getTimestamp(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);								
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
		
		return blog;
	}

	@Override
	public List<Blog> findAllBlog(Page page, int uid) {
		Connection con = DBConnection.getConnection();
		String findAll = "select * from t_blog where blog_uid = "+uid+" order by blog_id desc limit ?,?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Blog blog = null;
		List<Blog> blogs = new ArrayList<Blog>();
		try {
			pstmt = con.prepareStatement(findAll);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				blog = new Blog();
				blog.setBid(rs.getInt(1));	
				blog.setUid(rs.getInt(2));
				blog.setBgroup(rs.getInt(3));			
				blog.setBname(rs.getString(4));
				blog.setBtags(rs.getString(5));
				blog.setBtext(rs.getString(6));
				blog.setBdate(rs.getTimestamp(7));
				blogs.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);								//关闭结果集对象
			DBConnection.close(pstmt);							//关闭预处理对象
			DBConnection.close(con);							//关闭连接对象
		}
		return blogs;
	}

	@Override
	public int findAllCount(int uid) {
		Connection conn = DBConnection.getConnection();	//获得连接对象
		String findSQL = "select count(*) from t_blog where blog_uid = "+uid;
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
