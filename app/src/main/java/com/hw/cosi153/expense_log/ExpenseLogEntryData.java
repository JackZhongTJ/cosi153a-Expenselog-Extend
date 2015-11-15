package com.hw.cosi153.expense_log;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by zhongzhongzhong on 11/14/15.
 */
public class ExpenseLogEntryData {
    String Description;
    String Note;
    String date;

    //constructor function, take two string argument and store them into object's instance variables
    public ExpenseLogEntryData(String note_string, String description_string){
        //set object's data, Note
        setDate();
        setNote(note_string);
        setDescription(description_string);
    }

    public void setDescription(String description){
        this.Description = description;
    }
    public void setNote(String note){
        this.Note = note;
    }
    public void setDate(){
        // define a SimpleDateFormat variable to store current time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        //set date variable
        this.date = dateFormat.format(date);
    }
    //define three get local variable member function
    public String getDescription(){
        return Description;
    }
    public String getNote(){
        return Note;
    }
    public String getDate(){
        return date;
    }

}
