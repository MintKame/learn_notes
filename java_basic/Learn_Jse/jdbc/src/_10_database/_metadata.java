package _10_database;

import java.sql.*;

public class _metadata {
    // what are 2 type metadata && how get ?
    static void metaDB(Connection connection) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        meta.getURL();
        meta.getUserName();
        meta.getDriverName();
        // get the table of table's info
        ResultSet rs = meta.getTables(
                null, null, null, new String[]{"TABLE"});
        while (rs.next()){
            rs.getString("TABLE_NAME");
        }
    }

    static void metaRS(ResultSet resultSet) throws SQLException {
        ResultSetMetaData meta = resultSet.getMetaData();
        meta.getColumnCount();
        meta.getColumnName(1);
    }
}
