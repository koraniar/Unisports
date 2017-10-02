package com.unisports.database.context;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    protected static final String user = "root";
    protected static final String password = "12345678";
    protected static final String serverName = "127.0.0.1";
    protected static final String databaseName = "unisports";    
    protected static final String databaseType = "mysql";
    protected static final int timeOutTime = 0;
    private Connection _connection;

    public Connection connect() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            //_connection = DriverManager.getConnection("jdbc:" + databaseType + "://" + serverName +"/" + databaseName + "?user=" + user + "&password=" + password);            
            _connection = DriverManager.getConnection(String.format("jdbc:%s://%s/%s?user=%s&password=%s", databaseType, serverName, databaseName, user, password));

        }catch(ClassNotFoundException e){
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
