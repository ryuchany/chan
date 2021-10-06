package jdbc.select;

public class Test10_2 {
	public static void main(String[] args) {
		// 입력
		String kind = "member_id";
		String keyword = "stu";

		// 처리
		String sql = "select * from member where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", kind);
		System.out.println(sql);
	}
}
