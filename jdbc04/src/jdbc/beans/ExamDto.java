package jdbc.beans;

public class ExamDto {
	private int examId;
	private String student;
	private String subject;
	private String type;
	private int score;
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
	public ExamDto() {
		super();
	}
	@Override
	public String toString() {
		return "ExamDto [examId=" + examId + ", student=" + student + ", subject=" + subject + ", type=" + type
				+ ", score=" + score + "]";
	}
	
	

	
	
}
