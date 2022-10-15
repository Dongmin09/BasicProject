package group3;

import group3.book.BookController;
import group3.common.HomeMenu;
import group3.common.MenuNotFoundException;
import group3.join.JoinController;
import group3.sign.SignController;

public class Home {
	
	    private JoinController joinController = JoinController.getInstance();
	    private BookController bookController = BookController.getInstance();
	    private SignController signController = SignController.getInstance();
	
	    private BookManagementSystemView view = BookManagementSystemView.getInstance();

	    public void initialize() throws Exception {
	        home(view.init());
	    }
	    private void home(int number) throws Exception {
	        loop:
	        while (true) {
	            try {
	                HomeMenu menu = HomeMenu.findMenu(number);
	                System.out.print(menu.getMenuString());
	                switch (menu) {
	                    case HOME:
	                    case MYPAGE:
	                    case BORR:
	                    case MEMBER:
	                    case MEMBER_MODIFY_INFO:
	                    	number = view.getMenu();
	                    	break;
	                    // case BORR:		                    	  
	                       // break;
	                    case JOIN:
	                        number = view.join(joinController);
	                        break;
	                    case LOGIN:
	                    	//메뉴를 선택하세요 : 8
	                        number = view.login(signController);
	                        break;
	                    case LOGOUT:
	                        number = signController.signOut();
	                        break;
	                    case BORR_LIST:
	                        number = view.getBookList(bookController);
	                        break;
	                    case SEARCH:
	                        number = view.searchBook(bookController);
	                        break;
	                 
	                    case MEMBER_INFO:
	                        number = view.getMemberInfo(joinController);
	                        break;
	                    case MODIFY_NAME:
	                    case MODIFY_ADDRESS:
	                    case MODIFY_PHONE:
	                        number = view.modifyInfo(joinController, menu);
	                        break;
	                    case MODIFY_PW:
	                        number = view.changePassword(joinController);
	                        break;
	                    case QUIT:
	                        break loop;
	                }
	            } catch (MenuNotFoundException e) {
	                System.out.println(e.getMessage());
	                System.out.print(HomeMenu.HOME.getMenuString());
	            }
	            System.out.println();
	        }
	    }
	}
	
	

