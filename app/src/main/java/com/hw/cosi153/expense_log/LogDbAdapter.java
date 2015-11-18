package com.hw.cosi153.expense_log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by zhongzhongzhong on 11/17/15.
 */
public class LogDbAdapter {
    public static final String DATABASE_NAME = "cosi.db";
    public static final String EXPENSE_TABLE_NAME = "expense";
    public static final String EXPENSE_COLUMN_ID = "_id";
    public static final String EXPENSE_COLUMN_NOTE = "note";
    public static final String EXPENSE_COLUMN_DESCRIPTION = "description";
    public static final String EXPENSE_COLUMN_DATE = "date";
    public static final String TAG = "create?:";

    private final Context mCtx;

    private DBHelper mDbHelper;
    private SQLiteDatabase mDb;

    public LogDbAdapter(Context ctx){
        this.mCtx = ctx;
    }

    public LogDbAdapter open(){
        mDbHelper = new DBHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDb != null){
            mDbHelper.close();
        }
    }
    // insert a new record to database. Using contentValues to store key-value pair and interact with database.
    public long create_log(String note, String description, String date){
        ContentValues initiativeValue = new ContentValues();
        initiativeValue.put(EXPENSE_COLUMN_NOTE, note);
        initiativeValue.put(EXPENSE_COLUMN_DESCRIPTION, description);
        initiativeValue.put(EXPENSE_COLUMN_DATE, date);
        return mDb.insert(EXPENSE_TABLE_NAME, null, initiativeValue);
    }
    // delete one row from database according to it's id.
    public void delete_log(int id){
        //Cursor mCursor= null;
        mDb.execSQL("DELETE FROM 'expense' WHERE _id = '" + id +"'");
    }

    // execute a "select * from table" query by using query(), return a cursor which contains the whole database data.
    public Cursor fetch_AllLog(){
        Cursor mCursor = null;
          mCursor = mDb.query(EXPENSE_TABLE_NAME, new String[] {
                EXPENSE_COLUMN_ID,EXPENSE_COLUMN_NOTE,EXPENSE_COLUMN_DESCRIPTION,EXPENSE_COLUMN_DATE}, null, null, null, null, null);
        if(mCursor!= null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }



    public class DBHelper extends SQLiteOpenHelper {


        public DBHelper(Context context){
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // when it is onCreate, create a new table called "expense", there are four columns: _id, note, description and date.
            // user db.execSQL to execute a sql query.
            db.execSQL(
                    "create table expense" +
                            "(_id integer primary key autoincrement, note text, description text, date text)"
            );
            Log.d(TAG, "onCreate");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS expense");
            onCreate(db);
        }

    }
}


