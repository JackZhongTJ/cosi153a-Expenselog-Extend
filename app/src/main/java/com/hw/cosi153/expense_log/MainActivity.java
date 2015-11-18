package com.hw.cosi153.expense_log;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity{
    ListView mylistview;
    private LogDbAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this listview is the root element
        mylistview = (ListView) findViewById(R.id.mylistView);

        dbHelper = new LogDbAdapter(this);
        dbHelper.open();
        displayListView();
    }

    private void displayListView(){
        // use fetch_AllLog method to get all data in the database back.
        cursor = dbHelper.fetch_AllLog();
        // define column
        String[] columns = new String[] {

                LogDbAdapter.EXPENSE_COLUMN_NOTE,
                LogDbAdapter.EXPENSE_COLUMN_DESCRIPTION,
                LogDbAdapter.EXPENSE_COLUMN_DATE
        };
        //define int[]
        int[] to = new int[] {
                R.id.item_note,
                R.id.item_description,
                R.id.item_date
        };
        //define a new simplecursorAdapter class, sent argument to it.
        dataAdapter = new SimpleCursorAdapter(this, R.layout.expense_entry, cursor, columns, to, 0){
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                // TODO Auto-generated method stub
                return super.newView(context, cursor, parent);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                // TODO Auto-generated method stub
                // override bindView needs bind control to value manually
                String note = cursor.getString(cursor.getColumnIndex(LogDbAdapter.EXPENSE_COLUMN_NOTE));
                TextView text1 = (TextView) view.findViewById(R.id.item_note);
                // set text to "note" column
                text1.setText(note);

                String description = cursor.getString(cursor.getColumnIndex(LogDbAdapter.EXPENSE_COLUMN_DESCRIPTION));
                TextView  text2 = (TextView) view.findViewById(R.id.item_description);
                //set text to "description" column
                text2.setText(description);

                String date = cursor.getString(cursor.getColumnIndex(LogDbAdapter.EXPENSE_COLUMN_DATE));
                TextView text3 = (TextView) view.findViewById(R.id.item_date);
                //set text to "date"column
                text3.setText(date);
                // get row_id, to define which row to delete by using "getInt" method
                final int row_id = cursor.getInt(cursor.getColumnIndex("_id"));
                //define "delete" button and bind the button to layout file
                Button button = (Button) view.findViewById(R.id.delete_button);
                //set onclickListener to button
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        // delete single rows by using row_id using "delete_log" method defined in dbHelper class
                        dbHelper.delete_log(row_id);
                        // notify dataAdapter to change the cursor.
                        dataAdapter.changeCursor(dbHelper.fetch_AllLog());
                    }
                });

            }

        };
        // set dataAdapter to mylistview
        mylistview.setAdapter(dataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // when the case is action_settings
            case R.id.action_settings:
            // click to start a new addEntry activity
                Intent i = new Intent("com.hw.addEntry");
            // startactivity for result
                startActivityForResult(i,1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // get result from the addEntry activity, to get note and description user input
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                // get note and description to string
                String note = data.getStringExtra("expense_note");
                String description = data.getStringExtra("expense_description");

                // define a SimpleDateFormat variable to store current time
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                //get current date time with Date()
                Date date2 = new Date();
                //set date variable
                String date = dateFormat.format(date2);
                //use create_log to insert a new record to Sqlite database
                dbHelper.create_log(note, description, date);
                //use fetch_AllLog() method defined in LogDbAdapter class
                cursor = dbHelper.fetch_AllLog();
                // notyfy dataAdapter to change the cursor.
                dataAdapter.changeCursor(cursor);

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
