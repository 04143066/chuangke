package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dao.ReplyDao;
import model.Reply;
import util.DBConnection;
import util.Page;

public class ReplyDaoImpl implements ReplyDao{
	
	@Override
	public void addReplay(Reply reply) {
		Connection con =  DBConnection.getConnection();	
		String addSQL = "insert into t_reply(blog_id,user_id,reply_text,reply_date) values(?,?,?,?)";
		PreparedStatement pstmt = null;					
		try {
			pstmt = con.prepareStatement(addSQL);	
			pstmt.setInt(1, reply.getBid());
			pstmt.setInt(2, reply.getUid());
			pstmt.setString(3, reply.getRtext());
			pstmt.setTimestamp(4, new Timestamp(reply.getRdate().getTime()));
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	@Override
	public List<Reply> findReplayByBlogID(int blogId, Page page) {
		Connection con = DBConnection.getConnection();
		String findAll = " select * from t_reply where blog_id = ?  order by user_id desc limit ?,? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reply reply = null;
		List<Reply> replys = new ArrayList<Reply>();
		try {
			pstmt = con.prepareStatement(findAll);
			pstmt.setInt(1, blogId);
			pstmt.setInt(2, page.getBeginIndex());
			pstmt.setInt(3, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				reply = new Reply();
				reply.setUid(rs.getInt(3));
				reply.setRtext(rs.getString(4));
				reply.setRdate(rs.getTimestamp(5));
				replys.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{		
			DBConnection.close(rs);//关闭结果集对象
			DBConnection.close(pstmt);//关闭预处理对象
			DBConnection.close(con);							//关闭连接对象
		}	
		return replys;
	}

	@Override
	public int findCountByBlogID(int blogId) {
		Connection conn = DBConnection.getConnection();	//获得连接对象
		String findSQL = "select count(*) from t_reply where blog_id = ?";
		PreparedStatement pstmt = null;					//声明预处理对象
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(findSQL);		//获得预处理对象并赋值
			pstmt.setInt(1, blogId);
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
