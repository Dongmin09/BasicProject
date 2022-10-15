package group3.sign;

import group3.BookManagementSystemApplication;
import group3.common.HomeMenu;
import group3.join.JoinMemberVO;

public class SignController {	
		private static SignController instance = new SignController();
		public static SignController getInstance() {
			return instance;
		}

		private SignController() {
		}

		private SignService service = SignService.getInstance();

		private JoinMemberVO session = BookManagementSystemApplication.getSession();

		public JoinMemberVO signIn(JoinMemberVO vo) {
			JoinMemberVO member = service.findUser(vo);
			if (member == null) {
				return null;
			}
			session.setMemId(member.getMemId());
			session.setMemNm(member.getMemNm());
			return member;
		}

		public int signOut() {
			// 세션 초기화
			session.invalidate();
			return HomeMenu.HOME.getMenu();
		}

	}


