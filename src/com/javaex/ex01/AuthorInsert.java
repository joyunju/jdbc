package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorInsert {

	public static void main(String[] args) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null; --> insert에서는 필요 없음 
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 이렇게 한줄로 작성도 가능
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "webdb", "webdb");
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "아이디", "비밀번호");
			
			// 3. SQL문 준비 / 바인딩 / 실행
			
			// 3. SQL문 준비
			// String str = "이 안에 sql 에서 작성한 insert 문 복사 ";
			//String str = "INSERT INTO author VALUES (seq_author_id.nextval, '김문열', '경북 영양')";
			String query = "";
			query += " INSERT INTO author ";
			query += " VALUES (seq_author_id.nextval, ?, ?) ";
			
			System.out.println(query);
			
			// 3. 바인딩 
			pstmt = conn.prepareStatement(query);	//문자열을 쿼리로 만들기
			// ? 물음표가 두개니까
			//pstmt.setString(? 첫번째 자리에 들어갈 ,? 두번째 자리에 들어갈);
			pstmt.setString(1,"이문열");		// ?(물음표) 중 1번째 --> 순서 중요
			pstmt.setString(2,"경북 영양");	// ?(물음표) 중 2번째 --> 순서 중요
			
			//3. 실행
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
