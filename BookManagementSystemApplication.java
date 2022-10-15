package group3;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import group3.join.JoinMemberVO;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class BookManagementSystemApplication {


	
    private static JoinMemberVO session = new JoinMemberVO();
    private static JdbcTemplate template = new JdbcTemplate();

    public static void main(String[] args) throws Exception {
        new Home().initialize();
    }

    public static JoinMemberVO getSession() {
        return session;
    }
    public static JdbcTemplate getTemplate() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@192.168.142.4:1521:xe");
            dataSource.setUser("ddit");
            dataSource.setPassword("java");
            template.setDataSource(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return template;
    }
}
