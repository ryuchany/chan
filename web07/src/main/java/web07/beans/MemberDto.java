package web07.beans;

public class MemberDto {

	private String memberId;
	private String memberPw;
	private String memberNick;
	private String memberBirth;
	private String memberEmail;
	private String memberPhone;
	private String memberJoin;
	private int memberPoint;
	private String memberGrade;
	
	
	
	
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberPw=" + memberPw + ", memberNick=" + memberNick
				+ ", memberBirth=" + memberBirth + ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone
				+ ", memberJoin=" + memberJoin + ", memberPoint=" + memberPoint + ", memberGrade=" + memberGrade + "]";
	}

	public MemberDto() {
		super();
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberJoin() {
		return memberJoin;
	}
	public void setMemberJoin(String memberJoin) {
		this.memberJoin = memberJoin;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	public String getMemberBirthDate() {
		return memberBirth.substring(0, 10);
	}


}
