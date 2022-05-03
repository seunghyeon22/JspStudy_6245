package db_study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.util.ArrayList;


import db.DBConnectionMgr;
import repository.user.User;

public class UserDao {// db에 접근하기 위한 객체
	private DBConnectionMgr pool;
	
	public UserDao(DBConnectionMgr pool) {
		this.pool = pool;
		
	}
	public User getUserByUsername(String username) {
		String sql =null;
		Connection con =null;
		PreparedStatement pstmt = null; 
		ResultSet rs =null; // select 사용할 때만 사용
		
		User user =null;
		
		try {
			con = pool.getConnection();
			sql = "select * from user_mst where username= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			rs.next();
			try {
				user = User.builder()
						.user_code(rs.getInt(1))
						.username(rs.getString(2))
						.password(rs.getString(3))
						.name(rs.getString(4))
						.create_date(rs.getTimestamp(6).toLocalDateTime())
						.update_date(rs.getTimestamp(7).toLocalDateTime())
						.build();
			}catch (SQLDataException e) {
				System.out.println("해당 아이디로 조회된 데이터 가 없습니다.");
				user =null;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
							
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return user;
	}
	
	public ArrayList<User> getUserAll(){
		String sql =null;
		
		Connection con =null;
		PreparedStatement pstmt = null; 
		ResultSet rs =null;
		
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			con = pool.getConnection(); // 자바에서 db로 연결할 때 사용
			sql = "select*from user_mst"; //sql문 작성
			pstmt = con.prepareStatement(sql); // 쿼리 작성
			rs = pstmt.executeQuery(); // executeQuery = 쿼리 실행
			
			while(rs.next()) {//화살표 이동
				User user = User.builder()
						.user_code(rs.getInt(1))
						.username(rs.getString(2))
						.password(rs.getString(3))
						.name(rs.getString(4))
						.email(rs.getString(5))
						.create_date(rs.getTimestamp(6).toLocalDateTime())
						.update_date(rs.getTimestamp(7).toLocalDateTime())
						.build();
				userList.add(user);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return userList;
	}
	
}
