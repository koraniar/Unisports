package com.unisports.database.context;



public class Database {
    protected final String user = "";    
    protected final String password = "";
    protected final String url = "myDBHost.example.org";    
    protected final String databaseType = "";
    protected final int timeOutTime = 0;
    
    public boolean connect(){
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUser(user);
//        dataSource.setPassword(password);
//        dataSource.setServerName(url);
        return true;
    }
}
