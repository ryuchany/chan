package jdbc.select;

public class Test10_1 {
	public static void main(String[] args) {
		// 입력
		String kind = "member_id";
		String keyword = "stu";

		// 처리
		String sql = "select * from member where instr(" + kind + ", ?) > 0 order by " + kind + " asc";
		System.out.println(sql);
	}
}
