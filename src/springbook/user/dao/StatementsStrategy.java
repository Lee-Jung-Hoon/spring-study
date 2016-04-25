package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by kjnam on 2016. 4. 22..
 */
public interface StatementsStrategy {
    PreparedStatement makePreparedStatement(Connection c) throws SQLException;
}
