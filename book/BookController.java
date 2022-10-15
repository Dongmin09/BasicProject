package group3.book;

import java.util.List;

public class BookController {
    private static BookController instance = new BookController();
    public static BookController getInstance() {
        return instance;
    }
    private BookController() {}

    private BookService service = BookService.getInstance();

    public List<BookVO> selectBookList(String searchWord) throws Exception {
        return service.findAll(searchWord);
    }

}
