package com.uni3t3.demoproggrafica.sqliteaccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.uni3t3.demoproggrafica.sqliteaccess.pojos.Noticias;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by alvinbaltodano on 3/20/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "demo.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    static {
        cupboard().register(Noticias.class);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        cupboard().withDatabase(sqLiteDatabase).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        cupboard().withDatabase(sqLiteDatabase).upgradeTables();
    }
}