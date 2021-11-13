package home.beans;

public class BoardFileDto {
	private int boardFileNo;
	private int boardNo;
	private String boardFileUploadname;
	private String boardFileSavename;
	private String boardFileType;
	private long boardFileSize;
	public BoardFileDto() {
		super();
	}
	public int getBoardFileNo() {
		return boardFileNo;
	}
	public void setBoardFileNo(int boardFileNo) {
		this.boardFileNo = boardFileNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardFileUploadname() {
		return boardFileUploadname;
	}
	public void setBoardFileUploadname(String boardFileUploadname) {
		this.boardFileUploadname = boardFileUploadname;
	}
	public String getBoardFileSavename() {
		return boardFileSavename;
	}
	public void setBoardFileSavename(String boardFileSavename) {
		this.boardFileSavename = boardFileSavename;
	}
	public String getBoardFileType() {
		return boardFileType;
	}
	public void setBoardFileType(String boardFileType) {
		this.boardFileType = boardFileType;
	}
	public long getBoardFileSize() {
		return boardFileSize;
	}
	public void setBoardFileSize(long boardFileSize) {
		this.boardFileSize = boardFileSize;
	}
}
