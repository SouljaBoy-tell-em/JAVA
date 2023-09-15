package com.example.demo;

import java.util.List;

public class SQLDB {
    private List<SQLConnectorObject> DB;

    public SQLDB(List<SQLConnectorObject> DB) {
        this.DB = DB;
    }

    public List<SQLConnectorObject> getDB() {
        return DB;
    }

    public void setDB(List<SQLConnectorObject> DB) {
        this.DB = DB;
    }
}
