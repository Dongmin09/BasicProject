package group3.sign;



import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import group3.BookManagementSystemApplication;
import group3.join.JoinMemberVO;

public class SignDAO {
	 private static SignDAO instance = new SignDAO();
	    public static SignDAO getInstance() {
	        return instance;
	    }
	    private SignDAO() {}

	    private JdbcTemplate template = BookManagementSystemApplication.getTemplate();

	    //JoinMemberVO [memId=memNm=null'addr=null'ph=null'pw=6'email=null']
	    public JoinMemberVO findUser(JoinMemberVO vo) {
	        try {
	        	System.out.println("vo : " + vo.toString());
	            return template.queryForObject("SELECT MEM_ID, PW, MEM_NM, ADDR, EMAIL , PH FROM MEM WHERE MEM_ID = ? AND PW = ?", new BeanPropertyRowMapper<>(JoinMemberVO.class), vo.getMemId(), vo.getPw());
	        } catch (DataAccessException e) {
	            return null;
	        }
	    }
}
