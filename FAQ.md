
**How to get current date and time?**
- DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  Calendar cal = Calendar.getInstance();
  System.out.println(dateFormat.format(cal.getTime()));

**Why can't I get variable value from edit control**
- view defined inner class should be defined as final, so the value would not change

**Why my BaseAdapter's data not changed?**
- notifyDataSetChanged() to notify adapter that the listView has changed.

**How to receive multiple value through Intent?**
- _Intent returnIntent = new Intent();_  
_returnIntent.putExtra("title",titleField.getText().toString());_  
_returnIntent.putExtra("year",yearField.getText().toString());_  
_setResult(RESULT_OK,returnIntent);_  
_finish();_

- _tempTitle = data.getStringExtra("title");  
tempYear =  data.getStringExtra("year");_  
- http://stackoverflow.com/questions/17996221/how-to-receive-multiple-values-using-an-intent

**How to Change remote github url?**
- git remote set-url origin git@github.com:JackZhongTJ/cosi153a-Expenselog.git

**How to Pass an Object through intent?**
- Two way: Serializable and Parcelable

****
Reference:
- http://www.pcsalt.com/android/listview-using-baseadapter-android/
- https://github.com/krrishnaaaa/CustomListViewDemo
- http://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
