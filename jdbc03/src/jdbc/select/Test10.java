package jdbc.select;

public class Test10 {
	public static void main(String[] args) {
		// 입력
		String kind = "member_id";
		String keyword = "stu";

		// 처리
		String sql = "select * from member where instr(member_id, ?) > 0 order by member_id asc";
	}
}
