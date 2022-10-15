package group3.join;


import group3.BookManagementSystemApplication;
import group3.common.HomeMenu;

public class JoinController {

	private static JoinController instance = new JoinController();
    public static JoinController getInstance() {
        return instance;
    }
    private JoinController() {}

    private JoinService service = JoinService.getInstance();
    private JoinMemberVO session = BookManagementSystemApplication.getSession();

    public JoinController(JoinService service) {
        this.service = service;
    }

    public JoinMemberVO findMember() {
        return service.findMember(session.getMemId());
    }

    public int join(JoinMemberVO vo) {
        try {
            if (service.join(vo) == 1) {
                return HomeMenu.HOME.getMenu();
            }
        } catch (Exception e) {
            System.out.println("알수 없는 오류가 발생하였습니다");
            return HomeMenu.JOIN.getMenu();
        }
        return HomeMenu.HOME.getMenu();
    }
    public int modifyInfo(String modifyData, HomeMenu menu) {
    	JoinMemberVO vo = new JoinMemberVO();
        vo.setMemId(session.getMemId());
        switch (menu) {
        
            case MODIFY_NAME:
                vo.setMemNm(modifyData);
                break;
            case MODIFY_ADDRESS:
                vo.setAddr(modifyData);
                break;
            case MODIFY_PHONE:
                vo.setPh(modifyData);
                break;
            case MODIFY_EMAIL:
                vo.setEmail(modifyData);
                break;
            case MODIFY_PW:
            	vo.setPw(modifyData);
                break;   
                            
                
        }
        return service.modifyInfo(vo, menu);
    }
    
    public int modifyPassword(String pw) {
    	JoinMemberVO vo = new JoinMemberVO();
        vo.setMemId(session.getMemId());
        vo.setPw(pw);
        return service.modifyPw(vo);
    }
	  
	    
	    
}
