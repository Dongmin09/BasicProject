package group3.common;


import java.util.Scanner;

public enum HomeMenu {
   
    HOME(-1, "1.회원가입\t8.로그인\t5.도서검색\t0.프로그램 종료\n메뉴를 선택하세요: "), 
    QUIT(0, "프로그램을 종료합니다!\n이용해주셔서 감사합니다~\n"),  
    JOIN(1, "회원가입에 필요한 정보를 입력합니다.\n"),
    
    MYPAGE(2, "3.회원 정보\t4.대출정보\t5.도서검색\t9.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    MEMBER(3, "31.회원정보확인\t32.회원정보수정\t2.이전메뉴\t9.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    BORR(4, "41.대출목록\t42.대출연장\t43.도서반납\t2.이전메뉴\t9.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    SEARCH(5, "검색할 책 제목을 입력하세요: "),
    
    LOGIN(8, "아이디와 비밀번호를 입력하세요.\n"),  
    LOGOUT(9, "로그아웃 되었습니다!\n"),
    MEMBER_INFO(31, "개인정보 확인\n"),
    MEMBER_MODIFY_INFO(32, "321.이름\t322.주소\t323.휴대전화번호\t324.이메일\t325.비밀번호\t3.이전메뉴\n수정할 항목을 선택하세요: "),
    MODIFY_NAME(321, "이름 수정\n변경할 이름을 입력하세요: "),
    MODIFY_ADDRESS(322, "주소 수정\n변경할 주소를 입력하세요: "),
    MODIFY_PHONE(323, "휴대전화번호 수정\n변경할 휴대전화번호를 입력하세요: "),
    MODIFY_EMAIL(324, "이메일 수정\n변경할 이메일을 입력하세요: "),
    MODIFY_PW(325, "패스워드 변경\n변경할 패스워드를 입력하세요: "),

   BORR_LIST(41, "대출 책 목록\n"), 
   BORR_EXTE(42, "연장 할 도서번호를 선택하세요 :  "),
   BORR_RETURN(43, "반납 할 도서번호를 선택하세요 :  ");
	
	
	
    private final int menu;
    private final String menuString;

    HomeMenu(int menu, String menuString) {
        this.menu = menu;
        this.menuString = menuString;
    }

    public int getMenu() {
        return menu;
    }

    public String getMenuString() {
        return menuString;
    }

    public static HomeMenu findMenu(int number) throws MenuNotFoundException {
        for (HomeMenu menu: values()) {
            if (menu.getMenu() == number) {
                return menu;
            }
        }
        throw new MenuNotFoundException("선택하신 메뉴가 없습니다.");
    }
    public void display(Scanner scanner) {

    }
}