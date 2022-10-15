package group3.join;

public class JoinMemberVO {

	private String memId;
	private String memNm;
	private String addr;
	//private String memDiv;
	private String ph;
	private String pw;
	private String email;

	public JoinMemberVO() {

	}

	public JoinMemberVO(String memId, String pw) {

		this.memId = memId;
		this.pw = pw;
	}
	//memId, memNm, addr, ph, pw,email
	public JoinMemberVO(String memId, String memNm, String addr, String ph, String pw, String email) {

		this.memId = memId;
		this.memNm = memNm;
		this.addr = addr;
	//	this.memDiv = memDiv;
		this.ph = ph;
		this.pw = pw;
		this.email = email;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemNm() {
		return memNm;
	}

	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	/*private String getMemDiv() {
		return memDiv;
	}

	private void setMemDiv(String memDiv) {
		this.memDiv = memDiv;
	}
*/
	
	
	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void invalidate() {

		this.memId = null;
		this.memNm = null;
		this.addr = null;
	//	this.memDiv = null;
		this.ph = null;
		this.pw = null;
		this.email = null;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JoinMemberVO [");
		if (memId != null)
			builder.append("memId=").append(memId).append(", ");
		if (memNm != null)
			builder.append("memNm=").append(memNm).append(", ");
		if (addr != null)
			builder.append("addr=").append(addr).append(", ");
		if (ph != null)
			builder.append("ph=").append(ph).append(", ");
		if (pw != null)
			builder.append("pw=").append(pw).append(", ");
		if (email != null)
			builder.append("email=").append(email);
		builder.append("]");
		return builder.toString();
	}

//	@Override
//	public String toString() {
//		final StringBuilder abc = new StringBuilder();
//		abc.append("JoinMemberVO [");
//		abc.append("memId=").append(memId);
//		abc.append("memNm=").append(memNm).append('\'');
//		abc.append("addr=").append(addr).append('\'');
//	//	abc.append("memDiv=").append(memDiv).append('\'');
//		abc.append("ph=").append(ph).append('\'');
//		abc.append("pw=").append(pw).append('\'');
//		abc.append("email=").append(email).append('\'');
//		abc.append("]");
//		return abc.toString();
//	}
	

}
