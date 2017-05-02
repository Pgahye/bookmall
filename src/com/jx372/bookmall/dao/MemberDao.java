package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.BookVo;

public class MemberDao {
	
	private Connection getConnection() throws SQLException {

		Connection conn = null;

		PreparedStatement pstmt = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			// 2. connection 하기

			String url = "jdbc:mysql://localhost:3306/bookmall?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC Driver을 찾을수 없습니다. ");

		} // 드라이버 로드
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);
		}

		return conn;

	}
	
	public int insert(BookVo BookVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Statement stmt=null;
		int result=0;

		try {
			conn = getConnection();

			// 3. statement 준비

			String sql = "insert into member values( null,?,?,?,password(?) )";

			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩

			pstmt.setString(1, BookVo.getMem_name());
			pstmt.setString(2, BookVo.getPhone_num());
			pstmt.setString(3, BookVo.getEmail());
			pstmt.setString(4, BookVo.getPwd());
		
		

			// 5. sql 실행

			int count = pstmt.executeUpdate(); // select 는executeQuery,
												// insert , updete 는
							// excuteupdate , update는
												// 갯수로 반환이 됨

	
			
			// PK 가져오기 
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery( "select last_insert_id()" ); 
			if( rs.next() ) { 
				result = rs.getInt( 1 ); 
			} 


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);

	
			
		} finally {

			// 자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다.

			try {

				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					conn.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	

	}
	
	public List<BookVo> getList() {

		List<BookVo> list = new ArrayList<BookVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			conn = getConnection();

			// 3. statement 생성(확장성 용이)

			stmt = conn.createStatement();

			// 4. sql문 실행 ; 콜론 붙이지 않기

			String sql = "select mem_id, mem_name, phone_num,email,pwd from member";
			rs = stmt.executeQuery(sql); // select 는executeQuery, insert ,
											// updete 는 excuteupdate

			// 5. fetch row를 하나씩 가져오기

			while (rs.next()) {

				int mem_id = rs.getInt(1);
				String mem_name = rs.getString(2);
				String phone_num = rs.getString(3);
				String email = rs.getString(4);
				String pwd = rs.getString(5);
			

				BookVo BookVo = new BookVo();
				BookVo.setMem_id(mem_id);
				BookVo.setMem_name(mem_name);
				BookVo.setPhone_num(phone_num);
				BookVo.setEmail(email);
				BookVo.setPwd(pwd);
			

				list.add(BookVo);

			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);
			return list;

		} finally {

			// 자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다.

			try {

				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	public BookVo get(int no) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BookVo BookVo = null;

		try {
			// 1. 드라이버 로딩
			conn = getConnection();

			// 3. statement 생성(확장성 용이)

			// 4. sql문 실행 ; 콜론 붙이지 않기

			String sql = "select mem_id, mem_name, phone_num, email, pwd from member where mem_id=?";
			pstmt = conn.prepareStatement(sql);// select 는executeQuery, insert ,
												// updete 는 excuteupdate

			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			// 5. fetch row를 하나씩 가져오기

			while (rs.next()) {
			
				BookVo=new BookVo();
			
				
				BookVo.setMem_id(rs.getInt(1));
				BookVo.setMem_name(rs.getString(2));
				BookVo.setPhone_num(rs.getString(3));
				BookVo.setEmail(rs.getString(4));
				BookVo.setPwd(rs.getString(5));
			

			}

			return BookVo;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);

		} finally {

			// 자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다.

			try {

				if (rs != null) {
					rs.close();
					return BookVo;
				}
				if (pstmt != null) {
					pstmt.close();
					return BookVo;
				}
				if (conn != null) {
					conn.close();
					return BookVo;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return BookVo;

	}
	public boolean delete(int no) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BookVo BookVo = null;

		try {
			// 1. 드라이버 로딩
			conn = getConnection();

			// 3. statement 생성(확장성 용이)

			String sql = "delete from member where mem_id=?";
			pstmt = conn.prepareStatement(sql);// select 는executeQuery, insert ,
												// updete 는 excuteupdate

			pstmt.setLong(1, no);

			// 4. sql문 실행 ; 콜론 붙이지 않기
			int count = pstmt.executeUpdate();
			
			
			return (count == 1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);
			return false;

		} finally {

			// 자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다.

			try {

				if (rs != null) {
					rs.close();

				}
				if (pstmt != null) {
					pstmt.close();

				}
				if (conn != null) {
					conn.close();

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public boolean update(BookVo BookVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			conn = getConnection();

			// 3. statement 생성(확장성 용이)

			// 4. sql문 실행 ; 콜론 붙이지 않기

			String sql = "update member set mem_name=?, phone_num=?,email=?,pwd=? where mem_id=?";
			pstmt = conn.prepareStatement(sql);// select 는executeQuery, insert ,
												// updete 는 excuteupdate

			pstmt.setString(1, BookVo.getMem_name());
			pstmt.setString(2, BookVo.getPhone_num());
			pstmt.setString(3, BookVo.getEmail());
			pstmt.setString(4, BookVo.getPwd());
			pstmt.setInt(5, BookVo.getMem_id());
			// 5. fetch row를 하나씩 가져오기

			int count = pstmt.executeUpdate(); // select 는executeQuery,
			// insert , updete 는
			// excuteupdate , update는
			// 갯수로 반환이 됨
			
			return (count == 1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);
			return false;

		} finally {

			// 자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다.

			try {

				if (rs != null) {
					rs.close();

				}
				if (pstmt != null) {
					pstmt.close();

				}
				if (conn != null) {
					conn.close();

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
