package group3.book;

import java.util.Objects;

public class BookVO {
    private String bookNum;
    private String bookTt;
    private String ath;
    private String bookCfnCod;
    
	public BookVO() {
		super();
	}
	public BookVO(String bookNum, String bookTt, String ath, String bookCfnCod) {
		super();
		this.bookNum = bookNum;
		this.bookTt = bookTt;
		this.ath = ath;
		this.bookCfnCod = bookCfnCod;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookTt() {
		return bookTt;
	}
	public void setBookTt(String bookTt) {
		this.bookTt = bookTt;
	}
	public String getAth() {
		return ath;
	}
	public void setAth(String ath) {
		this.ath = ath;
	}
	public String getBookCfnCod() {
		return bookCfnCod;
	}
	public void setBookCfnCod(String bookCfnCod) {
		this.bookCfnCod = bookCfnCod;
	}
	@Override
	public String toString() {
		return "BookVO [bookNum=" + bookNum + ", bookTt=" + bookTt + ", ath=" + ath + ", bookCfnCod=" + bookCfnCod
				+ "]";
	}

}
