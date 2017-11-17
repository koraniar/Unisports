package com.unisports.database.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.unisports.cross.Constants;

public class Database {

    protected final boolean microsoftDB;
    protected final String user;
    protected final String password;
    protected final String serverName;
    protected static final String databaseName = "unisports";
    protected final String databaseType;
    protected static final int timeOutTime = 0;
    private Connection _connection;

    public Database() {
        microsoftDB = Constants.microsoft;
        user = microsoftDB ? "koraniar" : "root";
        password = microsoftDB ? "Testamfe$2207local" : "12345678";
        serverName = microsoftDB ? "localamfe.database.windows.net:1433" : "127.0.0.1";
        databaseType = microsoftDB ? "sqlserver" : "mysql";
    }

    public Connection connect() throws SQLException {
        try {
            if (microsoftDB) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                _connection = DriverManager.getConnection(String.format("jdbc:%s://%s;databaseName=%s;user=%s;password=%s", databaseType, serverName, databaseName, user, password));                

            } else {
                Class.forName("com.mysql.jdbc.Driver");
                _connection = DriverManager.getConnection(String.format("jdbc:%s://%s/%s?user=%s&password=%s", databaseType, serverName, databaseName, user, password));
            }        

        } catch (ClassNotFoundException e) {
            System.out.println("exception");            
            System.out.println(e.getMessage());
            return null;
        }
        
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
