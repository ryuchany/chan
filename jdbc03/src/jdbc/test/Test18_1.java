package jdbc.test;

import java.util.List;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test18_1 {
	public static void main(String[] args) throws Exception {
		//member 목록과 검색을 한 번에
		//1. 검색분류와 검색어가 없으면 목록을 조회하여 출력
		//2. 검색분류와 검색어가 있으면 검색을 수행하여 출력

		String column = "member_id";
		String keyword = "test";

//		boolean isSearch = column이 있고 keyword가 있으면;
		boolean isSearch = (column != null && !column.equals("")) 
										&& (keyword != null && !keyword.equals(""));
		System.out.println("isSearch = " + isSearch);

		MemberDao memberDao = new MemberDao();
		List<MemberDto> list;
		if(isSearch) {
			list = memberDao.select(column, keyword);
		}
		else {
			list = memberDao.list();
		}

		for(MemberDto memberDto : list) {
			System.out.println(memberDto);
		}
	}
}
