package group3.book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private static BookService instance = new BookService();
    public static BookService getInstance() {
        return instance;
    }
    private BookService() {}

    private BookDAO dao = BookDAO.getInstance();

    public List<BookVO> findAll(String searchWord) throws Exception {
        return dao.findAll(searchWord);
    }


}
