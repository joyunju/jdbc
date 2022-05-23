// JDBC(Java Database Connectivity)
// : 자바 프로그램내에서 SQL문을 실행하기 위한 자바 API

package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsert {

	public static void main(String[] args) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. SQL문 준비 / 바인딩 / 실행
			// 3-1. SQL문 준비
			String query = "";
			query += " INSERT INTO book ";
			query += " VALUES (seq_book_id.nextval, ?, ?, ?, ?) ";
			
			System.out.println(query);
			
			// 3-2. 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "토지");
			pstmt.setString(2, "마로니에북스");
			pstmt.setString(3, "2012-08-15");
			pstmt.setInt(4, 2);
			
			//3-3. 실행
			int count = pstmt.executeUpdate();			// 쿼리문 실행  --> 성공갯수 리턴
			
			
			// 4.결과처리
			System.out.println(count + "건이 등록 되었습니다.");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
//				if (rs != null) {
//					rs.close();
//				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

	}

}
