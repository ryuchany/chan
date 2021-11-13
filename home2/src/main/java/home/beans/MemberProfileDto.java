package home.beans;

public class MemberProfileDto {
	private int memberProfileNo;
	private String memberId;
	private String memberProfileUploadname;
	private String memberProfileSavename;
	private String memberProfileType;
	private long memberProfileSize;
	public MemberProfileDto() {
		super();
	}
	public int getMemberProfileNo() {
		return memberProfileNo;
	}
	public void setMemberProfileNo(int memberProfileNo) {
		this.memberProfileNo = memberProfileNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberProfileUploadname() {
		return memberProfileUploadname;
	}
	public void setMemberProfileUploadname(String memberProfileUploadname) {
		this.memberProfileUploadname = memberProfileUploadname;
	}
	public String getMemberProfileSavename() {
		return memberProfileSavename;
	}
	public void setMemberProfileSavename(String memberProfileSavename) {
		this.memberProfileSavename = memberProfileSavename;
	}
	public String getMemberProfileType() {
		return memberProfileType;
	}
	public void setMemberProfileType(String memberProfileType) {
		this.memberProfileType = memberProfileType;
	}
	public long getMemberProfileSize() {
		return memberProfileSize;
	}
	public void setMemberProfileSize(long memberProfileSize) {
		this.memberProfileSize = memberProfileSize;
	}


}
