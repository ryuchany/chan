package home.beans;

import java.sql.Date;

//회원 1명의 정보를 모두 담을 수 있는 포장(변환) 클래스
public class MemberDto {
	private String memberId;
	private String memberPw;
	private String memberNick;
	private String memberBirth;
	private String memberEmail;
	private String memberPhone;
	private Date memberJoin;
	private int memberPoint;
	private String memberGrade;
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
	public String getMemberBirthDay() {
		return memberBirth.substring(0, 10);
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public String getMemberEmailString() {
		if(memberEmail == null) 
			return "";
		else
			return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public String getMemberPhoneString() {
		if(memberPhone == null)
			return "";
		else
			return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public Date getMemberJoin() {
		return memberJoin;
	}
	public void setMemberJoin(Date memberJoin) {
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
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberNick=" + memberNick + ", memberBirth=" + memberBirth
				+ ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone + ", memberJoin=" + memberJoin
				+ ", memberPoint=" + memberPoint + ", memberGrade=" + memberGrade + "]";
	}
}
