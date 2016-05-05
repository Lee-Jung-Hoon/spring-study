package springbook.user.dao;

/**
 * Created by kjnam on 2016. 5. 5..
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {
    PreparedStatement makePreparedStatement(Connection c) throws SQLException;
}
