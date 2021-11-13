package home.beans;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

public class ReplyDto {
	private int replyNo;
	private int boardNo;
	private String replyWriter;
	private String replyContent;
	private Date replyTime;
	private int replySuperno;
	private int replyGroupno;
	private int replyDepth;
	public ReplyDto() {
		super();
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public int getReplySuperno() {
		return replySuperno;
	}
	public void setReplySuperno(int replySuperno) {
		this.replySuperno = replySuperno;
	}
	public int getReplyGroupno() {
		return replyGroupno;
	}
	public void setReplyGroupno(int replyGroupno) {
		this.replyGroupno = replyGroupno;
	}
	public int getReplyDepth() {
		return replyDepth;
	}
	public void setReplyDepth(int replyDepth) {
		this.replyDepth = replyDepth;
	}

    // 댓글 작성 시간 설정 (2000-10-10 00:00:00)
	public String getReplyFullTime() {
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(replyTime);
	}
	
}
