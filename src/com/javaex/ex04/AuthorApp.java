package com.javaex.ex04;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {

		AuthorDao authorDao = new AuthorDao();

		// authorInsert
		// authorDao.authorInsert("이문열", "경북영양");
//		authorDao.authorInsert("김문열", "경북영양");
//		authorDao.authorInsert("박경리", "경북영양");
//		authorDao.authorInsert("유시민", "17대 국회의원");
//		authorDao.authorInsert("기안84", "기안동에서 산 84년생");
//		authorDao.authorInsert("강풀", "온라인 만화가 1세대");
//		authorDao.authorInsert("김영하", "알쓸신잡");
		
//		AuthorVo authorVo = new AuthorVo("이문열", "경북영양");
//		authorDao.authorInsert(authorVo);
		
		AuthorVo authorVo = new AuthorVo("정우성", "영화배우");
//		authorVo.setAuthorDesc("정우성");
//		authorVo.setAuthorDesc("영화배우");
		authorDao.authorInsert(authorVo);
		

//		 int iCount = authorDao.authorInsert("박경리", "경상남도 통영");
//		 
//		 if(iCount > 0) { 
//			 System.out.println(iCount + "등록 되었습니다."); 
//		 }else {
//			 System.out.println(iCount + "등록 되지 않았습니다."); 
//		 }

		// 작가 삭제 메소드 : authorDelete
//		int dCount = authorDao.authorDelete(3);
//		System.out.println("삭제건수 : " + dCount);

		// 작가 수정 메소드 : authorUpdate
//		int uCount = authorDao.authorUpdate(1, "이문열", "삼국지 작가");
//		System.out.println("수정건수:" + uCount );

		// 작가 리스트 가져오기 메소드 : authorSelect
		// authorDao.authorSelect();
		List<AuthorVo> authorList = authorDao.authorSelect();
		// System.out.println(authorList.get(0).getAuthorName());
		for (int i = 0; i < authorList.size(); i++) {

//			int authorId = authorList.get(i).getAuthorId(); 
//			String authorName = authorList.get(i).getAuthorName(); 
//			String authorDesc = authorList.get(i).getAuthorDesc();
//			  
//			System.out.println(authorId + ", " + authorName + ", " + authorDesc);

			AuthorVo authorVo = authorList.get(i);
			System.out.println(
					authorVo.getAuthorId() + ", " + authorVo.getAuthorName() + ", " + authorVo.getAuthorDesc());

//			System.out.println(authorList.get(i).getAuthorId() + ", " + authorList.get(i).getAuthorName() + ", "
//					+ authorList.get(i).getAuthorDesc());

		}

	}

}
