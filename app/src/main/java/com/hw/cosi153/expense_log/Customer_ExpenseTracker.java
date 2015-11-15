package com.hw.cosi153.expense_log;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by zhongzhongzhong on 11/14/15.
 */
public class Customer_ExpenseTracker extends BaseAdapter {

    ArrayList<ExpenseLogEntryData> Expenselog = new ArrayList<>();
    LayoutInflater inflater;
    Context context;


    public Customer_ExpenseTracker(Context context, ArrayList<ExpenseLogEntryData> Expenselog){
        this.Expenselog = Expenselog;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount(){
        return Expenselog.size();
    }

    @Override
    public ExpenseLogEntryData getItem(int index) {

        return Expenselog.get(index);
    }


    @Override
    public long getItemId(int index) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder myViewHolder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.expense_entry, parent, false);
            myViewHolder = new ViewHolder (convertView);
            convertView.setTag(myViewHolder);
        }
        else {
            myViewHolder = (ViewHolder) convertView.getTag();
        }
        ExpenseLogEntryData myExpenseLogEntryData = getItem(position);
        //set three field using getDescription function defined in ExpenseLogEntryData class
        myViewHolder.description.setText(myExpenseLogEntryData.getDescription());
        myViewHolder.note.setText(myExpenseLogEntryData.getNote());
        myViewHolder.date.setText(myExpenseLogEntryData.getDate());
        return convertView;
    }


    // create a new ViewHolder class to put three textview into one row
    private class ViewHolder{
        TextView note, description, date;
        public ViewHolder(View item){
            note = (TextView) item.findViewById(R.id.item_note);
            description = (TextView) item.findViewById(R.id.item_description);
            date = (TextView) item.findViewById(R.id.item_date);
        }
    }


}
