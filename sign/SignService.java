package group3.sign;

import group3.join.JoinMemberVO;

public class SignService {
	private static SignService instance = new SignService();
    public static SignService getInstance() {
        return instance;
    }
    private SignService() {}

    private SignDAO dao = SignDAO.getInstance();

    public JoinMemberVO findUser(JoinMemberVO vo) {
        return dao.findUser(vo);
    }
}
