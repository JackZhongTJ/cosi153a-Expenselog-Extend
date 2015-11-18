package com.hw.cosi153.expense_log;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addEntry extends Activity{
EditText expense_note;
EditText expense_description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense_add);
        // find ID
        expense_note = (EditText)findViewById(R.id.note);
        expense_description = (EditText)findViewById(R.id.description);

        Button save = (Button) findViewById(R.id.save_button);
        Button cancel = (Button) findViewById(R.id.cancel_button);

        View.OnClickListener saveListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnIntent = new Intent();
                //store two string variable into Intent by putExtra method
                returnIntent.putExtra("expense_note", expense_note.getText().toString());
                returnIntent.putExtra("expense_description", expense_description.getText().toString());
                //send back result
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        };
        // cancel button event is finish() and go back to last activity
        View.OnClickListener cancelListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };
        //bind OnClickListener to two button
        save.setOnClickListener(saveListener);
        cancel.setOnClickListener(cancelListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
