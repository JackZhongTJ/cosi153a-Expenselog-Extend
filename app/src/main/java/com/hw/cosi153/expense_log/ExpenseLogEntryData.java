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

    public ExpenseLogEntryData(String note_string, String description_string){
        this.Description = description_string;
        this.Note = note_string;
        setDate();
        setNote(Note);
        setDescription(Description);
    }

    public void setDescription(String description){
        this.Description = description;
    }
    public void setNote(String note){
        this.Note = note;
    }
    public void setDate(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        this.date = dateFormat.format(date);
    }
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
