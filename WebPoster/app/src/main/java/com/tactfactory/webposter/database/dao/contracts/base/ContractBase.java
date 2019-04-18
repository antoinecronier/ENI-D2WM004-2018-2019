package com.tactfactory.webposter.database.dao.contracts.base;

public abstract class ContractBase {

    public String TABLE_NAME;

    public String COL_ID;

    public String[] ALL_SELECT;

    public String[] ALL_SELECT_WITH_LINKS;

    public String CREATE_TABLE;

    public String DROP_TABLE;

    public ContractBase(String TABLE_NAME, String COL_ID, String[] ALL_SELECT, String[] ALL_SELECT_WITH_LINKS, String CREATE_TABLE, String DROP_TABLE) {
        this.TABLE_NAME = TABLE_NAME;
        this.COL_ID = COL_ID;
        this.ALL_SELECT = ALL_SELECT;
        this.ALL_SELECT_WITH_LINKS = ALL_SELECT_WITH_LINKS;
        this.CREATE_TABLE = CREATE_TABLE;
        this.DROP_TABLE = DROP_TABLE;
    }
}
