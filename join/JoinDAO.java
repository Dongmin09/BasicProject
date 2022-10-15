package group3.join;

import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import group3.BookManagementSystemApplication;

public class JoinDAO {

	private static JoinDAO instance = new JoinDAO();
    public static JoinDAO getInstance() {
        return instance;
    }
    private JoinDAO() {}

    private JdbcTemplate template = BookManagementSystemApplication.getTemplate();

    public JoinMemberVO findMember(String memId) {
        return template.queryForObject("SELECT MEM_ID, MEM_NM, ADDR, PH, PW, EMAIL, FROM MEM WHERE MEM_ID = ?", new BeanPropertyRowMapper<>(JoinMemberVO.class), memId);
    }

    public int join(JoinMemberVO vo) {
    	 
	        int result = template.update("INSERT INTO MEM (MEM_ID, MEM_NM, ADDR,PH, PW, EMAIL) VALUES (?, ?, ?, ?, ?,?)", 
	        									vo.getMemId(), vo.getMemNm(), vo.getAddr(), vo.getPh(), vo.getPw(),vo.getEmail());
	        return result;
    	
    }

    public int modifyMemNm(JoinMemberVO vo) {
        return template.update("UPDATE MEM SET MEM_NM = ? WHERE MEM_ID = ?", vo.getMemNm(), vo.getMemId());
    }

    public int modifyAddr(JoinMemberVO vo) {
        return template.update("UPDATE MEM SET ADDR = ? WHERE MEM_ID = ?", vo.getAddr(), vo.getMemId());
    }

    /*
    public int modifyMemDiv(JoinMemberVO vo) {
        return template.update("UPDATE MEM SET MEM_DIV = ? WHERE MEM_ID = ?", vo.getMemDiv(), vo.getMemId());
    }
    */
    
    public int modifyPh(JoinMemberVO vo) {
        return template.update("UPDATE MEM SET PH = ? WHERE MEM_ID = ?", vo.getPh(), vo.getMemId());
    }

    public int modifyPw(JoinMemberVO vo) {
        return template.update("UPDATE MEM SET PW = ? WHERE MEM_ID = ?", vo.getPw(), vo.getMemId());
    }
	
    public int modifyEmail(JoinMemberVO vo) {
        return template.update("UPDATE MEM SET EMAIL = ? WHERE MEM_ID = ?", vo.getEmail(), vo.getMemId());
    }
    
    
    
}
