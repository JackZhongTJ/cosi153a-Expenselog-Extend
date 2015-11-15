package com.hw.cosi153.expense_log;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends Activity{
    ListView mylistview;
    Context context = MainActivity.this;
    ArrayList<ExpenseLogEntryData> mylist = new ArrayList<>();
    Customer_ExpenseTracker a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this listview is the root element
        mylistview = (ListView) findViewById(R.id.mylistView);

        // dummy data to display at the first time
        ExpenseLogEntryData ex1 = new ExpenseLogEntryData("12.5$","Dinner");
        ExpenseLogEntryData ex2 = new ExpenseLogEntryData("8.5$","Beer");
        ExpenseLogEntryData ex3 = new ExpenseLogEntryData("23.6$","Gas");

        // Add dummy data into the ArrayList myList
        mylist.add(ex1);
        mylist.add(ex2);
        mylist.add(ex3);
        a = new Customer_ExpenseTracker(context, mylist);
        // Set a new adapter for the root listview
        mylistview.setAdapter(a);

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
                //create a new ExpenseLogEntryData object. Two String Arguments is note and description
                ExpenseLogEntryData ex = new ExpenseLogEntryData(note,description);
                // add this new created object to mylist
                mylist.add(ex);
                // notifty the arraylist that data has changed
                a.notifyDataSetChanged();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
