package web07.beans;

//시험정보를 보관하기 위해 만든 클래스
//= 번호(exam_id) + 학생명(student) + 과목명(subject) + 유형(type) + 점수(score)
//= 자바에서 배웠던 가장 일반적인 클래스
//= DB 테이블의 1줄 정보를 저장할 수 있도록 구성한다
//= 택배상자(포장상자) 역할
public class ExamDto {
	private int examId;
	private String student;
	private String subject;
	private String type;
	private int score;

	
	
	@Override
	public String toString() {
		return "ExamDto [examId=" + examId + ", student=" + student + ", subject=" + subject + ", type=" + type
				+ ", score=" + score + "]";
	}

	// 기본생성자 + setter/getter (+toString)
	public ExamDto() {
		super();
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
