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



public class CategoryDao {
	
	
	
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
	
	public boolean insert(BookVo BookVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. statement 준비

			String sql = "insert into category values( null,? )";

			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩

			pstmt.setString(1, BookVo.getCa_name());
		
		

			// 5. sql 실행

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

			String sql = "select ca_id, ca_name from category";
			rs = stmt.executeQuery(sql); // select 는executeQuery, insert ,
											// updete 는 excuteupdate

			// 5. fetch row를 하나씩 가져오기

			while (rs.next()) {

				int ca_id = rs.getInt(1);
				String ca_name = rs.getString(2);
			

				BookVo BookVo = new BookVo();
				BookVo.setCa_id(ca_id);
				BookVo.setCa_name(ca_name);
			

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

			String sql = "select ca_id, ca_name from category where ca_id=?";
			pstmt = conn.prepareStatement(sql);// select 는executeQuery, insert ,
												// updete 는 excuteupdate

			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			// 5. fetch row를 하나씩 가져오기

			while (rs.next()) {
			
				BookVo=new BookVo();
				BookVo.setCa_id(rs.getInt(1));
				BookVo.setCa_name(rs.getString(2));			

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

			String sql = "delete from category where ca_id=?";
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

			String sql = "update category set ca_name=? where ca_id=?";
			pstmt = conn.prepareStatement(sql);// select 는executeQuery, insert ,
												// updete 는 excuteupdate

			pstmt.setString(1, BookVo.getCa_name());
			pstmt.setInt(2, BookVo.getCa_id());
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
