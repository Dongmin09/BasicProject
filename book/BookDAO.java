package group3.book;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import group3.BookManagementSystemApplication;
import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static BookDAO instance = new BookDAO();
    public static BookDAO getInstance() {
        return instance;
    }
    private BookDAO() {}

    private JdbcTemplate template = BookManagementSystemApplication.getTemplate();

    public List<BookVO> findAll(String searchWord) throws Exception {
        return template.query("SELECT BOOK_NUM, BOOK_TT, ATH, BOOK_CFN_COD FROM BOOK WHERE BOOK_TT like '%' || ? || '%'", new BeanPropertyRowMapper<>(BookVO.class), searchWord);

    }

}
