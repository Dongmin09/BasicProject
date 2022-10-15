package group3;

import java.util.Scanner;

import group3.book.BookController;
import group3.common.HomeMenu;
import group3.common.ScannerUtil;
import group3.join.JoinController;
import group3.join.JoinMemberVO;
import group3.sign.SignController;




public class BookManagementSystemView {

	private static BookManagementSystemView instance = new BookManagementSystemView();
    private BookManagementSystemView() {}
    public static BookManagementSystemView getInstance() {
        return instance;
    }

    private Scanner scanner = ScannerUtil.scanner();

    public int init() {
        System.out.println("I들 도서관리시스템에 오신 것을 환영합니다!");
        System.out.print(HomeMenu.HOME.getMenuString());
        return scanner.nextInt();
    }

    public int getMenu() {
        return scanner.nextInt();
    }

    public int join(JoinController controller) {
        int number;
        scanner.nextLine();
        System.out.print("아이디: ");
        String memId = scanner.nextLine();
        System.out.print("이름: ");
        String memNm = scanner.nextLine();
        System.out.print("주소: ");
        String addr = scanner.nextLine();
        System.out.print("전화번호: ");
        String ph = scanner.nextLine();
        System.out.print("패스워드: ");
        String pw = scanner.nextLine();
        System.out.print("이메일 : ");
        String email = scanner.nextLine();
        
        
        JoinMemberVO joinMemberVO = new JoinMemberVO(memId, memNm, addr, ph, pw,email);
//        System.out.println("joinMemberVO : " + joinMemberVO.toString());
        number = controller.join(joinMemberVO);
        System.out.println("memId : " + memId);
        System.out.println("memNm : " + memNm);
        System.out.println("addr : " + addr);
        System.out.println("ph : " + ph);
        System.out.println("pw : " + pw);
        System.out.println("Email : " + email);
        System.out.println("number : " + number);
        
        
        if (number == HomeMenu.HOME.getMenu()) {
            System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
        } else {
            System.out.print("회원 가입 실패! 다시 회원가입을 하시겠습니까?(y 또는 n을 입력): ");
            String inputFlag = scanner.nextLine();
            if (inputFlag.equalsIgnoreCase("y")) {
                number = HomeMenu.JOIN.getMenu();
            } else {
                number = HomeMenu.HOME.getMenu();
            }
        }
        return number;
    }
    
    public int login(SignController controller) {
        int number;
        System.out.print("아이디: ");
        scanner.nextLine();
        String userId = scanner.nextLine();
   //    System.out.println("userId : " + userId);
  //      scanner.nextLine();
        System.out.print("패스워드: ");
        String userPw = scanner.nextLine();
        //JoinMemberVO [memId=1, pw=6 ]
        JoinMemberVO joinMemberVO = new JoinMemberVO(userId, userPw);
//        System.out.println("joinMemberVO : " + joinMemberVO.toString());
        JoinMemberVO vo = controller.signIn(joinMemberVO);
//        System.out.println("vo : " + vo.toString());
        if (vo != null) {
            System.out.println(vo.getMemNm() + "님 로그인되었습니다.");
            number = HomeMenu.MYPAGE.getMenu();
         //  number = 0;
        } else {
            System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
            number = HomeMenu.HOME.getMenu();
        }
        return number;
    }


    public int getBookList(BookController controller) throws Exception {
        controller.selectBookList("").forEach(bookVO -> {
            System.out.printf("%s\t%s\t%s\t%s\n", bookVO.getBookNum(), bookVO.getBookTt(), bookVO.getAth(), bookVO.getBookCfnCod());
        });
        return HomeMenu.BORR.getMenu();
    }
//
    public int searchBook(BookController controller) throws Exception {
        // scanner의 nextInt()와 nextLine() 사이의 줄바꿈 특수문자 제거를 해줌
        scanner.nextLine();
        String searchWord = scanner.nextLine();
        System.out.println("도서번호\t도서제목\t 작가\t 도서분류코드");

        controller.selectBookList(searchWord).forEach(bookVO -> {
            System.out.printf("%s\t%s\t%s\t%s\n", bookVO.getBookNum(), bookVO.getBookTt(), bookVO.getAth(), bookVO.getBookCfnCod());
        });
        return HomeMenu.SEARCH.getMenu();
    }
    
 	public int getMemberInfo(JoinController controller) {

    	JoinMemberVO member = controller.findMember();
    	
        System.out.printf("아이디: %d\n", member.getMemId());
        System.out.printf("비밀번호: %s\n", member.getPw());
        System.out.printf("이름: %s\n", member.getMemNm());
        System.out.printf("주소: %s\n", member.getAddr());
        System.out.printf("휴대전화번호: %s\n", member.getPh());
        System.out.printf("이메일: %s\n", member.getEmail());
        return HomeMenu.MEMBER.getMenu();
    }

    public int modifyInfo(JoinController controller, HomeMenu menu) {
        scanner.nextLine();
        int resultName = controller.modifyInfo(scanner.nextLine(), menu);
        if (resultName == 1) {
            System.out.println("정상적으로 수정되었습니다.");
        }
        return HomeMenu.MEMBER.getMenu();
    }

    public int changePassword(JoinController controller) {
        scanner.nextLine();
        String newPassword = scanner.nextLine();
        System.out.print("비밀번호 확인을 위해 다시 한번 입력해주세요: ");
        String confirmPassword = scanner.nextLine();
        if (newPassword.equals(confirmPassword)) {
            controller.modifyPassword(confirmPassword);
            System.out.println("비밀번호가 변경되었습니다.");
        } else {
            System.out.println("비밀번호가 일치하지 않습니다. 비밀번호 변경을 취소합니다.");
        }
        return HomeMenu.MEMBER.getMenu();
    }
	
	
}
