package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dao.ValidationDao;
import model.Validation;
import util.DBConnection;
import util.Page;
/*
 * state  0  没有投标
 *        1  已经投标
 *        2  项目进行
 * 		  3      项目完结
 */
public class ValidationDaoImpl implements ValidationDao{

	@Override
	public void addValidation(Validation validation) {
		Connection con =  DBConnection.getConnection();	
		String addSQL = "insert into t_validation("
				+ "validation_money,validation_name,validation_text,"
				+ "validation_profile,validation_date,tenderer,"
				+ "tenderee,state,validation_group) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;					
		try {
			pstmt = con.prepareStatement(addSQL);	
			pstmt.setInt(1, validation.getVmoney());
			pstmt.setString(2, validation.getVname());
			pstmt.setString(3, validation.getVtext());
			pstmt.setString(4, validation.getVprofile());
			pstmt.setTimestamp(5, new Timestamp(validation.getVdate().getTime()));
			pstmt.setInt(6, validation.getVtenderer());
			pstmt.setInt(7, validation.getVtenderee());
			pstmt.setInt(8, validation.getVstate());
			pstmt.setInt(9, validation.getVgroup());
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	@Override
	public void deleteValidation(Validation validation) {
		Connection con =  DBConnection.getConnection();	
		String deleteSQL = "delete from t_validation where validation_id = ?";
		PreparedStatement pstmt = null;					
		try {
			pstmt = con.prepareStatement(deleteSQL);	
			pstmt.setInt(1, validation.getVid());	
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	@Override
	public void tenderValidation( Validation validation ,int tenderer) {
		Connection con =  DBConnection.getConnection();	
		String addSQL = "update t_validation set state = 1 , tenderer = ? where validation_id = ?";
		PreparedStatement pstmt = null;					
		try {
			pstmt = con.prepareStatement(addSQL);	
			pstmt.setInt(1, tenderer);
			pstmt.setInt(2, validation.getVid());
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	@Override
	public void endValidation(Validation validation) {
		Connection con =  DBConnection.getConnection();	
		String addSQL = "update t_validation set state = 3 where validation_id = ?";
		PreparedStatement pstmt = null;					
		try {
			pstmt = con.prepareStatement(addSQL);	
			pstmt.setInt(1, validation.getVid());
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	@Override
	public Validation findByVid(int vid) {
		Connection con = DBConnection.getConnection();
		String findById = "select * from t_validation where validation_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Validation validation = null; 
		try {
			pstmt = con.prepareStatement(findById);
			pstmt.setInt(1,vid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				validation = new Validation();	
				validation.setVid(rs.getInt(1));
				validation.setVmoney(rs.getInt(2));
				validation.setVname(rs.getString(3));			
				validation.setVtext(rs.getString(4));
				validation.setVdate(rs.getTimestamp(6));
				validation.setVprofile(rs.getString(5));
				validation.setVtenderer(rs.getInt(7));
				validation.setVtenderee(rs.getInt(8));
				validation.setVstate(rs.getInt(9));
				validation.setVgroup(rs.getInt(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);								
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
		
		return validation;
	}

	@Override
	public List<Validation> findUntendVaList(Page page) {
		Connection con = DBConnection.getConnection();
		String findAll = "select * from t_validation where state = 0 order by validation_id desc limit ?,?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Validation validation = null;
		List<Validation> validations = new ArrayList<Validation>();
		try {
			pstmt = con.prepareStatement(findAll);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				validation = new Validation();
				validation.setVid(rs.getInt(1));
				System.out.println(validation.getVid());
				validation.setVmoney(rs.getInt(2));	
				validation.setVname(rs.getString(3));
				validation.setVtext(rs.getString(4));
				validation.setVprofile(rs.getString(5));
				validation.setVdate(rs.getTimestamp(6));
				validation.setVtenderer(rs.getInt(7));
				validation.setVtenderee(rs.getInt(8));
				validation.setVstate(rs.getInt(9));
				validation.setVgroup(rs.getInt(10));
				validations.add(validation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);								//关闭结果集对象
			DBConnection.close(pstmt);							//关闭预处理对象
			DBConnection.close(con);							//关闭连接对象
		}
		return validations;
	}

	@Override
	public List<Validation> findAgreeVaList(int uid) {
		Connection con = DBConnection.getConnection();
		String findAll = "select * from t_validation where state = 2 and tenderee = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Validation validation = null;
		List<Validation> validations = new ArrayList<Validation>();
		try {
			pstmt = con.prepareStatement(findAll);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				validation = new Validation();
				validation.setVid(rs.getInt(1));
				validation.setVmoney(rs.getInt(2));	
				validation.setVname(rs.getString(3));
				validation.setVtext(rs.getString(4));			
				validation.setVdate(rs.getTimestamp(6));
				validation.setVprofile(rs.getString(5));
				validation.setVtenderer(rs.getInt(7));
				validation.setVtenderee(rs.getInt(8));
				validation.setVstate(rs.getInt(9));
				validation.setVgroup(rs.getInt(10));
				validations.add(validation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);								//关闭结果集对象
			DBConnection.close(pstmt);							//关闭预处理对象
			DBConnection.close(con);							//关闭连接对象
		}
		return validations;
	}

	@Override
	public List<Validation> findEndedVaList(int uid) {
		Connection con = DBConnection.getConnection();
		String findAll = "select * from t_validation where state = 3 and tenderee = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Validation validation = null;
		List<Validation> validations = new ArrayList<Validation>();
		try {
			pstmt = con.prepareStatement(findAll);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				validation = new Validation();
				validation.setVid(rs.getInt(1));
				validation.setVmoney(rs.getInt(2));	
				validation.setVname(rs.getString(3));
				validation.setVtext(rs.getString(4));			
				validation.setVdate(rs.getTimestamp(6));
				validation.setVprofile(rs.getString(5));
				validation.setVtenderer(rs.getInt(7));
				validation.setVtenderee(rs.getInt(8));
				validation.setVstate(rs.getInt(9));
				validation.setVgroup(rs.getInt(10));
				validations.add(validation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);								//关闭结果集对象
			DBConnection.close(pstmt);							//关闭预处理对象
			DBConnection.close(con);							//关闭连接对象
		}
		return validations;
	}

	@Override
	public int countUntendValidation() {
		Connection conn = DBConnection.getConnection();	//获得连接对象
		String findSQL = "select count(*) from t_validation where state = ?";
		PreparedStatement pstmt = null;					//声明预处理对象
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(findSQL);		//获得预处理对象并赋值
			pstmt.setInt(1, 0);
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

	@Override
	public void agreeValidation(Validation validation) {
		Connection con =  DBConnection.getConnection();	
		String addSQL = "update t_validation set state = 2 where validation_id = ?";
		PreparedStatement pstmt = null;					
		try {
			pstmt = con.prepareStatement(addSQL);	
			pstmt.setInt(1, validation.getVid());
			pstmt.executeUpdate();							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);							
			DBConnection.close(con);							
		}
	}

	@Override
	public List<Validation> findUntendVaList(int uid) {
		Connection con = DBConnection.getConnection();
		String findAll = "select * from t_validation where state = 0 and tenderee = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Validation validation = null;
		List<Validation> validations = new ArrayList<Validation>();
		try {
			pstmt = con.prepareStatement(findAll);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				validation = new Validation();
				validation.setVid(rs.getInt(1));
				validation.setVmoney(rs.getInt(2));	
				validation.setVname(rs.getString(3));
				validation.setVtext(rs.getString(4));			
				validation.setVdate(rs.getTimestamp(6));
				validation.setVprofile(rs.getString(5));
				validation.setVtenderer(rs.getInt(7));
				validation.setVtenderee(rs.getInt(8));
				validation.setVstate(rs.getInt(9));
				validation.setVgroup(rs.getInt(10));
				validations.add(validation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);								//关闭结果集对象
			DBConnection.close(pstmt);							//关闭预处理对象
			DBConnection.close(con);							//关闭连接对象
		}
		return validations;
	}

	@Override
	public List<Validation> findtendedVaList(int uid) {
		Connection con = DBConnection.getConnection();
		String findAll = "select * from t_validation where state = 1 and tenderee = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Validation validation = null;
		List<Validation> validations = new ArrayList<Validation>();
		try {
			pstmt = con.prepareStatement(findAll);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				validation = new Validation();
				validation.setVid(rs.getInt(1));
				validation.setVmoney(rs.getInt(2));	
				validation.setVname(rs.getString(3));
				validation.setVtext(rs.getString(4));			
				validation.setVdate(rs.getTimestamp(6));
				validation.setVprofile(rs.getString(5));
				validation.setVtenderer(rs.getInt(7));
				validation.setVtenderee(rs.getInt(8));
				validation.setVstate(rs.getInt(9));
				validation.setVgroup(rs.getInt(10));
				validations.add(validation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);								//关闭结果集对象
			DBConnection.close(pstmt);							//关闭预处理对象
			DBConnection.close(con);							//关闭连接对象
		}
		return validations;
	}

	
}
