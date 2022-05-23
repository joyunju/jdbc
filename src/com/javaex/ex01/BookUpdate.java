package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookUpdate {

	public static void main(String[] args) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			// 3-1. SQL문 준비
			String query = "";
			query += " UPDATE book ";
			query += " SET title = ?, ";
			query += " pubs = ?, ";
			query += " pub_date = ? ";
			query += " WHERE author_id = ? ";
			System.out.println(query);

			// 3-2. 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "용의자 X의 헌신");
			pstmt.setString(2, "재인");
			pstmt.setString(3, "2017-08-30");
			pstmt.setInt(4, 2);

			// 3-3. 실행
			int count = pstmt.executeUpdate(); // 쿼리문 실행 --> 성공갯수 리턴

			// 4.결과처리
			System.out.println(count + "건이 수정 되었습니다.");

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
