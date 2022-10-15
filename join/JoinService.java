package group3.join;

import group3.common.HomeMenu;

public class JoinService {

	private static JoinService instance = new JoinService();
	public static JoinService getInstance() {
        return instance;
    }
	
	private JoinService() {}
	
	private JoinDAO dao = JoinDAO.getInstance();
	
    public JoinMemberVO findMember(String memId) {
        return dao.findMember(memId);
    }

    public int join(JoinMemberVO vo) {
        return dao.join(vo);
    }

    public int modifyInfo(JoinMemberVO vo, HomeMenu menu) {
        int result = 0;
        switch (menu) {
            case MODIFY_NAME:
                result = dao.modifyMemNm(vo);
                break;
            case MODIFY_ADDRESS:
                result = dao.modifyAddr(vo);
                break;
            case MODIFY_PHONE:
                result = dao.modifyPh(vo);
                break;
            case MODIFY_PW:
                result = dao.modifyPw(vo);
                break;                  
            case MODIFY_EMAIL :
            	result = dao.modifyEmail(vo);
            	break;
                
                
                
        }
        return result;
    }

	public int modifyPw(JoinMemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}



    /*
    
    public int modifyPassword(JoinMemberVO vo) {
        return dao.modifyPassword(vo);
    }
	
	*/
	
	
}
