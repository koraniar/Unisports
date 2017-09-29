package com.unisports.database.context;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    protected static final String user = "root";
    protected static final String password = "12345678";
    protected static final String serverName = "127.0.0.1";
    protected static final String databaseName = "unisports";
    protected static final int timeOutTime = 0;

    public Connection connect() throws SQLException {
        
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser(user);
            dataSource.setPassword(password);
            dataSource.setServerName(serverName);
            dataSource.setDatabaseName(databaseName);

            Connection conn = dataSource.getConnection();
            return conn;
    }
}
