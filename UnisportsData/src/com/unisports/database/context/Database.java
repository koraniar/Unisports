package com.unisports.database.context;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.unisports.cross.Constants;

public class Database {

    protected final boolean release;
    protected final String user;
    protected final String password;
    protected final String serverName;
    protected static final String databaseName = "unisports";
    protected final String databaseType;
    protected static final int timeOutTime = 0;
    private Connection _connection;

    public Database() {
        release = Constants.release;
        user = release ? "koraniar" : "root";
        password = release ? "Testamfe$2207local" : "12345678";
        serverName = release ? "localamfe.database.windows.net:1433" : "127.0.0.1";
        databaseType = release ? "sqlserver" : "mysql";
    }

    public Connection connect() throws SQLException {
        try {
            if (release) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                _connection = DriverManager.getConnection(String.format("jdbc:%s://%s;databaseName=%s;user=%s;password=%s", databaseType, serverName, databaseName, user, password));                

            } else {
                Class.forName("com.mysql.jdbc.Driver");
                _connection = DriverManager.getConnection(String.format("jdbc:%s://%s/%s?user=%s&password=%s", databaseType, serverName, databaseName, user, password));
            }
            //String a = "jdbc:sqlserver://localamfe.database.windows.net:1433;databaseName=unisports";
            //_connection = DriverManager.getConnection("jdbc:" + databaseType + "://" + serverName +"/" + databaseName + "?user=" + user + "&password=" + password);            

        } catch (ClassNotFoundException e) {
            System.out.println("exception");            
            System.out.println(e.getMessage());
            return null;
        }

//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUser(user);
//        dataSource.setPassword(password);
//        dataSource.setServerName(serverName);
//        dataSource.setDatabaseName(databaseName);
//
//        _connection = dataSource.getConnection();
        return _connection;
    }

    public void Disconnect() {
        try {
            _connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
